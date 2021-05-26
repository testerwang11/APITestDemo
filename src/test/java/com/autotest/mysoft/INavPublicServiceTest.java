package com.autotest.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.autotest.BaseTest;
import com.autotest.enums.AuthType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.addAttachment;
import static org.testng.Assert.assertEquals;

@Story("INavPublicService")
public class INavPublicServiceTest extends BaseTest {
    private JSONArray response;
    @Test(description = "获取重构系统导航菜单(管理员)")
    @Severity(SeverityLevel.NORMAL)
    public void testGetApplicationMenu01() {
        response = iNavPublicService.getApplicationMenu(AuthType.Cookie, "4230BC6E-69E6-46A9-A39E-B929A06A84E8", "admin");
        assertEquals(response.size() > 0, true);
/*        FileOper.saveResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), response);
        Boolean diffResponse = DiffMethod.compareResponse(response, FileOper.queryResponse(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertTrue(diffResponse, "响应结果一致");*/
        addAttachment("响应结果", "application/json", response.toJSONString());

        //对比jsonSchema
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Test(description = "获取重构系统导航菜单(普通用户)")
    public void testGetApplicationMenu02() {
        response = iNavPublicService.getApplicationMenu(AuthType.Cookie, "4230BC6E-69E6-46A9-A39E-B929A06A84E8", "zhangjc");
        assertEquals(response.size() > 0, true);

        //对比jsonSchema
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }
}
