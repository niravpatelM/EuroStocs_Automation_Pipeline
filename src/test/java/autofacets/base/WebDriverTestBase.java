package autofacets.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author niravpatel
 */

public abstract class WebDriverTestBase {

	protected static WebDriver driver;

    public abstract WebDriver getdriver();

    public abstract void setupBrowser(String OS, String browser, String URL);
    
    public abstract void clearCache();

    public abstract void logout();

    public abstract void shutdownBrowser();

    public abstract void closeBrowser();

    public abstract void openURL(String AUT_URL);

    public abstract void generateTestReport();

    public abstract void refreshPage();

    public abstract void teardownTest();

    public abstract void waitForElementToBeClickable(long timeout, WebElement element);

    public abstract boolean waitForElementToBeClickableReturn(long timeout, WebElement element);
    
    public abstract void waitForElementToBeClickableByLocator(long timeout, String element);
    
    public abstract void waitForElementToBeClickableByCSSLocator(long timeout, String element);

    public abstract void waitForElementDisappear(long timeout, WebElement element);
    
    public abstract void waitForElementDisappearByXpath(long timeout, String xPath);

    public abstract void waitForElementVisible(long timeout, WebElement element);
    
    public abstract void waitForElementVisibleXpath(long timeout, String xPath);
    
    public abstract void waitForElementVisibleCSS(long timeout, String cssSelector);

    public abstract void waitForPageLoad(long timeout);

    public abstract void fluentWait(long timeout);

    public abstract void implicitWait(long timeout);

    public abstract void pause(long timeout);
    
    public abstract void pause(long timeout, String message);

    public abstract void waitForPageExpire(long timeout);

    public abstract void waitForTextToBePresentInElement(long timeout, WebElement element, String text);

    public abstract void waitForAlertPresent(long timeout, WebElement element);

    public abstract void setAsyncScriptTimeout(long timeout);

    public abstract void openCurrentBrowserInstance();

    public abstract void openNewBrowserTab();

    public abstract void waitForPageTitle(long timeout, String pageTitle);

    public abstract void frameToBeAvailableAndSwitch(long timeout, String frameID);

    public abstract void captureScreenshot(String screenshotName);

    public abstract boolean verifyFalse(Boolean Condition, String SuccessMessage, String FailureMessage);

    public abstract boolean verifyTrue(Boolean Condition, String SuccessMessage, String FailureMessage);

    public abstract void assertFalse(boolean condition, String successMessage, String failureMessage);

    public abstract void assertTrue(boolean condition, String successMessage, String failureMessage);

    public abstract boolean verifyElementPresence(String xpath);
    
    public abstract void moveCursorToElement(long timeout, WebElement superMenu, WebElement subMenu, WebElement workAround);
    
    public abstract void mouseHoverElement(long timeout, WebElement superMenu);

    public abstract void verifyElementPresence(String messageElement, String expectedErrorMessage, String field_name, String language_name);

    public abstract void scrollPage(int scrollData);

    public abstract void scrollDownPageToElement(int time, WebElement webElement);

}