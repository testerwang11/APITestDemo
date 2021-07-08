package com.autotest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.entity.AssertResEntity;
import com.autotest.entity.RequestEntity;
import com.autotest.entity.ResponseEntity;
import com.autotest.enums.AuthType;
import com.autotest.enums.DiffType;
import com.autotest.enums.MethodType;
import org.apache.commons.lang3.StringUtils;

public class ApiTestUtil {

    private String host = "http://10.5.6.14:9002";

    private String AppId = "Mysoft";//测试环境key

    private String AppKey = "ff483a6526ddf275";//测试环境秘钥

    private BaseCall call;

    public BaseCall setRequestEntity(RequestEntity requestEntity) {
        switch (requestEntity.getMethod()) {
            case "Post":
                call = new BaseCall(host, requestEntity.getUri(), MethodType.Post);
                break;
            case "Get":
                call = new BaseCall(host, requestEntity.getUri(), MethodType.Get);
                break;
            default:
                call = new BaseCall(host, requestEntity.getUri(), MethodType.Post);
        }
        //设置认证方式
        setAuth(call, requestEntity.getAuthType());
        //设置请求参数
        if (!StringUtils.isEmpty(requestEntity.getBody())) {
            //判断是否是json
            if (FastJsonDiff.isJson(requestEntity.getBody()) != 3) {
                call.addHeader("Content-Type", "application/json");
            }
            call.setData(requestEntity.getBody());
        }
        return this.call;
    }

    /**
     * 发送请求
     * @param assertResEntity
     * @return
     */
    public ResponseEntity callApi(AssertResEntity assertResEntity) {
        call.callService();
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setResStr(call.getReturnData());
        System.out.println(assertResEntity.getStatusCode());
        if (call.getStatusCode() != assertResEntity.getStatusCode()) {
            responseEntity.setMsg(String.format("StatusCode状态不一致,预期：%d,实际:%d", assertResEntity.getStatusCode(), call.getStatusCode()));
            responseEntity.setSuccess(false);
            return responseEntity;
        }
        if (com.autotest.utils.StringUtils.isEmpty(assertResEntity.getDiffType().getName())) {
            responseEntity.setSuccess(generalAssertion(assertResEntity.getMethodName(), call.getReturnData()));
        } else {
            responseEntity.setSuccess(assertion(assertResEntity.getDiffType(), assertResEntity.getMethodName(), call.getReturnData()));
        }
        responseEntity.setMsg("json校验失败");
        return responseEntity;
    }


    /**
     * 通用断言
     *
     * @param methodName
     * @param response
     * @return
     */
    private boolean generalAssertion(String methodName, String response) {
        //判断返回结果是不是json
        int type = FastJsonDiff.isJson(response);
        if (type == 1) {
            //首次保存jsonschema
            FileOper.saveJsonSchema(methodName, DiffMethod.generateJsonSchema(JSONObject.parse(response)));
            //首次保存响应结果
            FileOper.saveResponse(methodName, JSONObject.parse(response));
        } else if (type == 2) {
            //首次保存jsonschema
            FileOper.saveJsonSchema(methodName, DiffMethod.generateJsonSchema(JSONArray.parse(response)));
            //首次保存响应结果
            FileOper.saveResponse(methodName, JSONArray.parse(response));
        } else {
            //字符串
        }
        Boolean diffResponse1 = DiffMethod.compareResponse(DiffType.JsonSchema, call.getReturnData(), FileOper.queryResponse(methodName));
        Boolean diffResponse2 = DiffMethod.compareResponse(DiffType.Strict, call.getReturnData(), FileOper.queryResponse(methodName));
        if (diffResponse1 && diffResponse2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据指定类型进行断言
     * @param diffType
     * @param methodName
     * @param response
     * @return
     */
    private boolean assertion(DiffType diffType, String methodName, String response) {
        //判断返回结果是不是json
        int type = FastJsonDiff.isJson(response);
        if (type == 1) {
            //首次保存jsonschema
            FileOper.saveJsonSchema(methodName, DiffMethod.generateJsonSchema(JSONObject.parse(response)));
            //首次保存响应结果
            FileOper.saveResponse(methodName, JSONObject.parse(response));

        } else if (type == 2) {
            //首次保存jsonschema
            FileOper.saveJsonSchema(methodName, DiffMethod.generateJsonSchema(JSONArray.parse(response)));
            //首次保存响应结果
            FileOper.saveResponse(methodName, JSONArray.parse(response));
        } else {
            //字符串
        }
        return DiffMethod.compareResponse(diffType, call.getReturnData(), FileOper.queryResponse(methodName));
    }

    /**
     * 根据认证方式，设置请求头
     *
     * @param call
     * @param auth
     * @return
     */
    private BaseCall setAuth(BaseCall call, AuthType auth) {

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
     * 通过账号密码登录
     *
     * @param username
     * @param passwd
     * @return
     */
    private String login(String username, String passwd) {
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

    public static void main(String[] args) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setUri("/pub/Mysoft.PubPlatform.Message.Interfaces.ISendMessagePublicService/QueryTaskWakeHistoryList");
        requestEntity.setAuthType(AuthType.AppKey);
        requestEntity.setMethod(MethodType.Post.getName());
        requestEntity.setBody("{\n" +
                "  \"wakeMode\": 2,\n" +
                "  \"pageSize\": 20,\n" +
                "  \"pageIndex\": 0,\n" +
                "  \"appCode\": \"0220\",\n" +
                "  \"buGuid\": null,\n" +
                "  \"projGuid\": null,\n" +
                "  \"BusinessType\":\"供应商考察\",\n" +
                "  \"OrderBy\": \"asc\"\n" +
                "}");
        AssertResEntity assertResEntity = new AssertResEntity();

        assertResEntity.setDiffType(DiffType.JsonSchema);
        assertResEntity.setStatusCode(200);

        ApiTestUtil apiTestUtil = new ApiTestUtil();

        apiTestUtil.setRequestEntity(requestEntity);

        apiTestUtil.callApi(assertResEntity);
    }

}
