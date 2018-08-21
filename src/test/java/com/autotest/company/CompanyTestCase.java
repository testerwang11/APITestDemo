package com.autotest.company;

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

public class CompanyTestCase extends BaseTest {
    private String host = "http://106.15.136.173/";
    private String uri = "/api/company";
    private BaseCall call;
    private JSONObject body = new JSONObject();
    private JSONObject response;
    private JsonPath path = JsonPath.compile("$.ret.Routes");
    private JsonPath departure = JsonPath.compile("$.ret.Routes[*].Departure");

    @BeforeMethod
    public void beforeMethod() {
        call = new BaseCall(host, uri, MethodType.Post);
        call.addDefHeader();

    }

    @Test(description = "获取公司分页信息列表")
    public void getCompany_C001() {
        body.put("active", true);
        body.put("keyword", "");
        body.put("pageNo", 1);
        body.put("pageSize", 10);

        call.setData(body.toJSONString());
        call.callService();
        response = call.getReturnJsonObject();
        assertEquals(response.getString("Code"), "0", "验证返回Code为0");
        List<JSONObject> routes = path.read(response);
        List<String> departures = departure.read(response);
        assertThat(departures, hasItem("上海"));
    }

    @Test(description = "根据三字码推荐航线-广州")
    public void getReRoutesByCity_C002() {
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
