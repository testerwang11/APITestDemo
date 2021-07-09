package com.autotest.login;

import cn.hutool.core.net.URLEncoder;
import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import com.autotest.utils.RSAUtil;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.charset.Charset;

import static org.testng.Assert.*;

public class MysoftLoginTestCase extends BaseTest {
    //private String host = "http://10.5.6.15:8101";
    //private String host = "http://10.5.11.142:8201";
    private String uri = "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login";
    private BaseCall call;
    private JSONObject response;

/*    private JSONObject body = new JSONObject();
    private JsonPath code = JsonPath.compile("$.code");
    private JsonPath message = JsonPath.compile("$.message");
    private JsonPath error = JsonPath.compile("$.error");*/


    @DataProvider(name = "loginData")
    public static Object[][] data() {
        return new Object[][]{{"admin2", "admin", false, "帐号密码错误", 1}, {"zhangjc", "admin", false, "帐号密码错误", 1}, {"admin2", "", false, "帐号密码错误", 1}, {"admin2", "admin'", false, "帐号密码错误", 1}};
    }


    @Test(dataProvider = "loginData", description = "erp_登录异常用例", groups = {"erp", "master"})
    public void loginByPassword_Error_C001(String username, String password, Boolean success, String msg, Integer type) {
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body = "u=" + username + "&p=" + new URLEncoder().encode(RSAUtil.encryptionByPublicKey(password), Charset.defaultCharset()) + "&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        response = call.getReturnJsonObject();
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertEquals(response.getBoolean("success"), success, "验证success");
        assertEquals(response.getString("message"), msg, "验证登录失败提示信息");
        assertEquals(response.getInteger("type"), type, "异常type");
    }


    @Test(description = "erp_使用正确的账号密码登录", groups = {"erp", "master"})
    public void loginByPassword_C002() {
        String username = "admin", password = "1";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body = "u=" + username + "&p=" + new URLEncoder().encode(RSAUtil.encryptionByPublicKey(password), Charset.defaultCharset()) + "&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        response = call.getReturnJsonObject();
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));

        assertTrue(response.getBoolean("success"), "验证success");
        assertEquals(response.getString("message"), "", "验证登录失败提示信息");
        assertEquals(response.getIntValue("type"), 0, "异常type");
    }

    @DataProvider(name = "sassLoginData")
    public static Object[][] sassLoginData() {
        return new Object[][]{{"mysoft", "admin", "1"}, {"testc", "admin", "1"}};
    }


    @Test(description = "sass_使用正确的账号密码登录", groups = {"sass", "master"}, dataProvider = "sassLoginData")
    public void saasLoginByPassword_C001(String tenantName, String username, String password) {
        //String tenantName="mysoft",username = "admin", password = "1";
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body = "tenantName=" + tenantName + "&u=" + username + "&p=" + new URLEncoder().encode(RSAUtil.encryptionByPublicKey(password), Charset.defaultCharset()) + "&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        response = call.getReturnJsonObject();
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));

        assertTrue(response.getBoolean("success"), "验证success");
        assertEquals(response.getString("message"), "", "验证登录失败提示信息");
        assertEquals(response.getIntValue("type"), 0, "异常type");
    }

    @DataProvider(name = "sassLoginData2")
    public static Object[][] sassLoginData2() {
        return new Object[][]{{"a", "admin", "1", false, "无效的租户名", 0}, {"mysoft", "a", "1", false, "帐号密码错误", 1}, {"mysoft", "admin", "ddddd", false, "帐号密码错误", 1}};
    }

    @Test(dataProvider = "sassLoginData2", description = "sass_登录异常用例", groups = {"sass", "master"})
    public void sassLoginByPassword_Error_C001(String tenantName, String username, String password, Boolean success, String msg, Integer type) {
        call = new BaseCall(host, uri, MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body = "tenantName=" + tenantName + "&u=" + username + "&p=" + new URLEncoder().encode(RSAUtil.encryptionByPublicKey(password), Charset.defaultCharset()) + "&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        response = call.getReturnJsonObject();
        FileOper.saveJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName(), DiffMethod.generateJsonSchema(response));
        DiffMethod.diffFormatJson(response, FileOper.queryJsonSchema(Thread.currentThread().getStackTrace()[1].getMethodName()));
        assertEquals(response.getBoolean("success"), success, "验证success");
        assertEquals(response.getString("message"), msg, "验证登录失败提示信息");
        assertEquals(response.getInteger("type"), type, "异常type");
    }


    @AfterMethod
    public void afterMethod() {
        call.close();
        response.clear();
    }
}
