package ${packageName};

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
public class ${className} {

    private String hostFW = "${hostFW}";
    private String hostCore = "${hostCore}";


<#assign id= 1 />
<#list apis as api>
    @Feature("${api.suitName}")
    <#if api.enable>
    @Test(description = "${api.description!}", priority = ${id})
    <#else>
    @Test(description = "${api.description!}", priority = ${id}, enabled = false)
    </#if>
    public void tc_${id}() {
        ApiCaseEntity apiCaseEntity = new ApiCaseEntity();
        apiCaseEntity.setReqUrl("${api.reqUrl}");
        apiCaseEntity.setAuthType("${api.authType}");
        apiCaseEntity.setMethodType(EnumUtils.getEnum(MethodType.class, "${api.methodType}"));
        apiCaseEntity.setReqBody("${api.reqBody!}");
        apiCaseEntity.setResponse("${api.response}");
        apiCaseEntity.setResponseCode(${api.responseCode?number});
        apiCaseEntity.setAssertType("${api.assertType}");
        <#if api.platformType == "Framework">
            ExcelUtilsDemo.checkCaseStatus(ExcelUtilsDemo.excute(apiCaseEntity, hostFW));
        <#else >
            ExcelUtilsDemo.checkCaseStatus(ExcelUtilsDemo.excute(apiCaseEntity, hostCore));
        </#if>
    }
    <#assign id = id + 1 />


</#list>
}