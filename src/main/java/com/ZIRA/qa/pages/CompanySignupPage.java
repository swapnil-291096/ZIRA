package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.ZIRA.qa.util.TestUtils.*;

public class CompanySignupPage extends TestBase {
    CommonElements commonElements = new CommonElements();

    String sheetName = "FSMSignup";

    //    Company Sign Up
    @FindBy(xpath = "//h2")
    WebElement CompanySignupTitle;

    //    Signup Button
    @FindBy(xpath = "//button[@class='btn btn-brand-light-green btn-lg']")
    public WebElement signupButton;

    //    Company name input Field
    @FindBy(xpath = "//input[@id='companyName']")
    public WebElement companyNameInputField;

    //    First name input Field
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameInputField;

    //    Last name input Field
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameInputField;

    //    Email input Field
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInputField;

    //    Email already exists!
    @FindBy(xpath = "//div[@class='frm-errmsg']")
    WebElement emailAlreadyExist;

    //    Contact Number input Field
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement contactNoInputField;

    //    Select Company Profile dropdown
    @FindBy(xpath = "//input[@class='c-btn']")
    WebElement selectCompanyProfile;

    //    Password input Field
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInputField;

    //    Confirm Password input Field
    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmPasswordInputField;

    //    Please enter Company Name
    @FindBy(xpath = "//div[@class='frm-errmsg']")
    List<WebElement> errorMsgList;

    //    Please enter Company Name
    @FindBy(xpath = "//div[@class='form-grp']/div[1]/div[1]")
    WebElement companyNameErrorMsg;

    //    Please enter FSM First Name
    @FindBy(xpath = "//div[@class='form-grp']/div[3]/div[1]")
    WebElement firstNameErrorMsg;

    //    Please enter FSM Last Name
    @FindBy(xpath = "//div[@class='form-grp']/div[4]/div[1]")
    WebElement lastNameErrorMsg;

    //    Please enter FSM Email
    @FindBy(xpath = "//div[@class='form-grp']/div[5]/div[1]")
    WebElement emailErrorMsg;

    //    Invalid contact number.
    @FindBy(xpath = "//div[@class='form-grp']/div[6]/div[1]")
    WebElement contactNumberErrorMsg;

    //    Please select company profile
    @FindBy(xpath = "//div[@class='form-grp']/div[7]/div[2]")
    WebElement companyProfileErrorMsg;

    //    Password is required.
    @FindBy(id = "fsm-password")
    WebElement passwordErrorMsg;

    //    Password should consist of upper case, lower case, numbers and special characters.
    @FindBy(xpath = "//div[@class='zr-input-msg pass-icon label-icn pass-errmsg']//div[2]")
    WebElement passwordValidationErrorMsg2;

    //    Passwords do not match
    @FindBy(xpath = "//div[@class='form-grp']/div[11]/div[1]")
    WebElement confirmPasswordErrorMsg;

    //    country code
    @FindBy(xpath = "//div[@class='selected-dial-code']")
    WebElement countryCode;

    //    Country India
    @FindBy(xpath = "//ul[@class='iti__country-list']/li[101]")
    WebElement india;

    //    country Dropdown
    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    WebElement countryDropdown;

    //    Contacts-Country Dropdown search
    @FindBy(xpath = "//input[@id='country-search-box']")
    WebElement countryDropdownSearch;

    //    company profile 1st item cross button
    @FindBy(xpath = "//div[@class='c-list']/div[1]/span[2]")
    WebElement firstItemCrossButton;

    //    company profile 2nd item cross button
    @FindBy(xpath = "//div[@class='c-list']/div[2]/span[2]")
    WebElement secondItemCrossButton;

    //    company profile 3rd item cross button
    @FindBy(xpath = "//div[@class='c-list']/div[3]/span[2]")
    WebElement thirdItemCrossButton;

    //    company profile 4th item cross button
    @FindBy(xpath = "//div[@class='c-list']/div[4]/span[2]")
    WebElement fourthItemCrossButton;

    //    company profile dropdown
    @FindBy(xpath = "//div[@class='c-btn']")
    public WebElement companyProfileDropdown;

    //    company profile dropdown value = farm
    @FindBy(xpath = "//ul[@class='lazyContainer']/li[1]/label")
    public WebElement farm;

    //    company profile dropdown value = Greenhouse
    @FindBy(xpath = "//ul[@class='lazyContainer']/li[3]/label")
    WebElement greenhouse;

    //    company profile dropdown value = Greenhouse
//    @FindBy(xpath = "//ul[@class='lazyContainer']/li[3]/label")
    @FindBy(xpath = "//ul[@class='lazyContainer']/li[2]/label")
    WebElement harvestCrew;

    //    company profile dropdown value = Greenhouse
    @FindBy(xpath = "//ul[@class='lazyContainer']/li[4]/label")
    WebElement GMP;

    //    Price button1 = Basic
    @FindBy(xpath = "//div[@class='sub-parent']/button[1]/div[2]")
    WebElement basicDollar;

    //    Price button1 = Pro
    @FindBy(xpath = "//div[@class='sub-parent']/button[2]/div[2]")
    WebElement proDollar;

    //    Price button1 = Premium
    @FindBy(xpath = "//div[@class='sub-parent']/button[3]/div[2]")
    WebElement premiumDollar;

    //    Company Profile selected list
    @FindBy(xpath = "//div[@class='c-list']")
    WebElement profileSelectList;

    //    cross button to clear all in company profile
    @FindBy(xpath = "//span[@class='c-remove clear-all']")
    WebElement clearAll;

    //    Button- Basic $10
    @FindBy(xpath = "//div[@class='sub-parent']/button[1]")
    WebElement basicButton;

    //    Button- Pro$25
    @FindBy(xpath = "//div[@class='sub-parent']/button[2]")
    public WebElement proButton;

    //    Button- Premium$100
    @FindBy(xpath = "//div[@class='sub-parent']/button[3]")
    WebElement premiumButton;

    public void verifyUserOnCompanySignupPage() {
        driver.get("https://stage.zirafs.com/company/company-signup");

        CompanySignupTitle.isDisplayed();
        String title = CompanySignupTitle.getText();
        sa.assertEquals(title, "Company Sign Up");
        sleep(2000);

        List<WebElement> allTitle = driver.findElements(By.xpath("//label"));
        for (WebElement listOfItem : allTitle) {
            String list = listOfItem.getText();
            if (list.equals("Company Name")) {
                sa.assertEquals(list, "Company Name");
            } else if (list.equals("Company Logo")) {
                sa.assertEquals(list, "Company Logo");
            } else if (list.equals("Company Logo")) {
                sa.assertEquals(list, "Company Logo");
            } else if (list.equals("First Name")) {
                sa.assertEquals(list, "First Name");
            } else if (list.equals("Last Name")) {
                sa.assertEquals(list, "Last Name");
            } else if (list.equals("Email")) {
                sa.assertEquals(list, "Email");
            } else if (list.equals("Contact Number")) {
                sa.assertEquals(list, "Contact Number");
            } else if (list.equals("Select Company Profile")) {
                sa.assertEquals(list, "Select Company Profile");
            }
        }
        sa.assertAll();
    }

    public void verifySignupButtonFunctionalityWithoutEnterAnyData() {
        signupButton.click();
        commonElements.waitForLoaders();
        WebElement[] errorMessages = {companyNameErrorMsg, firstNameErrorMsg, lastNameErrorMsg, emailErrorMsg, contactNumberErrorMsg, companyProfileErrorMsg, passwordErrorMsg};
        for (int i = 0; i < errorMessages.length; i++){
            sa.assertEquals(errorMessages[i].getText(), excel.getCellData(sheetName, "ErrorMessages", i+2));
        }
        sa.assertAll();
    }

    public void verifyErrorMsgHideForCName_FName_LNameWhenEnterData() {

        companyNameInputField.sendKeys(excel.getCellData(sheetName, "Data", 2));
        sa.assertFalse(isElementPresent(companyNameErrorMsg));
        companyNameInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(companyNameErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));

        firstNameInputField.sendKeys(excel.getCellData(sheetName, "Data", 2));
        sa.assertFalse(isElementPresent(firstNameErrorMsg));
        firstNameInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(firstNameErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 3));

        lastNameInputField.sendKeys(excel.getCellData(sheetName, "Data", 2));
        sa.assertFalse(isElementPresent(lastNameErrorMsg));
        lastNameInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(lastNameErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 4));

        sa.assertAll();
    }

    public void verifyValidationsForEmailField() {

        emailInputField.sendKeys(excel.getCellData(sheetName, "Data", 2));

        sa.assertEquals(emailErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 9));
        emailInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(emailErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 5));

        emailInputField.sendKeys(excel.getCellData(sheetName, "Data", 3));
        sa.assertEquals(emailErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 9));
        emailInputField.sendKeys(Keys.BACK_SPACE);

        sa.assertFalse(isElementPresent(emailErrorMsg));
        emailInputField.clear();

        sa.assertAll();
    }

    public void verifyValidationsOfContactNumber() {

        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        sa.assertEquals(countryCode.getText(), excel.getCellData(sheetName, "ContactNo", 2));

        countryDropdown.click();
        countryDropdownSearch.sendKeys(excel.getCellData(sheetName, "ContactNo", 3));
        sleep(4000);

        india.click();

        sa.assertEquals(countryCode.getText(), excel.getCellData(sheetName, "ContactNo", 4));

        contactNoInputField.sendKeys(excel.getCellData(sheetName, "ContactNo", 5));
        emailInputField.click();
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        int contactNoLength = contactNoInputField.getAttribute("value").length();
        for (int i = 0; i <= contactNoLength; i++) {
            contactNoInputField.sendKeys(Keys.BACK_SPACE);
        }
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        contactNoInputField.sendKeys(excel.getCellData(sheetName, "ContactNo", 6));
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        contactNoInputField.sendKeys(excel.getCellData(sheetName, "ContactNo", 7));
        sa.assertFalse(isElementPresent(contactNumberErrorMsg));

        sa.assertAll();
    }

    public void verifyValidationsOfSelectCompanyProfile() {
//        signupButton.click();

        sa.assertEquals(companyProfileErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 7));

        companyProfileDropdown.click();

        farm.click();

        sa.assertEquals(basicDollar.getText(), excel.getCellData(sheetName, "Title", 2));

        sa.assertFalse(isElementPresent(companyProfileErrorMsg));

        sa.assertEquals(proDollar.getText(), excel.getCellData(sheetName, "Title", 3));
        sa.assertEquals(premiumDollar.getText(), excel.getCellData(sheetName, "Title", 4));

        firstItemCrossButton.click();

        sa.assertFalse(isElementPresent(basicDollar));
        sa.assertFalse(isElementPresent(proDollar));
        sa.assertFalse(isElementPresent(premiumDollar));

        farm.click();
        greenhouse.click();

        sa.assertEquals(basicDollar.getText(), excel.getCellData(sheetName, "Title", 5));

        sa.assertFalse(isElementPresent(companyProfileErrorMsg));

        sa.assertEquals(proDollar.getText(), excel.getCellData(sheetName, "Title", 6));
        sa.assertEquals(premiumDollar.getText(), excel.getCellData(sheetName, "Title", 7));
        sa.assertEquals(profileSelectList.getText(), "Farm\n" + "Greenhouse");

        greenhouse.click();

        sa.assertEquals(profileSelectList.getText(), "Farm");

        greenhouse.click();
        harvestCrew.click();

        sa.assertEquals(basicDollar.getText(), excel.getCellData(sheetName, "Title", 8));
        sa.assertEquals(proDollar.getText(), excel.getCellData(sheetName, "Title", 9));
        sa.assertEquals(premiumDollar.getText(), excel.getCellData(sheetName, "Title", 10));
        sa.assertEquals(profileSelectList.getText(), "Farm\n" + "Greenhouse\n" + "Harvest Crew");

        thirdItemCrossButton.click();
        sa.assertEquals(profileSelectList.getText(), "Farm\n" + "Greenhouse");

        harvestCrew.click();

        GMP.click();
        sa.assertEquals(basicDollar.getText(), excel.getCellData(sheetName, "Title", 11));
        sa.assertEquals(proDollar.getText(), excel.getCellData(sheetName, "Title", 12));
        sa.assertEquals(premiumDollar.getText(), excel.getCellData(sheetName, "Title", 13));
        sa.assertEquals(profileSelectList.getText(), "Farm\n" + "Greenhouse\n" + "Harvest Crew\n" + "GMP");

        clearAll.click();

        sa.assertFalse(isElementPresent(profileSelectList));

        sa.assertEquals(companyProfileErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 7));

        farm.click();
        signupButton.click();

        sleep(2000);
        basicButton.click();
        sleep(2000);
        if (basicButton.getAttribute("class").equals("faintGreenBtn")) {
            sa.assertTrue(true, "Button is selected");
        } else {
            sa.fail("Button is not selected.");
        }

        proButton.click();
        if (basicButton.getAttribute("class").equals("faintGreenBtn")) {
            sa.fail("Button is not selected.");
        } else {
            sa.assertTrue(true, "Button is selected");
        }

        premiumButton.click();
        if (proButton.getAttribute("class").equals("faintGreenBtn")) {
            sa.fail("Button is not selected.");
        } else {
            sa.assertTrue(true, "Button is selected");
        }
        sa.assertAll();
    }

    public void verifyValidationsForPasswordAndConfirmPassword() {
        signupButton.click();

        sa.assertEquals(passwordErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 8));

        //Enter only an alphabet
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Password", 2));
        sa.assertEquals(passwordValidationErrorMsg2.getText(), excel.getCellData(sheetName, "ErrorMessages", 10));

        //enter alphabet and one special char.
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Password", 3));
        sa.assertEquals(passwordValidationErrorMsg2.getText(), excel.getCellData(sheetName, "ErrorMessages", 10));

        passwordInputField.clear();

        //enter only special char and number
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Password", 4));
        sa.assertEquals(passwordValidationErrorMsg2.getText(), excel.getCellData(sheetName, "ErrorMessages", 10));

        passwordInputField.clear();

        //enter 5 char password
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Password", 5));
        sa.assertEquals(passwordValidationErrorMsg2.getText(), excel.getCellData(sheetName, "ErrorMessages", 10));

        passwordInputField.clear();

        //enter 19 char password
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Password", 6));

        int val = passwordInputField.getAttribute("value").length();;
        if (val < 19){
            sa.assertFalse(isElementPresent(passwordValidationErrorMsg2));
        }else {
            sa.fail("Failed due to accept more than 18 char");
        }

        confirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "Password", 5));

        sa.assertEquals(confirmPasswordErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 11));

        confirmPasswordInputField.clear();

        confirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "Password", 6));
        sa.assertEquals(confirmPasswordErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 11));

        confirmPasswordInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertFalse(isElementPresent(confirmPasswordErrorMsg));

        sa.assertAll();
    }

    public void VerifyEmailAlreadyExist() {
        companyNameInputField.sendKeys(excel.getCellData(sheetName, "Email", 2));
        firstNameInputField.sendKeys(excel.getCellData(sheetName, "Email", 3));
        lastNameInputField.sendKeys(excel.getCellData(sheetName, "Email", 4));
        emailInputField.sendKeys(excel.getCellData(sheetName, "Email", 5));
        contactNoInputField.sendKeys(excel.getCellData(sheetName, "Email", 6));
        scrollTillTheElementIsDisplay(passwordInputField);
        companyProfileDropdown.click();
        farm.click();
        companyProfileDropdown.click();
        proButton.click();
        passwordInputField.sendKeys(excel.getCellData(sheetName, "Email", 7));
        confirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "Email", 7));
        signupButton.click();

        sa.assertEquals(emailAlreadyExist.getText(), excel.getCellData(sheetName, "ErrorMessages", 12));

        sa.assertAll();
    }

    public void verifyUserRedirectOnTeamAfterSignUp() {
    }
}
