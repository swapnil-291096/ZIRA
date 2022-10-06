package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.ZIRA.qa.pages.ZiraMastersPage.*;
import static com.ZIRA.qa.util.TestUtils.*;


public class AdminLogMastersPage extends TestBase {
    String sheetName = "AdminLogMasters";
    LoginPage loginPage = new LoginPage();
    ZiraMastersPage ziraMastersPage = new ZiraMastersPage();

    //Log Master Link
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[1]/ul/li[4]/a[1]")
    WebElement LogMastersLink;

    //Log Masters Text
    @FindBy(css = "div[class='col-lg-12 mstr-hed middle-lg'] h3")
    WebElement LogMastersTitle;

    //save button
    @FindBy(xpath = "//div[@id='tab-two']/button[1]")
    WebElement SaveBtn;

    //Please enter Log Name
    @FindBy(xpath = "//div[@class='row bottom-lg bottom-md']/div[1]/div/div[2]")
    WebElement PlsEnterLogNameMsg;

    //Please enter Log Code
    @FindBy(xpath = "//div[@class='row bottom-lg bottom-md']//div[2]/div/div")
    WebElement PlsEnterLogCodeMsg;

    //Profile is required.
    @FindBy(xpath = "//div[@class='row bottom-lg bottom-md']//div[3]/div/div[2]")
    WebElement ProfileIsReqMsg;

    //Log Name Input Field
    @FindBy(xpath = "//input[@id='logName']")
    WebElement LogNameInputField;

    //Log Code Input Field
    @FindBy(xpath = "//input[@id='logCode']")
    WebElement LogCodeInputField;

    //Short Text
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[1]/img")
    WebElement shortText;

    //Descriptive Text
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[2]/img")
    WebElement descriptiveText;

    //Dropdown Button
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[3]/img")
    WebElement dropdown;

    //File Upload
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[4]/img")
    WebElement fileUpload;

    //Label
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[5]/img")
    WebElement Label;

    //Number
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[6]/img")
    WebElement Number;

    //Signature
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[7]/img")
    WebElement signature;

    //Yes/No
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[8]/img")
    WebElement Yes_No;

    //Checkbox
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[9]/img")
    WebElement checkbox;

    //Date Field
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[10]/img")
    WebElement dateField;

    //Date Field
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[11]/img")
    WebElement timeField;

    //Rating Field
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[12]/img")
    WebElement ratingField;

    //Total Rating Field
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[13]/img")
    WebElement ratingTotalField;

    //Instruction Field
    @FindBy(xpath = "//div[@class='cdk-drop-list row']/div[14]/img")
    WebElement instruction;

    //Drop Destination
    @FindBy(xpath = "//div[@class='cdk-drop-list upd-inpt-par']")
    WebElement DropDestination;

    //Drop Destination2
    @FindBy(xpath = "//div[@class='cdk-drop-list flds-lsts-par']")
    WebElement DropDestination2;

    //Save Button
    @FindBy(xpath = "//div[@class='zr-modal-mid zr-modal-os zr-chtw']//div[@class='zr-modal-footer row start-lg start-md']/button[1]")
    WebElement saveButton;

    //Delete Button
    @FindBy(xpath = "//div[@class='zr-modal-footer row start-lg start-md']/button[2]")
    WebElement deleteButton;

    //This field is required
    @FindBy(xpath = "//div[@class='frm-errmsg']")
    WebElement ErrorMsg;

    //Short Text Input Field
    @FindBy(xpath = "//textarea[@name='shortQuestion']")
    WebElement shortTextInputField;

    //Descriptive Text
    @FindBy(xpath = "//textarea[@name='descriptiveTextQuestion']")
    WebElement descriptiveTextInputField;

    //valid text: What is your role
    @FindBy(xpath = "//tr[@class='cdk-drag']/td[2]//p")
    WebElement validShortText;

    //Translate Button
    @FindBy(xpath = "//div[@class='trnsl-btn']/button")
    WebElement translateBtn;

    //Dropdown input field
    @FindBy(xpath = "//textarea[@name='dropQuestion']")
    WebElement dropdownInputField;

    //Dropdown input field error message
    @FindBy(xpath = "//div[@class='form-grp']/div/div")
    WebElement FieldErMsg;

    //Dropdown Choices field error message
    @FindBy(xpath = "//div[@class='form-grp inpt-btns']/div/div")
    WebElement ChoicesFieldErMsg;

    //Dropdown Choices field-1 input field
    @FindBy(xpath = "//input[@id='form_0']")
    WebElement ChoicesInputField;

    //Dropdown Choices field-1 input field
    @FindBy(xpath = "//input[@id='form_1']")
    WebElement ChoicesInputField1;

    //Dropdown Choices field-1 input field
    @FindBy(xpath = "//input[@id='form_2']")
    WebElement ChoicesInputField2;

    //+ icon for add value in dropdown
    @FindBy(xpath = "//div[@class='form-grp inpt-btns']//ul/li[1]")
    WebElement PlusIcon;

    //+ icon for add value in Yes/No
    @FindBy(xpath = "//div[@class='zr-modal-bdy']//ul/li[1]")
    WebElement PlusIconInYes_no;

    //- icon for add value in dropdown and Yes_no
    @FindBy(xpath = "//div[@class='form-grp inpt-btns']//ul/li[2]")
    WebElement minusIconInDropdown;

    //File Upload Input Field
    @FindBy(xpath = "//textarea[@name='fileUploadQuestion']")
    WebElement fileUploadInputField;

    //Fields Title
    @FindBy(xpath = "//div[@class='zr-modal-backdrop flds-pop']/div/div/h4")
    WebElement fieldTitle;

    //Fields Subtitles
    @FindBy(xpath = "//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p")
    WebElement fieldSubTitles;

    //Label Input Field
    @FindBy(xpath = "//textarea[@name='lableQuestion']")
    WebElement labelInputField;

    //Number Input Field
    @FindBy(xpath = "//textarea[@name='numberQuestion']")
    WebElement numberInputField;

    //Signature Input Field
    @FindBy(xpath = "//textarea[@name='signatureQuestion']")
    WebElement signatureInputField;

    //Yes/No Input Field
    @FindBy(xpath = "//textarea[@name='question']")
    WebElement yes_noInputField;

    //checkbox Input Field
    @FindBy(xpath = "//textarea[@name='yesOrNoQuestion']")
    WebElement checkboxInputField;

    //Date Field Input Field
    @FindBy(xpath = "//textarea[@name='dateFieldQuestion']")
    WebElement dateFieldInputField;

    //Time Field Input Field
    @FindBy(xpath = "//textarea[@name='timeFieldQuestion']")
    WebElement timeFieldInputField;

    //Rating Input Field
    @FindBy(xpath = "//textarea[@name='ratingQuestion']")
    WebElement ratingInputField;

    //Rating Total Input Field
    @FindBy(xpath = "//textarea[@name='ratingTotalQuestion']")
    WebElement ratingTotalInputField;

    //Instruction Input Field
    @FindBy(xpath = "//textarea[@name='instructionsQuestion']")
    WebElement instructionInputField;

    //(Leave empty if range is not required) | Will be a free hand drawing area to input signature or initials.... etc
    @FindBy(xpath = "//div[@class='ans-sec']/p")
    WebElement guideTypeText;

    //Instruction text
    @FindBy(xpath = "//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p")
    WebElement instructionText;

    //Edit Button
    @FindBy(xpath = "//div[@class='flds-lsts']/table/tr[1]/td[2]/ul/li[1]")
    WebElement editButton;

    //Copy button
    @FindBy(xpath = "//div[@class='flds-lsts']/table/tr[1]/td[2]/ul/li[2]")
    WebElement copyButton;

    //Delete log button
    @FindBy(xpath = "//div[@class='flds-lsts']/table/tr[1]/td[2]/ul/li[4]")
    WebElement deleteLogButton;

    //Edit Descriptive text log Text
    @FindBy(xpath = "//div[@class='flds-lsts']/table/tr[1]/td[2]/div/p")
    WebElement editDescText;

    //copy text of  Descriptive  log Text
    @FindBy(xpath = "//div[@class='flds-lsts']/table/tr[1]/td[2]/div/p")
    WebElement copyDescText;

    //Created Log1
    @FindBy(xpath = "//div[@class='zr-bx']/table/tr[2]/td[3]")
    WebElement log1;

    //Edit Log
    @FindBy(xpath = "//div[@class='zr-bx']/table/tr[2]/td[5]/ul/li[1]")
    WebElement editLog;

    //Delete Log
    @FindBy(xpath = "//div[@class='zr-bx']/table/tr[2]/td[5]/ul/li[2]")
    WebElement deleteLog;

    //Disable Log
    @FindBy(xpath = "//div[@class='zr-bx']/table/tr[2]/td[5]/ul/li[3]")
    WebElement disableLog;

    //ok button
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    WebElement okButton;


    public void verifyUserOnLogMastersPage() {
        loginPage.verifyLoginWithValidEmailAndValidPassword(prop.getProperty("email"), prop.getProperty("password"));
        LogMastersLink.click();
        sleep(5000);

        String LogMastersTitleText = LogMastersTitle.getText();
        sa.assertEquals(LogMastersTitleText, "Log Masters");

        List<WebElement> listOfItems = driver.findElements(By.xpath("//button[@id='tab-one']"));
        for (WebElement listOfItem : listOfItems) {
            String List = listOfItem.getText();
            if (List.equals("Frequent")) {
                sa.assertEquals(List, "Frequent");
            } else {
                sa.assertEquals(List, "Non-Frequent");
            }
        }

        List<WebElement> tableRow = driver.findElements(By.xpath("//div[@class='zr-bx']/table/tr[1]"));
        for (WebElement listOfItem : tableRow) {
            String List = listOfItem.getText();
            switch (List) {
                case "NO.":
                    sa.assertEquals(List, "NO.");
                    break;
                case "Icon":
                    sa.assertEquals(List, "Icon");
                    break;
                case "Log Name":
                    sa.assertEquals(List, "Log Name");
                    break;
                case "Frequency":
                    sa.assertEquals(List, "Frequency");
                    break;
                case "Actions":
                    sa.assertEquals(List, "Actions");
                    break;
            }
        }
    }

    public void verifyClickOnCreateNewBtn() {
        sleep(6000);
        createNewBtn.click();

        List<WebElement> listOfItems = driver.findElements(By.xpath("//button[@id='tab-one']"));
        for (WebElement listOfItem : listOfItems) {
            String List = listOfItem.getText();
            if (List.equals("Log")) {
                sa.assertEquals(List, "Log");
            } else if (List.equals("Configuration")) {
                sa.assertEquals(List, "Configuration");
            } else {
                sa.assertEquals(List, "Instructions");
            }
        }

        List<WebElement> LogName_Code_Profile = driver.findElements(By.xpath("//section[@class='mstr']//div[@class='zr-input-msg']/label"));
        for (WebElement listOfItem : LogName_Code_Profile) {
            String List = listOfItem.getText();
            switch (List) {
                case "Log Name":
                    sa.assertEquals(List, "Log Name");
                    break;
                case "Log Code":
                    sa.assertEquals(List, "Log Code");
                    break;
                case "Select Company Profile":
                    sa.assertEquals(List, "Select Company Profile");
                    break;
                default:
                    sa.assertEquals(List, "Log Icon");
                    break;
            }
        }

        List<WebElement> BasicsFields = driver.findElements(By.xpath("//div[@class='cdk-drag col-lg-6 flds-col']"));
        for (WebElement listOfItem : BasicsFields) {
            String List = listOfItem.getText();
            switch (List) {
                case "Short Text":
                    sa.assertEquals(List, "Short Text");
                    break;
                case "Descriptive Text":
                    sa.assertEquals(List, "Descriptive Text");
                    break;
                case "Drop Down":
                    sa.assertEquals(List, "Drop Down");
                    break;
                case "File Upload":
                    sa.assertEquals(List, "File Upload");
                    break;
                case "Label":
                    sa.assertEquals(List, "Label");
                    break;
                case "Numbers":
                    sa.assertEquals(List, "Numbers");
                    break;
                case "Signature":
                    sa.assertEquals(List, "Signature");
                    break;
                case "Yes / No":
                    sa.assertEquals(List, "Yes / No");
                    break;
                case "Checkbox":
                    sa.assertEquals(List, "Checkbox");
                    break;
                case "Date Field":
                    sa.assertEquals(List, "Date Field");
                    break;
                case "Time Field":
                    sa.assertEquals(List, "Time Field");
                    break;
                case "Rating":
                    sa.assertEquals(List, "Rating");
                    break;
                case "Rating Total":
                    sa.assertEquals(List, "Rating Total");
                    break;
                default:
                    sa.assertEquals(List, "Instructions");
                    break;
            }
        }
    }

    public void verifySaveButtonFunctionalityWithoutEnterAnyData() {
        SaveBtn.click();

        String PlsEnterLogNameMsgText = PlsEnterLogNameMsg.getText();
        sa.assertEquals(PlsEnterLogNameMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 2));

        String PlsEnterLogCodeMsgText = PlsEnterLogCodeMsg.getText();
        sa.assertEquals(PlsEnterLogCodeMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 3));

        sa.assertEquals(ProfileIsReqMsg.getText(), excel.getCellData(sheetName, "ErrorMessages", 4));
    }

    public void verifyErrorMessagesWhenEnterDataInRandomFields() {
        LogNameInputField.sendKeys("L");
        sa.assertFalse(isElementPresent(PlsEnterLogNameMsg));
        LogNameInputField.sendKeys(Keys.BACK_SPACE);
//        sa.assertEquals(PlsEnterLogNameMsgText, "Please enter Log Name");

        LogCodeInputField.sendKeys("C");
        sa.assertFalse(isElementPresent(PlsEnterLogCodeMsg));
        LogCodeInputField.sendKeys(Keys.BACK_SPACE);
//        sa.assertEquals(PlsEnterLogCodeMsgText, "Please enter Log Code");

        LogNameInputField.sendKeys(excel.getCellData(sheetName, "HeaderData", 2));
        LogCodeInputField.sendKeys(excel.getCellData(sheetName, "HeaderData", 3));
    }

    public void verifyDragAndDropForShortText() {
        newDragAndDropElement(shortText, DropDestination);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Short Text");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        String freeHandDrwSigTextMsg = guideTypeText.getText();
        sa.assertEquals(freeHandDrwSigTextMsg, "Will be a text box. Users can enter alphanumeric characters.");

        saveButton.click();
        String ErrorMgsText = ErrorMsg.getText();
        sa.assertEquals(ErrorMgsText, "This field is required");

        shortTextInputField.sendKeys("W");
        sa.assertNotEquals(ErrorMgsText, "");

        sleep(2000);
        shortTextInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMgsText, "This field is required");

        shortTextInputField.sendKeys("This is descriptive type field.");
        sa.assertNotEquals(ErrorMgsText, "");

        deleteButton.click();

        newDragAndDropElement(shortText, DropDestination);
        shortTextInputField.sendKeys("What is your role?");
        sa.assertNotEquals(ErrorMgsText, "");

        translateBtn.click();
        sleep(4000);
        String val = driver.findElement(By.xpath("//textarea[@id='spanishQuestion']")).getAttribute("value");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        sleep(4000);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("spanish to english");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
        sleep(4000);
        driver.findElement(By.xpath("//textarea[@class='tw-ta tw-text-large XcVN5d goog-textarea']")).sendKeys(val);
        sleep(4000);
        String val2 = driver.findElement(By.xpath("//pre[@id='tw-target-text']/span")).getText();

        driver.close();

        sa.assertEquals(val2, "What is your role?");

        saveButton.click();

        String validShortTexts = validShortText.getText();
        sa.assertEquals(validShortTexts, "What is your role?");


    }

    public void verifyDragAndDropForDescriptiveText() {
        newDragAndDropElement(descriptiveText, DropDestination);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Descriptive Text");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        String freeHandDrwSigTextMsg = guideTypeText.getText();
        sa.assertEquals(freeHandDrwSigTextMsg, "Will be a text box. Users can enter alphanumeric characters.");

        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        descriptiveTextInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        descriptiveTextInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        descriptiveTextInputField.sendKeys("This is descriptive type field.");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }


    public void verifyDragAndDropForDropDown() {
        newDragAndDropElement(dropdown, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Drop Down");

        saveButton.click();

        String dropdownInputFieldErMsgText = FieldErMsg.getText();
        sa.assertEquals(dropdownInputFieldErMsgText, "This field is required");

        String dropdownChoicesFieldErMsgText = ChoicesFieldErMsg.getText();
        sa.assertEquals(dropdownChoicesFieldErMsgText, "This field is required");

        dropdownInputField.sendKeys("Select From Below Choices");
        sa.assertNotEquals(dropdownInputFieldErMsgText, "");
        saveButton.click();
        sa.assertEquals(dropdownChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys("1");
        sa.assertNotEquals(dropdownChoicesFieldErMsgText, "");

        PlusIcon.click();
        saveButton.click();
        sa.assertEquals(dropdownChoicesFieldErMsgText, "This field is required");

        ChoicesInputField1.sendKeys("2");
        sa.assertNotEquals(dropdownChoicesFieldErMsgText, "");

        PlusIcon.click();
        ChoicesInputField2.sendKeys("3");
        ChoicesInputField1.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(dropdownChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys(Keys.BACK_SPACE);
        ChoicesInputField2.sendKeys(Keys.BACK_SPACE);
        sleep(4000);

        List<WebElement> dropdownChoicesFieldErMessage = driver.findElements(By.xpath("//div[@class='form-grp inpt-btns']/div/div"));

        for (WebElement listOfItem : dropdownChoicesFieldErMessage) {
            String List = listOfItem.getText();
            if (List.equals("This field is required")) {
                sa.assertEquals(List, "This field is required");
            } else if (List.equals("This field is required\n" +
                    "This field is required\n")) {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n");
            } else {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n" +
                        "This field is required");
            }
        }

        minusIconInDropdown.click();
        sleep(4000);
        minusIconInDropdown.click();

        ChoicesInputField.sendKeys("1");

        saveButton.click();
    }

    public void verifyDragAndDropForFileUpload() {
        newDragAndDropElement(fileUpload, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "File Upload");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }

        saveButton.click();
        String inputFieldMsg = FieldErMsg.getText();
        sa.assertEquals(inputFieldMsg, "This field is required");

        fileUploadInputField.sendKeys("Upload File");
        sa.assertNotEquals(inputFieldMsg, "");

        saveButton.click();
    }

    public void verifyDragAndDropForLabel() {
        newDragAndDropElement(Label, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Label");

        String fieldSubTitlesText = fieldSubTitles.getText();
        sa.assertEquals(fieldSubTitlesText, "Title/Label");

        saveButton.click();
        String inputFieldMsg = FieldErMsg.getText();
        sa.assertEquals(inputFieldMsg, "This field is required");

        labelInputField.sendKeys("This is title.");
        sa.assertNotEquals(inputFieldMsg, "");

        saveButton.click();
    }

    public void verifyDragAndDropNumbers() {
        newDragAndDropElement(Number, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Numbers");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer: Range of Values")) {
                sa.assertEquals(List, "Answer: Range of Values");
            }
        }
        String leaveEmptyTextMsg = guideTypeText.getText();
        sa.assertEquals(leaveEmptyTextMsg, "(Leave empty if range is not required)");

        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        numberInputField.sendKeys("S");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        numberInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        numberInputField.sendKeys("Select the numbers");
        sa.assertNotEquals(ErrorMsgs, "");
        sleep(4000);

        saveButton.click();
    }

    public void verifyDragAndDropForSignature() {
        newDragAndDropElement(signature, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Signature");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        String freeHandDrwSigTextMsg = guideTypeText.getText();
        sa.assertEquals(freeHandDrwSigTextMsg, "Will be a free hand drawing area to input signature or initials.");

        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        signatureInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        signatureInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        signatureInputField.sendKeys("Please sign below.");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyDragAndDropForYes_No() {
        newDragAndDropElement(Yes_No, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Yes / No");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer Choices")) {
                sa.assertEquals(List, "Answer Choices");
            }
        }
        saveButton.click();

        String InputFieldErMsgText = FieldErMsg.getText();
        sa.assertEquals(InputFieldErMsgText, "This field is required");

        String ChoicesFieldErMsgText = ChoicesFieldErMsg.getText();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        yes_noInputField.sendKeys("Select From Below Choices");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");
        saveButton.click();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys("Y");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");

        PlusIconInYes_no.click();
        saveButton.click();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField1.sendKeys("N");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");

        PlusIconInYes_no.click();
        ChoicesInputField2.sendKeys("Y-N");
        ChoicesInputField1.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys(Keys.BACK_SPACE);
        ChoicesInputField2.sendKeys(Keys.BACK_SPACE);
        sleep(4000);

        List<WebElement> yes_noChoicesFieldErMessage = driver.findElements(By.xpath("//div[@class='form-grp inpt-btns']/div/div"));

        for (WebElement listOfItem : yes_noChoicesFieldErMessage) {
            String List = listOfItem.getText();
            if (List.equals("This field is required")) {
                sa.assertEquals(List, "This field is required");
            } else if (List.equals("This field is required\n" +
                    "This field is required\n")) {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n");
            } else {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n" +
                        "This field is required");
            }
        }
        PlusIconInYes_no.click();       //Here +button works as -button
        sleep(4000);

        minusIconInDropdown.click();

        ChoicesInputField.sendKeys("Yes");

        saveButton.click();
    }

    public void verifyDragAndDropForCheckbox() {
        newDragAndDropElement(checkbox, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Checkbox");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer Choices")) {
                sa.assertEquals(List, "Answer Choices");
            }
        }
        saveButton.click();

        String InputFieldErMsgText = FieldErMsg.getText();
        sa.assertEquals(InputFieldErMsgText, "This field is required");

        String ChoicesFieldErMsgText = ChoicesFieldErMsg.getText();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        checkboxInputField.sendKeys("Select the checkbox From Below Choices");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");
        saveButton.click();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys("Y");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");

        PlusIcon.click();
        saveButton.click();
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField1.sendKeys("N");
        sa.assertNotEquals(ChoicesFieldErMsgText, "");

        PlusIconInYes_no.click();
        ChoicesInputField2.sendKeys("Y-N");
        ChoicesInputField1.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ChoicesFieldErMsgText, "This field is required");

        ChoicesInputField.sendKeys(Keys.BACK_SPACE);
        ChoicesInputField2.sendKeys(Keys.BACK_SPACE);
        sleep(4000);

        List<WebElement> yes_noChoicesFieldErMessage = driver.findElements(By.xpath("//div[@class='form-grp inpt-btns']/div/div"));

        for (WebElement listOfItem : yes_noChoicesFieldErMessage) {
            String List = listOfItem.getText();
            if (List.equals("This field is required")) {
                sa.assertEquals(List, "This field is required");
            } else if (List.equals("This field is required\n" +
                    "This field is required\n")) {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n");
            } else {
                sa.assertEquals(List, "This field is required\n" +
                        "This field is required\n" +
                        "This field is required");
            }
        }
        minusIconInDropdown.click();
        sleep(4000);

        minusIconInDropdown.click();

        ChoicesInputField.sendKeys("One");

        saveButton.click();
    }

    public void verifyDragAndDropForDateField() {
        newDragAndDropElement(dateField, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Date Field");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        dateFieldInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        dateFieldInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        dateFieldInputField.sendKeys("Select Date.");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyDragAndDropForTimeField() {
        newDragAndDropElement(timeField, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Time Field");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        timeFieldInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        timeFieldInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        timeFieldInputField.sendKeys("Select Time");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyDragAndDropForRating() {
        newDragAndDropElement(ratingField, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Rating");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer Choices: Slide Steps")) {
                sa.assertEquals(List, "Answer Choices: Slide Steps");
            }
        }
        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        ratingInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        ratingInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        ratingInputField.sendKeys("Give Rating");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyDragAndDropForTotalRating() {
        newDragAndDropElement(ratingTotalField, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Rating Total");

        List<WebElement> Text = driver.findElements(By.xpath("//div[@class='zr-modal-backdrop flds-pop']//form/div/div/div/p"));

        for (WebElement listOfItem : Text) {
            String List = listOfItem.getText();
            if (List.equals("Question")) {
                sa.assertEquals(List, "Question");
            } else if (List.equals("Answer")) {
                sa.assertEquals(List, "Answer");
            }
        }
        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        ratingTotalInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        ratingTotalInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        ratingTotalInputField.sendKeys("Give Rating Total");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyDragAndDropForInstruction() {
        newDragAndDropElement(instruction, DropDestination2);

        String fieldTitleText = fieldTitle.getText();
        sa.assertEquals(fieldTitleText, "Instructions");

        String InstructionTexts = instructionText.getText();
        sa.assertEquals(InstructionTexts, "Instructions");

        saveButton.click();
        String ErrorMsgs = ErrorMsg.getText();
        sa.assertEquals(ErrorMsgs, "This field is required");

        sleep(2000);
        instructionInputField.sendKeys("P");
        sa.assertNotEquals(ErrorMsgs, "");

        sleep(2000);
        instructionInputField.sendKeys(Keys.BACK_SPACE);
        sa.assertEquals(ErrorMsgs, "This field is required");

        instructionInputField.sendKeys("This is instruction Field");
        sa.assertNotEquals(ErrorMsgs, "");

        saveButton.click();
    }

    public void verifyEditFunctionalityForLogFields() {
        editButton.click();

        descriptiveTextInputField.sendKeys("This is descriptive type field is updated.");

        saveButton.click();

        String editDescTexts = editDescText.getText();
        sa.assertEquals(editDescTexts, "This is descriptive type field.This is descriptive type field is updated.");
    }

    public void verifyCopyFunctionalityForLogFields() {
        copyButton.click();

        String text = copyDescText.getText();
        sa.assertEquals(text, "This is descriptive type field.This is descriptive type field is updated.");

    }

    public void verifyDeleteFunctionalityForLogFields() {
        deleteLogButton.click();

        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        String confirmDeleteMsgText = confirmDeleteMsg.getText();
        sa.assertEquals(confirmDeleteMsgText, "Are you sure you want to delete this row?");

        deleteBtnForDeletePopup.click();
    }

    public void verifySaveLogFunctionalityForCreatedLog() {
        SaveBtn.click();
        String logText = log1.getText();
        sa.assertEquals(logText, "Log1");
    }

    public void verifyEditLogFunctionality() {
        editLog.click();

        sleep(4000);
        LogNameInputField.sendKeys(" updated");

        sleep(4000);
        SaveBtn.click();

        String logText = log1.getText();
        System.out.println(logText);
        sa.assertEquals(logText, "Log1 updated");
    }

    public void verifyDisableLogFunctionalityWhenClickOnCancelButton() {
        disableLog.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sleep(4000);
        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        confirmDisableMsg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Are you sure you want to disable this Log?");
        String confirmDisableMsgText = confirmDisableMsg.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Are you sure you want to disable this Log?");
        sa.assertEquals(confirmDisableMsgText, "Are you sure you want to disable this Log?");
        ExtentManager.getTest().log(Status.INFO, "Are you sure you want to disable this Log?");

        cancelBtnForDisablePopup.click();
//       WebElement val = driver.findElement(By.xpath("//table/tr[2] | //table//tr[@class='isDisabled']"));
        WebElement val = driver.findElement(By.xpath("//table/tr[2] | //table//tr[@class='isDisabled']/td[3]"));

        if (val.getAttribute("class").equals("isDisabled")) {
            sa.fail("Test Fail Due to element is disabled.");
        } else {
            String logText = log1.getText();
            sa.assertEquals(logText, "Log1 updated");
        }
    }

    public void verifyDisableLogFunctionalityWhenClickOnDisableButtonToDisableLog() {
        disableLog.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sleep(4000);
        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        confirmDisableMsg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Are you sure you want to disable this Log?");
        String confirmDisableMsgText = confirmDisableMsg.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Are you sure you want to disable this Log?");
        sa.assertEquals(confirmDisableMsgText, "Are you sure you want to disable this Log?");
        ExtentManager.getTest().log(Status.INFO, "Are you sure you want to disable this Log?");

        disableBtnForDisablePopup.click();

        sleep(2000);
        FSCertificateDisabledSuccessfully.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Log Disabled successfully.");
        String FSCertificateDisabledSuccessfullyText = FSCertificateDisabledSuccessfully.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Log Disabled successfully.");
        sa.assertEquals(FSCertificateDisabledSuccessfullyText, "Log Disabled successfully.");
        ExtentManager.getTest().log(Status.INFO, "Verified text: Log Disabled successfully.");

        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button button.");
        sleep(2000);

        if (disabledRow.getAttribute("class").equals("isDisabled")) {
            String logText = log1.getText();
            sa.assertEquals(logText, "Log1 updated");
        } else {
            sa.fail("Test Fail Due to element not disabled");
        }
    }

    public void verifyDisableLogFunctionalityWhenClickOnDisableButtonToEnableLog() {
//        boolean val = disabledRow.getAttribute("class").equals("isDisabled");
        disableLog.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on disable button.");

        sleep(4000);
        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        confirmDisableMsg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Are you sure you want to enable this Log?");
        String confirmDisableMsgText = confirmDisableMsg.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Are you sure you want to enable this Log?");
        sa.assertEquals(confirmDisableMsgText, "Are you sure you want to enable this Log?");
        ExtentManager.getTest().log(Status.INFO, "Are you sure you want to enable this Log?");

        enableBtnForDisablePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on enable button button.");
        sleep(4000);

        FSCertificateEnabledSuccessfully.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Log Enabled successfully.");
        String FSCertificateEnabledSuccessfullyText = FSCertificateEnabledSuccessfully.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Log Enabled successfully.");
        sa.assertEquals(FSCertificateEnabledSuccessfullyText, "Log Enabled successfully.");
        ExtentManager.getTest().log(Status.INFO, "Verified text: Log Enabled successfully.");

        sleep(4000);
        OKBtn.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");
        sleep(2000);

        WebElement val = driver.findElement(By.xpath("//table/tr[2] | //table//tr[@class='isDisabled']/td[3]"));

        if (val.getAttribute("class").equals("isDisabled")) {
            sa.fail("Test Fail Due to element is disabled.");
        } else {
            String logText = log1.getText();
            sa.assertEquals(logText, "Log1 updated");
        }
    }

    public void verifyDeleteLogFunctionalityWhenClickOnCancelButtonLog() {
        deleteLog.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Delete button.");

        sleep(3000);
        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        confirmDeleteMsg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Are you sure you want to delete this Certificate?");
        String confirmDeleteMsgText = confirmDeleteMsg.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Are you sure you want to delete this Certificate?");
        sa.assertEquals(confirmDeleteMsgText, "Are you sure you want to delete this Certificate?");
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to delete this Certificate?");

        cancelBtnForDeletePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on cancel button.");

        String logText = log1.getText();
        sa.assertEquals(logText, "Log1 updated");
    }

    public void verifyDeleteLogFunctionalityWhenClickOnDeleteButtonLog() {
        String logText = log1.getText();
        deleteLog.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Delete button.");

        sleep(3000);
        confirmAction.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Confirm Action");

        confirmDeleteMsg.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Are you sure you want to delete this Certificate?");
        String confirmDeleteMsgText = confirmDeleteMsg.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Are you sure you want to delete this Certificate?");
        sa.assertEquals(confirmDeleteMsgText, "Are you sure you want to delete this Certificate?");
        ExtentManager.getTest().log(Status.INFO, "Verified text: Are you sure you want to delete this Certificate?");

        deleteBtnForDeletePopup.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on delete button.");
        sleep(4000);

        FSCertificateDeletedSuccessfully.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed text: Log deleted successfully.");
        String FSCertificateDeletedSuccessfullyText = FSCertificateDeletedSuccessfully.getText();
        ExtentManager.getTest().log(Status.INFO, "Got text: Log deleted successfully.");
        sa.assertEquals(FSCertificateDeletedSuccessfullyText, "Log deleted successfully.");
        ExtentManager.getTest().log(Status.INFO, "Verified text: Log deleted successfully.");

        okButton.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on OK button.");
        sleep(2000);

        sa.assertNotEquals(logText, "");
    }

}


