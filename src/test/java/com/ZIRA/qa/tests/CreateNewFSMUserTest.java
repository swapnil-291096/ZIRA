package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewFSMUserTest extends TestBase {
    CreateNewFSMUser createNewFSMUser;
    public CreateNewFSMUserTest(){super();}

    @BeforeTest
    public void setup(){
        createExcelSheetObject();
        createNewFSMUser = new CreateNewFSMUser();
    }

    @BeforeMethod(alwaysRun = true)
    public void softAssertObject(){
        createSoftAssertObject();
    }

    @Test
    public void createNewFSMTest(){
        createNewFSMUser.createNewFSM(prop.getProperty("companyName"), prop.getProperty("fName"), prop.getProperty("lName"), prop.getProperty("fsmEmail"));
    }

    @Test
    public void stripeDetailsTest(){
        createNewFSMUser.stripeDetails();
    }
}
