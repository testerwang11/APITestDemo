package com.autotest.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class INavPublicServiceTest extends BaseTest {

    private BaseCall call;
    private JSONObject response;
    private JSONArray response2;

    @Test(description = "获取重构系统导航菜单(管理员)")
    public void testGetApplicationMenu01() {
        String uri = "/pub/Mysoft.PubPlatform.Nav.PublicServices.INavPublicService/GetApplicationMenu?userGuid=4230BC6E-69E6-46A9-A39E-B929A06A84E8";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取重构系统导航菜单(普通用户)")
    public void testGetApplicationMenu02() {
        String uri = "/pub/Mysoft.PubPlatform.Nav.PublicServices.INavPublicService/GetApplicationMenu?userGuid=8414781F-5A5C-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }
}
