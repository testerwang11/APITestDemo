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
public class M6i9p9hthe {

    private String hostFW = "http://10.5.6.14:8001", hostCore = "http://10.5.11.142:8007";
    private ExcelUtilsDemo excelUtilsDemo = new ExcelUtilsDemo();


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-无标记-通过接口名称IRoutingPubTestV2PublicService调用", priority = 1)
    public void tc_1() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("/pub/Mysoft.PubAutoTest.AppServices.IRoutingPubTestV2PublicService/Test");
        apiCaseEntity.setAuthType("AppId+AppKey");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "Post"));
        apiCaseEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
        apiCaseEntity.setReqBody("");
        apiCaseEntity.setResponse("");
        apiCaseEntity.setResponseCode(404);
        apiCaseEntity.setAssertType("");
        excelUtilsDemo.checkCaseStatus(excelUtilsDemo.excute(apiCaseEntity, hostFW));
    }


    @Feature("路由用例")
    @Test(description = "Framework pub-V2-无标记通过类名RoutingApiTestV2AppService调用", priority = 2)
    public void tc_2() {
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
    @Test(description = "Framework pub-V2-无标记通过类名RoutingApiTestV2AppService调用带aspx", priority = 3)
    public void tc_3() {
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
    @Test(description = "Framework pub-V2-ExportApi标记-通过接口名称IRoutingPubTestV2PublicService调用", priority = 4)
    public void tc_4() {
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
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名RoutingApiTestV2AppService调用", priority = 5)
    public void tc_5() {
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
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名IRoutingPubTestV2PublicService调用带aspx", priority = 6)
    public void tc_6() {
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
    @Test(description = "Framework pub-V2-ExportApi标记-通过类名RoutingApiTestV2AppService调用带aspx", priority = 7)
    public void tc_7() {
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
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-ExportApi标记-方法ExportApiClassTest-接口名称调用", priority = 8)
    public void tc_8() {
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
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-类名调用", priority = 9)
    public void tc_9() {
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
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-接口名调用带aspx", priority = 10)
    public void tc_10() {
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
    @Test(description = "Framework pub-V2-接口名称IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiClassTest-类名调用带aspx", priority = 11)
    public void tc_11() {
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
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-接口名调用", priority = 12)
    public void tc_12() {
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
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-类名调用", priority = 13)
    public void tc_13() {
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
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-接口名调用带aspx", priority = 14)
    public void tc_14() {
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
    @Test(description = "Framework pub-V2-接口名IRoutingPubTestV2PublicService-类名RoutingApiTestV2AppService-标记ExportApi-方法ExportApiAsync-类名调用带aspx", priority = 15)
    public void tc_15() {
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
    @Test(description = "Framework pub-V2-接口名RoutingTestV2AppService-方法Test-接口名调用", priority = 16)
    public void tc_16() {
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
    @Test(description = "Framework pub-V2-接口名RoutingTestV2AppService-方法Test-接口名调用带aspx", priority = 17)
    public void tc_17() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-方法Test-接口名调用", priority = 18)
    public void tc_18() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-方法Test-类名调用", priority = 19)
    public void tc_19() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiTest-接口名调用", priority = 20)
    public void tc_20() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiTest-类名调用", priority = 21)
    public void tc_21() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiAsync-接口名调用", priority = 22)
    public void tc_22() {
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
    @Test(description = "Framework pub-V3-接口名IRoutingPubTestV3PublicService-类名RoutingApiTestV3AppService-标记ExportApi-方法ExportApiAsync-类名调用", priority = 23)
    public void tc_23() {
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
    @Test(description = "Framework pub-V3-接口名RoutingTestV3AppService-方法Test-接口名调用", priority = 24)
    public void tc_24() {
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