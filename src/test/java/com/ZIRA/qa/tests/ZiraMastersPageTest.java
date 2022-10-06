package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.LoginPage;
import com.ZIRA.qa.pages.ZiraMastersPage;
import com.ZIRA.qa.util.CommonElements;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZiraMastersPageTest extends TestBase {
    CommonElements commonElements;
    ZiraMastersPage ziraMastersPage;
    LoginPage loginPage;

    public ZiraMastersPageTest(){super();}

    @BeforeTest
    public void setup() {
        ziraMastersPage = new ZiraMastersPage();
        commonElements = new CommonElements();
        loginPage = new LoginPage();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void refresh() {
        createSoftAssertObject();
        driver.navigate().refresh();
    }

    @Test
    public void adminLogin() {
        commonElements.login();
    }

    @Test
    public void verifyClickOnFSCertificationPageTest() {
        ziraMastersPage.verifyClickOnFSCertificationPage();
    }

    @Test
    public void verifyUserOnFSCertificationPageTest() {
        ziraMastersPage.verifyUserOnFSCertificationPage();
    }

    @Test
    public void verifyCreateNewButtonFunctionalityTest() {
        ziraMastersPage.verifyCreateNewButtonFunctionality();
    }

    @Test
    public void verifyCreateButtonFunctionalityWithoutEnterDataTest() {
        ziraMastersPage.verifyCreateButtonFunctionalityWithoutEnterData();
    }

    @Test
    public void verifyCancelButtonFunctionalityTest() {
        ziraMastersPage.verifyCancelButtonFunctionality();
    }

    @Test
    public void verifyCreateBtnFunctionalityWithEnterOPTypeOnlyTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWithEnterOPTypeOnly();
    }

    @Test
    public void verifyCreateBtnFunctionalityWithEnterDescriptionOnlyTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWithEnterDescriptionOnly();
    }

    @Test
    public void verifyCreateBtnFunctionalityWithLessThan4CharInOPTypeAndDescIsEnteredTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWithLessThan4CharInOPTypeAndDescIsEntered();
    }

    @Test
    public void verifyCreateBtnFunctionalityWithLessThan4CharInDescTypeAndOPTypeIsEnteredTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWithLessThan4CharInDescTypeAndOPTypeIsEntered();
    }

    @Test
    public void verifyCreateBtnFunctionalityWithLessThan4CharInOpTypeAndDescTypeTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWithLessThan4CharInOpTypeAndDescType();
    }

    @Test
    public void verifyCreateBtnFunctionalityWhenOPTypeLessThan4charAndDescIsEmptyTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWhenOPTypeLessThan4charAndDescIsEmpty();
    }

    @Test
    public void verifyCreateBtnFunctionalityWhenDescTypeLessThan4charAndOPIsEmptyTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWhenDescTypeLessThan4charAndOPIsEmpty();
    }

    @Test
    public void verifyCreateBtnFunctionalityWhenEnterValidDataTest() {
        ziraMastersPage.verifyCreateBtnFunctionalityWhenEnterValidData();
    }

    @Test
    public void verifyEditButtonFunctionalityTest() {
        ziraMastersPage.verifyEditButtonFunctionality();
    }

    @Test
    public void verifyDeleteButtonFunctionalityWhenClickOnCancelBtnTest() {
        ziraMastersPage.verifyDeleteButtonFunctionalityWhenClickOnCancelBtn();
    }

    @Test
    public void verifyDisableButtonFunctionalityWhenClickOnCancelBtnTest() {
        ziraMastersPage.verifyDisableButtonFunctionalityWhenClickOnCancelBtn();
    }

    @Test
    public void verifyDisableButtonFunctionalityWhenClickOnDisableBtnTest() {
        ziraMastersPage.verifyDisableButtonFunctionalityWhenClickOnDisableBtn();
    }

    @Test
    public void verifyDisableButtonFunctionalityWhenClickOnEnableBtnToGetEnableRowTest() {
        ziraMastersPage.verifyDisableButtonFunctionalityWhenClickOnEnableBtnToGetEnableRow();
    }

    @Test
    public void verifyDeleteButtonFunctionalityWhenClickOnDeleteBtnTest() {
        ziraMastersPage.verifyDeleteButtonFunctionalityWhenClickOnDeleteBtn();
    }

    @Test
    public void verifyUserOnUserRolesTest() {
        ziraMastersPage.verifyUserOnUserRoles();
    }

    @Test
    public void verifyErrorMessageDisplayAndHideValidationAndCreateUserRoleTest() {
        ziraMastersPage.verifyErrorMessageDisplayAndHideValidationAndCreateUserRole();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
