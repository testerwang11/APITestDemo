package com.autotest.help;

import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class SearchAbnormalFlight extends BaseTest {

    private String host = "https://help.ch.com";
    private String uri = "/Services/SearchAbnormalFlight";
    private BaseCall call;
    private JSONObject response;
    private HashMap<String, String> reqData = new HashMap<>();

    @BeforeMethod
    public void beforeMethod() {
        call = new BaseCall(host, uri, MethodType.Post);
    }
    @DataProvider(name="data")
    public static Object[][] data()
    {
        return new Object[][] {{"9C8851","2018-07-19","ABCD1234", "ERR_CRM_104"},{"9C8852","2018-07-19","ABCD1234", "ERR_CRM_104"},{"9C8853","2018-07-15","ABCD123", "ERR_CRM_104"}};
    }
    @Test(dataProvider="data")
    public void searchAbnormalFlight(String flightNo, String flightDate, String cardNo, String code) {
        call.addDefHeader();
        reqData.put("flightNo", flightNo);
        reqData.put("flightDate", flightDate);
        reqData.put("cardNo", cardNo);
        call.setData(reqData);
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("Code"), code, "验证返回Code");
    }

    @AfterMethod
    public void afterMethod() {
        reqData.clear();
        call.close();
    }
}
