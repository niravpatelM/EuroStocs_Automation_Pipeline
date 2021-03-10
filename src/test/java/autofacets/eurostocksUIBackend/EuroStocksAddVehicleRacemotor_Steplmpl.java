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

public class EuroStocksAddVehicleRacemotor_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("For Racemotor Select condition of vehicle <Nieuw>, <Auto van werknemer>, <Cardanaandrijving>, <mileage>, <firstReg>, <power>, <builtFor>, <available>, <mobileDe>")
    public void additionDataForVehicleForRacemotor(String condition, String subCategory, String typeOfDrive, String mileage, String firstReg, String power, String builtFor, String available, String mobileDe) {
        commanCall(condition, subCategory, typeOfDrive, mileage, firstReg);
    }

    void commanCall(String condition, String subCategory, String typeOfDrive, String mileage, String firstReg) {
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
        testBase.getdriver().findElement(By.xpath(typeOfDrive_dropdown)).click();
        String typeOfDrive_xpath = "//div[contains(text(),'" + typeOfDrive + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(typeOfDrive_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(mileage_input)).sendKeys(mileage);
        testBase.getdriver().findElement(By.xpath(first_reg_date)).sendKeys(firstReg+Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(construction_year_input)).sendKeys("6");

    }

    @Step("For Racemotor Select Transmission <Handgeschakeld>, <250>, <2200>, <Aardgas>, <power>, <>, <>, <>")
    public void addVehicleDataForRacemotor(String transmission, String cc, String buildFor, String fuel, String power, String available, String regDate, String mobileDe) {
        commanCall(transmission, cc, buildFor, fuel);
        testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(power_input)));
        testBase.getdriver().findElement(By.xpath(power_input)).sendKeys(power);
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String buildFor_xpath = "(//div[contains(text(),'"+buildFor+"')])[2]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(buildFor_xpath)).click();
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String available_xpath = "(//div[contains(text(),'"+available+"')])";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(available_xpath)).click();
        testBase.getdriver().findElement(By.xpath(reg_gen_input)).sendKeys(regDate+Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(mobileDe);
        testBase.getdriver().findElement(By.xpath(savenext_btn)).click();
        Gauge.captureScreenshot();

    }

    void commanCall(String transmission, String cc, String buildFor, String fuel) {
        testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(transmission_dropdown)));
        testBase.getdriver().findElement(By.xpath(transmission_dropdown)).click();
        String transmission_xpath = "//div[contains(text(),'" + transmission + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(transmission_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(CC_input)).sendKeys(cc);
        testBase.getdriver().findElement(By.xpath(fuel_dropdown)).click();
        String fuel_xpath = "//div[contains(text(),'" + fuel + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(fuel_xpath)).click();
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String optionOne_xpath = "//div[contains(text(),'" + buildFor + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(optionOne_xpath)).click();
    }

    @Step("For Racemotor Add Extensive data while adding vehicle <22pvps>, <internalNumber>, <color>, <manColor>, <ja>, <0>, <chassis>, <motDate>")
    public void addExtensiveVehicleDataForRacemotor(String licencePlate, String internalNumber, String color, String manColor, String damage,
                String previousOwner,String chassisNumber, String MOTDate) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.verifyElementPresence(license_plate_lbl);
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(licencePlate);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(internalNumber);
        testBase.getdriver().findElement(By.xpath(color_dropdown)).click();
        String color_xpath = "//div[contains(text(),'" + color + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(color_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(metalic_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fullServiceHistory_chkbox)).click();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(man_color_name_input)));
        testBase.getdriver().findElement(By.xpath(man_color_name_input)).sendKeys(manColor);
        testBase.getdriver().findElement(By.xpath(damage_dropdown)).click();
        String damage_xpath = "//div[contains(text(),'" + damage + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(damage_xpath)).click();
        testBase.getdriver().findElement(By.xpath(previousOwner_input)).sendKeys(previousOwner);
        testBase.getdriver().findElement(By.xpath(MOT_date)).sendKeys(MOTDate+Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(newMOT_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisNumber);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }


    @Step("For Racemotor Adding more data for vehicle interior with all the option")
    public void addingInteriorDataForRacemotor() throws AWTException {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, electircStart_label);
        testBase.verifyElementPresence(electircStart_label);
        testBase.getdriver().findElement(By.xpath(electircStart_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(catalyst_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(kickstarter_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(image_btn)).click();
        Utils.pause(1000, "wait for element load on the page");
        add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
        Utils.pause(3000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Racemotor Adding more data for vehicle Exterieur with all the option")
    public void addingExteriorDataForRacemotor() {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, adaptedForDisabled_lbl);
        testBase.verifyElementPresence(adaptedForDisabled_lbl);
        testBase.getdriver().findElement(By.xpath(adaptedForDisabled_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(storageCases_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(crashbar_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(windshield_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Racemotor Adding more data for vehicle Safety with all the option")
    public void addingSafetyDataForRacemotor() {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, ABS_lbl);
        testBase.verifyElementPresence(ABS_lbl);
        testBase.getdriver().findElement(By.xpath(abs_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }


}