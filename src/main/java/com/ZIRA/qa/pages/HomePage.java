package com.ZIRA.qa.pages;

import com.ZIRA.qa.base.ExtentManager;
import com.ZIRA.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {
    String sheetName = "HomePage";

    //Image Logo
    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement ImageLogo;

    //administration Link
    @FindBy(xpath = "//a[@class='header-ul-active']")
    WebElement administrationLink;

    //Zira Masters Link
    //xpath = "//ul[@class= 'inline-ul header-ul']/child::li[2]"
    //xpath = "//a[@class= 'header-ul-active']/parent::*/following-sibling::li[1]/a"
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[1]/ul/li[2]/a[1]")
    public WebElement ziraMastersLink;

    //Company Masters Link
    //xpath = "//a[@class= 'header-ul-active']/parent::*/following-sibling::li[2]/a"
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[1]/ul/li[3]/a[1]")
    WebElement companyMastersLink;

    //Log Masters Link
    //xpath = //a[@class= 'header-ul-active']/parent::*/following-sibling::li[3]/a
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[1]/ul/li[4]/a[1]")
    WebElement logMastersLink;

    //Search field
    @FindBy(xpath = "//input[@type='text']")
    WebElement searchField;

    //Admin Drop down
    @FindBy(xpath = "//div[1]/div/div/div[2]/div/div[2]/ul/li[3]/a")
    WebElement adminDropdown;

    public void verifyContentOnHomePage(){
        ImageLogo.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed Zira logo on home page");

        WebElement[] headerList = {administrationLink, ziraMastersLink, companyMastersLink, logMastersLink};
        for (int i = 0; i < headerList.length; i++){
            sa.assertEquals(headerList[i].getText(), excel.getCellData(sheetName,"Data",i+2));
            headerList[i].click();
        }

        searchField.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed search field.");

        adminDropdown.isDisplayed();
        ExtentManager.getTest().log(Status.INFO, "Displayed admin Dropdown.");

        sa.assertAll();
    }

    public void verifyLinksIsClickable(){
        WebElement[] headerListClick = {administrationLink, ziraMastersLink, companyMastersLink, logMastersLink};

        administrationLink.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on administration link");

        ziraMastersLink.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on zira Masters link");

        companyMastersLink.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Company Masters Link");

        logMastersLink.click();
        ExtentManager.getTest().log(Status.INFO, "Clicked on logMasters link");

        sa.assertAll();
    }
}
