package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import static com.ZIRA.qa.util.TestUtils.mouseHover;
import static com.ZIRA.qa.util.TestUtils.sleep;

public class ZiraMastersPage extends TestBase {
    String sheetName = "ZiraMasters";

    LoginPage loginPage = new LoginPage();

    //FS Certification Text
    @FindBy(css = "div[class='col-lg-12 mstr-hed middle-lg'] h3")
    WebElement FSCertificationTitle;

    //FS Certification Text
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[1]/ul/li[2]/a[1]")
    WebElement certificateHoverElement;

    //User Roles Text
    @FindBy(css = "div[class='col-lg-12 mstr-hed middle-lg'] h3")
    WebElement UserRolesTitle;

    //Facility Operation Button
    @FindBy(xpath = "//button[@class = 'btn fld-oprn btn-brand-green']")
    WebElement facilityOprBtn;

    //Field Operation Button
    @FindBy(xpath = "//button[@class = 'btn fld-oprn inctve-tab btn-brand-white']")
    WebElement fieldOprBtn;

    //Create New Button
    @FindBy(xpath = "//div/div/div/div/button[@class = 'btn btn-md btn-brand-light-green']")
    public static WebElement createNewBtn;

    //NO. text in FS Certification table
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr/child::th[1]")
    WebElement NOText;

    //Facility Operation Text
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr/child::th[2]")
    WebElement facilityOPText;

    //Description Text
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr/child::th[3]")
    WebElement descriptionText;

    //Actions Text
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr/child::th[4]")
    WebElement actionsText;

    //Create New Facility Operations Type
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']/div/div/h4")
    WebElement createNewFOT;

    //Operation Type / Name
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//div[@class='zr-input-msg'][1]/label")
    WebElement operationTypeText;

    //Description Text
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//div[@class='zr-input-msg'][2]/label")
    WebElement descText;

    //Operation type/name input field
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//input[@id='operationName']")
    WebElement opTypeInputField;

    //Description Textarea
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//textarea[@id='description']")
    WebElement descriptionTextarea;

    //Create Button
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//div[@class='zr-modal-footer zr-btn-grp center-lg row']/button[@class='btn btn-md btn-brand-light-green']")
    WebElement createBtn;

    //Cancel Button
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']//div[@class='zr-modal-footer zr-btn-grp center-lg row']/button[@class='btn btn-md btn-dark']")
    WebElement cancelBtn;

    //Operation Type is required.
    @FindBy(xpath = "//div[contains(text(),'Operation Type is required.')]")
    WebElement oprTypeMsgText;

    //Please enter Description
    @FindBy(xpath = "//div[@class='zr-input-msg']/div/div/div")
    WebElement plsEnterDescMsg;

    //Operation Type must be at least 4 characters long. for OP type
    @FindBy(xpath = "//div[contains(text(),'Operation Type must be at least 4 characters long.')]")
    WebElement opType4charMsg;

    //Operation Type must be at least 4 characters long. for Description
    @FindBy(xpath = "//*[@id='fsCertForm']/div/div/div[2]/div/div")
    WebElement desc4CharMsg;

    //OK button for FS Certificate created successfully.
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    static WebElement OKBtn;

    //FS Certificate created successfully.
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    WebElement FSCrtText;

    ////Done popup text
    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement DoneText;

    //Success img
    @FindBy(xpath = "//div[@class='swal2-success-ring']")
    WebElement successImg;

    //This Facility Operation
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr[2]/child::td[2]")
    WebElement ThisIsFacilityOPText;

    //This is Description
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr[2]/child::td[3]")
    WebElement ThisIsDescText;

    //Edit Button
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr[2]/child::td[4]/child::ul[1]/child::li[1]")
    WebElement editButton;

    //Delete Button
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr[2]/child::td[4]/child::ul[1]/child::li[2]")
    WebElement deleteButton;

    //Disable Button
    @FindBy(xpath = "//div[@class = 'mstr-tbl']/child::table/child::tr[2]/child::td[4]/child::ul[1]/child::li[3]")
    WebElement disableButton;

    //Edit Facility Operations Type
    @FindBy(xpath = "//div[@class = 'zr-modal-backdrop']//child::div/h4")
    WebElement editFOTypeText;

    //FS Certificate updated successfully.
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    WebElement FSCertUpdateSuccessfully;

    //Certificate Disabled successfully.
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    static WebElement FSCertificateDisabledSuccessfully;

    //Certificate Enabled successfully.
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    static WebElement FSCertificateEnabledSuccessfully;

    //Certificate Deleted successfully.
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    static WebElement FSCertificateDeletedSuccessfully;

    //Cancel Button for Delete Popup
    @FindBy(xpath = "//button[@class='btn btn-md btn-gray-outline']")
    static WebElement cancelBtnForDeletePopup;

    //Cancel Button for Disable Popup
    @FindBy(xpath = "//button[@class='btn btn-md btn-gray-outline']")
    static WebElement cancelBtnForDisablePopup;

    //Delete Button for Delete Popup
    @FindBy(xpath = "//button[@class='btn btn-md btn-brand-red']")
    static WebElement deleteBtnForDeletePopup;

    //Disable Button for Disable Popup
    @FindBy(xpath = "//button[@class='btn btn-md btn-brand-red']")
    static WebElement disableBtnForDisablePopup;

    //enable Button for Disable Popup
    @FindBy(xpath = "//button[@id='warning-disable-btn']")
    static WebElement enableBtnForDisablePopup;

    //Confirm Action
    @FindBy(xpath = "//div[@class='zr-modal zr-modal-xs']/div/h4")
    static WebElement confirmAction;

    //Are you sure you want to delete this FS Certificate?
    @FindBy(xpath = "//div[@class='zr-msg']")
    static WebElement confirmDeleteMsg;

    //Are you sure you want to disable this FS Certificate?
    @FindBy(xpath = "//div[@class='zr-msg']")
    static WebElement confirmDisableMsg;

    //Disable the element
    @FindBy(xpath = "//tr[@class='isDisabled']")
    static WebElement disabledRow;

    // User Title must be at least 2 characters long.
    @FindBy(xpath = "//div[@id='user-title-must-be']")
    WebElement TitleMustBe2CharLong;

    //  User Title is required.
    @FindBy(xpath = "//div[@id='user-title-required']")
    WebElement UserTitleMustBeReq;

    //  User Title Input Field.
    @FindBy(xpath = "//input[@id='userTitle']")
    WebElement UserTitleInputField;

    //Create New User Role
    @FindBy(xpath = "//div[@class='zr-modal-backdrop']/div//div/h4")
    WebElement createNewUserRole;

    //Created role "Role123"
    @FindBy(xpath = "//div[@class='col-3-tbl']//tr[2]/td[2]")
    WebElement Role123Text;

    //User role Created successfully.
    @FindBy(xpath = "//div[@class='swal2-html-container']")
    WebElement UsrRlCreatedScc;

    public void verifyClickOnFSCertificationPage(){
//
//        WebElement ZiraMaster = driver.findElement(By.xpath("//div[1]/div/div/div[2]/div/div[1]/ul/li[2]/a[1]"));
//        Actions action = new Actions(driver);
//        action.moveToElement(ZiraMaster).perform();
        mouseHover(certificateHoverElement);

        driver.findElement(By.linkText("FS Certification")).click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on FS Certification Link.");
    }

    public void verifyUserOnFSCertificationPage(){
        WebElement[] list = {FSCertificationTitle, facilityOprBtn, fieldOprBtn, createNewBtn, NOText, facilityOPText, descriptionText, actionsText};
        for (int i = 0; i< list.length; i++){
            sa.assertEquals(list[i].getText(), excel.getCellData(sheetName,"Title",i+2));
        }

        sa.assertAll();
    }

    public void verifyCreateNewButtonFunctionality(){
        sleep(2000);
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        WebElement[] list = {createNewFOT, operationTypeText, createBtn, cancelBtn};
        for (int i = 0; i< list.length; i++){
            sa.assertEquals(list[i].getText(), excel.getCellData(sheetName,"Title",i+10));
        }
//        sa.assertEquals(createNewFOT.getText(), excel.getCellData(sheetName,"Title",10));
//        ExtentManager.getTest().log(Status.INFO, "Verified text: Create New Facility Operations Type");
//
//        sa.assertEquals(operationTypeText.getText(), excel.getCellData(sheetName,"Title",11));
//        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type / Name");

        sa.assertEquals(descText.getText(), excel.getCellData(sheetName,"Title",8));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Description");

        opTypeInputField.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Operation Type / Name input field");

        descriptionTextarea.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Description Textarea");

//        sa.assertEquals(createBtn.getText(), excel.getCellData(sheetName,"Title",12));
//        ExtentManager.getTest().log(Status.INFO, "Verified text: Create");
//
//        sa.assertEquals(cancelBtn.getText(), excel.getCellData(sheetName,"Title",13));
//        ExtentManager.getTest().log(Status.INFO, "Verified text: Cancel");

        sa.assertAll();
    }

    public void verifyCreateButtonFunctionalityWithoutEnterData() {
        try {
            createNewBtn.click();
            ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(oprTypeMsgText.getText(), excel.getCellData(sheetName,"ErrorMessages",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type is required.");

        sa.assertEquals(plsEnterDescMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter Description");

        sa.assertAll();
    }

    public void verifyCancelButtonFunctionality(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        cancelBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Cancel button");

        sa.assertEquals(FSCertificationTitle.getText(), excel.getCellData(sheetName,"Title",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: FS Certification");

        sa.assertEquals(facilityOprBtn.getText(), excel.getCellData(sheetName,"Title",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Facility Operations");

        sa.assertEquals(fieldOprBtn.getText(), excel.getCellData(sheetName,"Title",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Field Operations");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWithEnterOPTypeOnly(){
        sleep(2000);
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",2));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into Operation type input field.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(plsEnterDescMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter Description");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWithEnterDescriptionOnly(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",3));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(oprTypeMsgText.getText(), excel.getCellData(sheetName,"ErrorMessages",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type is required.");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWithLessThan4CharInOPTypeAndDescIsEntered(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into Operation type input field.");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",3));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(opType4charMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type must be at least 4 characters long.");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWithLessThan4CharInDescTypeAndOPTypeIsEntered(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",2));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into Operation type input field.");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(desc4CharMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",5));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Description must be at least 4 characters long.");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWithLessThan4CharInOpTypeAndDescType(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into Operation type input field.");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(opType4charMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type must be at least 4 characters long.");

        sa.assertEquals(desc4CharMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",5));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Description must be at least 4 characters long.");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWhenOPTypeLessThan4charAndDescIsEmpty(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into Operation type input field.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(opType4charMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",4));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type must be at least 4 characters long.");

        sa.assertEquals(plsEnterDescMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",3));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Please enter Description");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWhenDescTypeLessThan4charAndOPIsEmpty(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",4));
        ExtentManager.getTest().log(Status.INFO, "Sent less than 4 char. Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(oprTypeMsgText.getText(), excel.getCellData(sheetName,"ErrorMessages",2));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Operation Type is required.");

        sa.assertEquals(desc4CharMsg.getText(), excel.getCellData(sheetName,"ErrorMessages",5));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Description must be at least 4 characters long.");

        sa.assertAll();
    }

    public void verifyCreateBtnFunctionalityWhenEnterValidData(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",5));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into Operation type input field.");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",6));
        ExtentManager.getTest().log(Status.INFO, "Sent Keys into description type input textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");
        sleep(5000);

        successImg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed img successfully.");

        sa.assertEquals(DoneText.getText(), excel.getCellData(sheetName,"Data",7));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Done...");

        sa.assertEquals(FSCrtText.getText(), excel.getCellData(sheetName,"Title",14));
        ExtentManager.getTest().log(Status.INFO, "Verified text: FS Certificate created successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");

        sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",5));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility Operation");

        sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",6));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This is Description");

        sa.assertAll();
    }

    public void verifyEditButtonFunctionality(){
        editButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on edit button.");

        sa.assertEquals(editFOTypeText.getText(), excel.getCellData(sheetName,"Title",26));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Edit Facility Operations Type");

        opTypeInputField.sendKeys(excel.getCellData(sheetName,"Data",8));
        ExtentManager.getTest().log(Status.INFO, "Keys sent into input type field.");

        descriptionTextarea.sendKeys(excel.getCellData(sheetName,"Data",9));
        ExtentManager.getTest().log(Status.INFO, "Keys sent into description type textarea.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button.");
        sleep(5000);

        FSCertUpdateSuccessfully.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Edit Facility Operations Type");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");

        sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",10));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility OperationThis Facility Operation is updated.");

        sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",11));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This is DescriptionThis is Description is updated.");

        sa.assertAll();
    }

    public void verifyDeleteButtonFunctionalityWhenClickOnCancelBtn(){
        deleteButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Delete button.");

        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        sa.assertEquals(confirmDeleteMsg.getText(), excel.getCellData(sheetName,"Title",17));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to delete this FS Certificate?");

        cancelBtnForDeletePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on cancel button.");

        sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",10));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility OperationThis Facility Operation is updated.");

        sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",11));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This is DescriptionThis is Description is updated.");

        sa.assertAll();
    }

    public void verifyDisableButtonFunctionalityWhenClickOnCancelBtn(){
        disableButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sa.assertEquals(confirmDisableMsg.getText(), excel.getCellData(sheetName,"Title",18));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to disable this FS Certificate?");

        disableBtnForDisablePopup.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: disable");

        cancelBtnForDisablePopup.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Cancel");

        cancelBtnForDisablePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Cancel button button.");

        sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",10));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility OperationThis Facility Operation is updated.");

        sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",11));
        ExtentManager.getTest().log(Status.INFO, "Verified text: This is DescriptionThis is Description is updated.");

        sa.assertAll();
    }

    public void verifyDisableButtonFunctionalityWhenClickOnDisableBtn(){

        disableButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sa.assertEquals(confirmDisableMsg.getText(), excel.getCellData(sheetName,"Title",18));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to disable this FS Certificate?");

        disableBtnForDisablePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button button.");
        sleep(4000);

        sa.assertEquals(FSCertificateDisabledSuccessfully.getText(), excel.getCellData(sheetName,"Title",19));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Certificate Disabled successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button button.");
        sleep(2000);

        if (disabledRow.getAttribute("class").equals("isDisabled")){

            sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",10));
            ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility OperationThis Facility Operation is updated.");

            sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",11));
            ExtentManager.getTest().log(Status.INFO, "Verified text: This is DescriptionThis is Description is updated.");
        }
        else {
            sa.fail("Test Fail Due to element not disabled");
        }

        sa.assertAll();
    }

    public void verifyDisableButtonFunctionalityWhenClickOnEnableBtnToGetEnableRow(){

        boolean val = disabledRow.getAttribute("class").equals("isDisabled");

        disableButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sa.assertEquals(confirmDisableMsg.getText(), excel.getCellData(sheetName,"Title",20));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to enable this FS Certificate?");

        enableBtnForDisablePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on enable button button.");
        sleep(4000);

        sa.assertEquals(FSCertificateEnabledSuccessfully.getText(), excel.getCellData(sheetName,"Title",21));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Certificate Enabled successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");
        sleep(2000);

        if (!val){
            sa.fail("Test Fail Due to element not enabled.");
        }
        else {

            sa.assertEquals(ThisIsFacilityOPText.getText(), excel.getCellData(sheetName,"Data",10));
            ExtentManager.getTest().log(Status.INFO, "Verified text: This Facility OperationThis Facility Operation is updated.");

            sa.assertEquals(ThisIsDescText.getText(), excel.getCellData(sheetName,"Data",11));
            ExtentManager.getTest().log(Status.INFO, "Verified text: This is DescriptionThis is Description is updated.");
        }

        sa.assertAll();
    }


    public void verifyDeleteButtonFunctionalityWhenClickOnDeleteBtn(){
        String thisIsFacilityOPText = ThisIsFacilityOPText.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: This Facility OperationThis Facility Operation is updated.");

        String thisIsDescText = ThisIsDescText.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: This is DescriptionThis is Description is updated.");

        deleteButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on delete button.");

        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        sa.assertEquals(confirmDeleteMsg.getText(), excel.getCellData(sheetName,"Title",17));
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to delete this FS Certificate?");

        deleteBtnForDeletePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on delete button.");
        sleep(4000);

        sa.assertEquals(FSCertificateEnabledSuccessfully.getText(), excel.getCellData(sheetName,"Title",22));
        ExtentManager.getTest().log(Status.INFO, "Verified text: FS Certificate deleted successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");
        sleep(4000);

        sa.assertNotEquals(thisIsFacilityOPText, "");
        ExtentManager.getTest().log(Status.INFO, "Verified text not match with: This Facility OperationThis Facility Operation is updated.");

        sa.assertNotEquals(thisIsDescText, "");
        ExtentManager.getTest().log(Status.INFO, "Verified text not match with: This is DescriptionThis is Description is updated.");

        sa.assertAll();
    }

    public void verifyUserOnUserRoles(){
        WebElement menu = driver.findElement(By.xpath("//div[1]/div/div/div[2]/div/div[1]/ul/li[2]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();

        driver.findElement(By.linkText("User Roles")).click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on User Roles Link.");

        sa.assertEquals(UserRolesTitle.getText(), excel.getCellData(sheetName,"Title",23));
        ExtentManager.getTest().log(Status.INFO, "Verified text : User Roles");

        sa.assertAll();
    }

    public void verifyErrorMessageDisplayAndHideValidationAndCreateUserRole(){
        createNewBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create new button");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");

        sa.assertEquals(createNewUserRole.getText(), excel.getCellData(sheetName,"Title",24));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Create New User Role");

        sa.assertEquals(UserTitleMustBeReq.getText(), excel.getCellData(sheetName,"ErrorMessages",6));
        ExtentManager.getTest().log(Status.INFO, "Verified text : User Title is required.");
        sleep(4000);

        UserTitleInputField.sendKeys(excel.getCellData(sheetName,"Data",12));
        ExtentManager.getTest().log(Status.INFO, "Sent keys into User Role Title input field.");
        sleep(4000);

        String TitleMustBe2CharLongText = TitleMustBe2CharLong.getText();
        sa.assertEquals(TitleMustBe2CharLongText, excel.getCellData(sheetName,"ErrorMessages",7));
        ExtentManager.getTest().log(Status.INFO, "Verified Text: User Title must be at least 2 characters long.");

        UserTitleInputField.sendKeys(excel.getCellData(sheetName,"Data",13));
        ExtentManager.getTest().log(Status.INFO, "Sent keys into User Role Title input field.");
        sa.assertNotEquals(TitleMustBe2CharLongText, "");
        ExtentManager.getTest().log(Status.INFO, "Verified text not equals to: User Title must be at least 2 characters long.");

        int docNameLength = UserTitleInputField.getAttribute("value").length();
        for (int i = 2; i <= docNameLength; i++ )
            UserTitleInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(TitleMustBe2CharLong.getText(), excel.getCellData(sheetName,"ErrorMessages",7));
        ExtentManager.getTest().log(Status.INFO, "Verified text : User Title must be at least 2 characters long.");

        UserTitleInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(UserTitleMustBeReq.getText(), "User Title is required.");
        ExtentManager.getTest().log(Status.INFO, "Verified text : User Title is required.");

        UserTitleInputField.sendKeys(excel.getCellData(sheetName,"Data",14));
        ExtentManager.getTest().log(Status.INFO, "Sent keys into User Role Title input field.");

        createBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on create button");
        sleep(2000);

        sa.assertEquals(UsrRlCreatedScc.getText(), excel.getCellData(sheetName,"Title",25));
        ExtentManager.getTest().log(Status.INFO, "Verified text : User role created successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button");

        sa.assertEquals(Role123Text.getText(), excel.getCellData(sheetName,"Data",14));
        ExtentManager.getTest().log(Status.INFO, "Verified text : Role123");

        sa.assertAll();
    }
}

