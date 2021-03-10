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

public class EuroStocksAddVehicleBestelwagen_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("For Bestelwagen Add mobile.de description <Bestelwagen MDX for mobile.de>, <Bestelwagen AJX>")
    public void fillRequiredDataForBestelwagen(String desc, String modelDesc) {
        commanCall(desc);
        testBase.getdriver().findElement(By.xpath(modelDesc_input)).sendKeys(modelDesc);
    }

    void commanCall(String desc) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(desc_input)));
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(desc_input)).sendKeys(desc);
    }

    @Step("For Bestelwagen Select condition of vehicle <Nieuw>, <Auto van werknemer>, <22>, <01-01-1991>, <2>, <250>")
    public void additionDataForVehicleForBestelwagen(String condition, String subCategory, String mileage, String DORegistration, String consYear, String LICENSED_WEIGHT) {
        commanCall(condition, subCategory, mileage, DORegistration, consYear);
        testBase.getdriver().findElement(By.xpath(licenceWeight_input)).sendKeys(LICENSED_WEIGHT);
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
        testBase.getdriver().findElement(By.xpath(mileage_input)).sendKeys(mileage);
        testBase.getdriver().findElement(By.xpath(first_reg_date)).sendKeys(DORegistration);
        testBase.getdriver().findElement(By.xpath(construction_year_input)).sendKeys(consYear);
    }

    @Step("For Bestelwagen Select Transmission <Automatische transmissie>, <2200>, <Aardgas>, <250>, <220>, <230>")
    public void addVehicleDataForBestelwagen(String transmission, String CC, String fuel, String height, String width, String length) {
        testBase.scrollPage(300);
        commanCall(transmission, CC, fuel);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(bioDiesl_chkbox)));
        testBase.getdriver().findElement(By.xpath(bioDiesl_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(height_input)).sendKeys(height);
        testBase.getdriver().findElement(By.xpath(width_input)).sendKeys(width);
        testBase.getdriver().findElement(By.xpath(length_input)).sendKeys(length);
        Gauge.captureScreenshot();
    }



    void commanCall(String transmission, String CC, String fuel) {
        testBase.getdriver().findElement(By.xpath(transmission_dropdown)).click();
        String transmission_xpath = "//div[contains(text(),'" + transmission + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(transmission_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(CC_input)).sendKeys(CC);
        testBase.getdriver().findElement(By.xpath(fuel_dropdown)).click();
        String fuel_xpath = "//div[contains(text(),'" + fuel + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(fuel_xpath)).click();
        if(fuel.equalsIgnoreCase("Aardgas")){
            testBase.getdriver().findElement(By.xpath(E10_chkbox)).click();
        }else{
        }
    }

    @Step("For Bestelwagen Add Power (in KW) <151>, <251>, <252>, <32>, <44>, <Beschikbaar>, <Lokaal verkeer>, <01-01-1990>, <>, <>")
    public void vehicleDataForBestelwagen(String power, String loadingWidth, String loadingHeight, String storage, String volume, String buildForCountry,
                                          String checkAvailabilty, String option, String dateOfReg, String mobileDe) {
        //testBase.scrollPage(600);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(power_input)));
        testBase.getdriver().findElement(By.xpath(power_input)).sendKeys(power);
        testBase.getdriver().findElement(By.xpath(loadingWidth_input)).sendKeys(loadingWidth);
        testBase.getdriver().findElement(By.xpath(loadingHeight_input)).sendKeys(loadingHeight);
        testBase.getdriver().findElement(By.xpath(storageSpaces_input)).sendKeys(storage);
        testBase.getdriver().findElement(By.xpath(shippingVolume_input)).sendKeys(volume);
        commanCallPower(buildForCountry, checkAvailabilty, option, dateOfReg, mobileDe);
    }



    void commanCallPower(String optionOne, String optionTwo, String optionThree, String optionFour, String optionFive) {
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String optionOne_xpath = "//div[contains(text(),'" + optionOne + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(optionOne_xpath)).click();
        testBase.scrollPage(200);
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String optionTwo_xpath = "(//div[contains(text(),'"+optionTwo+"')])";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(optionTwo_xpath)).click();
        testBase.getdriver().findElement(By.xpath(typeOfCabin_dropdown)).click();
        String optionThree_xpath = "(//div[contains(text(),'"+optionThree+"')])";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(optionThree_xpath)).click();
        testBase.scrollPage(500);
        testBase.getdriver().findElement(By.xpath(reg_gen_input)).sendKeys(optionFour);
        testBase.getdriver().findElement(By.xpath(reg_gen_input)).sendKeys(Keys.ENTER);
        Utils.pause(500,"wait to load element on the page");
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(optionFive);
        testBase.getdriver().findElement(By.xpath(savenext_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("For Bestelwagen Add Extensive data while adding vehicle <22pvps>, <Euro1>, <>, <4>, <Schuifdeur beide zijden>, <4>, <Groen>, <Ja>, <wit>, <Nee>, <Nee>, <Ja>, <Geel>")
    public void addExtensiveVehicleDataForBestelwagen(String licencePlate, String checkOption, String internalNumber, String door, String slidingDoor,
                                                      String chairs, String color, String metalic, String manColor, String damage, String damageHistory, String roadworthy, String option) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.verifyElementPresence(license_plate_lbl);
        commanCallExtensive(licencePlate, internalNumber, slidingDoor, chairs, color, manColor, damage);
        testBase.getdriver().findElement(By.xpath(emission_dropdown)).click();
        System.out.println(checkOption);
        String option_xpath = "(//div[contains(text(),'" + checkOption + "')])[1 or 2 or 3]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(option_xpath)).click();
        testBase.getdriver().findElement(By.xpath(environmental_dropdown)).click();
        System.out.println(option);
        String environmental_xpath = "(//div[contains(text(),'" + option + "')])[1 or 2 or 3]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(environmental_xpath)).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(metalicColor_chkbox)));
        testBase.getdriver().findElement(By.xpath(metalicColor_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(diesel_filter_chkbox)).click();
        Gauge.captureScreenshot();
    }


    void commanCallExtensive(String optionOne, String optionTwo, String optionThree, String optionFour,
                             String optionFive, String optionSix, String optionSeven) {
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(optionOne);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(optionTwo);
        testBase.getdriver().findElement(By.xpath(sliding_door_dropdown)).click();
        String sliding_xpath = "//div[contains(text(),'" + optionThree + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(sliding_xpath)).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(charis_input)));
        testBase.getdriver().findElement(By.xpath(charis_input)).sendKeys(optionFour);
        testBase.scrollDownPageToElement(400,testBase.getdriver().findElement(By.xpath(color_dropdown)));
        testBase.getdriver().findElement(By.xpath(color_dropdown)).click();
        String color_xpath = "//div[contains(text(),'" + optionFive + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(color_xpath)).click();
        testBase.getdriver().findElement(By.xpath(metalic_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(man_color_name_input)).sendKeys(optionSix);
        testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(damage_dropdown)));
        testBase.getdriver().findElement(By.xpath(damage_dropdown)).click();
        String damage_xpath = "(//div[contains(text(),'" + optionSeven + "')])[1]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(damage_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
    }

    @Step("For Bestelwagen Adding more data for vehicle <01-01-1990>, <Yes>, <242>, <5678NL5623LPA4562>")
    public void addVehicleReqDataForBestelwagen(String MOTDate, String newMOT, String co2, String chassisNumber) {
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(MOT_date)));
        testBase.getdriver().findElement(By.xpath(MOT_date)).sendKeys(MOTDate);
        testBase.getdriver().findElement(By.xpath(MOT_date)).sendKeys(Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(newMOT_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(co2_input)).sendKeys(co2);
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisNumber);
        testBase.getdriver().findElement(By.xpath(taxiOption_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("For Bestelwagen Adding more data for vehicle interior <Automatische airconditioning>, and select all features checkbox <Ja>")
    public void addingInteriorDataForBestelwagen(String ac, String checked) throws AWTException {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, airConditioning_label);
        testBase.verifyElementPresence(airConditioning_label);
        testBase.getdriver().findElement(By.xpath(ac_dropdown)).click();
        String ac_xpath = "//div[contains(text(),'" + ac + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(ac_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        if (checked.contains("Ja")) {
            testBase.getdriver().findElement(By.xpath(centralDoorLocking_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(navigation_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(powerSteering_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricallyAdjustableSeats2_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(parkingHeater2_chkbox)));
            testBase.getdriver().findElement(By.xpath(parkingHeater2_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(partition_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(image_btn)).click();
            Utils.pause(1000, "wait for element load on the page");
            add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
            Utils.pause(3000, "wait for element load on the page");
            Gauge.captureScreenshot();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_btn)));
        testBase.getdriver().findElement(By.xpath(save_btn)).click();
    }

    @Step("For Bestelwagen Adding more data for vehicle Exterieur with all the option checked <Ja>, <Afneembare trekhaak>")
    public void addingExteriorDataForBestelwagen(String checked, String towbar) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, crane_lbl);
            testBase.verifyElementPresence(crane_lbl);
            testBase.getdriver().findElement(By.xpath(crane_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(tailgate_chkbox)).click();
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

    @Step("For Bestelwagen Adding more data for vehicle Safety with all the option checked <Ja>, <Adaptieve cruisecontrol>, <Zelfsturend systeem | Parking Assistent>, <360° camera>, <Achter>, <Voor>")
    public void addingSafetyDataForBestelwagen(String checked, String cruiseControl, String psOptionOne,
                                               String psOptionTwo, String psOptionThree, String psOptionFour) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, ABS_lbl);
            testBase.verifyElementPresence(ABS_lbl);
            testBase.getdriver().findElement(By.xpath(abs_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(cruiseControl_dropdown)));
            testBase.getdriver().findElement(By.xpath(cruiseControl_dropdown)).click();
            String cruiseControl_xpath = "//div[contains(text(),'" + cruiseControl + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(cruiseControl_xpath)).click();
            testBase.getdriver().findElement(By.xpath(parkingSensors_dropdown)).click();
            String psOptionOne_xpath = "//label[@title='" + psOptionOne + "']";
            testBase.getdriver().findElement(By.xpath(psOptionOne_xpath)).click();
            String psOptionTwo_xpath = "//label[@title='" + psOptionTwo + "']";
            testBase.getdriver().findElement(By.xpath(psOptionTwo_xpath)).click();
            String psOptionThree_xpath = "//label[@title='" + psOptionThree + "']";
            testBase.getdriver().findElement(By.xpath(psOptionThree_xpath)).click();
            String psOptionFour_xpath = "//label[@title='" + psOptionFour + "']";
            testBase.getdriver().findElement(By.xpath(psOptionFour_xpath)).click();
            testBase.getdriver().findElement(By.xpath(fourWheelDrive_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(ESPElectronicStabilityControl_chkbox)).click();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }
}