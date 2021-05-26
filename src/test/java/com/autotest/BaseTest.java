package com.autotest;

import com.autotest.services.mysoft.INavPublicService;
import com.autotest.services.mysoft.IOrganizationPublicService;
import com.autotest.services.mysoft.IRoleAclPublicService;
import com.autotest.services.mysoft.IStandardRolePublicService;
import org.testng.annotations.*;

public class BaseTest {
    public String host;
    public String AppId = "Mysoft";
    public String AppKey = "ff483a6526ddf275";

    public IOrganizationPublicService iOrganizationPublicService;
    public IRoleAclPublicService iRoleAclPublicService;
    public INavPublicService iNavPublicService;
    public IStandardRolePublicService iStandardRolePublicService;

    @BeforeClass
    @Parameters({"host"})
    public void beforeSuite(@Optional("http://10.5.6.15:8006") String host) {
        System.out.println("before Class");

        this.host = host;
        //host = "http://10.5.6.15:8006";//mysql
        //host = "http://10.5.6.15:8007";//sqlserver
        //System.out.println(host);
        //System.setProperty("地址:", host);
        //System.setProperty("projectName", projectName);
        iOrganizationPublicService = new IOrganizationPublicService(host);
        iRoleAclPublicService = new IRoleAclPublicService(host);
        iNavPublicService = new INavPublicService(host);
        iStandardRolePublicService = new IStandardRolePublicService(host);
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
