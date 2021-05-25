package com.autotest.listeners;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

/**
 * 保存测试结果至数据库
 */
public class TestResultStorageListener extends TestListenerAdapter {

    public void onFinish(ITestContext testContext) {
        new StorageHandler().handle(testContext);
    }

}
