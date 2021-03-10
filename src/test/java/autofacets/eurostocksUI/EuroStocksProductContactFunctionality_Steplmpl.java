package autofacets.eurostocksUI;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * @author niravpatel
 */

public class EuroStocksProductContactFunctionality_Steplmpl extends EuroStocksTest implements WebLocators.Homepage, WebLocators.ContactPage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;
    private String price,location;


    @Step("Search for the product and open contact details page <>")
    public void redirectToProductsListDealer(String options) {
        testBase.waitForElementVisibleXpath(waitTime, searchDealer_input);
        testBase.getdriver().findElement(By.xpath(searchDealer_input)).sendKeys(options);
        testBase.getdriver().findElement(By.xpath(searchDealer_input)).sendKeys(Keys.ENTER);
        String options_xpath = "//h5[normalize-space()='"+options+"']";
        testBase.waitForElementVisibleXpath(waitTime, options_xpath);
        testBase.verifyElementPresence(options_xpath);
        testBase.getdriver().findElement(By.xpath(options_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Click on Parts Menu and go to <Bobine> Options from the list")
    public void redirectToProductsList(String options) {
        testBase.waitForElementVisibleXpath(waitTime, parts_menu_nl);
        testBase.getdriver().findElement(By.xpath(parts_menu_nl)).click();
        String options_xpath = "//h4//a[contains(text(),'" + options + "')]";
        testBase.waitForElementVisibleXpath(waitTime, options_xpath);
        testBase.verifyElementPresence(options_xpath);
        testBase.getdriver().findElement(By.xpath(options_xpath)).click();
        testBase.getdriver().navigate().refresh();
        testBase.waitForPageLoad(waitTime);
        Gauge.captureScreenshot();
    }

    @Step("Click on <any> Product from the list")
    public void clickOnProduct(String products) {
        Utils.pause(3000,"wait to load element on the page");
        String products_xpath = "//h5[contains(text(),'" + products + "')]";
        testBase.waitForElementVisibleXpath(30, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Click on contact button from the details page")
    public void clickOnContactButton() {
        Utils.pause(1000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, contact_btn_nl);
        testBase.verifyElementPresence(contact_btn_nl);
        testBase.waitForElementToBeClickable(waitTime, testBase.getdriver().findElement(By.xpath(contact_btn_nl)));
        testBase.getdriver().findElement(By.xpath(contact_btn_nl)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verifying Contact Page for products")
    public void verifyingPage() {
        testBase.waitForElementVisibleXpath(waitTime, contactpage_lbl_nl);
        testBase.verifyElementPresence(contactpage_lbl_nl);
    }

    @Step("Verify validation message for required field on Contact Page for products")
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

    @Step("Click on <Bobines Toyota Prius> Product from the list and get Price and Details <url>")
    public void clickOnProductandGetPrice(String products, String urlContains) {
        Utils.pause(3000,"wait to load element on the page");
        String products_xpath = "//h5[contains(text(),'" + products + "')]";
        testBase.waitForElementVisibleXpath(30, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        price = testBase.getdriver().findElement(By.xpath("//a[contains(@href,'"+urlContains+"')]//following-sibling::div[@class='location-price']//following-sibling::span[@class='price']")).getText();
        location = testBase.getdriver().findElement(By.xpath("//a[contains(@href,'"+urlContains+"')]//following-sibling::div[@class='location-price']//following-sibling::span[@class='location ']")).getText();
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify product details with tile <title>")
    public void verifyingProductsDetails(String title) {
        String title_xpath = "//h1[contains(text(),'"+title+"')]";
        testBase.waitForElementVisibleXpath(waitTime,title_xpath);
        testBase.verifyElementPresence(title_xpath);
        String price_xpath = "//span[contains(text(),'"+price.substring(1)+"')]";
        //String location_xpath = "//h3[contains(text(),'"+location.replace("\n","").replace("\r", "")+"')]";
        testBase.verifyElementPresence(price_xpath);
        //testBase.verifyElementPresence(location_xpath);
        testBase.verifyElementPresence(contactApp_btn_nl);
        testBase.verifyElementPresence(contactCall_btn_nl);
        testBase.verifyElementPresence(addProduct_btn_nl);
        Gauge.captureScreenshot();
    }

    @Step("Verify product details with tile <title> for dealer website")
    public void verifyingProductsDetailsDealer(String title) {
        //String price = testBase.getdriver().findElement(By.xpath("//div[@class='location-price ng-star-inserted']//span")).getText();
        String title_xpath = "//h5[normalize-space()='"+title+"']";
        testBase.waitForElementVisibleXpath(waitTime,title_xpath);
        testBase.verifyElementPresence(title_xpath);
        testBase.getdriver().findElement(By.xpath(title_xpath)).click();
        Utils.pause(3000,"wait to load element on the page");
        String titleIn_xpath = "//h2[normalize-space()='"+title+"']";
        testBase.waitForElementVisibleXpath(waitTime,titleIn_xpath);
        testBase.verifyElementPresence(titleIn_xpath);
        /*String price_xpath = "//span[contains(text(),'"+price.substring(1)+"')]";
        testBase.verifyElementPresence(price_xpath);*/
        testBase.verifyElementPresence(contactApp_btn_nl);
        testBase.verifyElementPresence(contactCall_btn_nl);
        testBase.verifyElementPresence(contact_btn_nl);
        Gauge.captureScreenshot();
    }
}