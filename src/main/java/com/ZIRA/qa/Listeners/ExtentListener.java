package com.ZIRA.qa.Listeners;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.TestUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Mayur on 10/02/21, 11:02 PM.
 */
public class ExtentListener extends TestBase implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.startTest(result.getName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "<b>Test Method " + result.getName() + " Successful</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentManager.getTest().log(Status.PASS, m);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        ExtentManager.getTest().fail("<details><summary><b><font color=red>" + "Exception Occurred, click to see details:" +
                "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
        String screenShotPath = TestUtils.capture(result.getName());
        try {
            ExtentManager.getTest().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotPath).build());
        } catch (IOException e) {
            ExtentManager.getTest().fail("Test Failed, cannot attach screenshot");
        }
        String logText = "<b>Test Method " + methodName + " Failed</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ExtentManager.getTest().log(Status.FAIL, m);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        ExtentManager.getTest().log(Status.SKIP, m);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.createInstance().flush();
    }
}