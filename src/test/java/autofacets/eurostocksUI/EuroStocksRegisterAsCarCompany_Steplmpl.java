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

public class EuroStocksRegisterAsCarCompany_Steplmpl extends EuroStocksTest implements WebLocators.Homepage, WebLocators.RegisterAsCarCompany, WebLocators.AddProducts {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("Click on link for Register as Car Company")
    public void clickOnLinkForRegister() {
        testBase.waitForElementVisibleXpath(waitTime, registerascarcompany_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, registerascarcompany_link_nl);
        testBase.getdriver().findElement(By.xpath(registerascarcompany_link_nl)).click();
    }

    @Step("Verify Page and Fill the information about the Register as Car Company <companyname><website><firstname><middlename><lastname><pnumber><email>")
    public void registerAsCarCompany(String companyname, String website, String firstname, String middlename, String lastname, String pnumber, String email) {
        testBase.waitForElementVisibleXpath(waitTime, verify_lbl_nl);
        testBase.waitForElementVisibleXpath(waitTime, adverteren_lbl_nl);
        testBase.verifyElementPresence(verify_lbl_nl);
        testBase.verifyElementPresence(adverteren_lbl_nl);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(companyname_txt)).sendKeys(companyname);
        testBase.getdriver().findElement(By.xpath(companyWebsite_txt)).sendKeys(website);
        testBase.getdriver().findElement(By.xpath(firstname_txt)).sendKeys(firstname);
        testBase.getdriver().findElement(By.xpath(middlename_txt)).sendKeys(middlename);
        testBase.getdriver().findElement(By.xpath(lastname_txt)).sendKeys(lastname);
        testBase.getdriver().findElement(By.xpath(regphonenumber_txt)).sendKeys(pnumber);
        testBase.getdriver().findElement(By.xpath(emailCarCompany_txt)).sendKeys(email);
        testBase.getdriver().findElement(By.xpath(contact_btn)).click();
        Gauge.captureScreenshot();
        testBase.waitForElementVisibleXpath(waitTime,successAlert_msg);
        testBase.verifyElementPresence(successAlert_msg);
        Gauge.captureScreenshot();
    }

    @Step("Check verification email received <URL> for register as car company")
    public void verifyEmail(String url){
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().navigate().to(url);
        testBase.waitForElementVisibleXpath(waitTime,contactEmailReg_lbl);
        testBase.verifyElementPresence(contactEmailReg_lbl);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(contactEmailReg_lbl)).click();
        Utils.pause(1000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(deleteEmailReg_btn)).click();
    }

    @Step("Verify validation message for required field on Register as Car Company Page")
    public void validationMessageVerificationRegisterAsCarCompanyPage() {
        testBase.waitForElementVisibleXpath(waitTime, submit_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, submit_btn_nl);
        testBase.getdriver().findElement(By.xpath(submit_btn_nl)).click();
        testBase.verifyElementPresence(companyname_msg_nl);
        testBase.verifyElementPresence(firstnamereg_msg_nl);
        testBase.verifyElementPresence(lastnamereg_msg_nl);
        testBase.verifyElementPresence(pnumberreg_msg_nl);
        testBase.verifyElementPresence(emailreg_msg_nl);
        Gauge.captureScreenshot();
    }
}