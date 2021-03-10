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

public class EuroStocksGeneralContactFunctionality_Steplmpl extends EuroStocksTest implements WebLocators.Homepage, WebLocators.ContactPage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("Click on Contact link from Dashboard page")
    public void clickOnContactLink() {
        testBase.waitForElementVisibleXpath(waitTime, contact_link_nl);
        testBase.scrollDownPageToElement(10, testBase.getdriver().findElement(By.xpath(contact_link_nl)));
        testBase.getdriver().findElement(By.xpath(contact_link_nl)).click();
    }

    @Step("Click on Contact link from Dashboard page for dealer website")
    public void clickOnContactLinkDealer() {
        testBase.waitForElementVisibleXpath(waitTime, contactDealer_link_nl);
        testBase.scrollDownPageToElement(10, testBase.getdriver().findElement(By.xpath(contactDealer_link_nl)));
        testBase.getdriver().findElement(By.xpath(contactDealer_link_nl)).click();
    }

    @Step("Verifying Contact Page")
    public void verifyingPage() {
        testBase.waitForElementVisibleXpath(waitTime, contactpage_lbl_nl);
        testBase.verifyElementPresence(contactpage_lbl_nl);
        testBase.waitForElementVisibleXpath(waitTime, addressTitle_lbl_nl);
        testBase.verifyElementPresence(addressTitle_lbl_nl);
        testBase.waitForElementVisibleXpath(waitTime, address_lbl_nl);
        testBase.verifyElementPresence(address_lbl_nl);
        Gauge.captureScreenshot();
    }

    @Step("Verifying Contact Page for dealer website")
    public void verifyingPageDealer() {
        testBase.waitForElementVisibleXpath(waitTime, contactpage_lbl_nl);
        testBase.verifyElementPresence(contactpage_lbl_nl);
        testBase.waitForElementVisibleXpath(waitTime, addressTitleDealer_lbl_nl);
        testBase.verifyElementPresence(addressTitleDealer_lbl_nl);
        testBase.waitForElementVisibleXpath(waitTime, addressDealer_lbl_nl);
        testBase.verifyElementPresence(addressDealer_lbl_nl);
        Gauge.captureScreenshot();
    }

    @Step("Verify validation message for required field on Contact Page")
    public void validationMessageVerification() {
        Utils.pause(2000, "wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, contactus_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, contactus_btn_nl);
        testBase.getdriver().findElement(By.xpath(contactus_btn_nl)).click();
        testBase.verifyElementPresence(name_msg_nl);
        testBase.verifyElementPresence(email_msg_nl);
        testBase.verifyElementPresence(question_msg_nl);
        Gauge.captureScreenshot();
    }


    @Step("Add required field and request for inquiry and verify alert message <name>, <email>, <number> and <message>")
    public void addRequiredFieldAndVerifySuccessAlert(String name, String email, String number, String message) {
        testBase.waitForElementVisibleXpath(waitTime, contactus_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, contactus_btn_nl);
        testBase.getdriver().findElement(By.xpath(name_input)).sendKeys(name);
        testBase.getdriver().findElement(By.xpath(email_input)).sendKeys(email);
        testBase.getdriver().findElement(By.xpath(phoneNumber_input)).sendKeys(number);
        testBase.getdriver().findElement(By.xpath(message_input)).sendKeys(message);
        testBase.getdriver().findElement(By.xpath(contactus_btn_nl)).click();
        Gauge.captureScreenshot();
        testBase.waitForElementVisibleXpath(waitTime,successAlert_lbl);
        testBase.verifyElementPresence(successAlert_lbl);
        Gauge.captureScreenshot();
    }


    @Step("Check verification email received <URL>")
    public void verifyEmail(String url){
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().navigate().to(url);
        testBase.waitForElementVisibleXpath(waitTime,contactEmail_lbl);
        testBase.verifyElementPresence(contactEmail_lbl);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(contactEmail_lbl)).click();
        Utils.pause(1000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(deleteEmail_btn)).click();
    }
}