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

public class EuroStocksAddProduct_Steplmpl extends EuroStocksTest implements WebLocators.AddProducts, WebLocators.Homepage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Add product/ vehicle/ tyres to the shopping cart <products>")
    public void addProduct(String products) {
        testBase.waitForElementVisibleXpath(waitTime, dropdown_btn);
        testBase.verifyElementPresence(dropdown_btn);
        testBase.getdriver().findElement(By.xpath(dropdown_btn)).click();
        Utils.pause(2000,"wait to load element on the page");
        String products_xpath = "//option[contains(text(),'" + products + "')]";
        testBase.waitForElementVisibleXpath(waitTime, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        testBase.getdriver().findElement(By.xpath(search_btn)).click();
        testBase.waitForElementVisibleXpath(50, buy_btn);
        testBase.getdriver().findElement(By.xpath(buy_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, order_btn);
        testBase.getdriver().findElement(By.xpath(order_btn)).click();
    }


    @Step("Add product/ vehicle/ tyres to the shopping cart <Auto onderdelen> with change sorting option <Titel volgorde (z-a)>")
    public void implementation1(String products, String option) {
        testBase.waitForElementVisibleXpath(waitTime, dropdown_btn);
        testBase.verifyElementPresence(dropdown_btn);
        testBase.getdriver().findElement(By.xpath(dropdown_btn)).click();
        Utils.pause(2000,"wait to load element on the page");
        String products_xpath = "//option[contains(text(),'" + products + "')]";
        testBase.waitForElementVisibleXpath(waitTime, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        testBase.getdriver().findElement(By.xpath(search_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, sorting_options);
        testBase.verifyElementPresence(sorting_options);
        testBase.getdriver().findElement(By.xpath(sorting_options)).click();
        Utils.pause(1000,"wait to load element on the page");
        String options_xpath = "//option[contains(text(),'" + option + "')]";
        testBase.waitForElementVisibleXpath(waitTime, options_xpath);
        testBase.getdriver().findElement(By.xpath(options_xpath)).click();
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(50, buy_btn);
        testBase.getdriver().findElement(By.xpath(buy_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, order_btn);
        testBase.getdriver().findElement(By.xpath(order_btn)).click();
    }


    @Step("Verify Shopping cart page and click on proceed to checkout")
    public void verifyShoppingPageandCheckOut() {
        testBase.waitForElementVisibleXpath(waitTime, shoppingPage_lbl);
        testBase.verifyElementPresence(shoppingPage_lbl);
        testBase.waitForElementVisibleXpath(waitTime, checkout_btn);
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, totalAmount_lbl);
        testBase.getdriver().findElement(By.xpath(checkout_btn)).click();
    }


    @Step("Verify Shopping cart page and click on proceed to checkout for dealer website")
    public void verifyShoppingPageandCheckOutDealer() {
        testBase.getdriver().findElement(By.xpath("//img[@alt='Winkelwagen']")).click();
        testBase.waitForElementVisibleXpath(waitTime, orderDealer_btn);
        testBase.getdriver().findElement(By.xpath(orderDealer_btn)).click();
        Utils.pause(1000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, shoppingPageDealer_lbl);
        testBase.verifyElementPresence(shoppingPageDealer_lbl);
        testBase.waitForElementVisibleXpath(waitTime, checkout_btn);
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, totalAmount_lbl);
        testBase.getdriver().findElement(By.xpath(checkout_btn)).click();
        Gauge.captureScreenshot();
    }


    @Step("Verify Page and Fill the information about the user <firstname><middlename><lastname><address><postalcode><housernumber><extnumber><street><city><email><pnumber><licenceplate>")
    public void fillInformation(String firstname, String middlename, String lastname, String address, String postalcode, String housenumber, String extnumber, String street, String city, String email, String pnumber, String licenceplate) {
        testBase.waitForElementVisibleXpath(waitTime, data_lbl);
        testBase.verifyElementPresence(data_lbl);
        testBase.getdriver().findElement(By.xpath(firstname_txt)).sendKeys(firstname);
        testBase.getdriver().findElement(By.xpath(middlename_txt)).sendKeys(middlename);
        testBase.getdriver().findElement(By.xpath(lastname_txt)).sendKeys(lastname);
        //testBase.getdriver().findElement(By.xpath(address_txt)).sendKeys(address);
        testBase.getdriver().findElement(By.xpath(postalcode_txt)).sendKeys(postalcode);
        testBase.getdriver().findElement(By.xpath(housenumber_txt)).sendKeys(housenumber);
        if(extnumber.equalsIgnoreCase("06")){
            testBase.getdriver().findElement(By.xpath(houseextDealer_txt)).sendKeys(extnumber);
        }else{
            testBase.getdriver().findElement(By.xpath(houseext_txt)).sendKeys(extnumber);
        }
        testBase.getdriver().findElement(By.xpath(email_txt)).sendKeys(email);
        testBase.getdriver().findElement(By.xpath(phonenumber_txt)).sendKeys(pnumber);
        testBase.getdriver().findElement(By.xpath(licenceplate_txt)).sendKeys(licenceplate);
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, idel_btn);
        testBase.getdriver().findElement(By.xpath(idel_btn)).click();
        testBase.waitForElementToBeClickableByLocator(waitTime, further_btn);
        Utils.pause(2000,"wait to load element on the page");
        //testBase.getdriver().findElement(By.xpath(further_btn)).click();
        testBase.getdriver().findElement(By.xpath(street_txt)).sendKeys(street);
        testBase.getdriver().findElement(By.xpath(city_txt)).sendKeys(city);
        testBase.getdriver().findElement(By.xpath(further_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify overview page and click on order")
    public void verifyOverviewPage() {
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, overview_lbl);
        testBase.verifyElementPresence(overview_lbl);
        testBase.waitForElementToBeClickableByLocator(waitTime, finalorder_btn);
        Utils.pause(2000,"wait to load element on the page");
        testBase.getdriver().findElement(By.xpath(finalorder_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("Navigate to the checkout page and select status for your payment <mode>")
    public void checkoutPageandSelectPayment(String mode) {
        if (mode.equalsIgnoreCase("Open")) {
            testBase.waitForElementVisibleXpath(waitTime, open_btn);
            testBase.verifyElementPresence(open_btn);
            testBase.getdriver().findElement(By.xpath(open_btn)).click();
        } else if (mode.equalsIgnoreCase("Paid")) {
            testBase.waitForElementVisibleXpath(waitTime, paid_btn);
            testBase.verifyElementPresence(paid_btn);
            testBase.getdriver().findElement(By.xpath(paid_btn)).click();
        } else if (mode.equalsIgnoreCase("Failed")) {
            testBase.waitForElementVisibleXpath(waitTime, failed_btn);
            testBase.verifyElementPresence(failed_btn);
            testBase.getdriver().findElement(By.xpath(failed_btn)).click();
        } else if (mode.equalsIgnoreCase("Canceled")) {
            testBase.waitForElementVisibleXpath(waitTime, canceled_btn);
            testBase.verifyElementPresence(canceled_btn);
            testBase.getdriver().findElement(By.xpath(canceled_btn)).click();
        } else if (mode.equalsIgnoreCase("Expired")) {
            testBase.waitForElementVisibleXpath(waitTime, expired_btn);
            testBase.verifyElementPresence(expired_btn);
            testBase.getdriver().findElement(By.xpath(expired_btn)).click();
        }
        testBase.waitForElementToBeClickableByLocator(waitTime, continue_btn);
        testBase.getdriver().findElement(By.xpath(continue_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify order confirmation of payment method <Open> and continue shopping")
    public void verifyOrderStatusandShopping(String mode) {
        if (mode.equalsIgnoreCase("Open")) {
            testBase.waitForElementVisibleXpath(waitTime, confirmorder_lbl);
            testBase.waitForElementVisibleXpath(waitTime, openorderVerification_lbl);
            testBase.verifyElementPresence(confirmorder_lbl);
            testBase.verifyElementPresence(openorderVerification_lbl);
            commanCode();
        } else if (mode.equalsIgnoreCase("Paid")) {
            testBase.waitForElementVisibleXpath(waitTime, confirmorder_lbl);
            testBase.waitForElementVisibleXpath(waitTime, confirmorderVerification_lbl);
            testBase.verifyElementPresence(confirmorder_lbl);
            testBase.verifyElementPresence(confirmorderVerification_lbl);
            commanCode();
        } else if (mode.equalsIgnoreCase("Failed")) {
            testBase.waitForElementVisibleXpath(waitTime, failedorder_lbl);
            testBase.waitForElementVisibleXpath(waitTime, failedorderVerification_lbl);
            testBase.verifyElementPresence(failedorder_lbl);
            testBase.verifyElementPresence(failedorderVerification_lbl);
            commanCode();
        } else if (mode.equalsIgnoreCase("Canceled")) {
            testBase.waitForElementVisibleXpath(waitTime, caneclorder_lbl);
            testBase.waitForElementVisibleXpath(waitTime, cancelorderVerification_lbl);
            testBase.verifyElementPresence(caneclorder_lbl);
            testBase.verifyElementPresence(cancelorderVerification_lbl);
            commanCode();
        } else if (mode.equalsIgnoreCase("Expired")) {
            try{
                testBase.waitForElementVisibleXpath(waitTime, expiredorder_lbl);
                testBase.waitForElementVisibleXpath(waitTime, expiredorderVerification_lbl);
                testBase.verifyElementPresence(expiredorder_lbl);
                testBase.verifyElementPresence(expiredorderVerification_lbl);
                Gauge.captureScreenshot();
            }catch (Exception e){
                testBase.waitForElementVisibleXpath(waitTime, expiredorderFinal_lbl);
                testBase.waitForElementVisibleXpath(waitTime, expiredorderVerificationFinal_lbl);
                testBase.verifyElementPresence(expiredorderFinal_lbl);
                testBase.verifyElementPresence(expiredorderVerificationFinal_lbl);
                Gauge.captureScreenshot();
                commanCode();
            }
        }
    }

    private void commanCode() {
        testBase.waitForElementToBeClickableByLocator(waitTime, conshopping_btn);
        Gauge.captureScreenshot();
        Utils.pause(2000,"wait to load element on the page");
        testBase.getdriver().findElement(By.xpath(conshopping_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, mainSearch_fld);
        Utils.pause(2000,"wait to load element on the page");
        testBase.verifyElementPresence(mainSearch_fld);
        Gauge.captureScreenshot();
    }
}