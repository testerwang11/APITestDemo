package com.autotest.listeners;

import com.autotest.enums.EnvType;
import com.autotest.mode.TestResultStoragePO;
import com.autotest.services.TestResultService;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.collections.Lists;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StorageHandler {
    private TestResultService testResultService = new TestResultService();
    private EnvType env;

    /**
     * 获取当前测试环境
     *
     * @return
     */
    private String getEnvModel() {

        return Objects.toString("测试环境", StringUtils.EMPTY);
    }

    /**
     * 获取ITestContext中的测试结果，将结果插入到数据库
     *
     * @param testContext
     */
    public void handle(ITestContext testContext) {
        //所有测试结果
        List<TestResultStoragePO> testResultStoragePOs = Lists.newArrayList();
        String env = getEnvModel();
        String testTaskId = generatorId();
        String testName = testContext.getName();
        testContext.getPassedTests().getAllResults().forEach(iTestResult -> testResultStoragePOs.add
                (assembleTestResult(iTestResult, env, testTaskId, testName)));
        testContext.getSkippedTests().getAllResults().forEach(iTestResult -> testResultStoragePOs.add
                (assembleTestResult(iTestResult, env, testTaskId, testName)));
        testContext.getFailedTests().getAllResults().forEach(iTestResult -> testResultStoragePOs.add
                (assembleTestResult(iTestResult, env, testTaskId, testName)));
        insertData(testResultStoragePOs);
    }

    /**
     * 组装测试用例结果入库对象
     *
     * @param testResult
     * @param env
     * @param testTaskId
     * @param testName
     * @return
     */
    private TestResultStoragePO assembleTestResult(ITestResult testResult, String env, String testTaskId, String testName) {
        TestResultStoragePO testResultStoragePO = new TestResultStoragePO();
        testResultStoragePO.setTestClass(testResult.getTestClass().getName());
        testResultStoragePO.setMethod(testResult.getName());
        testResultStoragePO.setStartTime(testResult.getStartMillis());
        testResultStoragePO.setEndTime(testResult.getEndMillis());
        testResultStoragePO.setStatus(testResult.getStatus());
        testResultStoragePO.setErrMsg(testResult.getThrowable() == null ? "" : testResult.getThrowable().getMessage());
        testResultStoragePO.setEnv(env);
        testResultStoragePO.setTestTaskId(testTaskId);
        testResultStoragePO.setId(generatorId());
        testResultStoragePO.setTestName(testName);
        testResultStoragePO.setDescription(testResult.getMethod().getDescription());
        return testResultStoragePO;
    }

    /**
     * 向数据库中插入测试结果数据
     *
     * @param testResultStoragePOs
     */
    private void insertData(List<TestResultStoragePO> testResultStoragePOs) {
        try {
            testResultService.insertTestResult(testResultStoragePOs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成唯一ID
     *
     * @return
     */
    private String generatorId() {
        String s = UUID.randomUUID().toString();
        return s.replaceAll("-", "");
    }

}
