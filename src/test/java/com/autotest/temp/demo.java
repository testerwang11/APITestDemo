package com.autotest.temp;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.autotest.database.model.ApiCaseEntity;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.excel.ExcelUtilsDemo;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.EnumUtils;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;

public class demo {

    @Test(description = "", priority =1, enabled = true)
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
        String className = LocalDateTimeUtil.now().toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\\.", "");
        System.out.println(className);

        className = LocalDateTimeUtil.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        System.out.println(className);

        MethodType a = EnumUtils.getEnum(MethodType.class, "Get");

        String dd = "{'wc':'1'}";
        String cc = JSONObject.parseObject(dd).toString();
        System.out.println(cc);

        String s = cc.replaceAll("\"", "\\\\\"");
        System.out.println(s);

    }
}
