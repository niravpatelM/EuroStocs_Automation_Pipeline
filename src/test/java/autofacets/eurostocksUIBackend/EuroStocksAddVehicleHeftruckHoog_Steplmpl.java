package autofacets.eurostocksUIBackend;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import java.awt.*;


/**
 * @author niravpatel
 */

public class EuroStocksAddVehicleHeftruckHoog_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("For Heftruck hoog Select condition of vehicle <Nieuw>, <Auto van werknemer>, <22>, <01-01-1991>, <2>")
    public void additionDataForVehicleForHeftruckHoog(String condition, String subCategory, String mileage, String DORegistration, String consYear) {
        commanCall(condition, subCategory, mileage, DORegistration, consYear);
        Gauge.captureScreenshot();
    }

    void commanCall(String condition, String subCategory, String mileage, String DORegistration, String consYear) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(condition_dropdown)));
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(condition_dropdown)).click();
        String cond_xpath = "//div[contains(text(),'" + condition + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(cond_xpath)).click();
        Utils.pause(500, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(subcategory_dropdown)).click();
        String subCategory_xpath = "//div[contains(text(),'" + subCategory + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(subCategory_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(runningHours_input)).sendKeys("8");

    }

    @Step("For Heftruck hoog Select Transmission <Automatische transmissie>, <2200>, <Aardgas>, <>, <>, <>, <>, <>")
    public void addVehicleDataForHeftruckHoog(String transmission, String buildFor, String fuel, String available, String machineHeight, String liftingCapacity, String liftHeight, String mobileDe) {
        testBase.scrollPage(300);
        commanCall(transmission, buildFor, fuel);
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String available_xpath = "(//div[contains(text(),'"+available+"')])";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(available_xpath)).click();
        testBase.getdriver().findElement(By.xpath(machineHeight_input)).sendKeys(machineHeight);
        testBase.getdriver().findElement(By.xpath(liftingCapactiy_input)).sendKeys(liftingCapacity);
        testBase.getdriver().findElement(By.xpath(liftHeight_input)).sendKeys(liftHeight);
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(mobileDe);
        testBase.getdriver().findElement(By.xpath(savenext_btn)).click();
        Gauge.captureScreenshot();

    }

    void commanCall(String transmission, String buildFor, String fuel) {
        testBase.getdriver().findElement(By.xpath(transmission_dropdown)).click();
        String transmission_xpath = "//div[contains(text(),'" + transmission + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(transmission_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(fuel_dropdown)).click();
        String fuel_xpath = "//div[contains(text(),'" + fuel + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(fuel_xpath)).click();
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String optionOne_xpath = "//div[contains(text(),'" + buildFor + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(optionOne_xpath)).click();
    }

    @Step("For Heftruck hoog Add Extensive data while adding vehicle <22pvps>, <>, <>")
    public void addExtensiveVehicleDataForHeftruckHoog(String licencePlate, String internalNumber, String chassisNumber) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.verifyElementPresence(license_plate_lbl);
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(licencePlate);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(internalNumber);
        testBase.getdriver().findElement(By.xpath(cabin_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisNumber);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Heftruck hoog Adding more data for vehicle interior with all the option")
    public void addingExteriorDataForHeftruckHoog() throws AWTException {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, powerSteering_lbl);
        testBase.verifyElementPresence(powerSteering_lbl);
        testBase.getdriver().findElement(By.xpath(powerSteering_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(image_btn)).click();
        Utils.pause(1000, "wait for element load on the page");
        add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
        Utils.pause(3000, "wait for element load on the page");
        Gauge.captureScreenshot();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Heftruck hoog Adding more data for vehicle Exterieur with all the option checked <Ja>, <Afneembare trekhaak>")
    public void addingExteriorDataForHeftruckHoog(String checked, String towbar) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, towar_lbl);
            testBase.verifyElementPresence(towar_lbl);
            testBase.getdriver().findElement(By.xpath(towbar_dropdown)).click();
            String towbar_xpath = "//div[contains(text(),'" + towbar + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(towbar_xpath)).click();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Heftruck hoog Adding more data for vehicle Safety with all the option")
    public void addingSafetyDataForHeftruckHoog() {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, securityRoof_lbl);
        testBase.verifyElementPresence(securityRoof_lbl);
        testBase.getdriver().findElement(By.xpath(securityRoof_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }


}