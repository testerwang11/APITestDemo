package com.autotest.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ExtentTestNGITestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance("target/extent.html" );
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private static String message;

    @Override
    public synchronized void onStart(ITestContext context) {
        //context.getSuite().getName();
        ExtentTest parent = extent.createTest(context.getName());
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.setSystemInfo("环境", System.getProperty("环境"));
        try {
            extent.setSystemInfo("运行机IP", InetAddress.getLocalHost().getHostAddress());
            extent.setSystemInfo("服务器IP", InetAddress.getByName("www.ch.com").getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        ExtentManager.setProjectName(System.getProperty("projectName"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(child);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        getTest().log(Status.INFO, message);
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public synchronized static ExtentTest getTest() {
        return test.get();
    }

    public synchronized static void logOutPut(String imgSrc, String headerName) {
        String imgPath = "<div class='col l4 m6 s12'>"
                + "<div class='card-panel'><h4 class='md-display-4'>"
                + headerName + "</h4><img src=" + imgSrc
                + " style=\"width:100%;height:100%;\"></div></div>";
        extent.setTestRunnerOutput(imgPath);

    }

    public synchronized static void logVideo(String videoSrc, String headerName) {
        String videoPath = "<div class='col l4 m6 s12'>"
                + "<div class='card-panel'><h4 class='md-display-4'>"
                + headerName + "</h4><video width=\"320\" height=\"240\" controls>"
                + "<source src="
                + videoSrc + " style=\"width:100%;height:100%;\" type=\"video/mp4\">"
                + "</video></div></div>";
        extent.setTestRunnerOutput(videoPath);
    }

    public synchronized static void logImg(String imgSrc, String headerName) {
        String imgPath = "<div class='col l4 m6 s12'>"
                + "<div class='card-panel'><h4 class='md-display-4'>"
                + headerName + "</h4><video width=\"320\" height=\"240\" controls>"
                + "<source src="
                + imgSrc + " style=\"width:100%;height:100%;\" type=\"video/mp4\">"
                + "</video></div></div>";
        extent.setTestRunnerOutput(imgPath);
    }

    public synchronized static void logger(String message1) {
        try{
            message = message1;
            //getTest().log(Status.INFO, message);
        }catch(Exception e){

        }
    }
}
