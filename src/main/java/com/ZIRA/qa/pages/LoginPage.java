package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase {
    String sheetName = "LoginPage";
    HomePage homePage = new HomePage();
    CommonElements commonElements = new CommonElements();

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[@class='logo-img']")
    public WebElement ZiraLogo;

    @FindBy(xpath = "//a[@class='login-links']")
    WebElement forgotPassLink ;

    @FindBy(xpath = "//span[@class='login-frm-ico icon-zirauser']")
    WebElement emailIcon ;

    @FindBy(xpath = "//span[@class='login-frm-ico icon-ziralock']")
    WebElement passwordIcon ;

    //Please enter an email address.
    @FindBy(xpath = "//div[@id='requiredEmail']")
    WebElement requiredEmailMsg ;

    //Please enter password.
    @FindBy(xpath = "//div[@id='requiredPassword']")
    WebElement requiredPasswordMsg ;

    //Please enter valid email address.1
    @FindBy(xpath = "//div[@id='invalidEmail']")
    WebElement invalidEmailMsg ;

    //Please enter valid email address.2
    @FindBy(xpath = "//*[@id='loginForm']/div[1]/div[1]/div")
    WebElement PlsEnterValidEmail ;

    //Actions:
    public void verifyUserOnLoginPage(){
        sa.assertEquals(driver.getTitle(), excel.getCellData(sheetName,"Data",8));
        ExtentManager.getTest().log(Status.INFO, "Page title verified.");
    }

    public void verifyContentInLoginPage(){
        WebElement[] pageDetails = {ZiraLogo, email, emailIcon, password, passwordIcon};
        for (WebElement pageDetail : pageDetails) {
            pageDetail.isDisplayed();
        }

        sa.assertEquals(loginBtn.getText(), excel.getCellData(sheetName,"Data",9));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Log In");

        sa.assertEquals(forgotPassLink.getText(), excel.getCellData(sheetName,"Data",10));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Forgot Password?");

        sa.assertAll();
    }

    public void verifyLoginWithBlankEmailAndPassword(){
        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(requiredEmailMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter your email address");

        sa.assertEquals(requiredPasswordMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter password.");
        sa.assertAll();
    }

    public void verifyLoginWithBlankPassword(){
        email.sendKeys(excel.getCellData(sheetName,"Data",3));
        ExtentManager.getTest().log(Status.INFO, "Sent keys into email field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(requiredPasswordMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter password.");

        sa.assertAll();
    }

    public void verifyLoginWithBlankEmail(){
        password.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent keys into password field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(requiredEmailMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter your email address");

        sa.assertAll();
    }

    public void verifyLoginWithValidEmailAndInvalidPassword(){

        email.sendKeys(excel.getCellData(sheetName,"Data",2));
        ExtentManager.getTest().log(Status.INFO, "Sent valid keys into email field");

        password.sendKeys(excel.getCellData(sheetName,"Data",5));
        ExtentManager.getTest().log(Status.INFO, "Sent invalid keys into password field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(PlsEnterValidEmail.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter valid email address.");

        sa.assertAll();
    }

    public void verifyLoginWithInvalidEmailAndValidPassword(){

        email.sendKeys(excel.getCellData(sheetName,"Data",3));
        ExtentManager.getTest().log(Status.INFO, "Sent invalid keys into email field");

        password.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent valid keys into password field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(invalidEmailMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter valid email address.");

        sa.assertAll();
    }

    public void verifyLoginWithInvalidEmailAndInvalidPassword(){

        email.sendKeys(excel.getCellData(sheetName,"Data",3));
        ExtentManager.getTest().log(Status.INFO, "Sent invalid keys into email field");

        password.sendKeys(excel.getCellData(sheetName,"Data",5));
        ExtentManager.getTest().log(Status.INFO, "Sent invalid keys into password field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");

        sa.assertEquals(invalidEmailMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter valid email address.");

        sa.assertAll();
    }

    public void verifyLoginWithValidEmailAndValidPassword(String mail, String passwords){
        email.sendKeys(mail);
        ExtentManager.getTest().log(Status.INFO, "Sent keys into email field");

        password.sendKeys(passwords);
        ExtentManager.getTest().log(Status.INFO, "Sent keys into password field");

        loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login Button.");
        commonElements.waitForLoaders();

        homePage.ImageLogo.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Zira Logo Image on home page.");

        sa.assertEquals(homePage.administrationLink.getText(), excel.getCellData(sheetName,"Data",6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Administration");

        sa.assertEquals(homePage.ziraMastersLink.getText(), excel.getCellData(sheetName,"Data",7));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Zira Masters");

        sa.assertAll();
    }
}
