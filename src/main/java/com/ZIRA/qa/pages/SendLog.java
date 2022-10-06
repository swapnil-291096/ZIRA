package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.util.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

import static com.ZIRA.qa.util.TestUtils.*;
import static com.sun.tools.classfile.Attribute.Signature;

public class SendLog extends TestBase {
    String sheetName = "SendLog";
    CommonElements commonElements = new CommonElements();

    //--------------------------------------------------R25 PERIODIC CLEANING & SANITATION//--------------------------------------------------

    //R25 PERIODIC CLEANING & SANITATION all checkbox
    @FindBy(xpath = "//div[@class='col-sm-2']")
    List<WebElement>  checkboxWithText;

    //R25 PERIODIC CLEANING & SANITATION all checkbox
    @FindBy(xpath = "//span[@class='checkmark']")
    List<WebElement>  checkbox;

    //error message[Date, Time, Comments, Signature]
    @FindBy(xpath = "//div[@class='frm-errmsg']/div")
    List<WebElement> errorMessages;

    //all checkbox error message
    @FindBy(xpath = "//div[@class='frm-errms']/div")
    List<WebElement> checkboxErrorMessages;

    //save button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    //date Input button
    @FindBy(xpath = "//input[@type='date']")
    WebElement dateInputField;

    //time Input button
    @FindBy(xpath = "//input[@type='time']")
    WebElement time;

    //time Input button
    @FindBy(xpath = "//signature-pad/canvas")
    WebElement signature;

    //Textarea
    @FindBy(xpath = "//textarea")
    WebElement textarea;

    //log Save button
    @FindBy(xpath = "//button[@class='btn btn-md btn-brand-light-green']")
    WebElement logSave;

    //--------------------------------------------------R25 PERIODIC CLEANING & SANITATION//--------------------------------------------------

    //R25 PERIODIC CLEANING & SANITATION
    @FindBy(xpath = "//div[@class='zr-bx']//tr[13]/td[5]//li[5]")
    WebElement R25LogSendButton;

    //FSM - ilia stark (FSM)
    @FindBy(xpath = "//ul[@class='lazyContainer']/li[3]")
    WebElement selectFSM;

    //Dropdown Selected value
    @FindBy(xpath = "//div[@class='c-btn']")
    WebElement selectedValue;

    //Dropdown Selected value
    @FindBy(xpath = "//div[@class='c-btn']/span/span")
    WebElement dropdownSelectedValue;

    //Log Masters
    @FindBy(xpath = "//ul[@class='inline-ul header-ul']/li[3]")
    WebElement logMasters;

    //Non-Frequent
    @FindBy(xpath = "//div[@class='mstr-tbs col-lg-6']/button[2]")
    WebElement nonFrequent;

    // Please select personnel
    @FindBy(xpath = "//div[@class='frm-errmsg']/div")
    WebElement pleaseSelectPersonnel;

    // Please select personnel
    @FindBy(xpath = "//div[@class='zr-modal-mid zr-modal-os zr-chtw']/div[2]/button[1]")
    WebElement sendButton;

    // Log Schedule
    @FindBy(xpath = "//ul[@class='inline-ul header-ul']/li[2]")
    WebElement logSchedule;

    // cross button
    @FindBy(xpath = "//span[@class='c-remove clear-all']")
    WebElement crossButton;

    // search input box
    @FindBy(xpath = "//input[@class='c-input ng-pristine ng-valid ng-touched']")
    WebElement searchInputBox;

    // save Log button
    @FindBy(xpath = "//div[@class='col-lg-12']/div//tr[2]/td[5]/ul")
    WebElement saveLogButton;

    // search List
    @FindBy(xpath = "//li[@class='pure-checkbox']")
    WebElement searchList;

    // Log schedule 1st log row
    @FindBy(xpath = "//div[@class='col-lg-12']/div//tr[2]/td")
    List<WebElement> firstLogRow;

    // status
    @FindBy(xpath = "//div[@class='col-lg-12']/div//tr[2]/td[4]")
    WebElement logStatus;

    //--------------------------------------------------view Log--------------------------------------------------//
    //View Log button
    @FindBy(xpath = "//div[@class='zr-bx']//tr[2]/td[5]//li[2]")
    WebElement viewButton;

    //signature
    @FindBy(xpath = "//div[@class='page page-2']/div[4]//img")
    WebElement signatureImage;

    //comments
    @FindBy(xpath = "//div[@class='page page-2']/div[3]//div[2]//textarea")
    WebElement comments;

    //--------------------------------------------------edit Log--------------------------------------------------//
    //edit log
    @FindBy(xpath = "//div[@class='zr-bx']//tr[2]/td[5]//li[1]")
    WebElement editLog;

    //Textarea list
    @FindBy(xpath = "//textarea")
    List<WebElement> textareaList;


    public void clickOnSaveButtonWithoutSelectPersonnel(){
//        fsmProfile.verifyFSMLoggedInSuccessfully(prop.getProperty("FSMEmail"), prop.getProperty("FSMPassword"));

        logMasters.click();
        commonElements.waitForLoaders();
        nonFrequent.click();
        R25LogSendButton.click();
        commonElements.waitForLoaders();
        sendButton.click();
        sa.assertEquals(pleaseSelectPersonnel.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));
        sa.assertAll();
    }

    public void sendLogToFSM(){
        selectedValue.click();
        selectFSM.click();
        sa.assertFalse(isElementPresent(pleaseSelectPersonnel));
        sa.assertAll();
    }

    public void verifyFunctionalityOfCrossButton(){
        crossButton.click();
        sa.assertEquals(pleaseSelectPersonnel.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));
        sa.assertAll();
    }

    public void verifySearchFunctionality(){
        selectedValue.click();
        sleep(2000);
        searchInputBox.sendKeys(excel.getCellData(sheetName, "Data", 2));
        sa.assertEquals(searchList.getText(), excel.getCellData(sheetName, "Data", 3));
        sleep(2000);
        searchList.click();
        sa.assertEquals(dropdownSelectedValue.getText(), excel.getCellData(sheetName, "Data", 3));
        sendButton.click();
        sa.assertAll();
    }

    public void verifySentLogDisplayedInLogSchedule(){
        logSchedule.click();
        sleep(3000);

        //Select all checkbox
        for (int i = 0; i <3; i++){
            sa.assertEquals(firstLogRow.get(i+1).getText(), excel.getCellData(sheetName, "Data", i+4));
        }
        sa.assertAll();
    }

    public void verifyClickOnSaveButtonWithoutEnterAnyData(){
        saveLogButton.click();
        commonElements.waitForLoaders();
        saveButton.click();

        //Deselect all checkbox
        for (int i = 0; i<errorMessages.size(); i++) {
            sa.assertEquals(errorMessages.get(i).getText(), excel.getCellData(sheetName, "ErrorMessages", i+3));
        }

        //verify error message
        for (int i = 0; i<checkboxErrorMessages.size(); i++) {
            sa.assertEquals(checkboxErrorMessages.get(i).getText(), excel.getCellData(sheetName, "ErrorMessages", 7));
        }
        sa.assertAll();
    }

    public void verifyAllFieldsFillSuccessfully() throws Exception {

        dateInputField.sendKeys(excel.getCellData(sheetName, "Data", 7));
        time.sendKeys(excel.getCellData(sheetName, "Data", 8));

        //Select all checkbox
        for (int i = 0; i<checkbox.size(); i++) {
            System.out.println("check before"+checkbox.get(i).isSelected());
            checkbox.get(i).click();
//            System.out.println("check after"+checkboxWithText.get(i).isSelected());
            System.out.println("check after"+checkbox.get(i).isSelected());

            sleep(50);
//            sa.assertFalse(checkboxWithText.get(i).isSelected());
        }

        WebElement element = driver.findElement(By.xpath("//signature-pad/canvas"));

        Actions builder = new Actions(driver);
          builder.clickAndHold(element).moveByOffset(10, 50).moveByOffset(50, 10).release().perform();

        takeScreenshot(signature, "Signature");

        imageComparison(signature, "blankSignature" );

        textarea.sendKeys(excel.getCellData(sheetName, "Data", 9));

        sa.assertAll();
    }

    public void verifyAllCheckboxDeselectAndChangedFrequencyOfLog(){

        for (int i = 0; i<checkbox.size(); i++) {
            checkbox.get(i).click();
            sleep(50);
        }

        for (int i = 0; i<checkboxErrorMessages.size(); i++) {
            sa.assertEquals(checkboxErrorMessages.get(i).getText(), excel.getCellData(sheetName, "ErrorMessages", 7));
        }

        for (int i = 0; i<checkbox.size(); i++) {
            checkbox.get(i).click();
            sleep(50);
        }

        logSave.click();
        commonElements.waitForLoaders();
        sleep(3000);
        sa.assertEquals(logStatus.getText(), excel.getCellData(sheetName, "Data", 10));

        sa.assertAll();
    }

    public void verifyDataOnViewLogPage() throws IOException {
        viewButton.click();

        sa.assertEquals(dateInputField.getAttribute("value"), excel.getCellData(sheetName, "View Log", 2));
        sa.assertEquals(time.getAttribute("value"), excel.getCellData(sheetName, "View Log", 3));
        sa.assertEquals(comments.getAttribute("value"), excel.getCellData(sheetName, "View Log", 4));
        imageComparison(signatureImage, "Signature");
        driver.navigate().back();
        sa.assertAll();
    }

    public void verifyEditFunctionality(){
        editLog.click();
        dateInputField.sendKeys(excel.getCellData(sheetName, "Edit log", 2));
        time.sendKeys(excel.getCellData(sheetName, "Edit log", 3));
//        textarea.sendKeys(excel.getCellData(sheetName, "Edit log", 3));

        for (int i = 0; i < textareaList.size(); i++){
            sleep(5000);
            textareaList.get(i).sendKeys(excel.getCellData(sheetName, "Edit log", i+4));
            sleep(5000);
        }
        sa.assertAll();
    }
}
