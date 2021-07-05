package com.autotest.mysoft;

import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.enums.AuthType;
import com.autotest.enums.DiffType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IRoleAclPublicServiceTest extends BaseTest {

    private JSONObject response;

    @Test(description = "获取指定用户、是否存在指定的功能权限点(有权限)", groups = {"query", "pub"})
    public void testExistsSpecifyUserActionRights01() {
        response = iRoleAclPublicService.existsSpecifyUserActionRights(AuthType.AppKey, "{  \"functionCode\": \"02200904\",  \"actionCode\": \"01\",  \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\"}");
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取指定用户、是否存在指定的功能权限点(无权限)", groups = {"query", "pub"})
    public void testExistsSpecifyUserActionRights02() {
        response = iRoleAclPublicService.existsSpecifyUserActionRights(AuthType.AppKey, "{  \"functionCode\": \"02200904\",  \"actionCode\": \"01\",  \"userId\": \"4230BC6E-69E6-46A9-A39E-B929A06A84E8\"}");
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取指定用户、指定功能点的动作点集合", groups = {"query", "pub"})
    public void testGetSpecifyUserActionRights01() {
        response = iRoleAclPublicService.getSpecifyUserActionRights(AuthType.AppKey, "{  \"functionCode\": \"02200904\",  \"userId\": \"8414781F-5A5C-EB11-902C-CB823B2D279F\"}");
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }

    @Test(description = "获取用户的所有权限", groups = {"query", "pub"})
    public void testGetUserActionRightInfos01() {
        response = iRoleAclPublicService.getUserActionRightInfos(AuthType.AppKey, "83897767-BB5B-EB11-902C-CB823B2D279F");
        assertEquals(response.getString("success"), "true");
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(DiffType.General, response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");
    }
}
