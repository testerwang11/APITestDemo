package com.autotest.login;

import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class LoginTestCase extends BaseTest {
    private String host = "http://106.15.136.173";
    private String uri = "/api/user/login/password";
    private BaseCall call;
    private JSONObject body = new JSONObject();
    private JSONObject response;
    private JsonPath code = JsonPath.compile("$.code");
    private JsonPath message = JsonPath.compile("$.message");
    private JsonPath error = JsonPath.compile("$.error");


    @BeforeMethod
    public void beforeMethod() {
        call = new BaseCall(host, uri, MethodType.Post);
        //call.addDefHeader();
        call.addHeader("Accept", "application/json");
        call.addHeader("Content-Type", "application/json; charset=utf-8");
        call.addHeader("Origin", "http://hcm-ui-dev.oss-cn-shanghai.aliyuncs.com");
        call.addHeader("Referer", "http://hcm-ui-dev.oss-cn-shanghai.aliyuncs.com/index.html");
        call.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        body.clear();

    }

    @Test(description = "使用不存在的账号登录")
    public void loginByPassword_C001() {
        body.put("username", "firmlybelieve@yeah.netqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq!!!!");
        body.put("password", "qqqq3333");
        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("code"),"11003","验证登录失败Code");
        assertEquals(response.getString("message"), "用户名不存在！", "验证登录失败提示信息");
        assertNull(response.getString("error"),"异常信息为空");
    }

    @Test(description = "使用存在的账号，错误的密码登录")
    public void loginByPassword_C002() {
        body.put("username", "why");
        body.put("password", "qqqq33q33");
        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("code"),"11004","验证登录失败Code");
        assertEquals(response.getString("message"), "密码错误！", "验证登录失败提示信息");
        assertNull(response.getString("error"),"异常信息为空");
    }

    @Test(description = "使用正确的账号密码登录")
    public void loginByPassword_C003() {
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
