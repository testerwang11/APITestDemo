package com.autotest.mysoft;

import com.autotest.entity.AssertResEntity;
import com.autotest.entity.RequestEntity;
import com.autotest.enums.AuthType;
import com.autotest.enums.DiffType;
import com.autotest.enums.MethodType;
import com.autotest.utils.ApiTestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {



    @Test
    public void test111() {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setUri("/pub/Mysoft.PubPlatform.Message.Interfaces.ISendMessagePublicService/QueryTaskWakeHistoryList");
        requestEntity.setAuthType(AuthType.AppKey);
        requestEntity.setMethod(MethodType.Post.getName());
        requestEntity.setBody("{\n" +
                "  \"wakeMode\": 2,\n" +
                "  \"pageSize\": 20,\n" +
                "  \"pageIndex\": 0,\n" +
                "  \"appCode\": \"0220\",\n" +
                "  \"buGuid\": null,\n" +
                "  \"projGuid\": null,\n" +
                "  \"BusinessType\":\"供应商考察\",\n" +
                "  \"OrderBy\": \"asc\"\n" +
                "}");
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        AssertResEntity assertResEntity = new AssertResEntity();
        assertResEntity.setDiffType(DiffType.JsonSchema);
        assertResEntity.setMethodName(methodName);
        ApiTestUtil apiTestUtil = new ApiTestUtil();
        apiTestUtil.setRequestEntity(requestEntity);
        Assert.assertTrue(apiTestUtil.callApi(assertResEntity).isSuccess());
    }
}
