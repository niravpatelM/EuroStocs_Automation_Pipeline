package autofacets.eurostocksUI;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

/**
 * @author niravpatel
 */

public class EuroStocksVehicleContactFunctionality_Steplmpl extends EuroStocksTest implements WebLocators.Homepage, WebLocators.ContactPage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;
    private String title;


    @Step("Click on Vehicle Menu and go to <Bobine> Options from the list")
    public void redirectToProductsList(String options) {
        testBase.waitForElementVisibleXpath(waitTime, vehicles_menu_nl);
        testBase.getdriver().findElement(By.xpath(vehicles_menu_nl)).click();
        String options_xpath = "//h4//a[contains(text(),'" + options + "')]";
        testBase.waitForElementVisibleXpath(30, options_xpath);
        testBase.verifyElementPresence(options_xpath);
        testBase.getdriver().findElement(By.xpath(options_xpath)).click();
        //testBase.getdriver().navigate().refresh();
        //testBase.waitForPageLoad(waitTime);
        Gauge.captureScreenshot();
    }


    @Step("Click on Wheel Menu and go to <Bobine> Options from the list")
    public void wheel(String options) {
        testBase.waitForElementVisibleXpath(waitTime, wheel_menu_nl);
        testBase.getdriver().findElement(By.xpath(wheel_menu_nl)).click();
        String options_xpath = "//h4//a[contains(text(),'" + options + "')]";
        testBase.waitForElementVisibleXpath(30, options_xpath);
        testBase.verifyElementPresence(options_xpath);
        testBase.getdriver().findElement(By.xpath(options_xpath)).click();
        //testBase.getdriver().navigate().refresh();
        //testBase.waitForPageLoad(waitTime);
        Gauge.captureScreenshot();
    }

    @Step("Click on <any> Vehicle from the list")
    public void clickOnProduct(String products) {
        Utils.pause(5000,"wait to element load on the page");
        //testBase.waitForPageLoad(waitTime);
        //String products_xpath = "//h5[contains(text(),'" + products + "')]";
        String products_xpath = "(//h5[1])[1]";
        testBase.waitForElementVisibleXpath(30, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verifying Contact Page for vehicles")
    public void verifyingPage() {
        testBase.waitForElementVisibleXpath(waitTime, contactpage_lbl_nl);
        testBase.verifyElementPresence(contactpage_lbl_nl);
    }

    @Step("Verify validation message for required field on Contact Page for vehicles")
    public void validationMessageVerification() {
        testBase.waitForElementVisibleXpath(waitTime, contactus_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, contactus_btn_nl);
        testBase.scrollDownPageToElement(20, testBase.getdriver().findElement(By.xpath(contactus_btn_nl)));
        testBase.getdriver().findElement(By.xpath(contactus_btn_nl)).click();
        testBase.verifyElementPresence(name_msg_nl);
        testBase.verifyElementPresence(email_msg_nl);
        testBase.verifyElementPresence(question_msg_nl);
        Gauge.captureScreenshot();
    }

    @Step("Click on < MSC 50 Mobiele Compressor> Vehicle from the list and get title")
    public void clickOnProductandGetPrice(String products) {
        Utils.pause(5000,"wait to element load on the page");
        //String products_xpath = "//h5[contains(text(),'" + products + "')]";
        String products_xpath = "(//h5[1])[1]";
        testBase.waitForElementVisibleXpath(30, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        //price = testBase.getdriver().findElement(By.xpath("//a[contains(@href,'" + urlContains + "')]//following-sibling::div[@class='location-price']//following-sibling::span[@class='price']")).getText();
        //location = testBase.getdriver().findElement(By.xpath("//a[contains(@href,'" + urlContains + "')]//following-sibling::div[@class='location-price']//following-sibling::span[@class='location ']")).getText();
        title = testBase.getdriver().findElement(By.xpath(products_xpath)).getText();
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify vehicle details with title")
    public void verifyingVehiclesDetails() {
        String title_xpath = "//h1[normalize-space()='"+title+"']";
        testBase.waitForElementVisibleXpath(waitTime,title_xpath);
        testBase.verifyElementPresence(title_xpath);
        //String price_xpath = "//span[contains(text(),'"+price.substring(1)+"')]";
        //testBase.verifyElementPresence(price_xpath);
        //testBase.verifyElementPresence(contactApp_btn_nl);
        testBase.verifyElementPresence(contactCall_btn_nl);
        testBase.verifyElementPresence(contact_btn_nl);
        Gauge.captureScreenshot();
    }
}