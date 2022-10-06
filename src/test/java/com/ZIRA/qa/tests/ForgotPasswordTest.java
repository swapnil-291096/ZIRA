package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.ForgotPasswordPage;
import com.ZIRA.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase {
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;

    public ForgotPasswordTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        forgotPasswordPage = new ForgotPasswordPage();
        loginPage = new LoginPage();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void refresh() {
        driver.navigate().refresh();
        createSoftAssertObject();
    }

    @Test
    public void verifyUserOnForgotPasswordPageTest() {
        forgotPasswordPage.verifyUserOnForgotPasswordPage();
    }

    @Test
    public void verifySubmitButtonFunctionalityWithBlankEmailTest() {
        forgotPasswordPage.verifySubmitButtonFunctionalityWithBlankEmail();
    }

    @Test
    public void verifySubmitButtonFunctionalityWithInvalidMailTest() {
        forgotPasswordPage.verifySubmitButtonFunctionalityWithInvalidMail();
    }

    @Test
    public void verifySubmitButtonFunctionalityWithWrongMailTest() {
        forgotPasswordPage.verifySubmitButtonFunctionalityWithWrongMail();
    }

    @Test
    public void verifyCancelFunctionalityTest() {
        forgotPasswordPage.verifyCancelFunctionality();
    }

    @Test
    public void verifySubmitButtonWithValidMailTest() {
        forgotPasswordPage.verifySubmitButtonWithValidMail(prop.getProperty("email"));
    }

    @Test
    public void verifyResetPasswordTest() throws Exception {
        forgotPasswordPage.verifyResetPassword();
    }

    @Test
    public void navigateToResetPasswordPageTest() {
        forgotPasswordPage.navigateToResetPasswordPage();
    }

    @Test
    public void verifySubmitPasswordWithoutEnterDataTest() {
        forgotPasswordPage.verifySubmitPasswordWithoutEnterData();
    }

    @Test
    public void verifySubmitPasswordWithNewPasswordOnlyTest() {
        forgotPasswordPage.verifySubmitPasswordWithNewPasswordOnly();
    }

    @Test
    public void verifySubmitPasswordWithConfirmNewPasswordOnlyTest() {
        forgotPasswordPage.verifySubmitPasswordWithConfirmNewPasswordOnly();
    }

    @Test
    public void verifyValidationWhenLettersAreLessThanSixTest() {
        forgotPasswordPage.verifyValidationWhenLettersAreLessThanSix();
    }

    @Test
    public void verifyValidationWhenLettersMoreThanEighteenCharTest() {
        forgotPasswordPage.verifyValidationWhenLettersMoreThanEighteenChar();
    }

    @Test
    public void verifyPasswordMismatchTest() {
        forgotPasswordPage.verifyPasswordMismatch(prop.getProperty("password"));
    }

    @Test
    public void verifySubmitWithValidPasswordTest() {
        forgotPasswordPage.verifySubmitWithValidPassword(prop.getProperty("newPassword"), prop.getProperty("confirmNewPassword"));
    }

    @Test
    public void verifyUserRedirectToLoginPageTest() {
        forgotPasswordPage.verifyUserRedirectToLoginPage();
    }

    @Test
    public void verifyLoginWithNewPasswordTest() {
        forgotPasswordPage.verifyLoginWithNewPassword(prop.getProperty("email"), prop.getProperty("newPassword"));
    }

    @Test
    public void verifyUserLoggedInSuccessfullyWithNewPasswordTest() {
        forgotPasswordPage.verifyUserLoggedInSuccessfullyWithNewPassword();
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
