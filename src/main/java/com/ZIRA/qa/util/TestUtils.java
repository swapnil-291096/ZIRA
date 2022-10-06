package com.ZIRA.qa.util;




import com.ZIRA.qa.base.TestBase;
import com.google.zxing.Reader;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestUtils extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 3;
    public static SoftAssert sa = new SoftAssert();



    //Method to verify active links on a web page
    public void verifyActiveLinks() throws IOException {
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Size of all links----->" + linksList.size());
        List<WebElement> activeLinks = new ArrayList<WebElement>();

        for (int i = 0; i < linksList.size(); i++) {
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript"))) {
                activeLinks.add(linksList.get(i));
            }
        }

        System.out.println("Size of all links----->" + activeLinks.size());

        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();

            if (connection.getResponseCode() == 200) {
                System.out.println(activeLinks.get(j).getAttribute("href") + " - " + connection.getResponseMessage());
            }
            if (connection.getResponseCode() != 200) {
                System.out.println(activeLinks.get(j).getAttribute("href") + " - " + connection.getResponseMessage());
            }
            sa.assertEquals(connection.getResponseMessage(), "OK");
            sa.assertAll();
            connection.disconnect();
        }

    }

    //Method to upload file on mac
    public static void Upload_file(String filepath) throws Exception {

        String appl = "tell app \"System Events\"\n" +
                "keystroke \"G\" using {command down, shift down}\n" +
                "delay 1\n" +
                "keystroke \"" + filepath + "\"\n" +
                "delay 1\n" +
                "keystroke return\n" +
                "delay 1\n" +
                "keystroke return\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", appl};

        try {
            Process process = runtime.exec(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method to cancel file upload on mac
    public static void cancel_fileUpload() throws Exception {

        String appl = "tell app \"System Events\"\n" +
//                "keystroke \"G\" using {command down, shift down}\n" +
//                "delay 1\n" +
//                "keystroke \"" + filepath + "\"\n" +
//                "delay 1\n" +
//                "keystroke return\n" +
                "delay 1\n" +
                "keystroke \"w\" using command down\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", appl};

        try {
            Process process = runtime.exec(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method to capture screenshot
    public static String capture(String screenShotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/ErrorScreenshots/" + screenShotName + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot path =" + dest);
        return dest;
    }


    //Method for sleep
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method for click on Element
    public static void clickOnElement(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (TimeoutException e) {
            sa.fail("Timeout Exception, " + element.toString() + "  Element not found.");
        } catch (NoSuchElementException e) {
            sa.fail("NoSuchElementException Exception, " + element.toString() + " Element is not present.");
        } catch (ElementNotVisibleException e) {
            sa.fail("ElementNotVisibleException Exception, " + element.toString() + " Element is not visible.");
        }
    }



    //Method for wait until Element Displayed
    public static void waitForElementToBeDisplayed(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            sa.fail("Timeout Exception, " + element.toString() + "  Element not found.");
        } catch (NoSuchElementException e) {
            sa.fail("NoSuchElementException Exception, " + element.toString() + " Element is not present.");
        } catch (ElementNotVisibleException e) {
            sa.fail("ElementNotVisibleException Exception, " + element.toString() + " Element is not visible.");
        }
    }

    //Method for wait until ALL Element Displayed
    public static void waitForAllElementToBeDisplayed(List<WebElement> element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (TimeoutException e) {
            sa.fail("Timeout Exception, " + element.toString() + "  Element not found.");
        } catch (NoSuchElementException e) {
            sa.fail("NoSuchElementException Exception, " + element.toString() + " Element is not present.");
        } catch (ElementNotVisibleException e) {
            sa.fail("ElementNotVisibleException Exception, " + element.toString() + " Element is not visible.");
        }
    }

    //Method for wait until Element Disappear
    public static void waitForInvisibilityOfElement(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            sa.fail("Timeout Exception, " + element.toString() + "  Element not found.");
        } catch (NoSuchElementException e) {
            sa.fail("NoSuchElementException Exception, " + element.toString() + " Element is not present.");
        } catch (ElementNotVisibleException e) {
            sa.fail("ElementNotVisibleException Exception, " + element.toString() + " Element is not visible.");
        }
    }

    //Method for wait until Element Clickable
    public static void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        } catch (TimeoutException e) {
            sa.fail("Timeout Exception, " + element.toString() + "  Element not found.");
        } catch (NoSuchElementException e) {
            sa.fail("NoSuchElementException Exception, " + element.toString() + " Element is not present.");
        } catch (ElementNotVisibleException e) {
            sa.fail("ElementNotVisibleException Exception, " + element.toString() + " Element is not visible.");
        }
    }

    //Method for image comparison
    public static void imageComparison(WebElement actualElement, String expectedImageName) throws IOException {

        BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/Images/" + expectedImageName + ".png"));
        Screenshot logoImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, actualElement);
        // Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, actualElement);
        BufferedImage actualImage = logoImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (!diff.hasDiff())
            sa.assertFalse(diff.hasDiff(), "Images are Same...");
        else
            sa.assertTrue(diff.hasDiff(), "Images are Different...");
        sleep(1000);
        sa.assertAll();
    }

    //Method for image comparison
    public static void imageComparisonWithReturnBoolean(WebElement actualElement, String expectedImageName) throws IOException {

        BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/Images/" + expectedImageName + ".png"));
        Screenshot logoImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, actualElement);
        // Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, actualElement);
        BufferedImage actualImage = logoImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff())
            sa.assertFalse(diff.hasDiff(), "Images are Same...");
//            return false;
        else
            sa.assertTrue(diff.hasDiff(), "Images are Different...");
//            return true;
        sleep(1000);
        sa.assertAll();
    }

    //Method for taking WebElement screenshot
    public static void takeScreenshot(WebElement element, String imageName) throws Exception {
        Thread.sleep(2000);

        Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
        ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "/Images/" + imageName + ".png"));

        Thread.sleep(2000);
    }

    //Method web element image comparison
    public void webElementImageComparision(WebElement actualElement, WebElement expectedElement) throws IOException {
        Screenshot actualImageScreenshot = new AShot().takeScreenshot(driver, actualElement);
        BufferedImage actualImage = actualImageScreenshot.getImage();

        Screenshot expectedImageScreenshot = new AShot().takeScreenshot(driver, expectedElement);
        BufferedImage expectedImage = expectedImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == false)
            sa.assertFalse(diff.hasDiff(), "Images are Same...");
        else
            sa.assertFalse(diff.hasDiff(), "Images are Different...");
        sleep(1000);
        sa.assertAll();
    }

    //Method for wait until loader get disable
    public static void waitForLoader(WebElement loader) {
        sleep(1000);
        if (loader.isDisplayed()) {
            waitForInvisibilityOfElement(loader);
        }
        sleep(1000);
    }

    //Method for wait until loader get disable
    public static void waitForToaster(WebElement toaster) {
        sleep(1000);
        if (toaster.isDisplayed()) {
            waitForInvisibilityOfElement(toaster);
        }
        sleep(1000);
    }

    //Method to move cursor to element
    public void moveToElement(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    //Method to test barcode
    public void testBarCode(String imgPath) throws FormatException, ChecksumException, NotFoundException, IOException, com.google.zxing.NotFoundException {
        Reader reader = new MultiFormatReader();
        // Pass the image a parameter, which converts the image into binary bitmap
        InputStream barCodeIS = new FileInputStream(imgPath);
        BufferedImage buffImage = ImageIO.read(barCodeIS);

        LuminanceSource lsrc = new BufferedImageLuminanceSource(buffImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lsrc));

        // Reader decodes the bitmap & extract the data
        Result result = reader.decode(bitmap);

        String code = result.getText();
        System.out.println("Image Barcode / QR Code : " + code);

    }

    //Method to generate fake data
    public void generateFakeData() {

        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        System.out.println(person.getFullName());
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
        System.out.println(person.getEmail());
        System.out.println(person.getTelephoneNumber());
        System.out.println(person.getAddress());
    }

    //Method to wait until ajax call complete
    public static void waitForAjaxToComplete() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);

            ExpectedCondition<Boolean> isLoadingFalse = new
                    ExpectedCondition<Boolean>() {

                        @Override

                        public Boolean apply(WebDriver driver) {

                            Object obj = ((JavascriptExecutor)
                                    driver).executeScript("return !window.ajaxActive");

                            Object jQueryActive = ((JavascriptExecutor)
                                    driver).executeScript("return jQuery.active;");

                            if (obj != null && obj.toString().equals("true") &&
                                    jQueryActive.toString().equals("0"))

                                return Boolean.valueOf(true);

                            else

                                return false;

                        }

                    };

            wait.until(isLoadingFalse);


        } catch (Exception e) {


        }

    }

    //Method to drag and drop element
    public static void dragAndDropElement(WebElement dragFrom, WebElement dragTo) throws Exception {
        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);
        // Get size of elements

        org.openqa.selenium.Dimension fromSize = dragFrom.getSize();
        Dimension toSize = dragTo.getSize();
        Point toLocation = dragTo.getLocation();
        Point fromLocation = dragFrom.getLocation();
        //Make Mouse coordinate centre of element
        toLocation.x += toSize.width / 2;
        toLocation.y += toSize.height / 2 + 100;
        fromLocation.x += fromSize.width / 2;
        fromLocation.y += fromSize.height / 2 + 100;

        //Move mouse to drag from location
        robot.mouseMove(fromLocation.x, fromLocation.y);
        //Click and drag
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragFrom, dragTo).build().perform();

        //Drag events require more than one movement to register
        //Just appearing at destination doesn't work so move halfway first
        robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

        //Move to final position
        robot.mouseMove(toLocation.x, toLocation.y);
        //Drop
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    //New Method to drag and drop element - sometimes old method will not work, then use this method.
    public static void newDragAndDropElement(WebElement source, WebElement destination) {
        sleep(2000);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(source).moveToElement(destination).release(destination).build();
        sleep(2000);
        dragAndDrop.perform();
    }

    //Method to read PDF file
    public void readPDF(String filePath, String assertText) throws IOException {

        URL url = new URL(filePath);

        InputStream is = url.openStream();
        BufferedInputStream fileParse = new BufferedInputStream(is);
        PDDocument document = null;

        document = PDDocument.load(fileParse);
        String pdfContent = new PDFTextStripper().getText(document);
        System.out.println(pdfContent);

        sa.assertTrue(pdfContent.contains(assertText));
        sa.assertAll();

    }

    //Method to avoid opeaning link in an new window
    public void avoidSwitchWindow(String linkXpath) {
        WebElement we = driver.findElement(By.cssSelector(linkXpath));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('target','_self');", we);

        we.click();
    }

    //Method to verify Element is present or not
    public static boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            System.out.println("Element is currently visible");

            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element is currently not visible");
            return false;
        }
    }

    //Method to verify Switch Window
    public static void switchToTab(int index) {
        String windowId = null;
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> iter = windowIds.iterator();
        for (int i = 0; i <= index; i++) {
            windowId = iter.next();
        }
        driver.switchTo().window(windowId);
    }

    //Scroll till the element is display
    public static void scrollTillTheElementIsDisplay(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to clear input text field
    public static void clearInputText(WebElement element) {
        int docNameLength = element.getAttribute("value").length();
        for (int i = 0; i < docNameLength; i++)
            element.sendKeys(Keys.BACK_SPACE);
    }

    // Method to generate random number
    public static int generateRandomNumber() {
        int number = (int) Math.floor(Math.random() * 101);
        return number;
    }

    //Method to verify captcha
    public static void verifyCaptcha() {
        try {
            driver.findElement(By.xpath("//button[text()='0C]")).click();
            driver.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
            WebElement imageElement = driver.findElement(By.xpath("(//*[@id='nlpImgContainer']//following::img)[2]"));
            File src = imageElement.getScreenshotAs(OutputType.FILE);
            String path = "/Users/Mayur/Documents/Automation/SeleniumWebFrameworkcopy/Images";
            FileHandler.copy(src, new File(path));
            Thread.sleep(2000);
            ITesseract image = new Tesseract();
            String str = image.doOCR(new File(path));
            System.out.println("image OCR done");
            System.out.println(str);
            String Captcha = str.split("below")[1].replaceAll("[Aa,A-Z0-9]", "");
            driver.findElement(By.id("n1pAnswer")).sendKeys(Captcha);
        } catch (Exception e) {
            System.out.println("Exception caught" + e.getMessage());
        }
    }


    //Method to get value from properties file
    public static String getPropertyValueByKey(String key) {
        String value = prop.get(key).toString();

        if(StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: "+key + " in properties file.");
            }catch(Exception e) {}
        }

        return value;
    }

    /************************************* Generic Methods *******************************/

    public static void redirectToMenu(WebElement menu, WebElement heading) {
        driver.findElement(By.xpath("//div[@class='hamburger-menu']//input")).click();
        sleep(1000);
        menu.click();
        waitForElementToBeDisplayed(heading);

    }

    public static void mouseHover(WebElement hoverElement) {
        Actions action = new Actions(driver);
        action.moveToElement(hoverElement).perform();
        sleep(2000);
    }

    public static void selectValueByText(WebElement dropdownElement, String text) {
        Select obj = new Select(dropdownElement);
        obj.selectByVisibleText(text);
    }

    public static void openNewTabWithUrl(String url) {
        String a = "window.open('"+url+"', '_blank');";
        ((JavascriptExecutor)driver).executeScript(a);
    }

    public static void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }


    /************************************ Generic Methods Ends *******************************/

}
