package com.autotest.mysoft;

import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MonkeyTest extends BaseTest {

    private BaseCall call;
    private String cookies;

    @Test(description = "登录页面", priority = 0)
    public void testLoginPage() {
        call = new BaseCall(host, "/PubPlatform/Login/index.aspx?ReturnUrl=%2f", MethodType.Post);
        call.callService();
        assertThat(call.getStatusCode(), equalTo(200));
        call.getReturnData();
        assertThat(call.getReturnData(), containsString("密码修改成功"));
    }

    @Test(description = "ERP登录", priority = 1)
    public void testLoginERP() {
        call = new BaseCall(host, "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login", MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        call.setData("u=admin&p=np3D8xDaPR54K1%2BvxlvB6RoOHZhGwdOY5y0LBSThB2DiVqINdbkM%2BJAgScExgDdlxSDycKe8j4TSa64SylLD8ajVfvk4K0B7Pve%2BYJRX7dbv43PI%2FUMvdpEf1Tn5G5ILCzJkBw8fvZNOazcBgKieKU0Se%2BbPQCzNalt9TzPQGzs%3D&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080");
        call.callService();
        String cookies = call.getCookies().get(0).split(";")[0].split("=")[1];
        BaseCall call2 = new BaseCall(host, call.getReturnJsonObject().getString("data"), MethodType.Get);
        call2.addHeader("Cookie", "userToken=" + cookies);
        call2.callService();
        cookies = call2.getCookies().get(0);
        assertThat(cookies, notNullValue());
    }
}
