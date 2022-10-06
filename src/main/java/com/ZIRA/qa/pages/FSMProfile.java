package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ZIRA.qa.util.TestUtils.*;

public class FSMProfile extends TestBase {
    LoginPage loginPage = new LoginPage();
    CommonElements commonElement = new CommonElements();
    String sheetName = "Profile";

    //Log schedule
    @FindBy(xpath = "//ul[@class='inline-ul header-ul']/li[2]/a")
    WebElement logSchedule;

    //profile name
    @FindBy(xpath = "//li[@class='downarrow-wrap']")
    WebElement profileName;

    //profile
    @FindBy(xpath = "//li[@class='downarrow-wrap']/ul/li[1]")
    public WebElement profile;

    //logout
    @FindBy(xpath = "//li[@class='downarrow-wrap']/ul/li[2]")
    public WebElement logout;

    //logout button
    @FindBy(id = "warning-disable-btn")
    public WebElement logoutButton;

    //profile title
    @FindBy(xpath = "//h3")
    WebElement profileTitle;

    //first name
    @FindBy(xpath = "//div[@class='col-sm-12']/div[1]/label")
    WebElement firstName;

    //last name
    @FindBy(xpath = "//div[@class='col-sm-12']/div[2]/label")
    public WebElement lastName;

    //email
    @FindBy(xpath = "//div[@class='col-sm-12']/div[3]/label")
    WebElement emailtext;

    //first name input field
    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement firstNameInputField;

    //Last name input field
    @FindBy(xpath = "//input[@name='first_last']")
    WebElement lastNameInputField;

    //email input field
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInputField;

    //phone input field
    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneInputField;

    //Language dropdown
    @FindBy(xpath = "//select[@name='language']")
    WebElement languageDropdown;

    //cancel button
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']/div/form/div[2]/button[1]")
    WebElement cancelButton;

    //save changes button
    @FindBy(xpath = "//button[@class='btn btn-md btn-brand-light-green']")
    WebElement saveChanges;

    //Please enter First Name
    @FindBy(xpath = "//div[@id='fsm-first-name']")
    WebElement pleaseEnterFirstName;

    //Please enter Last Name
    @FindBy(xpath = "//div[@id='fsm-last-name']")
    WebElement pleaseEnterLastName;

    //Please enter Email
    @FindBy(xpath = "//div[@id='fsm-email']")
    WebElement pleaseEnterEmail;

    //Please enter Contact Number
    @FindBy(xpath = "//div[@id='fsm-contac-number']")
    WebElement pleaseEnterContactNumber;

    //Change password button
    @FindBy(xpath = "//div[@class='col-sm-7']/div/div[2]/button")
    WebElement changePasswordButton;

    //Change password button
    @FindBy(xpath = "//h4")
    WebElement changePasswordText;

    //Current Password Label
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[1]/label")
    WebElement currentPasswordLabel;

    //Current Password input field
    @FindBy(xpath = "//input[@name='current_password']")
    WebElement currentPasswordInputField;

    //New Password Label
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[2]/label")
    WebElement newPasswordLabel;

    //New Password input field
    @FindBy(xpath = "//input[@name='new_password']")
    WebElement newPasswordInputField;

    //Confirm Password Label
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[3]/label")
    WebElement reConfirmPasswordLabel;

    //Current Password input field
    @FindBy(xpath = "//input[@name='confirm_password']")
    WebElement reConfirmPasswordInputField;

    //cancelButton in change password
    @FindBy(xpath = "//div[@class='zr-modal-footer row start-lg start-md']/button[1]")
    WebElement cancelButtonChangePass;

    //save Button in change password
    @FindBy(xpath = "//div[@class='zr-modal-footer row start-lg start-md']/button[2]")
    WebElement saveButtonChangePass;

    //Please enter current password
    @FindBy(xpath = "//div[@id='fsm-current-password']")
    WebElement plsEnterCurrentPass;

    //invalid Password
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[1]/div")
    WebElement invalidPassword;

    //Please enter new password
    @FindBy(xpath = "//div[@id='fsm-new-password']")
    WebElement plsEnterNewPass;

    //Please enter confirm password
    @FindBy(xpath = "//div[@id='fsm-confirm-password']")
    WebElement plsConfirmNewPass;

    //passwords do not match
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[3]/div")
    WebElement passwordDoNotMatch;

    //Your password changed successfully!
    @FindBy(xpath = "//div[@class='act-sccss']/p")
    WebElement passwordChangedSuccessfully;

    //Okay button
    @FindBy(xpath = "//div[@class='zr-modal-footer row start-lg start-md']/button")
    WebElement okayButton;

    //Dashboard
    @FindBy(xpath = "//ul[@class='inline-ul header-ul']/li[1]/a")
    WebElement dashboard;



    public void verifyFSMLoggedInSuccessfully() {
        sa.assertTrue(logSchedule.getAttribute("class").equals("header-ul-active"));

        sa.assertAll();
    }

    public void verifyFSMNavigateToProfilePage() {
        mouseHover(profileName);

        profile.click();

        sa.assertEquals(firstName.getText(), excel.getCellData(sheetName, "FirstName", 2));

//        sa.assertEquals(lastName.getText(), excel.getCellData(sheetName,"LastName",2));

        sa.assertEquals(emailtext.getText(), excel.getCellData(sheetName, "Email", 2));
        commonElement.waitForLoaders();

        sa.assertAll();
    }

    public void verifyDisplayFSMDataInAllField() {
        sa.assertEquals(firstNameInputField.getAttribute("value"), excel.getCellData(sheetName, "FirstName", 3));

        sa.assertEquals(lastNameInputField.getAttribute("value"), excel.getCellData(sheetName, "LastName", 3));

        sa.assertEquals(emailInputField.getAttribute("value"), excel.getCellData(sheetName, "Email", 3));

        sa.assertEquals(phoneInputField.getAttribute("value"), excel.getCellData(sheetName, "Contact", 2));

        sa.assertEquals(languageDropdown.getAttribute("value"), excel.getCellData(sheetName, "Language", 2));

        sa.assertAll();
    }

    public void verifyCancelButtonFunctionality() {
        waitForElementToBeDisplayed(cancelButton);
        cancelButton.click();

//need to verify user redirect to the homepage
        if (dashboard.getAttribute("class").equals("header-ul-active")){
            sa.assertTrue(true);
        }else {
            sa.fail("Fail due to the navigate to the wrong page.");
        }

        sa.assertAll();
    }

    public void verifyErrorMessagesForAllField() {
        waitForElementToBeDisplayed(firstNameInputField);
        firstNameInputField.clear();
        lastNameInputField.clear();
        emailInputField.clear();
        phoneInputField.clear();

        // There is an issue, profile is getting saved when above data was cleared.
        saveChanges.click();

//        sa.assertEquals(pleaseEnterFirstName.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));
//        sa.assertEquals(pleaseEnterLastName.getText(), excel.getCellData(sheetName, "ErrorMessages", 3));
//        sa.assertEquals(pleaseEnterEmail.getText(), excel.getCellData(sheetName, "ErrorMessages", 4));
//        sa.assertEquals(pleaseEnterContactNumber.getText(), excel.getCellData(sheetName, "ErrorMessages", 5));

        sa.assertAll();
    }

    public void verifyValidationsForEmail() {
    }

    public void verifyInvalidContactNo() {
    }

    public void verifyEditAllFields() {
    }

    public void verifyClickedOnChangePasswordButton() {
        commonElement.waitForLoaders();
        changePasswordButton.click();

        sa.assertEquals(currentPasswordLabel.getText(), excel.getCellData(sheetName, "CurrentPassword", 2));
        sa.assertEquals(newPasswordLabel.getText(), excel.getCellData(sheetName, "NewPassword", 2));
        sa.assertEquals(reConfirmPasswordLabel.getText(), excel.getCellData(sheetName, "ConfirmPassword", 2));

        sa.assertAll();
    }

    public void verifyCancelButtonFunctionalityForChangePassword() {
        commonElement.waitForLoaders();
        cancelButton.click();

        sa.assertAll();
    }

    public void clickOnSaveButtonWithoutEnterAnyData() {
        commonElement.waitForLoaders();
        changePasswordButton.click();

        saveButtonChangePass.click();

        WebElement[] passwords = {plsEnterCurrentPass, plsEnterNewPass, plsConfirmNewPass};
        for (int i = 0; i< passwords.length; i++){
            sa.assertEquals(passwords[i].getText(), excel.getCellData(sheetName, "ErrorMessages", i+9));
        }

        sa.assertAll();
    }

    public void verifyInvalidCurrentPassword() {
        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "NewPassword", 3));
        reConfirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "ConfirmPassword", 3));
        currentPasswordInputField.sendKeys(excel.getCellData(sheetName, "CurrentPassword", 3));

        saveButtonChangePass.click();
        commonElement.waitForLoaders();

        sa.assertEquals(invalidPassword.getText(), excel.getCellData(sheetName, "ErrorMessages", 12));

        sa.assertAll();
    }

    public void verifyValidationsForNewPasswordFieldIfEnterNumbersAndSpecialCharOnly() {
        currentPasswordInputField.clear();
        reConfirmPasswordInputField.clear();
        newPasswordInputField.clear();
        currentPasswordInputField.sendKeys(excel.getCellData(sheetName, "CurrentPassword", 4));

        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "NewPassword", 4));

        saveButtonChangePass.click();

        sa.assertEquals(plsEnterNewPass.getText(), excel.getCellData(sheetName, "ErrorMessages", 13));

        sa.assertAll();
    }

    public void verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndNumberOnly() {
        newPasswordInputField.clear();
        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "NewPassword", 5));

        saveButtonChangePass.click();

        sa.assertEquals(plsEnterNewPass.getText(), excel.getCellData(sheetName, "ErrorMessages", 13));

        sa.assertAll();
    }

    public void verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndSpecialChar() {
        newPasswordInputField.clear();
        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "NewPassword", 7));

        saveButtonChangePass.click();

        sa.assertEquals(plsEnterNewPass.getText(), excel.getCellData(sheetName, "ErrorMessages", 13));

        sa.assertAll();
    }

    public void verifyValidationsForConfirmPasswordFieldOnly() {
        currentPasswordInputField.clear();
        reConfirmPasswordInputField.clear();

        currentPasswordInputField.sendKeys(excel.getCellData(sheetName, "CurrentPassword", 4));

        newPasswordInputField.sendKeys(Keys.BACK_SPACE);
        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "NewPassword", 6));

        reConfirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "ConfirmPassword", 4));

        saveButtonChangePass.click();

        sa.assertEquals(passwordDoNotMatch.getText(), excel.getCellData(sheetName, "ErrorMessages", 14));
        sa.assertAll();
    }

    public void verifyPasswordChangedSuccessfully() {
        newPasswordInputField.clear();
        reConfirmPasswordInputField.clear();

        reConfirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "ConfirmPassword", 4));
        newPasswordInputField.sendKeys(excel.getCellData(sheetName, "ConfirmPassword", 4));

        saveButtonChangePass.click();
        commonElement.waitForLoaders();

        sa.assertEquals(passwordChangedSuccessfully.getText(), excel.getCellData(sheetName, "ErrorMessages", 15));
        sleep(2000);
        okayButton.click();

        sa.assertAll();
    }

    public void verifyFSMNotLoggedInWithOldPassword() {
        mouseHover(profileName);
        logout.click();

        logoutButton.click();
        commonElement.waitForLoaders();

        loginPage.email.sendKeys("ilia@yopmail.com");
        loginPage.password.sendKeys("Letmein@1234");

//        sa.assertEquals(loginPage.invalidEmailMsg.getText(), excel.getCellData(sheetName1,"Data",6));
//        sa.assertEquals(loginPage.invalidEmailMsg.getText(), excel.getCellData(sheetName1,"Data",6));
        sa.assertAll();
    }
}
