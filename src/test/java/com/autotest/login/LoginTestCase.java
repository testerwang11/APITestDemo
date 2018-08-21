package com.autotest.login;

import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class LoginTestCase extends BaseTest {
    //private String host = "http://106.15.136.173";
    private String host = "http://47.97.2.113:8083";
    private String uri = "/api/user/login/password";
    private BaseCall call;
    private JSONObject body = new JSONObject();
    private JSONObject response;
    private JsonPath code = JsonPath.compile("$.code");
    private JsonPath message = JsonPath.compile("$.message");
    private JsonPath error = JsonPath.compile("$.error");


    @DataProvider(name="loginData")
    public static Object[][] data()
    {
        return new Object[][] {{"why111","qqqq3333","11003", "用户名不存在！"}, {"why","qqq3333","11004", "密码错误！"}};
    }

    @BeforeMethod
    public void beforeMethod() {
        call = new BaseCall(host, uri, MethodType.Post);
        call.addDefHeader();
        body.clear();

    }

    @Test(dataProvider="loginData", description = "登录异常用例")
    public void loginByPassword_Error_C001(String username, String password, String code, String msg) {
        body.put("username", username);
        body.put("password", password);
        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("code"),code,"验证登录失败Code");
        assertEquals(response.getString("message"), msg, "验证登录失败提示信息");
        assertNull(response.getString("error"),"异常信息为空");
    }


    @Test(description = "使用正确的账号密码登录")
    public void loginByPassword_C002() {
        body.put("username", "why");
        body.put("password", "qqqq3333");
        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("code"),"0","验证登录Code");
        assertEquals(response.getString("message"), "SUCCESS", "验证登录提示信息");
        assertNotNull(response.getString("data"),"异常信息为空");
        assertEquals(response.getString("data").length(), 201, "验证data字段");
        System.out.println(response.getString("data").length());
    }


    @AfterMethod
    public void afterMethod() {
        call.close();
    }
}
