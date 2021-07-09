package com.autotest.temp;

import org.testng.annotations.Test;
import java.util.*;
import com.autotest.utils.excel.ExcelUtilsDemo;
import io.qameta.allure.Feature;
import com.autotest.database.model.ApiCaseEntity;
import org.apache.commons.lang3.EnumUtils;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;

/**
* 根据模板生成的用例
*/
public class Usr6496orz {

    private String hostFW = "http://10.5.6.14:8001", hostCore = "http://10.5.11.142:8007";
    private ExcelUtilsDemo excelUtilsDemo = new ExcelUtilsDemo();


    @Feature("数据权限用例")
    @Test(description = "Framework V2产品打标记-二开注册-请求拦截", priority = 1)
    public void tc_1() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/ApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2产品打标记-二开注册-请求成功", priority = 2)
    public void tc_2() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/ApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2产品不打标记-二开不注册-请求成功", priority = 3)
    public void tc_3() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonAttrApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2其他服务调用-产品打标记-二开注册-请求拦截", priority = 4)
    public void tc_4() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/DupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2其他服务调用-产品打标记-二开注册-请求成功", priority = 5)
    public void tc_5() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/DupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC2");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2其他服务调用-传递报错字符串-请求拦截", priority = 6)
    public void tc_6() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonDupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework V2其他服务调用-传递报错字符串-请求成功", priority = 7)
    public void tc_7() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonDupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC3");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3产品打标记-二开注册-请求拦截", priority = 8)
    public void tc_8() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/ApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3产品打标记-二开注册-请求成功", priority = 9)
    public void tc_9() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/ApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3产品不打标记-二开不注册-请求成功", priority = 10)
    public void tc_10() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonAttrApiV3");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3其他服务调用-产品打标记-二开注册-请求拦截", priority = 11)
    public void tc_11() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/DupApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3其他服务调用-产品打标记-二开注册-请求不拦截", priority = 12)
    public void tc_12() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/DupApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3其他服务调用-传递报错字符串-请求拦截", priority = 13)
    public void tc_13() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonDupApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework API-V3其他服务调用-传递报错字符串-请求成功", priority = 14)
    public void tc_14() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonDupApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2产品打标记-二开注册-请求拦截", priority = 15)
    public void tc_15() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/ApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2产品打标记-二开注册-请求成功", priority = 16)
    public void tc_16() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/ApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2产品不打标记-二开不注册-请求成功", priority = 17)
    public void tc_17() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonAttrApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2其他服务调用-产品打标记-二开注册-请求拦截", priority = 18)
    public void tc_18() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/DupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2其他服务调用-产品打标记-二开注册-请求成功", priority = 19)
    public void tc_19() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/DupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC2");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2其他服务调用-传递报错字符串-请求拦截", priority = 20)
    public void tc_20() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonDupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V2其他服务调用-传递报错字符串-请求成功", priority = 21)
    public void tc_21() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAppService/NonDupApiV2");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC3");
        apiCaseEntity.setResponse("5");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("等于");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3产品打标记-二开注册-请求拦截", priority = 22)
    public void tc_22() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/ApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3产品打标记-二开注册-请求成功", priority = 23)
    public void tc_23() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/ApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3产品不打标记-二开不注册-请求成功", priority = 24)
    public void tc_24() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonAttrApiV3");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3其他服务调用-产品打标记-二开注册-请求拦截", priority = 25)
    public void tc_25() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/DupApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3其他服务调用-产品打标记-二开注册-请求不拦截", priority = 26)
    public void tc_26() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/DupApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3其他服务调用-传递报错字符串-请求拦截", priority = 27)
    public void tc_27() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonDupApiV3?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core API-V3其他服务调用-传递报错字符串-请求成功", priority = 28)
    public void tc_28() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/api/00993403/AppDataPermission/NonDupApiV3?CurUserName=WC1");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("\"success\":true");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework AJXA-V2-打标记-请求拦截", priority = 29)
    public void tc_29() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetAll");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework AJXA-V2-打标记-请求成功", priority = 30)
    public void tc_30() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetAll");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("打标记，请求成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework AJXA-V2-不打标记-请求成功", priority = 31)
    public void tc_31() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetNone");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没打标机，请求成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Core AJXA-V2-打标记-请求拦截", priority = 32)
    public void tc_32() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetAll");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core AJXA-V2-打标记-请求成功", priority = 33)
    public void tc_33() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetAll");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("打标记，请求成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core AJXA-V2-不打标记-请求成功", priority = 34)
    public void tc_34() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/ajax/Mysoft.Ylxt.TestProject.AppServices.DataPermissionAjaxHandler/GetNone");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没打标机，请求成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V2-打标记,非Openapi方式登录-请求拦截", priority = 35)
    public void tc_35() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V2-打标记,非Openapi方式登录-请求成功", priority = 36)
    public void tc_36() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V2-打标记，appId+appKey登录-请求成功", priority = 37)
    public void tc_37() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithAppid");
        apiCaseEntity.setAuthType("AppId+AppKey");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V2-不打标记-请求成功", priority = 38)
    public void tc_38() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithoutAttr");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V3-打标记,非Openapi方式登录-请求拦截", priority = 39)
    public void tc_39() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V3-打标记,非Openapi方式登录-请求成功", priority = 40)
    public void tc_40() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V3-打标记，appId+appKey登录-请求成功", priority = 41)
    public void tc_41() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithAppid");
        apiCaseEntity.setAuthType("AppId+AppKey");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Framework PUB-V3-不打标记-请求成功", priority = 42)
    public void tc_42() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/DataPermission/GetDataWithoutAttr?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V2-打标记,非Openapi方式登录-请求拦截", priority = 43)
    public void tc_43() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V2-打标记,非Openapi方式登录-请求成功", priority = 44)
    public void tc_44() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V2-打标记，appId+appKey登录-请求成功", priority = 45)
    public void tc_45() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithAppid");
        apiCaseEntity.setAuthType("AppId+AppKey");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V2-不打标记-请求成功", priority = 46)
    public void tc_46() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithoutAttr");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V3-打标记,非Openapi方式登录-请求拦截", priority = 47)
    public void tc_47() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("没有权限操作此数据!");
        apiCaseEntity.setResponseCode(500);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V3-打标记,非Openapi方式登录-请求成功", priority = 48)
    public void tc_48() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithCookie");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V3-打标记，appId+appKey登录-请求成功", priority = 49)
    public void tc_49() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.Ylxt.TestProject.PublicServices.DataPermissionPublicService/GetDataWithAppid");
        apiCaseEntity.setAuthType("AppId+AppKey");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC1");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("数据权限用例")
    @Test(description = "Core PUB-V3-不打标记-请求成功", priority = 50)
    public void tc_50() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/DataPermission/GetDataWithoutAttr?CurUserName=WC");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/json; charset=UTF-8");
        apiCaseEntity.setReqBody("WC");
        apiCaseEntity.setResponse("调用成功");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("包含");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostCore));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-无标记-通过接口名称IRoutingPubTestV2PublicService调用", priority = 51)
    public void tc_51() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-无标记通过类名RoutingApiTestV2AppService调用", priority = 52)
    public void tc_52() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-无标记通过类名RoutingApiTestV2AppService调用带aspx", priority = 53)
    public void tc_53() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/Test.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-ExportApi标记-通过接口名称IRoutingPubTestV2PublicService调用", priority = 54)
    public void tc_54() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名RoutingApiTestV2AppService调用", priority = 55)
    public void tc_55() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名IRoutingPubTestV2PublicService调用带aspx", priority = 56)
    public void tc_56() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiTest.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名RoutingApiTestV2AppService调用带aspx", priority = 57)
    public void tc_57() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiTest.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-ExportApi标记-方法ExportApiClassTest-接口名称调用", priority = 58)
    public void tc_58() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiClassTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-类名调用", priority = 59)
    public void tc_59() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiClassTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-接口名调用带aspx", priority = 60)
    public void tc_60() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiClassTest.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-类名调用带aspx", priority = 61)
    public void tc_61() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiClassTest.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-接口名调用", priority = 62)
    public void tc_62() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiAsync");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-类名调用", priority = 63)
    public void tc_63() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiAsync");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-接口名调用带aspx", priority = 64)
    public void tc_64() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/ExportApiAsync.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-类名调用带aspx", priority = 65)
    public void tc_65() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingApiTestV2AppService/ExportApiAsync.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名RoutingTestV2AppService-方法Test-接口名调用", priority = 66)
    public void tc_66() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingTestV2AppService/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-接口名RoutingTestV2AppService-方法Test-接口名调用带aspx", priority = 67)
    public void tc_67() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.RoutingTestV2AppService/Test.aspx");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-方法Test-接口名调用", priority = 68)
    public void tc_68() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingPubTestV3/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-方法Test-类名调用", priority = 69)
    public void tc_69() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingApiTestV3/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiTest-接口名调用", priority = 70)
    public void tc_70() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingPubTestV3/ExportApiTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiTest-类名调用", priority = 71)
    public void tc_71() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingApiTestV3/ExportApiTest");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiAsync-接口名调用", priority = 72)
    public void tc_72() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingPubTestV3/ExportApiAsync");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(200);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiAsync-类名调用", priority = 73)
    public void tc_73() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingApiTestV3/ExportApiAsync");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V3-接口名RoutingTestV3AppService-方法Test-接口名调用", priority = 74)
    public void tc_74() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/00993403/RoutingTestV3/Test");
        apiCaseEntity.setAuthType("Cookie");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
            excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


}