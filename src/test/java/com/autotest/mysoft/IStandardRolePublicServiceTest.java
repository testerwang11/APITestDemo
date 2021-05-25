package com.autotest.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IStandardRolePublicServiceTest extends BaseTest {

    private BaseCall call;
    private JSONObject response;
    private JSONArray response2;
    String cookies;

    @Test(description = "根据ID数组获取所有的标准角色")
    public void testGetUserOrgAndRoles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IStandardRolePublicService/GetUserOrgAndRoles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "  \"243AA589-1360-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }
}
