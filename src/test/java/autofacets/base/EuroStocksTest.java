package autofacets.base;

import autofacets.utils.PropertyManager;
import autofacets.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * @author niravpatel
 */

public class EuroStocksTest {
    PropertyManager propertyManager = new PropertyManager();
    TestBase base = new TestBase();


    protected void quickSetupForLaunchBrowser(TestBase testBase, String browser) {
        if (browser.contains("Chrome")) {
            testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("CHROME_BROWSER"),
                    propertyManager.getResourceBundle.getProperty("Launch_URL"));
        } else if (browser.contains("Firefox")) {
            testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("FF_BROWSER"),
                    propertyManager.getResourceBundle.getProperty("Launch_URL"));
        } else if (browser.contains("IE")) {
            testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("IE_BROWSER"),
                    propertyManager.getResourceBundle.getProperty("Launch_URL"));
        }
    }

    protected void quickSetupForLaunchBrowser(TestBase testBase, String browser, String site) {
        if(site.contains("dealer")){
            if (browser.contains("Chrome")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("CHROME_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Dealer_Launch_URL"));
            } else if (browser.contains("Firefox")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("FF_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Dealer_Launch_URL"));
            } else if (browser.contains("IE")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("IE_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Dealer_Launch_URL"));
            }
        }else if(site.contains("backend")){
            if (browser.contains("Chrome")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("CHROME_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Backend_Launch_URL"));
            } else if (browser.contains("Firefox")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("FF_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Backend_Launch_URL"));
            } else if (browser.contains("IE")) {
                testBase.setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("IE_BROWSER"),
                        propertyManager.getResourceBundle.getProperty("Backend_Launch_URL"));
            }
        }
    }

    public void sendTextMethod(String xpathOption, String value){
        base.getdriver().findElement(By.xpath(xpathOption)).sendKeys(value);
        Utils.pause(200, "wait for element load on the page");
        base.getdriver().findElement(By.xpath(""+xpathOption+"")).click();
        base.getdriver().findElement(By.xpath(""+xpathOption+"")).sendKeys(Keys.TAB);
    }

    public void add_Photos(String path) throws AWTException {
        StringSelection stringSelection = new StringSelection(path);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void add_PhotosVehicle(String path) throws AWTException {
        StringSelection stringSelection = new StringSelection(path);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Utils.pause(2000, "wait for element load on the page");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}