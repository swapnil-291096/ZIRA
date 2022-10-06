package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.CompanySignupPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompanySignupPageTest extends TestBase {
    CompanySignupPage companySignupPage;

    public CompanySignupPageTest(){super();}

    @BeforeTest
    public void setup(){
        createExcelSheetObject();
        companySignupPage = new CompanySignupPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void sotAssertObject(){
        createSoftAssertObject();
    }

    @Test
    public void verifyUserOnCompanySignupPageTest(){
        companySignupPage.verifyUserOnCompanySignupPage();
    }

    @Test
    public void verifySignupButtonFunctionalityWithoutEnterAnyDataTest(){
        companySignupPage.verifySignupButtonFunctionalityWithoutEnterAnyData();
    }

    @Test
    public void verifyErrorMsgHideForCName_FName_LNameWhenEnterDataTest(){
        companySignupPage.verifyErrorMsgHideForCName_FName_LNameWhenEnterData();
    }

    @Test
    public void verifyValidationsForEmailFieldTest(){
        companySignupPage.verifyValidationsForEmailField();
    }

    @Test
    public void verifyValidationsOfContactNumberTest(){
        companySignupPage.verifyValidationsOfContactNumber();
    }

    @Test
    public void verifyValidationsOfSelectCompanyProfileTest(){
        companySignupPage.verifyValidationsOfSelectCompanyProfile();
    }

    @Test
    public void verifyValidationsForPasswordAndConfirmPasswordTest(){
        companySignupPage.verifyValidationsForPasswordAndConfirmPassword();
    }

    @Test
    public void VerifyEmailAlreadyExistTest(){
        companySignupPage.VerifyEmailAlreadyExist();
    }
//
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

}
