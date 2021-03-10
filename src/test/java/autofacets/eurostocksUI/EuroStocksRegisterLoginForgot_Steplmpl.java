package autofacets.eurostocksUI;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.PropertyManager;
import autofacets.utils.Utils;
import com.github.javafaker.Faker;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

/**
 * @author niravpatel
 */

public class EuroStocksRegisterLoginForgot_Steplmpl extends EuroStocksTest implements WebLocators.Homepage, WebLocators.UserRegistrationPage, WebLocators.AddProducts {
    TestBase testBase = new TestBase();
    PropertyManager propertyManager = new PropertyManager();
    private String password = "" + propertyManager.getResourceBundle.getProperty("Password") + "";
    private String plainPassword = Utils.passwordEncryptDecrypt(password);
    final static long waitTime = 60;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    @Step("Click on link for Register User")
    public void clickOnLinkForRegisterUser() {
        testBase.waitForElementVisibleXpath(waitTime, registerUser_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, registerUser_link_nl);
        testBase.getdriver().findElement(By.xpath(registerUser_link_nl)).click();
        Gauge.captureScreenshot();
    }

    @Step("Click on link for Register User for dealer website")
    public void registerUserDealerWebsite() {
        Utils.pause(2000,"wait to load element on the page");
        testBase.waitForElementVisibleXpath(waitTime, navigation_menu);
        testBase.getdriver().findElement(By.xpath(navigation_menu)).click();
        testBase.waitForElementVisibleXpath(waitTime, user_icon);
        testBase.getdriver().findElement(By.xpath(user_icon)).click();
        testBase.waitForElementVisibleXpath(waitTime, register_option);
        testBase.waitForElementToBeClickableByLocator(waitTime, register_option);
        testBase.getdriver().findElement(By.xpath(register_option)).click();
        Gauge.captureScreenshot();
    }

    @Step("Click on link for Login User")
    public void clickOnLinkForLoginUser() {
        testBase.waitForElementVisibleXpath(waitTime, loginUser_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, loginUser_link_nl);
        testBase.getdriver().findElement(By.xpath(loginUser_link_nl)).click();
        Gauge.captureScreenshot();
    }


    @Step("Click on link for Login User for dealer website")
    public void clickOnLinkForLoginUserDealer() {
        Utils.pause(5000,"wait to element load on page");
        testBase.waitForElementVisibleXpath(waitTime, navigation_menu);
        testBase.getdriver().findElement(By.xpath(navigation_menu)).click();
        testBase.waitForElementVisibleXpath(waitTime, user_icon);
        testBase.getdriver().findElement(By.xpath(user_icon)).click();
        testBase.waitForElementVisibleXpath(waitTime, login_option);
        testBase.waitForElementToBeClickableByLocator(waitTime, login_option);
        testBase.getdriver().findElement(By.xpath(login_option)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify validation message for required field on Registration Page")
    public void validationMessageVerification() {
        testBase.waitForElementVisibleXpath(waitTime, registerasUser_btn_nl);
        testBase.scrollDownPageToElement(1000, testBase.getdriver().findElement(By.xpath(registerasUser_btn_nl)));
        testBase.waitForElementToBeClickableByLocator(waitTime, registerasUser_btn_nl);
        testBase.getdriver().findElement(By.xpath(registerasUser_btn_nl)).click();
        testBase.verifyElementPresence(firstname_msg_nl);
        testBase.verifyElementPresence(lastname_msg_nl);
        testBase.verifyElementPresence(postalcode_msg_nl);
        testBase.verifyElementPresence(housernumber_msg_nl);
        testBase.verifyElementPresence(street_msg_nl);
        testBase.verifyElementPresence(city_msg_nl);
        testBase.verifyElementPresence(pnumber_msg_nl);
        testBase.verifyElementPresence(email_msg_nl);
        testBase.verifyElementPresence(confirmemail_msg_nl);
        testBase.verifyElementPresence(password_msg_nl);
        testBase.verifyElementPresence(confirmpassword_msg_nl);
        //testBase.verifyElementPresence(captch_msg_nl);
        Gauge.captureScreenshot();
    }


    @Step("Fill Required data for register user <firstname><middlename><lastname><postalcode><housernumber><extnumber><street><city><pnumber><licenceplate>")
    public void fillInformation(String firstname, String middlename, String lastname, String postalcode, String housenumber, String extnumber, String street, String city, String pnumber, String licenceplate) {
        testBase.getdriver().findElement(By.xpath(firstname_txt)).sendKeys(firstname);
        testBase.getdriver().findElement(By.xpath(middlename_txt)).sendKeys(middlename);
        testBase.getdriver().findElement(By.xpath(lastname_txt)).sendKeys(lastname);
        testBase.getdriver().findElement(By.xpath(address_input)).sendKeys("Nederland");
        testBase.getdriver().findElement(By.xpath(postalcode_txt)).sendKeys(postalcode);
        testBase.getdriver().findElement(By.xpath(housenumber_txt)).sendKeys(housenumber);
        testBase.getdriver().findElement(By.xpath(houseext_input)).sendKeys(extnumber);
        testBase.getdriver().findElement(By.xpath(phonenumber_txt)).sendKeys(pnumber);
        testBase.getdriver().findElement(By.xpath(licenceplate_txt)).sendKeys(licenceplate);
        testBase.getdriver().findElement(By.xpath(email_input)).sendKeys(""+firstName+lastName+"@mailinator.com");
        testBase.getdriver().findElement(By.xpath(confirmEmail_input)).sendKeys(""+firstName+lastName+"@mailinator.com");
        testBase.getdriver().findElement(By.xpath(password_input)).sendKeys("EuroStocks@1234");
        testBase.getdriver().findElement(By.xpath(confrimPassword_input)).sendKeys("EuroStocks@1234");
        Utils.pause(2000,"wait to element load on the page");
        testBase.getdriver().findElement(By.xpath(street_txt)).sendKeys(street);
        testBase.getdriver().findElement(By.xpath(city_txt)).sendKeys(city);
        testBase.waitForElementVisibleXpath(waitTime, register_btn);
        testBase.getdriver().findElement(By.xpath(register_btn)).click();
        Gauge.captureScreenshot();
        testBase.waitForElementVisibleXpath(waitTime,successAlert_lbl);
        testBase.verifyElementPresence(successAlert_lbl);
        Gauge.captureScreenshot();
    }

    @Step("Check user register email received <URL>")
    public void verifyEmail(String url){
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().navigate().to(url+""+firstName+lastName+"#/#inboxpane");
        testBase.waitForElementVisibleXpath(waitTime,contactEmail_lbl);
        testBase.verifyElementPresence(contactEmail_lbl);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(contactEmail_lbl)).click();
        Utils.pause(1000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(deleteEmail_btn)).click();
    }


    @Step("Verify validation message for required field on Login Page")
    public void validationMessageVerificationLoginPage() {
        testBase.waitForElementVisibleXpath(waitTime, loginUser_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, loginUser_btn_nl);
        testBase.getdriver().findElement(By.xpath(loginUser_btn_nl)).click();
        testBase.verifyElementPresence(loginemail_msg_nl);
        testBase.verifyElementPresence(loginpassword_msg_nl);
        Gauge.captureScreenshot();
    }


    @Step("Click on link for Forgot Password Link")
    public void clickOnLinkForForfotPassword() {
        testBase.waitForElementVisibleXpath(waitTime, loginUser_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, loginUser_link_nl);
        testBase.getdriver().findElement(By.xpath(loginUser_link_nl)).click();
        testBase.waitForElementVisibleXpath(waitTime, forgotpassword_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, forgotpassword_link_nl);
        testBase.getdriver().findElement(By.xpath(forgotpassword_link_nl)).click();
        Gauge.captureScreenshot();
    }

    @Step("Click on link for Forgot Password Link for dealer website")
    public void clickOnLinkForForfotPasswordDealer() {
        testBase.waitForElementVisibleXpath(waitTime, forgotpassword_link_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, forgotpassword_link_nl);
        testBase.getdriver().findElement(By.xpath(forgotpassword_link_nl)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verify validation message for required field on Forgot Password Page")
    public void validationMessageVerificationForgotPasswordPage() {
        testBase.waitForElementVisibleXpath(waitTime, forgot_btn_nl);
        testBase.waitForElementToBeClickableByLocator(waitTime, forgot_btn_nl);
        testBase.getdriver().findElement(By.xpath(forgot_btn_nl)).click();
        testBase.verifyElementPresence(loginemailforgot_msg_nl);
        Gauge.captureScreenshot();
    }

    @Step("Enter valid username <eurostocksauto@mailinator.com> and password for user")
    public void enterUsernameAndPassword(String username) {
        testBase.waitForElementVisibleXpath(waitTime, email_input_nl);
        testBase.getdriver().findElement(By.xpath(email_input_nl)).sendKeys(username);
        System.out.println(plainPassword);
        testBase.getdriver().findElement(By.xpath(password_input_nl)).click();
        testBase.getdriver().findElement(By.xpath(password_input_nl)).clear();
        testBase.getdriver().findElement(By.xpath(password_input_nl)).click();
        testBase.getdriver().findElement(By.xpath(password_input_nl)).sendKeys(plainPassword);
        testBase.getdriver().findElement(By.xpath(loginUser_btn_nl)).click();
    }

    @Step("Verify User is redirect to the dashboard screen <loggedUser>")
    public void verifyDashboardScreen(String user) {
        String loggedUser_xpath= "//*[contains(text(),'"+user+"')]";
        testBase.waitForElementVisibleXpath(30, loggedUser_xpath);
        testBase.verifyElementPresence(loggedUser_xpath);
        Gauge.captureScreenshot();
    }

    @Step("Verify User is redirect to the dashboard screen <loggedUser> for dealer website")
    public void verifyDashboardScreenDealer(String user) {
        Utils.pause(2000,"wait to element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, navigation_menu);
        testBase.getdriver().findElement(By.xpath(navigation_menu)).click();
        testBase.waitForElementVisibleXpath(waitTime, user_icon);
        testBase.getdriver().findElement(By.xpath(user_icon)).click();
        String loggedUser_xpath= "//*[contains(text(),'"+user+"')]";
        testBase.waitForElementVisibleXpath(30, loggedUser_xpath);
        testBase.verifyElementPresence(loggedUser_xpath);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(close_icon)).click();
    }
}