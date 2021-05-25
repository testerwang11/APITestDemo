package com.autotest.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IOrganizationPublicServiceTest extends BaseTest {

    private BaseCall call;
    private JSONObject response;
    private JSONArray response2;

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
    }

    @Test(description = "获取组织下的用户")
    public void testGetUserByOrganization01() {
        iOrganizationPublicService.getUserByOrganization(AuthType.Appkey, "11b11db4-e907-4f1f-8835-b9daab6e1f23");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据条件查询用户列表接口")
    public void testGetUsers01() {
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

    @Test(description = "查询组织下的所有用户")
    public void testQueryUserCompanyInfoWithBU01() {
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

    @Test(description = "查询用户是否存在于相关组织")
    public void testCheckUserExistInBu01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/CheckUserExistInBu";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"buid\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\",\n" +
                "  \"userId\": \"016DB354-0D60-EB11-902C-CB823B2D279F\",\n" +
                "  \"option\": \"Up\"\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "查询组织下的所有用户(根据组织查组织下的所有用户)")
    public void testGetUsersByOrganizationRecursive01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetUsersByOrganizationRecursive";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"UserName\": \"\",\n" +
                "  \"UserCode\": \"\",\n" +
                "  \"HierarchyCode\": \"zb\",\n" +
                "  \"BUGUID\": \"\",\n" +
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

    @Test(description = "查询组织下的所有用户(根据组织查组织下的所有用户)")
    public void testQueryUserCompanyInfoWithBUCount01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/QueryUserCompanyInfoWithBUCount";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"UserName\": \"\",\n" +
                "  \"UserCode\": \"\",\n" +
                "  \"HierarchyCode\": \"zb\",\n" +
                "  \"BUGUID\": \"\",\n" +
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


    @Test(description = "计划系统根据部门ID集合批量获取部门负责人\n")
    public void testQueryBUPersonInCharge01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/QueryBUPersonInCharge";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "  \"6BEAECC6-5459-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据筛选条件获取组织单元")
    public void testGetOrganizationsByFilter01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationsByFilter";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"BuType\": \"Company\"\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    //todo 返回无数据
    @Test(description = "根据条件查询用户列表分页接口")
    public void testGetUsersPaging01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUsersPaging";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\"pageIndex\":0,\"pageSize\":5,\"filter\":[{\"Key\":\"null\",\"Value\":{}}]}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据一组组织id批量查询组织详情")
    public void testQueryOrganizationByIds01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/QueryOrganizationByIds";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "  \"6BEAECC6-5459-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据用户GUID获取用户备选功能")
    public void testGetAlternativeFunctionByUserGuid01() {
        String uri = "/pub/Mysoft.PubPlatform.Nav.PublicServices.INavPublicService/GetAlternativeFunctionByUserGuid?userGuid=83897767-BB5B-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据用户id查询对应角色")
    public void testGetRoleByUser01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetRoleByUser?userGuid=83897767-BB5B-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
        //call.setData("{\"userGuid\":[\"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"]}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据用户名或帐号模糊搜索用户列表接口")
    public void testGetUsersByBatchCondition01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUsersByBatchCondition";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"UserNames\": [\n" +
                "    \"张景秋\"\n" +
                "  ],\n" +
                "  \"UserCodes\": [\n" +
                "    \"\"\n" +
                "  ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据用户名或帐号模糊搜索用户列表接口")
    public void testGetUsersByBatchCondition02() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUsersByBatchCondition";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"UserNames\": [\n" +
                "    \"\"\n" +
                "  ],\n" +
                "  \"UserCodes\": [\n" +
                "    \"zhangjq03\"\n" +
                "  ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    //todo 无数据
    @Test(description = "根据组织、角色集合、项目解析用户")
    public void testQueryUserByOrganizationRolesProject01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/QueryUserByOrganizationRolesProject";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"roleGuids\": [\n" +
                "    \"243AA589-1360-EB11-902C-CB823B2D279F\"\n" +
                "  ],\n" +
                "  \"organizationGuid\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\",\n" +
                "  \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\"\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据组织ID查询所有子集")
    public void testQueryBUTreeDataListByBUID01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/QueryBUTreeDataListByBUID?buid=6BEAECC6-5459-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Get);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
        //call.setData("6BEAECC6-5459-EB11-902C-CB823B2D279F");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    //TODO 测试环境无报表数据
    @Test(description = "获取报表权限")
    public void testGetReportRightsByUser01() {
        String uri = "/pub/Mysoft.Report.Interface.IReportPublicService/GetReportRightsByUser?userId=8414781F-5A5C-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
        //call.setData("6BEAECC6-5459-EB11-902C-CB823B2D279F");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取当前登录用户有权限的所有组织")
    public void testGetAllOrganizationsTreeByUser01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetAllOrganizationsTreeByUser";
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

    @Test(description = "获取当前登录用户有权限的所有组织，可传筛选条件")
    public void testGetAllOrganizationsTreeByUserAndFilter01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetAllOrganizationsTreeByUserAndFilter";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Content-Type", "application/json");
        call.addHeader("Cookie", cookies);
        call.setData("{\n" +
                "  \"BuType\": \"Company\"\n" +
                "}");
        call.callService();
        response2 = call.getReturnJsonArray();
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取角色下的组织用户列表")
    public void testGetUserRoleDetailsByRoles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUserRoleDetailsByRoles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "  \"243AA589-1360-EB11-902C-CB823B2D279F\",\n" +
                "  \"7296DE29-045B-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取配置类业务参数值")
    public void testGetParamValue01() {
        String uri = "/pub/Mysoft.PubPlatform.Param.PublicServices.IParamPublicService/GetParamValue";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取所有的标准角色")
    public void testGetAllMyStandardRoles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IStandardRolePublicService/GetAllMyStandardRoles?buGuid=F0A50BB6-9A5B-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
 /*       call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");*/
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取所有用户")
    public void testGetAllUsers01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetAllUsers";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
 /*       call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");*/
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取所有组织")
    public void testGetOrganizations01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizations";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
 /*       call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");*/
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据GUID获取指定用户")
    public void testGetUser01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUser?userGuid=83897767-BB5B-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
 /*       call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");*/
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

/*    @Test(description = "获取用户的所有权限")
    public void testGetUserActionRightInfos01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IRoleAclPublicService/GetUserActionRightInfos?userId=83897767-BB5B-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        //call.addHeader("Content-Type", "application/json");
 *//*       call.setData("{\n" +
                "  \"paramCode\": \"JobTaskInterval\",\n" +
                "  \"scopeId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "}");*//*
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }*/

    @Test(description = "获取用户集合")
    public void testGetUsersByIds01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUsersByIds";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "  \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "  \"84F410BF-DE5B-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取用户组织角色根据用户过滤")
    public void testGetUserOrgAndRoles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetUserOrgAndRoles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"UserGuids\": [\n" +
                "        \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "        \"84F410BF-DE5B-EB11-902C-CB823B2D279F\"\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取用户组织角色根据组织过滤")
    public void testGetUserOrgAndRolesByBuguid01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetUserOrgAndRolesByBuguid";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"Buguids\": [\n" +
                "        \"F0A50BB6-9A5B-EB11-902C-CB823B2D279F\",\n" +
                "        \"DD6BBCDB-9A5B-EB11-902C-CB823B2D279F\"\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取用户组织角色根据角色过滤")
    public void testGetUserOrgAndRolesByRolesId01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetUserOrgAndRolesByRolesId";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"RolesId\": [\n" +
                "        \"826853E8-595C-EB11-902C-CB823B2D279F\",\n" +
                "        \"243AA589-1360-EB11-902C-CB823B2D279F\",\n" +
                "        \"7296DE29-045B-EB11-902C-CB823B2D279F\"\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取组织")
    public void testGetOrganizationById01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationById?id=6BEAECC6-5459-EB11-902C-CB823B2D279F";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
/*        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"RolesId\": [\n" +
                "        \"826853E8-595C-EB11-902C-CB823B2D279F\",\n" +
                "        \"243AA589-1360-EB11-902C-CB823B2D279F\",\n" +
                "        \"7296DE29-045B-EB11-902C-CB823B2D279F\"\n" +
                "    ]\n" +
                "}");*/
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取组织信息(子公司)")
    public void testGetOrganization01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganization";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"BuCode\": \"001\",\n" +
                "  \"IsRoot\": false\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取组织信息(集团)")
    public void testGetOrganization02() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganization";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"BuCode\": \"zb\",\n" +
                "  \"IsRoot\": true\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    //TODO 无数据
    @Test(description = "解析通用角色获取用户")
    public void testGetUserByAnalyzeGlobalRoleProject01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUserByAnalyzeGlobalRoleProject";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "  \"mode\": 0,\n" +
                "  \"organizationId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\",\n" +
                "  \"globalRoleId\": \"430F7E74-93F0-484B-B642-08D915272D36\",\n" +
                "  \"professionId\": \"\",\n" +
                "  \"projectGuids\": [\n" +
                "    \"7BF25225-5559-EB11-902C-CB823B2D279F\"\n" +
                "  ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    //会修改数据，需还原数据库
    @Test(description = "批量调整组织归属", priority = 2)
    public void testChangeParent01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/ChangeParent";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"businessUnitList\": [\n" +
                "        {\n" +
                "            \"code\": \"XY06\",\n" +
                "            \"parentCode\": \"001\",\n" +
                "            \"id\": \"30B91EE2-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"parentId\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "批量新增标准角色功能权限点", priority = 2)
    public void testCreateRoleRithts01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IStandardRolePublicService/CreateRoleRithts";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"roleRightList\": [\n" +
                "        {\n" +
                "            \"roleId\": \"7296DE29-045B-EB11-902C-CB823B2D279F\",\n" +
                "            \"applicationCode\": \"0000\",\n" +
                "            \"functionCode\": \"00002220\",\n" +
                "            \"actionCode\": \"00\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleId\": \"7296DE29-045B-EB11-902C-CB823B2D279F\",\n" +
                "            \"applicationCode\": \"0000\",\n" +
                "            \"functionCode\": \"00002211\",\n" +
                "            \"actionCode\": \"00\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "批量修改组织", priority = 2)
    public void testUpdate01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/Update";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"businessUnitList\": [\n" +
                "        {\n" +
                "            \"id\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"code\": \"001\",\n" +
                "            \"name\": \"武汉公司\",\n" +
                "            \"comments\": \"测试1\",\n" +
                "            \"orgName\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"30B91EE2-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"code\": \"002\",\n" +
                "            \"name\": \"襄阳公司2\",\n" +
                "            \"comments\": \"测试2\",\n" +
                "            \"orgName\": \"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "false");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "批量修改组织(龙湖专用)", priority = 2)
    public void testUpdateLH01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/UpdateLH";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"businessUnitList\": [\n" +
                "        {\n" +
                "            \"id\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"code\": \"001\",\n" +
                "            \"name\": \"武汉公司\",\n" +
                "            \"comments\": \"测试2\",\n" +
                "            \"orgName\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"30B91EE2-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"code\": \"002\",\n" +
                "            \"name\": \"襄阳公司2\",\n" +
                "            \"comments\": \"测试2\",\n" +
                "            \"projId\": \"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "新增用户的项目和角色", priority = 2)
    public void testCreateUserProject2Roles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/CreateUserProject2Roles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userProject2RoleList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"958ABCDD-595C-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "移除用户的项目和角色", priority = 2, dependsOnMethods = "testCreateUserProject2Roles01")
    public void testDeleteUserProject2Roles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/DeleteUserProject2Roles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userProject2RoleList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"958ABCDD-595C-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "新增用户公司项目权限", priority = 2)
    public void testCreateUserBUProjectRights01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/CreateUserBUProjectRights";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userBUProjectRightList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"291048FE-9A5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "移除用户的项目和角色", priority = 2, dependsOnMethods = "testCreateUserBUProjectRights01")
    public void testDeleteUserBUProjectRights01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/DeleteUserBUProjectRights";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userBUProjectRightList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"291048FE-9A5B-EB11-902C-CB823B2D279F\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }


    @Test(description = "新增用户角色关联", priority = 2)
    public void testCreateUser2Roles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/CreateUser2Roles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"User2RoleList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"958ABCDD-595C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"DCABF5BF-BA5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "移除用户角色关联", priority = 2, dependsOnMethods = "testCreateUser2Roles01")
    public void testDeleteUser2Roles01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/DeleteUser2Roles";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"User2RoleList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"958ABCDD-595C-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"11B11DB4-E907-4F1F-8835-B9DAAB6E1F23\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"roleId\": \"DCABF5BF-BA5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"businessUnitId\": \"6BEAECC6-5459-EB11-902C-CB823B2D279F\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "新增用户项目权限", priority = 2)
    public void testCreateUserProjectRights01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/CreateUserProjectRights";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userProjectRightList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\",\n" +
                "            \"createdName\": \"系统管理员\",\n" +
                "            \"createdGUID\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "移除用户项目权限", priority = 2, dependsOnMethods = "testCreateUserProjectRights01")
    public void testDeleteUserProjectRights01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/DeleteUserProjectRights";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("AppId", AppId);
        call.addHeader("AppKey", AppKey);
        call.addHeader("Content-Type", "application/json");
        call.setData("{\n" +
                "    \"userProjectRightList\": [\n" +
                "        {\n" +
                "            \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"userId\": \"83897767-BB5B-EB11-902C-CB823B2D279F\",\n" +
                "            \"projectId\": \"7BF25225-5559-EB11-902C-CB823B2D279F\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据用户ID查询项目权限")
    public void testApplyBUProjectRightsByUserIds01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/ApplyBUProjectRightsByUserIds";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Cookie", cookies);

        call.addHeader("Content-Type", "application/json");
        call.setData("[\n" +
                "    \"E405E0AA-DE5B-EB11-902C-CB823B2D279F\",\n" +
                "    \"D80FFFD2-DE5B-EB11-902C-CB823B2D279F\"\n" +
                "]");
        call.callService();
        assertTrue(call.getEntityString().equals(""));
/*        response = call.getReturnJsonObject();
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");*/
    }

    @Test(description = "查询组织结构树")
    public void testListFullBUTree01() {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/ListFullBUTree?organizationOnly=false";
        call = new BaseCall(host, uri, MethodType.Get);
        System.out.println(cookies);
        call.addHeader("Cookie", cookies);
        call.callService();
        response2 = call.getReturnJsonArray();
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据组织ID查询组织角色", priority = 2, groups = {"query", "pub"})
    public void testGetOrganizationsAndRole01() {
        response2 = iOrganizationPublicService.getOrganizationsAndRole(AuthType.Cookie, "6BEAECC6-5459-EB11-902C-CB823B2D279F");
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "根据关键字查询组织用户", priority = 2, groups = {"query", "pub"})
    public void testGetAllHasRoleUsers01() {
        response2 = iOrganizationPublicService.getAllHasRoleUsers(AuthType.Cookie, "cg");
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取当前登录用户有权限的所有组织", groups = {"query", "pub"})
    public void testQueryBUTreeDataList01() {
        response2 = iOrganizationPublicService.queryBUTreeDataList(AuthType.Cookie);
        assertEquals(response2.size() > 0, true);
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response2);
        Boolean diffResponse = DiffMethod.compareResponse(response2, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }
}
