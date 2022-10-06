package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        loginPage = new LoginPage();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void createRequiredObjects() {
        driver.navigate().refresh();
        createSoftAssertObject();
    }

    @Test
    public void verifyUserOnLoginPageTest() {
        loginPage.verifyUserOnLoginPage();
    }

    @Test
    public void verifyContentInLoginPageTest() {
        loginPage.verifyContentInLoginPage();
    }

    @Test
    public void verifyLoginWithBlankEmailAndPasswordTest() {
        loginPage.verifyLoginWithBlankEmailAndPassword();
    }

    @Test
    public void verifyLoginWithBlankPasswordTest() {
        loginPage.verifyLoginWithBlankPassword();
    }

    @Test
    public void verifyLoginWithBlankEmailTest() {
        loginPage.verifyLoginWithBlankEmail();
    }

    @Test
    public void verifyLoginWithValidEmailAndInvalidPasswordTest() {
        loginPage.verifyLoginWithValidEmailAndInvalidPassword();
    }

    @Test
    public void verifyLoginWithInvalidEmailAndValidPasswordTest() {
        loginPage.verifyLoginWithInvalidEmailAndValidPassword();
    }

    @Test
    public void verifyLoginWithInvalidEmailAndInvalidPasswordTest() {
        loginPage.verifyLoginWithInvalidEmailAndInvalidPassword();
    }

    @Test
    public void verifyLoginWithValidEmailAndValidPasswordTest() {
        loginPage.verifyLoginWithValidEmailAndValidPassword(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
