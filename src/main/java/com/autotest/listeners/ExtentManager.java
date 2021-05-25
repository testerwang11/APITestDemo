package com.autotest.listeners;

import com.autotest.utils.ConfigManager;
import com.autotest.utils.DateUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ExtentManager {

    private static ExtentReports extent;
    private static KlovReporter klovReporter;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance("target/extent.html");
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        extent = new ExtentReports();
        //extent.attachReporter(createHtmlReporter(fileName), createKlovReporter());
        extent.attachReporter(createHtmlReporter(fileName));

        return extent;
    }

    public static ExtentHtmlReporter createHtmlReporter(String fileName){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        return htmlReporter;
    }

    public static KlovReporter createKlovReporter() {
        klovReporter = new KlovReporter();
        klovReporter.initMongoDbConnection(ConfigManager.getInstance().getProperty("mongodb_host"), ConfigManager.getInstance().getNumber("mongodb_port"));
        klovReporter.setKlovUrl(ConfigManager.getInstance().getProperty("klov_url"));
        return klovReporter;
    }

    public static void setProjectName(String projectName) {
        klovReporter.setProjectName(projectName);
        klovReporter.setReportName(projectName);
        extent.attachReporter(klovReporter);

    }
}