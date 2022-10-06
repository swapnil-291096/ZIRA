package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.AdminLogMastersPage;
import com.ZIRA.qa.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogMastersPageTest extends TestBase {
    AdminLogMastersPage logMastersPage;
    LoginPage loginPage;


    public LogMastersPageTest(){super();}

    @BeforeTest
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        logMastersPage = new AdminLogMastersPage();

    }

//    @BeforeMethod
//    public void refresh(){
//        driver.navigate().refresh();
//    }

    @Test
    public void verifyUserOnLogMastersPageTest(){
        logMastersPage.verifyUserOnLogMastersPage();
    }

    @Test
    public void verifyClickOnCreateNewBtnTest(){
        logMastersPage.verifyClickOnCreateNewBtn();
    }

//    @Test
//    public void verifySaveButtonFunctionalityWithoutEnterAnyDataTest(){
//        logMastersPage.verifySaveButtonFunctionalityWithoutEnterAnyData();
//    }

//    @Test
//    public void verifyDragAndDropForShortTextTest(){
//        logMastersPage.verifyDragAndDropForShortText();
//    }

//    @Test
//    public void verifyDragAndDropForDescriptiveTextTest(){
//        logMastersPage.verifyDragAndDropForDescriptiveText();
//    }

//    @Test
//    public void verifyDragAndDropForDropDownTest(){
//        logMastersPage.verifyDragAndDropForDropDown();
//    }
//
//    @Test
//    public void verifyDragAndDropForFileUploadTest(){
//        logMastersPage.verifyDragAndDropForFileUpload();
//    }
//
//    @Test
//    public void verifyDragAndDropForLabelText(){
//        logMastersPage.verifyDragAndDropForLabel();
//    }
//
//    @Test
//    public void verifyDragAndDropNumbersTest(){
//        logMastersPage.verifyDragAndDropNumbers();
//    }
//
//    @Test
//    public void verifyDragAndDropForSignatureTest(){
//        logMastersPage.verifyDragAndDropForSignature();
//    }
//
//    @Test
//    public void verifyDragAndDropForYes_NoTest(){
//        logMastersPage.verifyDragAndDropForYes_No();
//    }
//
//    @Test
//    public void verifyDragAndDropForCheckboxTest(){
//        logMastersPage.verifyDragAndDropForCheckbox();
//    }
//
//    @Test
//    public void verifyDragAndDropForDateFieldTest(){
//        logMastersPage.verifyDragAndDropForDateField();
//    }
//
//    @Test
//    public void verifyDragAndDropForTimeFieldTest(){
//        logMastersPage.verifyDragAndDropForTimeField();
//    }
//
//    @Test
//    public void verifyDragAndDropForRatingTest(){
//        logMastersPage.verifyDragAndDropForRating();
//    }
//
//    @Test
//    public void verifyDragAndDropForTotalRatingTest(){
//        logMastersPage.verifyDragAndDropForTotalRating();
//    }
//
//    @Test
//    public void verifyDragAndDropForInstructionTest(){
//        logMastersPage.verifyDragAndDropForInstruction();
//    }

//    @Test
//    public void verifyEditFunctionalityForLogFieldsTest(){
//        logMastersPage.verifyEditFunctionalityForLogFields();
//    }
//
//    @Test
//    public void verifyCopyFunctionalityForLogFieldsTest(){
//        logMastersPage.verifyCopyFunctionalityForLogFields();
//    }
//
//    @Test
//    public void verifyDeleteFunctionalityForLogFieldsTest(){
//        logMastersPage.verifyDeleteFunctionalityForLogFields();
//    }
//
//    @Test
//    public void verifySaveLogFunctionalityForCreatedLogTest(){
//        logMastersPage.verifySaveLogFunctionalityForCreatedLog();
//    }

//    @Test
//    public void verifyEditLogFunctionalityTest(){
//        logMastersPage.verifyEditLogFunctionality();
//    }

//    @Test
//    public void verifyDisableLogFunctionalityWhenClickOnCancelButtonTest(){
//        logMastersPage.verifyDisableLogFunctionalityWhenClickOnCancelButton();
//    }
//
//    @Test
//    public void verifyDisableLogFunctionalityWhenClickOnDisableButtonToDisableLogTest(){
//        logMastersPage.verifyDisableLogFunctionalityWhenClickOnDisableButtonToDisableLog();
//    }
//
//    @Test
//    public void verifyDisableLogFunctionalityWhenClickOnDisableButtonToEnableLogTest(){
//        logMastersPage.verifyDisableLogFunctionalityWhenClickOnDisableButtonToEnableLog();
//    }
//
//    @Test
//    public void verifyDeleteLogFunctionalityWhenClickOnCancelButtonLogTest(){
//        logMastersPage.verifyDeleteLogFunctionalityWhenClickOnCancelButtonLog();
//    }
//
//    @Test
//    public void verifyDeleteLogFunctionalityWhenClickOnDeleteButtonLogTest(){
//        logMastersPage.verifyDeleteLogFunctionalityWhenClickOnDeleteButtonLog();
//    }


}

