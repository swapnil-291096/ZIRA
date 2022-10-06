package com.ZIRA.qa.base;

import com.ZIRA.qa.Listeners.WebEventListener;
import com.ZIRA.qa.util.ExcelApiTest;
import com.ZIRA.qa.util.TestUtils;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static SoftAssert sa;
    public static ExtentTest extentTest;
    public static ExcelApiTest excel;


    public TestBase() {
        PageFactory.initElements(driver, this);
        extentTest = ExtentManager.getTest();
    }

    @BeforeTest
    public static void initialization() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/swapnilshinde/Documents/Java Programming/ZIRA/src" +
                    "/main/java/com/ZIRA/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.getBrowserName();
            driver = new EdgeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

//        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1440, 945));
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    public void createSoftAssertObject() {
        sa = new SoftAssert();
    }

    public static void createExcelSheetObject(){
        try {
            excel = new ExcelApiTest(System.getProperty("user.dir") + "/src/main/java/com/ZIRA/qa/testdata/Zira.xlsx");
//            excel = new ExcelApiTest(System.getProperty("/Users/swapnilshinde/Documents/Java Programming/ZIRA"+ "/src/main/java/com/ZIRA/qa/testdata/Zira.xlsx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
