package com.autotest.utils.excel;

import cn.hutool.core.util.URLUtil;
import cn.hutool.poi.excel.ExcelUtil;
import com.autotest.client.BaseCall;
import com.autotest.database.model.ApiCaseEntity;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.StringUtils;
import com.github.crab2died.ExcelUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtilsDemo {


    public static String AppId = "Mysoft";//测试环境key

    public static String AppKey = "77c1cdd7d4e45d40";//测试环境秘钥

    public static String host;


    public static LinkedList<ApiCaseEntity> excel2Object2() {

        String path = "D:\\study\\接口自动化测试demo.xlsx";
        try {
            List<String> sheetNames = ExcelUtil.getReader(path).getSheetNames();

            List<ApiCaseEntity> caseDatas = new ArrayList<>();
            List<ApiCaseEntity> caseDatasTemp = new ArrayList<>();
            LinkedList<ApiCaseEntity> caseEntities = new LinkedList<>();

            for (int i = 0; i < sheetNames.size(); i++) {
                caseDatasTemp.clear();
                caseDatas = ExcelUtils.getInstance().readExcel2Objects(path, ApiCaseEntity.class, 0, i);
                for (ApiCaseEntity caseData : caseDatas) {
                    caseData.setSuitName(sheetNames.get(i));
                    caseDatasTemp.add(caseData);
                }
                caseEntities.addAll(caseDatasTemp);
            }
            System.out.println(caseEntities);
            return caseEntities;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过账号密码登录
     *
     * @param username
     * @param passwd
     * @return
     */
    public String login(String username, String passwd) {
        BaseCall call = new BaseCall(host, "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login", MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body = "u=" + username + "&p=np3D8xDaPR54K1%2BvxlvB6RoOHZhGwdOY5y0LBSThB2DiVqINdbkM%2BJAgScExgDdlxSDycKe8j4TSa64SylLD8ajVfvk4K0B7Pve%2BYJRX7dbv43PI%2FUMvdpEf1Tn5G5ILCzJkBw8fvZNOazcBgKieKU0Se%2BbPQCzNalt9TzPQGzs%3D&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        String cookies = call.getCookies().get(0).split(";")[0].split("=")[1];

        BaseCall call2 = new BaseCall(host, call.getReturnJsonObject().getString("data"), MethodType.Get);
        call2.addHeader("Cookie", "userToken=" + cookies);

        call2.callService();
        cookies = call2.getCookies().get(0);
        return cookies;
    }

    /**
     * 根据认证方式，设置请求头
     *
     * @param call
     * @param auth
     * @return
     */
    public BaseCall setAuth(BaseCall call, AuthType auth) {
        switch (auth.getIndex()) {
            case 1:
                call.addHeader("AppId", AppId);
                call.addHeader("AppKey", AppKey);
                break;
            case 2:
                call.addHeader("Cookie", login("admin", "1"));
                break;
            default:
                call.addHeader("_TestMock", "1");
        }

        return call;
    }

    /**
     * 根据bean内容发起请求
     *
     * @param apiCaseEntity
     * @return
     */
    public CheckResult excute(ApiCaseEntity apiCaseEntity, String host) {
        this.host = host;
        BaseCall call;
        if (apiCaseEntity.getReqUrl().startsWith("http")) {
            System.out.println(URLUtil.getStringURI(apiCaseEntity.getReqUrl()).toString());
            call = new BaseCall(URLUtil.getStringURI(apiCaseEntity.getReqUrl()).toString(), apiCaseEntity.getMethodType());
        } else {
            call = new BaseCall(host, apiCaseEntity.getReqUrl(), apiCaseEntity.getMethodType());
        }
        setAuth(call, AuthType.valueOfName(apiCaseEntity.getAuthType()));
        if(DiffMethod.isJsonObject(apiCaseEntity.getReqBody()) || DiffMethod.isJsonArray(apiCaseEntity.getReqBody())){
            call.addHeader("Content-Type", "application/json");
        }
        if (!StringUtils.isEmpty(apiCaseEntity.getReqBody())) {
            call.setData(apiCaseEntity.getReqBody());
        }
        call.callService();
        String response = call.getReturnData();

        //先根据excel内容断言
        CheckResult checkResult = new CheckResult();
        List<String> faileMsgs = new ArrayList<>();
        //断言statusCode
        if (call.getStatusCode() == apiCaseEntity.getResponseCode()) {
            checkResult.setStatusCode(true);
        } else {
            faileMsgs.add(String.format("响应Code检查,预期结果:%d,实际结果:%d", apiCaseEntity.getResponseCode(), call.getStatusCode()));
        }
        //断言响应结果
        switch (apiCaseEntity.getAssertType().trim()) {
            case "等于":
                //TODO 考虑json数组类型,key顺序不一致的情况
                if (apiCaseEntity.getResponse().trim().equals(response)) {
                    checkResult.setResponse(true);
                } else {
                    checkResult.setResponse(false);
                    faileMsgs.add(String.format("预期结果与实际结果不相等, 预期结果:%s,实际结果:%s", apiCaseEntity.getResponse(), response));
                }
                break;
            case "包含":
                if (response.contains(apiCaseEntity.getResponse())) {
                    checkResult.setResponse(true);
                    faileMsgs.add("");
                } else {
                    checkResult.setResponse(false);
                    faileMsgs.add(String.format("预期结果不包含指定内容:%s, 实际结果:%s", apiCaseEntity.getResponse(), response));
                }
                break;
        }
        checkResult.setFaileMsgs(faileMsgs);
        //TODO json情况默认追加jsonSchema比对
        checkResult.setJsonschema(true);
        return checkResult;
    }


    /**
     * 根据检查结果断言用例状态
     *
     * @param checkResult
     * @return
     */
    public void checkCaseStatus(CheckResult checkResult) {
        if (checkResult.getStatusCode() && checkResult.getResponse() && checkResult.getJsonschema()) {
            //全部为true,执行通过
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false, checkResult.getFaileMsgs().toString());
        }
    }


    public static void main(String[] args) {
        LinkedList<ApiCaseEntity> datas = excel2Object2();
        for (ApiCaseEntity api : datas) {
            System.out.println(api);
            //excute(api, null);
        }
    }
}
