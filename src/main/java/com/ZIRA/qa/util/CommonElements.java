package com.ZIRA.qa.util;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ZIRA.qa.util.TestUtils.waitForLoader;

public class CommonElements extends TestBase {

    @FindBy(xpath = "//input[@id='email']")
    WebElement mail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public void waitForLoaders(){
            waitForLoader(driver.findElement(By.xpath("//div[@class='loaderwrap-column']")));
    }

    public void login(){
        mail.sendKeys(prop.getProperty("email"));
        password.sendKeys(prop.getProperty("password"));
        submitButton.click();
        waitForLoaders();
    }

    public void FSMLogin(){
        mail.sendKeys(prop.getProperty("FSMEmail"));
        password.sendKeys(prop.getProperty("FSMPassword"));
        submitButton.click();
        waitForLoaders();
    }
}
