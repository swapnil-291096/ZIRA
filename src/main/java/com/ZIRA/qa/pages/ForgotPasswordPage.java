package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import com.ZIRA.qa.util.EmailVerification;
import com.ZIRA.qa.util.TestUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ForgotPasswordPage extends TestBase {
    CommonElements commonElements = new CommonElements();
    String sheetName = "ForgotPassword";

    String url;
    LoginPage loginpage = new LoginPage();
    EmailVerification emailVerification = new EmailVerification();
    HomePage homePage = new HomePage();

    @FindBy(xpath = "//img[@class='logo-img']")
    WebElement ZiraLogo;

    @FindBy(xpath = "//div[@class='col-lg-12 forgot-pass-ttle']")
    WebElement forgotPasswordText;

    @FindBy(xpath = "//input[@id='forgotPasswordEmail']")
    WebElement forgotPasswordEmailField;

    @FindBy(xpath = "//button[@class='btn btn-block']")
    WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='boxmodal-footer center-xs']/div/button[2]")
    WebElement submitBtn;

    @FindBy(xpath = "//a[@class='login-links']")
    WebElement forgotPasswordLink;

    //Please enter an email address.
    @FindBy(xpath = "//div[@id='requiredForgotPasswordEmail']")
    WebElement PleaseEnterAnEmailAddressMsg;

    //The email address that you have entered doesn't match any account. Please enter your registered email address.
    @FindBy(xpath = "//div[@class='errormsg-div']")
    WebElement invalidEmailMsg;

    //Please enter valid email address.
    @FindBy(xpath = "//div[@id = 'invalidForgotPasswordEmail']")
    WebElement plsEnterValidEmail;

    @FindBy(xpath = "//button[@class='btn btn-brand-light-green btn-lg btn-block btn-submit']")
    WebElement OkButton;

    //Reset Password Page
    //Reset Password
    @FindBy(xpath = "//div[@class = 'col-lg-12 forgot-pass-ttle']")
    WebElement resetPasswordText;

    //Please enter new password.
    @FindBy(xpath = "//div[@id = 'requiredPassword']")
    WebElement plsEnterNewPassword;

    //Please enter confirm password.
    @FindBy(xpath = "//div[@id = 'requiredConfirmPassword']")
    WebElement plsEnterConfirmPassword;

    //Password should consist of upper case letters, lower case letters, numbers and special characters.
    @FindBy(xpath = "//div[@id = 'patternPassword']")
    WebElement validationMessage;

    //Password Length: Minimum 6 characters.Maximum 18 characters.
    @FindBy(xpath = "//div[@id = 'minlengthPassword']")
    WebElement minLengthPassword;

    //Submit Button
    @FindBy(xpath = "//button[@class='btn btn-brand-light-green btn-lg btn-block']")
    WebElement submitButton;

    //New Password Field
    @FindBy(xpath = "//input[@id='password']")
    WebElement newPasswordField;

    //confirm new Password
    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmNewPasswordField;

    //Both the passwords do not match.
    @FindBy(xpath = "//div[@id='doNotMatch']")
    WebElement bothPasswordNotMatch;


    public void verifyUserOnForgotPasswordPage() {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked");

        ZiraLogo.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Zira Logo is displayed.");

        sa.assertEquals(forgotPasswordText.getText(), excel.getCellData(sheetName, "Title", 2));
        ExtentManager.getTest().log(Status.INFO, "link text verified.");

        forgotPasswordEmailField.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "forgot Password Email Field displayed.");

        sa.assertEquals(cancelBtn.getText(), excel.getCellData(sheetName, "Title", 3));
        ExtentManager.getTest().log(Status.INFO, "Verified Text: Cancel");

        sa.assertEquals(submitBtn.getText(), excel.getCellData(sheetName, "Title", 4));
        ExtentManager.getTest().log(Status.INFO, "Verified Text: Submit");

        sa.assertAll();
    }

    public void verifySubmitButtonFunctionalityWithBlankEmail() {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked");

        submitBtn.click();
        ExtentManager.getTest().log(Status.INFO, "submitBtn is Clicked.");

        sa.assertEquals(PleaseEnterAnEmailAddressMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));
        ExtentManager.getTest().log(Status.INFO, "Verified Message: Please enter your email address");

        sa.assertAll();
    }

    public void verifySubmitButtonFunctionalityWithInvalidMail() {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked");

        forgotPasswordEmailField.sendKeys(excel.getCellData(sheetName, "Data", 2));
        ExtentManager.getTest().log(Status.INFO, "Sent keys in forgot password email field.");

        submitBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(invalidEmailMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 3));
        ExtentManager.getTest().log(Status.INFO, "Please enter registered email address.");

        sa.assertAll();
    }

    public void verifySubmitButtonFunctionalityWithWrongMail() {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked");

        forgotPasswordEmailField.sendKeys(excel.getCellData(sheetName, "Data", 3));
        ExtentManager.getTest().log(Status.INFO, "Sent keys in forgot password email field.");

        submitBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(plsEnterValidEmail.getText(), excel.getCellData(sheetName, "ErrorMessages", 4));
        ExtentManager.getTest().log(Status.INFO, "Verified Message: Please enter valid email address.");

        sa.assertAll();
    }

    public void verifyCancelFunctionality() {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked.");

        cancelBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Cancel Button.");

        sa.assertEquals(loginpage.loginBtn.getText(), excel.getCellData(sheetName, "Title", 5));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Log In");

        sa.assertEquals(forgotPasswordLink.getText(), excel.getCellData(sheetName, "Title", 6));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Forgot Password?");

        sa.assertAll();
    }

    public void verifySubmitButtonWithValidMail(String mail) {
        forgotPasswordLink.click();
        ExtentManager.getTest().log(Status.INFO, "forgot password link clicked.");

        forgotPasswordEmailField.sendKeys(mail);
        ExtentManager.getTest().log(Status.INFO, "Sent valid keys into forgot Password Email Field.");

        submitBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Submit Button.");
        TestUtils.sleep(5000L);

        OkButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK Button.");

        sa.assertAll();
    }

    public void verifyResetPassword() throws Exception {
        TestUtils.sleep(8000L);
        String val = emailVerification.getMailData("ZIRA", "ZIRA - Reset Password", "swapnil.shinde@mobifilia.com", "Ss@9527810513");
        System.out.println(val);
        ExtentManager.getTest().log(Status.INFO, "Got the email text");

        url = emailVerification.extractURL(val);
        System.out.println(url);
        ExtentManager.getTest().log(Status.INFO, "Extracted the url from mail");

        sa.assertAll();
    }

    public void navigateToResetPasswordPage() {
        driver.get(url);
        ExtentManager.getTest().log(Status.INFO, "Opened Reset password Url from mail");

        loginpage.ZiraLogo.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Zira Logo.");

        sa.assertEquals(resetPasswordText.getText(), excel.getCellData(sheetName, "Title", 7));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Reset Password");

        sa.assertEquals(submitButton.getText(), excel.getCellData(sheetName, "Title", 8));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Submit");

        newPasswordField.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed New Password Field.");

        confirmNewPasswordField.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Confirm New Password Field.");

        sa.assertAll();
    }

    public void verifySubmitPasswordWithoutEnterData() {
        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Submit Button");

        sa.assertEquals(plsEnterNewPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 5));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter new password.");

        sa.assertEquals(plsEnterConfirmPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please confirm new password");

        sa.assertAll();
    }

    public void verifySubmitPasswordWithNewPasswordOnly() {

        newPasswordField.sendKeys(excel.getCellData(sheetName, "Data", 4));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in new Password Field only");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(validationMessage.getText(), excel.getCellData(sheetName, "ErrorMessages", 7));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Password should consist of upper case letters,\n" +
                "lower case letters, numbers and special characters.");

        sa.assertEquals(plsEnterConfirmPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please confirm new password");

        sa.assertAll();
    }

    public void verifySubmitPasswordWithConfirmNewPasswordOnly() {

        newPasswordField.sendKeys(excel.getCellData(sheetName, "Data", 4));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in confirm new Password Field only");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(validationMessage.getText(), excel.getCellData(sheetName, "ErrorMessages", 7));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Password should consist of upper case letters,\n" +
                "lower case letters, numbers and special characters.");

        sa.assertEquals(plsEnterConfirmPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please confirm new password");

        sa.assertAll();
    }

    public void verifyValidationWhenLettersAreLessThanSix() {

        newPasswordField.sendKeys(excel.getCellData(sheetName, "Data", 5));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in Less than six char. in new Password Field only");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(minLengthPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 9));
        ExtentManager.getTest().log(Status.INFO, "Verified text:- Password Length: Minimum 6 characters.\n" +
                "Maximum 18 characters.");

        sa.assertEquals(plsEnterConfirmPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please confirm new password");

        sa.assertAll();
    }

    public void verifyValidationWhenLettersMoreThanEighteenChar() {

        newPasswordField.sendKeys(excel.getCellData(sheetName, "Data", 6));
        if (newPasswordField.getAttribute("value").length() > 18) {
            sa.fail("Except more than 18 char.");
        } else {
            sa.assertTrue(true);
        }
        ExtentManager.getTest().log(Status.INFO, "Sent Keys Less than six char. in new Password Field only");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertAll();
    }

    public void verifyPasswordMismatch(String resetPsd) {

        newPasswordField.sendKeys(resetPsd);
        ExtentManager.getTest().log(Status.INFO, "Sent Keys  in new Password Field.");

        confirmNewPasswordField.sendKeys(excel.getCellData(sheetName, "Data", 8));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in confirm new Password Field not matched with new password field.");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");

        sa.assertEquals(bothPasswordNotMatch.getText(), excel.getCellData(sheetName, "ErrorMessages", 10));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Entered passwords do not match. Please re-enter the password");

        sa.assertAll();
    }

    public void verifySubmitWithValidPassword(String resetNewPsd, String confirmNewPsd) {
        newPasswordField.sendKeys(resetNewPsd);
        ExtentManager.getTest().log(Status.INFO, "Sent Keys  in new Password Field.");

        confirmNewPasswordField.sendKeys(confirmNewPsd);
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in confirm new Password Field.");

        submitButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on submit button.");
        TestUtils.sleep(8000);

        sa.assertAll();
    }

    public void verifyUserRedirectToLoginPage() {
        loginpage.verifyContentInLoginPage();
        ExtentManager.getTest().log(Status.INFO, "Verified all content on login page");

        sa.assertAll();
    }

    public void verifyLoginWithNewPassword(String mail, String passwords) {
        driver.get("https://stage.zirafs.com/login");
//        TestUtils.sleep(5000);
        loginpage.email.sendKeys(mail);
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in email Field.");

        loginpage.password.sendKeys(passwords);
        ExtentManager.getTest().log(Status.INFO, "Sent Keys in password Field.");

        loginpage.loginBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on login button.");

        homePage.ImageLogo.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Zira logo on home page");

        sa.assertAll();
    }

    public void verifyUserLoggedInSuccessfullyWithNewPassword() {
        homePage.verifyContentOnHomePage();
    }
}
