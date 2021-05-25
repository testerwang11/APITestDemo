package com.autotest.services.mysoft;

import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;

public class BaseService {



    public String AppId = "Mysoft";//测试环境key

    public String AppKey = "ff483a6526ddf275";//测试环境秘钥

    public String host;

    /**
     * 通过账号密码登录
     * @param username
     * @param passwd
     * @return
     */
    public String login(String username, String passwd) {
        BaseCall call = new BaseCall(host, "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login", MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        String body  = "u="+username+"&p=np3D8xDaPR54K1%2BvxlvB6RoOHZhGwdOY5y0LBSThB2DiVqINdbkM%2BJAgScExgDdlxSDycKe8j4TSa64SylLD8ajVfvk4K0B7Pve%2BYJRX7dbv43PI%2FUMvdpEf1Tn5G5ILCzJkBw8fvZNOazcBgKieKU0Se%2BbPQCzNalt9TzPQGzs%3D&c=&r=true&returnUrl=%2F&directSite=&screenRate=1920*1080";
        call.setData(body);
        call.callService();
        String cookies = call.getCookies().get(0).split(";")[0].split("=")[1];

        BaseCall call2 = new BaseCall(host, call.getReturnJsonObject().getString("data"), MethodType.Get);
        call2.addHeader("Cookie", "userToken=" + cookies);

        call2.callService();
        cookies = call2.getCookies().get(0);
        return cookies;
    }

    /**
     * 根据认证方式，设置请求头
     * @param call
     * @param auth
     * @return
     */
    public BaseCall setAuth(BaseCall call, AuthType auth) {

        switch (auth.getIndex()){
            case 1:
                call.addHeader("AppId", AppId);
                call.addHeader("AppKey", AppKey);
                break;
            case 2:
                call.addHeader("Cookie", login("admin", "1"));
                break;
            default:
                call.addHeader("_TestMock", "1");
        }

        return call;
    }

}
