package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.CompanySignupPage;
import com.ZIRA.qa.pages.FSMProfile;
import com.ZIRA.qa.util.CommonElements;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FSMProfileTest extends TestBase {
    FSMProfile fsmProfile;
    CommonElements commonElements;

    public FSMProfileTest(){super();}

    @BeforeTest
    public void setup(){
        fsmProfile = new FSMProfile();
        commonElements = new CommonElements();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void createRequiredObjects() {
        createSoftAssertObject();
    }


    @Test
    public void verifyFSMLoggedIn(){
        commonElements.FSMLogin();
    }

    @Test
    public void verifyFSMLoggedInSuccessfullyTest(){
        fsmProfile.verifyFSMLoggedInSuccessfully();
    }

    @Test
    public void verifyFSMNavigateToProfilePageTest(){
        fsmProfile.verifyFSMNavigateToProfilePage();
    }

    @Test
    public void verifyDisplayFSMDataInAllFieldTest(){
        fsmProfile.verifyDisplayFSMDataInAllField();
    }

//    @Test
//    public void verifyCancelButtonFunctionalityTest(){
//        fsmProfile.verifyCancelButtonFunctionality();
//    }

    @Test
    public void verifyErrorMessagesForAllFieldTest(){
        fsmProfile.verifyErrorMessagesForAllField();
    }

//    @Test
//    public void verifyValidationsForEmailTest(){
//        fsmProfile.verifyValidationsForEmail();
//    }
//
//    @Test
//    public void verifyInvalidContactNoTest(){
//        fsmProfile.verifyInvalidContactNo();
//    }
//
//    @Test
//    public void verifyEditAllFieldsTest(){
//        fsmProfile.verifyEditAllFields();
//    }

//    @Test
//    public void verifyClickedOnChangePasswordButtonTest(){
//        fsmProfile.verifyClickedOnChangePasswordButton();
//    }
//
//    @Test
//    public void verifyCancelButtonFunctionalityForChangePasswordTest(){
//        fsmProfile.verifyCancelButtonFunctionalityForChangePassword();
//    }
//
//    @Test
//    public void clickOnSaveButtonWithoutEnterAnyDataTest(){
//        fsmProfile.clickOnSaveButtonWithoutEnterAnyData();
//    }
//
//    @Test
//    public void verifyInvalidCurrentPasswordTest(){
//        fsmProfile.verifyInvalidCurrentPassword();
//    }
//
//    @Test
//    public void verifyValidationsForNewPasswordFieldIfEnterNumbersAndSpecialCharOnlyTest(){
//        fsmProfile.verifyValidationsForNewPasswordFieldIfEnterNumbersAndSpecialCharOnly();
//    }
//
//    @Test
//    public void verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndNumberOnlyTest(){
//        fsmProfile.verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndNumberOnly();
//    }
//    @Test
//    public void verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndSpecialCharTest(){
//        fsmProfile.verifyValidationsForNewPasswordFieldIfEnterAlphabetsAndSpecialChar();
//    }
//
//    @Test
//    public void verifyValidationsForConfirmPasswordFieldOnlyTest(){
//        fsmProfile.verifyValidationsForConfirmPasswordFieldOnly();
//    }
//
//    @Test
//    public void verifyPasswordChangedSuccessfullyTest(){
//        fsmProfile.verifyPasswordChangedSuccessfully();
//    }
//
//    @Test
//    public void verifyFSMNotLoggedInWithOldPasswordTest(){
//        fsmProfile.verifyFSMNotLoggedInWithOldPassword();
//    }
}
