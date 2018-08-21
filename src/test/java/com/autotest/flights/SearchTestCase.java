package com.autotest.flights;

import com.alibaba.fastjson.JSONObject;
import com.autotest.BaseTest;
import com.autotest.client.BaseCall;
import com.autotest.enums.MethodType;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

//@Listeners(ru.yandex.qatools.allure.testng.AllureTestListener.class)
public class SearchTestCase extends BaseTest {
    private String host = "https://flights.ch.com";
    private String uri = "/Default/GetReRoutesByCity";
    private BaseCall call;
    private JSONObject response;
    private JsonPath path = JsonPath.compile("$.ret.Routes");
    private JsonPath departure = JsonPath.compile("$.ret.Routes[*].Departure");

    @BeforeMethod
    public void beforeMethod() {
        call = new BaseCall(host, uri, MethodType.Post);
    }

    @Test(description = "根据三字码推荐航线-上海")
    public void getReRoutesByCity_C001() {
        call.addDefHeader();
        call.setData("CityCode=SHA&Lang=zh-cn&_="+System.currentTimeMillis());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("Code"), "0", "验证返回Code为0");
        List<JSONObject> routes = path.read(response);
        List<String> departures = departure.read(response);
        assertThat(departures, hasItem("上海"));
    }

    @Test(description = "根据三字码推荐航线-广州")
    public void getReRoutesByCity_C002() {
        call.addDefHeader();
        call.setData("CityCode=CAN&Lang=zh-cn&_="+System.currentTimeMillis());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("Code"), "0", "验证返回Code为0");
        List<JSONObject> routes = path.read(response);
        List<String> departures = departure.read(response);
        assertThat(departures, hasItem("广州"));
    }

    @AfterMethod
    public void afterMethod() {
        call.close();
    }
}
