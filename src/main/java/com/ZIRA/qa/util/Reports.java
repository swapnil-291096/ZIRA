package com.ZIRA.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by Mayur on 29/09/17.
 */
public class Reports
{
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    //    @BeforeSuite
    public void startReport()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Report/TestReport.html");
        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "Mobifilia Software India LLP");
        extent.setSystemInfo("Environment", "Dev");
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Test Automation Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    //    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        String screenShotPath =  TestUtils.capture(result.getName());
        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(new File(screenShotPath)));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            test.fail("<details><summary><b><font color=red>Exception Occurred, click to see details:" +"</font></b></summary>"+ exceptionMessage.replaceAll(",","<br>")+"</details> \n");

            try {
                test.fail("<b><font color=red>"+"Screenshot of failure" + "</font></b>", MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.UTF_8)).build());
            } catch (IOException e){
                test.fail("Test fail, cannot attach screenshot");
            }

            String logText = "<b>Text Method "+result.getName()+"Failed</b>";
            Markup markup=MarkupHelper.createLabel(logText,ExtentColor.RED);
            test.log(Status.FAIL,markup);
//            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
//            test.fail(result.getThrowable());
            test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    //    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}