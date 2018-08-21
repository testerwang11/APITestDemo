package com.autotest;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    @Parameters({"env","projectName"})
    public void beforeSuite(@Optional("test") String env, @Optional("test") String projectName) {
        System.setProperty("环境",env);
        System.setProperty("projectName", projectName);
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
