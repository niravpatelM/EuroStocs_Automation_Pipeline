package autofacets.eurostocksUIBackend;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.awt.*;


/**
 * @author niravpatel
 */

public class EuroStocksAddVehicleHooimachine_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("For Hooimachine Select condition of vehicle <Nieuw>, <Auto van werknemer>, <22>, <01-01-1991>, <power>, <builtFor>, <available>, <mobileDe>")
    public void additionDataForVehicleForHooimachine(String condition, String subCategory, String runningHours, String consYear, String power, String builtFor, String available, String mobileDe) {
        commanCall(condition, subCategory, runningHours, consYear);
        testBase.getdriver().findElement(By.xpath(power_input)).sendKeys(power);
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String builtFor_xpath = "//div[contains(text(),'" + builtFor + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(builtFor_xpath)).click();
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String available_xpath = "//div[contains(text(),'" + available + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(available_xpath)).click();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)));
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(mobileDe);
        testBase.getdriver().findElement(By.xpath(savenext_btn)).click();
        Gauge.captureScreenshot();
    }

    void commanCall(String condition, String subCategory, String runningHours, String consYear) {
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
        testBase.getdriver().findElement(By.xpath(runningHours_input)).sendKeys(runningHours);
        testBase.getdriver().findElement(By.xpath(construction_year_input)).sendKeys(consYear);

    }



    @Step("For Hooimachine Add Extensive data while adding vehicle <22pvps>, <internalNumber>, <chassis>, <environment>, <motDate>")
    public void addExtensiveVehicleDataForHooimachine(String licencePlate, String internalNumber, String chassisNumber, String environmentSticker, String MOTDate) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.verifyElementPresence(license_plate_lbl);
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(licencePlate);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(internalNumber);
        testBase.getdriver().findElement(By.xpath(cabin_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(environmental_dropdown)).click();
        String environmentSticker_xpath = "//div[contains(text(),'" + environmentSticker + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(environmentSticker_xpath)).click();
        testBase.getdriver().findElement(By.xpath(MOT_date)).sendKeys(MOTDate+ Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(newMOT_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisNumber);
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(municipalGovernmentVehicle_chkbox)));
        testBase.getdriver().findElement(By.xpath(municipalGovernmentVehicle_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Hooimachine Adding more data for vehicle interior with all the option")
    public void addingInteriorDataForHooimachine() throws AWTException {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, airConditioning_label);
        testBase.verifyElementPresence(airConditioning_label);
        testBase.getdriver().findElement(By.xpath(cabinAC_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(powerSteering_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(parkingHeater2_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(image_btn)).click();
        Utils.pause(1000, "wait for element load on the page");
        add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
        Utils.pause(3000, "wait for element load on the page");
        Gauge.captureScreenshot();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Hooimachine Adding more data for vehicle Exterieur with all the option")
    public void addingExteriorDataForHooimachine() {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, frontHydraulics_lbl);
        testBase.verifyElementPresence(frontHydraulics_lbl);
        testBase.getdriver().findElement(By.xpath(frontHydraulics_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(frontLift_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Hooimachine Adding more data for vehicle Safety with all the option")
    public void addingSafetyDataForHooimachine() {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, ABS_lbl);
        testBase.verifyElementPresence(ABS_lbl);
        testBase.getdriver().findElement(By.xpath(abs_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fourWheelDrive_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }


}