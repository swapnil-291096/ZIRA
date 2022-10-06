package com.ZIRA.qa.util;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.HomePage;
import com.ZIRA.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginSuccessful extends TestBase {
    HomePage homePage;
    LoginPage loginPage;



    @BeforeTest
    public void setup(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }

    @Test
    public void successful(){
        loginPage.verifyLoginWithValidEmailAndValidPassword(prop.getProperty("email"), prop.getProperty("password"));
    }
}
