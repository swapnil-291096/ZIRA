package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.HomePage;
import com.ZIRA.qa.pages.LoginPage;
import com.ZIRA.qa.util.CommonElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    CommonElements commonElement;

    public HomePageTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        commonElement = new CommonElements();
        homePage = new HomePage();
        createExcelSheetObject();
    }

    @BeforeMethod(alwaysRun = true)
    public void createRequiredObjects() {
        driver.navigate().refresh();
        createSoftAssertObject();
    }

    @Test
    public void login() {
        commonElement.login();
    }

    @Test
    public void verifyContentOnHomePageTest() {
        homePage.verifyContentOnHomePage();
    }

    @Test
    public void verifyLinksIsClickableTest() {
        homePage.verifyLinksIsClickable();
    }
}
