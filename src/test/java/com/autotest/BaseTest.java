package com.autotest;

import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.services.mysoft.IOrganizationPublicService;
import com.autotest.services.mysoft.IRoleAclPublicService;
import org.testng.annotations.*;

public class BaseTest {
    public String host;
    //public String host = "http://10.5.6.15:8006";//mysql
    //public String host = "http://10.5.6.15:8007";//sqlserver
    //public String host = "http://10.20.22.72:83";
    //public String host = "http://10.5.11.234:9060";

    public String AppId = "Mysoft";
    public String AppKey = "ff483a6526ddf275";
    private String feeItemGUID;
    public IOrganizationPublicService iOrganizationPublicService;

    public IRoleAclPublicService iRoleAclPublicService;


    @BeforeSuite
    @Parameters({"host","projectName"})
    public void beforeSuite(@Optional("host") String host, @Optional("projectName") String projectName) {
        System.setProperty("地址:",host);
        System.setProperty("projectName", projectName);
        iOrganizationPublicService = new IOrganizationPublicService(host);
        iRoleAclPublicService = new IRoleAclPublicService(host);
        this.host = host;
        host = "http://10.5.6.15:8006";//mysql
        //host = "http://10.5.6.15:8007";//sqlserver
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");


    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }
}
