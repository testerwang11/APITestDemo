package com.autotest;

import com.autotest.services.mysoft.INavPublicService;
import com.autotest.services.mysoft.IOrganizationPublicService;
import com.autotest.services.mysoft.IRoleAclPublicService;
import com.autotest.services.mysoft.IStandardRolePublicService;
import org.testng.annotations.*;

public class BaseTest {

    //public String host = "http://10.5.6.15:8007";
    //public String host = "http://10.5.6.15:8006";
    //public String host = "http://10.5.6.14:8001";
    public String host = "http://10.5.11.142:8006";
    //public String host = "http://10.5.11.172:9002";




    public String AppId = "Mysoft";
    public String AppKey = "ff483a6526ddf275";
    //public String AppKey = "77c1cdd7d4e45d40";

    public IOrganizationPublicService iOrganizationPublicService;
    public IRoleAclPublicService iRoleAclPublicService;
    public INavPublicService iNavPublicService;
    public IStandardRolePublicService iStandardRolePublicService;
    //http://10.5.6.15:8007/
    @BeforeClass
    @Parameters({"host"})
    public void beforeSuite(@Optional("http://10.5.6.15:8007") String host) {
        System.out.println("before Class");
        //this.host = host;
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
