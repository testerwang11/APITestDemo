package com.autotest.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PublicServicesTest extends BaseTest {


    //private String host = "http://10.5.11.234:9060";
    private BaseCall call;
    private JSONObject response;
    private JSONArray response2;

    private String feeItemGUID;
    String cookies;


    @BeforeTest(enabled = true)
    public void beforeTest() {
        call = new BaseCall(host, "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login", MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        call.setData("u=zj01&p=np3D8xDaPR54K1%2BvxlvB6RoOHZhGwdOY5y0LBSThB2DiVqINdbkM%2BJAgScExgDdlxSDycKe8j4TSa64SylLD8ajVfvk4K0B7Pve%2BYJRX7dbv43PI%2FUMvdpEf1Tn5G5ILCzJkBw8fvZNOazcBgKieKU0Se%2BbPQCzNalt9TzPQGzs%3D&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080");
        call.callService();
        cookies = call.getCookies().get(0).split(";")[0].split("=")[1];

        BaseCall call2 = new BaseCall(host, call.getReturnJsonObject().getString("data"), MethodType.Get);
        call2.addHeader("Cookie", "userToken=" + cookies);

        call2.callService();
        cookies = call2.getCookies().get(0);
        System.out.println("重定向后：" + call2.getCookies());
    }


    @Test(description = "V3单条插入")
    public void V3Insert() {
        call = new BaseCall(host, "/api/00993403/FeeItemV3/Insert", MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"FeeItemCode\": \"bbb\",\n" +
                "  \"FeeItemName\": \"bbb\",\n" +
                "  \"IsEnd\": \"true\",\n" +
                "  \"IsFk\": 0,\n" +
                "  \"IsOverdueFine\": 0,\n" +
                "  \"IsSys\": \"false\",\n" +
                "  \"FeeItemTypeTag\": 0,\n" +
                "  \"FeeItemGUID\": \"\",\n" +
                "  \"parentGUID\": \"\"\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
        feeItemGUID = response.getJSONObject("result").getString("FeeItemGUID");
        assertEquals(response.getString("success"), "true");
    }

    @Test(description = "V3单条插入", dependsOnMethods = "V3Insert")
    public void V3Update() {
        call = new BaseCall(host, "/api/00993403/FeeItemV3/Update", MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        JSONObject body = response.getJSONObject("result");
        body.put("FeeItemCode", "bbb1");
        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
    }

    @Test(description = "V3单条查询", dependsOnMethods = "V3Update")
    public void V3GetById() {
        call = new BaseCall(host, "/api/00993403/FeeItemV3/GetById?guid=" + feeItemGUID, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");

        call.callService();
        response = call.getReturnJsonObject();

        assertEquals(response.getString("success"), "true");
    }

    @Test(description = "V3单条删除", dependsOnMethods = "V3GetById")
    public void V3Delete() {
        call = new BaseCall(host, "/api/00993403/FeeItemV3/Delete?id=" + feeItemGUID, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");

        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
    }

    @Test(description = "查询组织下的所有用户")
    public void testQueryUserCompanyInfoWithBU() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/QueryUserCompanyInfoWithBU";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"UserName\": \"\",\n" +
                "  \"UserCode\": \"\",\n" +
                "  \"HierarchyCode\": \"\",\n" +
                "  \"BUGUID\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\",\n" +
                "  \"ArrIsDisabled\": [\n" +
                "    0\n" +
                "  ],\n" +
                "  \"SortingField\": \"\",\n" +
                "  \"SortingOrder\": \"\",\n" +
                "  \"PageSize\": 20,\n" +
                "  \"PageIndex\": 0\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }


    @Test(description = "根据条件查询用户列表接口")
    public void testGetUsers() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUsers";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"Keyword\": \"\",\n" +
                "  \"IsAdmin\": true\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据条件查询用户列表接口")
    public void testGetOrganization() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganization";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"Keyword\": \"\",\n" +
                "  \"IsAdmin\": true\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "查询标准角色", priority = 2)
    public void testGetRoles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices/IOrganizationPublicService/GetRoles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Cookie", cookies);

        call.addHeader("Content-Type", "application/json");
        call.callService();
        response2 = call.getReturnJsonArray();
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

}
