package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.TeamPage;
import com.ZIRA.qa.util.CommonElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamPageTest extends TestBase {
    TeamPage teamPage;
    CommonElements commonElements;
    public TeamPageTest(){super();}

    @BeforeTest
    public void setup(){
        commonElements = new CommonElements();
        teamPage = new TeamPage();
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

    @Test
    public void verifyFSMOnTeamPageTest(){
        teamPage.verifyFSMOnTeamPage();
    }

    @Test
    public void verifyFSMOnCreateTeamPageTest(){
        teamPage.verifyFSMOnCreateTeamPage();
    }

    @Test
    public void verifyClickOnSaveButtonWithoutEnterAnyDataTest(){
        teamPage.verifyClickOnSaveButtonWithoutEnterAnyData();
    }

    @Test
    public void verifyInvalidEmailTest(){
        teamPage.verifyInvalidEmail();
    }

    @Test
    public void verifyExistingMailTest(){
        teamPage.verifyExistingMail();
    }

    @Test
    public void verifyInvalidContactNumberTest(){
        teamPage.verifyInvalidContactNumber();
    }

    @Test
    public void verifyClickOnSaveButtonWithEnterValidDetailsTest(){
        teamPage.verifyClickOnSaveButtonWithEnterValidDetails();
    }

    @Test
    public void verifyTeamMemberCreatedSuccessfullyTest(){
        teamPage.verifyTeamMemberCreatedSuccessfully();
    }

    @Test
    public void verifyTeamMemberEditFunctionalityTest(){
        teamPage.verifyTeamMemberEditFunctionality();
    }

    @Test
    public void verifyDeleteFunctionalityWhenClickOnCancelButtonTest(){
        teamPage.verifyDeleteFunctionalityWhenClickOnCancelButton();
    }

    @Test
    public void verifyDeleteFunctionalityWhenClickOnDeleteButtonTest(){
        teamPage.verifyDeleteFunctionalityWhenClickOnDeleteButton();
    }

}
