package com.autotest.temp;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.net.URLEncoder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.autotest.client.BaseCall;
import com.autotest.database.model.ApiCaseEntity;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.RSAUtil;
import com.autotest.utils.excel.ExcelUtilsDemo;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.EnumUtils;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.time.format.DateTimeFormatter;

public class demo {

    @Test(description = "", priority = 1, enabled = true)
    public void test() {
        ApiCaseEntity api = new ApiCaseEntity();
        api.setReqUrl(api.getReqUrl());
        api.setReqBody(api.getReqBody());
        api.setResponseCode(api.getResponseCode());
        api.setResponse(api.getResponse());
        api.setAuthType(api.getAuthType());
        api.setMethodType(api.getMethodType());

    }

    public static void main(String[] args) {
        String host = "http://10.5.6.14:8001", username = "admin", passwd = "1";
        BaseCall call = new BaseCall(host, "/ajax/Mysoft.PubPlatform.Nav.Handlers.LoginHandler/Login", MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("_TestMock", "1");
        URLEncoder urlEncoder= new URLEncoder();
        String body = "u=" + username + "&p=" + urlEncoder.encode(RSAUtil.encryptionByPublicKey(passwd), Charset.defaultCharset());
        call.setData(body);
        call.callService();
        System.out.println(call.getReturnData());
        System.out.println(call.getCookies());
        String cookies = call.getCookies().get(0).split(";")[0].split("=")[1];

        BaseCall call2 = new BaseCall(host, call.getReturnJsonObject().getString("data"), MethodType.Get);
        call2.addHeader("Cookie", "userToken=" + cookies);

        call2.callService();
        cookies = call2.getCookies().get(0);
        System.out.println(cookies);


    }
}
