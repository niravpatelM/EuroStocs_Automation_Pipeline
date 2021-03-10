package autofacets.base;

import autofacets.utils.PropertyManager;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author niravpatel
 */

public class TestBase extends WebDriverTestBase {

    PropertyManager propertyManager = new PropertyManager();

    @Override
    public WebDriver getdriver() {
        return driver;
    }

    @Override
    public void setupBrowser(String OS, String browser, String URL) {
        if (OS.equalsIgnoreCase("mac")) {
            if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", propertyManager.getResourceBundle.getProperty("IE_DRIVER_PATH_MAC"));
                driver = new InternetExplorerDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                System.setProperty("webdriver.gecko.driver",
                        propertyManager.getResourceBundle.getProperty("GECKO_DRIVER_PATH_MAC"));
                driver = new FirefoxDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH_MAC"));
                driver = new ChromeDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                System.setProperty("phantomjs.binary.path",
                        propertyManager.getResourceBundle.getProperty("PHANTOMJS_DRIVER_PATH_MAC"));
                driver = new PhantomJSDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                openURL(URL);
            }
        } else if (OS.equalsIgnoreCase("win") || OS.equalsIgnoreCase("window")) {
            if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", propertyManager.getResourceBundle.getProperty("IE_DRIVER_PATH_WIN"));
                driver = new InternetExplorerDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                System.setProperty("webdriver.gecko.driver",
                        propertyManager.getResourceBundle.getProperty("GECKO_DRIVER_PATH_WIN"));
                driver = new FirefoxDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH_WIN"));
                //DesiredCapabilities caps = new DesiredCapabilities();
                //caps.setCapability("resolution", "1600x900");
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("headless");
                //options.addArguments("window-size=1920x1080");
                //options.addArguments("window-size=1936x1056");
                //options.addArguments("window-size=1600x900");
                //options.addArguments("--incognito");
                driver = new ChromeDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless_chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH_WIN"));
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
                driver = new ChromeDriver(options);
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                System.setProperty("phantomjs.binary.path",
                        propertyManager.getResourceBundle.getProperty("PHANTOMJS_DRIVER_PATH_WIN"));
                driver = new PhantomJSDriver();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver",
                        propertyManager.getResourceBundle.getProperty("EDGE_DRIVER_PATH_WIN"));
                driver = new EdgeDriver();
                openURL(URL);
            }
        }
        Reporter.log(browser + " launched successfully");
        Reporter.log(URL + " passed to browser");
    }

    @Override
    public void openURL(String AUT_URL) {
        driver.get(AUT_URL);
        System.out.println(driver.manage().window().getSize());
        //Dimension d = new Dimension(1600,900);
        //driver.manage().window().setSize(d);
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
        Utils.pause(2000,"wait for page to load and stable");
        //refreshPage();
        Reporter.log(AUT_URL + " has been opened in browser successfully");
    }

    @Override
    public void teardownTest() {
        refreshPage();
        shutdownBrowser();
        generateTestReport();
    }

    @Override
    public void shutdownBrowser() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.equals("internet explorer")) {
            System.out.println("adding logout steps for the next test execution");
            logout();
        }
        clearCache();
        closeBrowser();
    }

    @Override
    public void refreshPage() {
        Reporter.log("On Request: Refreshing Page...");
        driver.navigate().refresh();
        Reporter.log("Refreshed page " + driver.getTitle() + " successfully");
    }

    @Override
    public void logout() {
        try{
            Reporter.log("logging out from the browser...");
            driver.findElement(By.xpath("//div[@class='col-auto align-self-center pr-4 pr-lg-0 mr-3 mr-sm-4 mr-lg-0']")).click();
            waitForElementVisibleXpath(20,"//div[@class='bg-white box-shadow-type-1 top-strip position-relative']//li[2]");
            driver.findElement(By.xpath("//div[@class='bg-white box-shadow-type-1 top-strip position-relative']//li[2]")).click();
            waitForElementVisibleXpath(20,"//button[@class='font-16 font-weight-bold btn-1 btn-lg d-flex px-lg-4']");
            driver.findElement(By.xpath("//button[@class='font-16 font-weight-bold btn-1 btn-lg d-flex px-lg-4']")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void clearCache() {
        Reporter.log("Clearing browser cache...");
        driver.manage().deleteAllCookies();
    }

    @Override
    public void closeBrowser() {
        driver.quit();
        Reporter.log("On Request: Closed all browser instances successfully");
    }

    @Override
    public void generateTestReport() {
        Reporter.log("Opening Test Reports in browser...");
        System.out.println("report location::" + propertyManager.getResourceBundle.getProperty("REPORT_LOCATION"));
        setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("CHROME_BROWSER"),
                propertyManager.getResourceBundle.getProperty("REPORT_LOCATION"));
        Reporter.log("Opened ReportNG based Test Report " + propertyManager.getResourceBundle.getProperty("REPORT_LOCATION") + " in browser successfully");
    }

    @Override
    public void openCurrentBrowserInstance() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
    }

    @Override
    public void openNewBrowserTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    @Override
    public void pause(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pause(long timeout, String message) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @Override
    public void fluentWait(long timeout) {
        new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }

    @Override
    public void waitForPageLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    @Override
    public void waitForElementVisible(long timeout, WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementVisibleXpath(long timeout, String xpath) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    @Override
    public void waitForElementVisibleCSS(long timeout, String cssSelector) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    @Override
    public void waitForElementDisappear(long timeout, WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
    }

    @Override
    public void waitForElementDisappearByXpath(long timeout, String xPath) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }

    @Override
    public void waitForElementToBeClickable(long timeout, WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public boolean waitForElementToBeClickableReturn(long timeout, WebElement element) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public void waitForElementToBeClickableByLocator(long timeout, String element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    @Override
    public void waitForElementToBeClickableByCSSLocator(long timeout, String element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
    }

    @Override
    public void waitForPageExpire(long timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    @Override
    public void setAsyncScriptTimeout(long timeout) {
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    @Override
    public void waitForTextToBePresentInElement(long timeout, WebElement element, String text) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    @Override
    public void waitForAlertPresent(long timeout, WebElement element) {

    }

    @Override
    public void waitForPageTitle(long timeout, String pageTitle) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.titleIs(pageTitle));
    }

    @Override
    public void frameToBeAvailableAndSwitch(long timeout, String frameID) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameID)));
    }

    @Override
    public void captureScreenshot(String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotSrc = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotSrc,
                    new File(propertyManager.getResourceBundle.getProperty("SCREENSHOT_LOCATION") + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifyTrue(Boolean Condition, String SuccessMessage, String FailureMessage) {
        if (Condition) {
            Reporter.log(SuccessMessage, true);
            return true;
        } else {
            Assert.fail(FailureMessage);
            Reporter.log(FailureMessage, false);
            return false;
        }
    }

    @Override
    public boolean verifyFalse(Boolean Condition, String SuccessMessage, String FailureMessage) {
        if (!Condition) {
            Reporter.log(SuccessMessage, true);
            return true;
        } else {
            Reporter.log(FailureMessage, false);
            return false;
        }
    }

    @Override
    public void assertTrue(boolean condition, String successMessage, String failureMessage) {
        if (condition) {
            Reporter.log(successMessage, true);
        } else {
            Reporter.log(failureMessage, false);
            throw new AssertionError("Assertion Error");
        }
    }

    @Override
    public void assertFalse(boolean condition, String successMessage, String failureMessage) {
        if (condition) {
            Reporter.log(successMessage, true);
        } else {
            Reporter.log(failureMessage, false);
            throw new AssertionError("Assertion Error");
        }
    }


    @Override
    public boolean verifyElementPresence(String xpath) {
        if (driver.findElements(By.xpath(xpath)).size() != 0) {
            Reporter.log(xpath + ":: Element is Present", true);
            Assert.assertTrue(true, "Element is Present");
            return true;
        } else {
            Reporter.log(xpath + ":: Element is Absent", true);
            Assert.fail("Element is Absent");
            return false;
        }
    }

    @Override
    public void moveCursorToElement(long timeout, WebElement superMenu, WebElement subMenu, WebElement wprkAround) {
        Actions builder = new Actions(driver);
        builder.moveToElement(superMenu).build().perform();
        pause(2000);
        subMenu.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(wprkAround).build().perform();
    }

    @Override
    public void mouseHoverElement(long timeout, WebElement superMenu) {
        Actions builder = new Actions(driver);
        builder.moveToElement(superMenu).build().perform();
        pause(timeout);
    }

    @Override
    public void verifyElementPresence(String messageElement, String expectedErrorMessage, String field_name, String language_name) {
        String actualErrorMessage = driver.findElement(By.xpath(messageElement)).getText();
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            Gauge.writeMessage(field_name + " :: " + language_name + " :: " + "Element Verified Successfully.");
        } else {
            Gauge.writeMessage(field_name + " :: " + language_name + " :: " + "Element Not Verified Successfully.");
        }
        Gauge.captureScreenshot();
    }

    @Override
    public void scrollPage(int scrollData) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + scrollData + ")");
    }

    @Override
    public void scrollDownPageToElement(int timeout, WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        scrollPage(-timeout);
        Utils.pause(timeout);
    }
}