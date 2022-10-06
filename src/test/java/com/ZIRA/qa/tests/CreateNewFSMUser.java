package com.ZIRA.qa.tests;

import com.ZIRA.qa.base.TestBase;
import com.ZIRA.qa.pages.CompanySignupPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.ZIRA.qa.util.TestUtils.scrollTillTheElementIsDisplay;
import static com.ZIRA.qa.util.TestUtils.sleep;

public class CreateNewFSMUser extends TestBase {
    String sheetName = "FSMSignup";
    CompanySignupPage companySignupPage = new CompanySignupPage();

    //Card no input field
    @FindBy(id = "cardNumber")
    WebElement cardNoInputField;

    //Card Date input field
    @FindBy(id = "cardExpiry")
    WebElement cardDateInputField;

    //Card CVC input field
    @FindBy(id = "cardCvc")
    WebElement cardCVCInputField;

    //Card CVC input field
    @FindBy(id = "billingName")
    WebElement nameOnCard;

    //Card CVC input field
    @FindBy(xpath = "//div[@class='form-grp']/div[9]/div[1]")
    WebElement subscribeButton;

    //Card CVC input field
    @FindBy(xpath = "//ul[@class='lazyContainer']//li//label")
    List<WebElement> companyProfileList;

    public void createNewFSM(String companyName,String fName, String lName, String Email){
        driver.get(prop.getProperty("FSMSignupUrl"));
        companySignupPage.companyNameInputField.sendKeys(companyName);
        companySignupPage.firstNameInputField.sendKeys(fName);
        companySignupPage.lastNameInputField.sendKeys(lName);
        companySignupPage.emailInputField.sendKeys(Email);
        companySignupPage.contactNoInputField.sendKeys(excel.getCellData(sheetName, "Email", 6));
        scrollTillTheElementIsDisplay(companySignupPage.passwordInputField);
        companySignupPage.companyProfileDropdown.click();

        for (WebElement list : companyProfileList){
            list.click();
        }

        companySignupPage.companyProfileDropdown.click();
        companySignupPage.proButton.click();
        companySignupPage.passwordInputField.sendKeys(excel.getCellData(sheetName, "Email", 7));
        companySignupPage.confirmPasswordInputField.sendKeys(excel.getCellData(sheetName, "Email", 7));
        companySignupPage.signupButton.click();
        sleep(3000);
    }

    public void stripeDetails(){
        cardNoInputField.sendKeys("4242424242424242");
        cardDateInputField.sendKeys("0333");
        cardCVCInputField.sendKeys("123");
        nameOnCard.sendKeys("Swapnil Shinde");
//        subscribeButton.click();
    }

}
