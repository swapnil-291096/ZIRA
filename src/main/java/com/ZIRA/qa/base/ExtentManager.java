package com.ZIRA.qa.base;

import com.ZIRA.qa.util.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mayur on 10/02/21, 10:53 PM.
 */
public class ExtentManager {
    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();
    static String reportPath = System.getProperty("user.dir") +
            "/reports/AutomationReport.html";

    public static synchronized ExtentReports createInstance() {

        if (extent == null) {
            ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
            sparkReport.config().setDocumentTitle("Automation Report");
            sparkReport.config().setReportName("Automation Test Results");
            sparkReport.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.setSystemInfo("Executed on Environment: ", TestUtils.getPropertyValueByKey("url"));
            extent.setSystemInfo("Executed on Browser: ", TestUtils.getPropertyValueByKey("browser"));
            extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
            extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
            extent.attachReporter(sparkReport);
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = createInstance().createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
