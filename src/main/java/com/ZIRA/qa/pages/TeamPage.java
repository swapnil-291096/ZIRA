package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.ZIRA.qa.util.TestUtils.*;

public class TeamPage extends TestBase {
    String sheetName = "Team";
    FSMProfile fsmProfile = new FSMProfile();
    CommonElements commonElements = new CommonElements();

    //team
    @FindBy(xpath = "//a[@href='/fsm/team']")
    WebElement team;

    //team label
    @FindBy(xpath = "//h3")
    WebElement teamLabel;

    //create new button
    @FindBy(xpath = "//div[@id='tab-two']/button")
    WebElement createNewBtn;

    //create new button
    @FindBy(xpath = "//div[@id='moveTop']//h4")
    WebElement createTeamMemberLabel;

    //create new button
    @FindBy(xpath = "//div[@id='moveTop']/form/div[3]/button[1]")
    WebElement saveButton;

    //First name is required
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[1]/div[2]")
    WebElement firstNameIsRequired;

    //Last name is required
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[2]/div[3]")
    WebElement lastNameIsRequired;

    //user role is required
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[3]/div[2]/div[2]")
    WebElement userRoleIsRequired;

    //email is required
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[4]/div[3]")
    WebElement emailIsRequired;

    //email is required
    @FindBy(xpath = "//div[@class='zr-modal-bdy']/div[5]/div[3]")
    WebElement contactIsRequired;

    //First name is required
    @FindBy(xpath = "//div[@class='frm-errmsg']")
    List<WebElement> errorMessages;

    //First name Input field
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameInputField;

    //Last name Input field
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameInputField;

    //email Input field
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInputField;

    //Contact number input field
    @FindBy(xpath = "//input[@id='phone']")
    WebElement contactNumInputField;

    //User role Dropdown
    @FindBy(xpath = "//select[@formcontrolname ='userRole']")
    WebElement userRoleDropdown;

    //edit button
    @FindBy(xpath = "//div[@class='zr-bx']//tr[2]/td[6]//li[1]")
    WebElement editButton;

    //delete button
    @FindBy(xpath = "//div[@class='zr-bx']//tr[2]/td[6]//li[2]")
    WebElement deleteButton;

    //cancel button
    @FindBy(xpath = "//button[@id='warning-cancel-btn']")
    WebElement cancelButton;

    //delete button for confirmation
    @FindBy(xpath = "//button[@id='warning-delete-btn']")
    WebElement deleteButtonForConfirmation;

    //table grid - first row
    @FindBy(xpath = "//div[@class='zr-bx']//tr[2]")
    WebElement firstRow;

    //Are you sure you want to delete this user?
    @FindBy(xpath = "//div[@class='zr-msg']/p")
    WebElement confirmDeleteActionLabel;

    //--------contact
    //    country code
    @FindBy(xpath = "//div[@class='selected-dial-code']")
    WebElement countryCode;

    //    country Dropdown
    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    WebElement countryDropdown;

    //    Contacts-Country Dropdown search
    @FindBy(xpath = "//input[@id='country-search-box']")
    WebElement countryDropdownSearch;

    //    Country India
    @FindBy(xpath = "//ul[@class='iti__country-list']/li[101]")
    WebElement india;

//    //    Contact Number input Field
//    @FindBy(xpath = "//input[@id='phone']")
//    public WebElement contactNoInputField;

    //    Invalid contact number.
    @FindBy(xpath = "//div[@class='zr-modal-bdy']//div[5]/div[3]")
    WebElement contactNumberErrorMsg;



    public void verifyFSMOnTeamPage(){
//        fsmProfile.verifyFSMLoggedInSuccessfully(prop.getProperty("FSMEmail"), prop.getProperty("FSMPassword"));
//        commonElements.FSMLogin();
        team.click();
        sa.assertTrue(team.getAttribute("class").equals("header-ul-active"));

        sa.assertEquals(teamLabel.getText(), excel.getCellData(sheetName, "Title", 2));
        sa.assertAll();
    }

    public void verifyFSMOnCreateTeamPage(){
        waitForElementToBeDisplayed(createNewBtn);
        createNewBtn.click();
        sa.assertEquals(createTeamMemberLabel.getText(), excel.getCellData(sheetName, "Title", 3));

        sa.assertAll();
    }

    public void verifyClickOnSaveButtonWithoutEnterAnyData(){
        waitForElementToBeDisplayed(saveButton);
        saveButton.click();

        for (int i = 0; i<errorMessages.size(); i++){
            sa.assertEquals(errorMessages.get(i).getText(), excel.getCellData(sheetName, "ErrorMessages", i+2));
        }

        sa.assertAll();
    }

    public void verifyInvalidEmail(){
        WebElement [] inputFields={firstNameInputField,lastNameInputField,contactNumInputField};
        WebElement [] val = {firstNameIsRequired, lastNameIsRequired, contactIsRequired};

        for (int i=0; i< val.length; i++) {
            inputFields[i].sendKeys(excel.getCellData(sheetName, "Data", i+2));
            sa.assertFalse(isElementPresent(val[i]));
        }

        waitForElementToBeDisplayed(userRoleDropdown);

        selectValueByText(userRoleDropdown, "Draftsman");
        sa.assertEquals(emailIsRequired.getText(), excel.getCellData(sheetName, "ErrorMessages", 5));
        sa.assertAll();
    }

    public void verifyExistingMail(){
        emailInputField.clear();

        emailInputField.sendKeys(excel.getCellData(sheetName, "Email", 3));

        saveButton.click();

        sa.assertEquals(emailIsRequired.getText(), excel.getCellData(sheetName, "ErrorMessages", 8));
        emailInputField.clear();
        sa.assertAll();
    }

    public void verifyInvalidContactNumber(){
        contactNumInputField.clear();

//        contactNumInputField.sendKeys(excel.getCellData(sheetName, "ContactNumber", 3));
//
//        sa.assertEquals(contactIsRequired.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        sa.assertEquals(countryCode.getText(), excel.getCellData(sheetName, "ContactNumber", 2));

        countryDropdown.click();
        countryDropdownSearch.sendKeys(excel.getCellData(sheetName, "ContactNumber", 3));
        sleep(4000);

        india.click();

        sa.assertEquals(countryCode.getText(), excel.getCellData(sheetName, "ContactNumber", 4));

        contactNumInputField.sendKeys(excel.getCellData(sheetName, "ContactNumber", 5));
        emailInputField.click();
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 9));

        int contactNoLength = contactNumInputField.getAttribute("value").length();
        for (int i = 0; i <= contactNoLength; i++) {
            contactNumInputField.sendKeys(Keys.BACK_SPACE);
        }
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 6));

        contactNumInputField.sendKeys(excel.getCellData(sheetName, "ContactNumber", 6));
        sa.assertEquals(contactNumberErrorMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 9));

        contactNumInputField.sendKeys(excel.getCellData(sheetName, "ContactNumber", 7));
        sa.assertFalse(isElementPresent(contactNumberErrorMsg));

        sa.assertAll();
    }

    public void verifyClickOnSaveButtonWithEnterValidDetails(){
        emailInputField.clear();

        contactNumInputField.clear();

        emailInputField.sendKeys(excel.getCellData(sheetName, "Email", 4));

        contactNumInputField.sendKeys(excel.getCellData(sheetName, "ContactNumber", 8));

        saveButton.click();

        sa.assertAll();
    }

    public void verifyTeamMemberCreatedSuccessfully(){
        sleep(5000);
        sa.assertEquals(firstRow.getText(), excel.getCellData(sheetName, "Data", 5));
        sa.assertAll();
    }

    public void verifyTeamMemberEditFunctionality(){
        waitForElementToBeDisplayed(editButton);
        editButton.click();
        WebElement [] allInputFields={firstNameInputField, lastNameInputField, emailInputField, contactNumInputField};
        for (int i = 0; i<allInputFields.length; i++){
            allInputFields[i].clear();
            allInputFields[i].sendKeys(excel.getCellData(sheetName, "Data", i+6));
        }
        waitForElementToBeDisplayed(userRoleDropdown);
        selectValueByText(userRoleDropdown, "Designer");

        saveButton.click();

        sleep(5000);
        System.out.println(firstRow.getText());
        sa.assertEquals(firstRow.getText(), excel.getCellData(sheetName, "Data", 10));
        sa.assertAll();
    }

    public void verifyDeleteFunctionalityWhenClickOnCancelButton(){
        waitForElementToBeDisplayed(deleteButton);
        deleteButton.click();

        sa.assertEquals(confirmDeleteActionLabel.getText(), excel.getCellData(sheetName, "Title", 4));

        waitForElementToBeDisplayed(cancelButton);
        cancelButton.click();
        sleep(3000);

        sa.assertEquals(firstRow.getText(), excel.getCellData(sheetName, "Data", 10));

        sa.assertAll();
    }

    public void verifyDeleteFunctionalityWhenClickOnDeleteButton(){
        waitForElementToBeDisplayed(deleteButton);
        deleteButton.click();

        waitForElementToBeDisplayed(deleteButtonForConfirmation);
        deleteButtonForConfirmation.click();

        sleep(3000);

        sa.assertTrue(isElementPresent(firstRow));

        sa.assertAll();
    }
}
