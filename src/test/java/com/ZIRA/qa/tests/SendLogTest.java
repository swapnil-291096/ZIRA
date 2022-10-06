package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.SendLog;
import com.ZIRA.qa.util.CommonElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SendLogTest extends TestBase {
    SendLog sendLog;
    CommonElements commonElements;

    public SendLogTest(){super();}

    @BeforeTest
    public void setup(){
        sendLog = new SendLog();
        commonElements = new CommonElements();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void createRequiredObjects() {
        createSoftAssertObject();
    }

    @Test
    public void FSMLogin(){
        commonElements.FSMLogin();
    }

//    @Test
//    public void clickOnSaveButtonWithoutSelectPersonnelTest(){
//        sendLog.clickOnSaveButtonWithoutSelectPersonnel();
//    }
//
//    @Test
//    public void verifyFSMOnTeamPageTest(){
//        sendLog.sendLogToFSM();
//    }
//
//    @Test
//    public void verifyFunctionalityOfCrossButtonTest(){
//        sendLog.verifyFunctionalityOfCrossButton();
//    }
//
//    @Test
//    public void verifySearchFunctionalityTest(){
//        sendLog.verifySearchFunctionality();
//    }
//
//    @Test
//    public void verifySentLogDisplayedInLogScheduleTest(){
//        sendLog.verifySentLogDisplayedInLogSchedule();
//    }
//
//    @Test
//    public void verifyClickOnSaveButtonWithoutEnterAnyDataTest(){
//        sendLog.verifyClickOnSaveButtonWithoutEnterAnyData();
//    }
//
//    @Test
//    public void verifyAllFieldsFillSuccessfullyTest() throws Exception {
//        sendLog.verifyAllFieldsFillSuccessfully();
//    }
//
//    @Test
//    public void verifyAllCheckboxDeselectAndChangedFrequencyOfLogTest(){
//        sendLog.verifyAllCheckboxDeselectAndChangedFrequencyOfLog();
//    }

    @Test
    public void verifyDataOnViewLogPageTest() throws IOException {
        sendLog.verifyDataOnViewLogPage();
    }

    @Test
    public void verifyEditFunctionalityTest(){
        sendLog.verifyEditFunctionality();
    }

}
