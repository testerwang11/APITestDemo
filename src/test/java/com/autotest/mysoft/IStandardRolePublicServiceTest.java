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

public class IStandardRolePublicServiceTest extends BaseTest {

    private JSONObject response;

    @Test(description = "根据ID数组获取所有的标准角色", groups = {"query", "pub"})
    public void testGetUserOrgAndRoles01() {
        response = iStandardRolePublicService.getUserOrgAndRoles(AuthType.AppKey, "[\"243AA589-1360-EB11-902C-CB823B2D279F\"]");
        assertEquals(response.getString("success"), "true");
        //返回结果全匹配
/*        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diff1 = DiffMethod.compareResponse(DiffType.Strict, response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diff1, "严格模式校验通过");*/

        //返回结果
        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diff2 = DiffMethod.compareResponse(DiffType.General, response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diff2, "宽松模式校验通过");

        //返回结果JsonSchema比较
/*        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        Boolean diff3 = DiffMethod.compareResponse(DiffType.JsonSchema, response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diff3, "jsonscheam校验通过");*/

    }
}
