package com.autotest.listeners;


import com.autotest.utils.ConfigManager;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngRetry implements IRetryAnalyzer {
	private static Logger logger = Logger.getLogger(TestngRetry.class);
	private int retryCount = 1;
	private static int maxRetryCount = 2;
	
	static {
		maxRetryCount = Integer.parseInt(ConfigManager.getInstance().getProperty("retrycount").trim());
		logger.info("retrycount=" + maxRetryCount);
		logger.info("sourceCodeDir=" + ConfigManager.getInstance().getProperty("sourcecodedir"));
		logger.info("sourceCodeEncoding=" + ConfigManager.getInstance().getProperty("sourcecodeencoding"));
	}
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "Retry for [" + result.getName() + "] on class [" + result.getTestClass().getName() + "] Retry "
					+ retryCount + " times";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}

	public static int getMaxRetryCount() {
		return maxRetryCount;
	}
	
	public int getRetryCount() {
		return retryCount;
	}
}
