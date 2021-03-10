package autofacets.eurostocksUIBackend;
import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;

/**
 * @author niravpatel
 */

public class EuroStocksAddVehicleSedan_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Redirect to Add Vehicle page and verify page and click on add Vehicle button")
    public void addVehicleAndAddButtonClick() {
        Utils.pause(5000, "wait to load element on the page");
        testBase.getdriver().findElement(By.xpath(vehicle_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        testBase.getdriver().findElement(By.xpath(add_vehicle_btn)).click();
    }

    @Step("Verify add vehicle page")
    public void verifyAddVehiclePage() {
        testBase.waitForElementVisibleXpath(waitTime, vehicle_information_lbl);
        testBase.waitForElementVisibleXpath(waitTime, all_data_chkbox);
        testBase.getdriver().findElement(By.xpath(all_data_chkbox)).click();
        Gauge.captureScreenshot();
    }

    @Step("Select Vehicle <Auto's>, Categorie <Sedan>, brand <AC>, model <>")
    public void addDataForVehicle(String vehicleType, String category, String brand, String model) {
        Utils.pause(4000, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, vehicle_type_dropdown);
        Select vehicleSelect = new Select(testBase.getdriver().findElement(By.xpath(vehicle_type_dropdown)));
        vehicleSelect.selectByVisibleText(vehicleType);
        Utils.pause(2000, "wait for element load on the page");
        Select categorySelect = new Select(testBase.getdriver().findElement(By.xpath(category_dropdown)));
        categorySelect.selectByVisibleText(category);
        testBase.waitForElementVisibleXpath(waitTime, brand_dropdown);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(brand_dropdown)));
        testBase.getdriver().findElement(By.xpath(brand_dropdown)).click();
        String brand_xpath = "//div[contains(text(),'" + brand + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(brand_xpath)).click();
        if (model.equalsIgnoreCase("null")) {
            Gauge.writeMessage("Not Found Element on the page for this vehicle");
        } else {
            testBase.waitForElementVisibleXpath(waitTime, model_dropdown);
            testBase.getdriver().findElement(By.xpath(model_dropdown)).click();
            String model_xpath = "//div[contains(text(),'" + model + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(model_xpath)).click();
        }
        Gauge.captureScreenshot();
    }

    @Step("Add mobile.de description <Acura MDX for mobile.de>, Model variant <Acura MDX>, Option package name <Acura MDX O>, Model code <Acura 22> and additional title name <Acura MDX Optional>, Extra additional title description <>")
    public void fillRequiredData(String desc, String modelVariant, String optionalName, String modelCode, String additionalTitleName, String extraAdditionalTitleDesc) {
        commanCall(desc);
        testBase.getdriver().findElement(By.xpath(modelVariant_input)).sendKeys(modelVariant);
        testBase.getdriver().findElement(By.xpath(optionalPackage_input)).sendKeys(optionalName);
        testBase.getdriver().findElement(By.xpath(modelCode_input)).sendKeys(modelCode);
        commanCall(additionalTitleName, extraAdditionalTitleDesc);
    }


    void commanCall(String desc) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(desc_input)));
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(desc_input)).sendKeys(desc);
    }

    void commanCall(String additionalTitleName, String extraAdditionalTitleDesc) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(additionalTitleDesc_input)));
        testBase.getdriver().findElement(By.xpath(additionalTitleDesc_input)).sendKeys(additionalTitleName);
        testBase.getdriver().findElement(By.xpath(extraDesc_input)).sendKeys(extraAdditionalTitleDesc);
        Gauge.captureScreenshot();
    }

    @Step("Select condition of vehicle <Nieuw>, Subcategorie <Auto van werknemer>, Mileage <22>,Date of first registration <01-01-1991>,Year of construction <2>,Model production date <01-01-1990> and Date of construction <01-01-1990>")
    public void additionDataForVehicle(String condition, String subCategory, String mileage, String DORegistration, String consYear, String prodDate, String consDate) {
        commanCall(condition, subCategory, mileage, DORegistration, consYear);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(first_models_prod_date)));
        testBase.getdriver().findElement(By.xpath(first_models_prod_date)).sendKeys(prodDate + Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(construction_date)).sendKeys(consDate+ Keys.ENTER);
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
        testBase.getdriver().findElement(By.xpath(construction_year_input)).sendKeys(consYear+Keys.ENTER);
    }

    @Step("Select Transmission <Automatische transmissie>, Engine capacity in CC <2200>, Fuel <Aardgas>,Suitable for E10 <Ja>, Suitable for Biodiesel <Ja>")
    public void addVehicleData(String transmission, String CC, String fuel, String suitableE10, String suitableBioDiesel) {
        commanCall(transmission, CC, fuel);
        testBase.getdriver().findElement(By.xpath(biodiesl_chkbox)).click();
        Gauge.captureScreenshot();
    }

    void commanCall(String transmission, String CC, String fuel) {
        testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(transmission_dropdown)));
        Utils.pause(1000,"wait to load element on the page");
        testBase.getdriver().findElement(By.xpath(transmission_dropdown)).click();
        String transmission_xpath = "//div[contains(text(),'" + transmission + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(transmission_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(CC_input)).sendKeys(CC);
        testBase.scrollDownPageToElement(300,testBase.getdriver().findElement(By.xpath(fuel_dropdown)));
        testBase.getdriver().findElement(By.xpath(fuel_dropdown)).click();
        String fuel_xpath = "//div[contains(text(),'" + fuel + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(fuel_xpath)).click();
        testBase.getdriver().findElement(By.xpath(E10_chkbox)).click();
    }

    @Step("Add Power (in KW) <151>, Power combined <151.22>, Battery <Gekochte accu>, Battery capacity in kWh <32>, Built for <Nederland>, availabilty <Beschikbaar>, Date first registration generated <01-01-1990> and Mobile.de Adid <>")
    public void vehicleData(String power, String combinedPower, String battery, String batteryCapacity, String buildForCountry, String checkAvailabilty, String dateOfReg, String mobileDe) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(power_input)));
        testBase.getdriver().findElement(By.xpath(power_input)).sendKeys(power);
        testBase.getdriver().findElement(By.xpath(combine_power_input)).sendKeys(combinedPower);
        testBase.getdriver().findElement(By.xpath(battery_capacity_input)).sendKeys(batteryCapacity);
        commanCallPower(battery, buildForCountry, checkAvailabilty, dateOfReg, mobileDe);
    }

    void commanCallPower(String optionOne, String optionTwo, String optionThree, String optionFour, String optionFive) {
        testBase.getdriver().findElement(By.xpath(battery_dropdown)).click();
        String battery_xpath = "//div[contains(text(),'" + optionOne + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(battery_xpath)).click();
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String build_xpath = "(//div[contains(text(),'" + optionTwo + "')])[2]";
        Utils.pause(500, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(build_xpath)).click();
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String available_xpath = "//div[contains(text(),'" + optionThree + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(available_xpath)).click();
        testBase.scrollPage(500);
        testBase.getdriver().findElement(By.xpath(reg_gen_input)).sendKeys(optionFour + Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(optionFive);
        testBase.getdriver().findElement(By.xpath(savenext_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("Add Extensive data while adding vehicle <22pvps>, <Ja>, <>, <4>, <Schuifdeur beide zijden>, <4>, <Groen>, <Ja>, <wit>, <Nee>, <Nee>, <Ja>")
    public void addExtensiveVehicleData(String licencePlate, String workStatus, String internalNumber, String door,
                                        String slidingDoor, String chairs, String color, String metalic, String manColor, String damage, String damageHistory, String roadworthy) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.verifyElementPresence(license_plate_lbl);
        testBase.getdriver().findElement(By.xpath(work_status_chkbox)).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(door_count_input)));
        testBase.getdriver().findElement(By.xpath(door_count_input)).sendKeys(door);
        commanCallExtensive(licencePlate, internalNumber, slidingDoor, chairs, color, manColor, damage, damageHistory);
        testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(roadworthy_dropdown)));
        testBase.getdriver().findElement(By.xpath(roadworthy_dropdown)).click();
        String roadworthy_xpath = "(//div[contains(text(),'" + roadworthy + "')])[3]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(roadworthy_xpath)).click();
        Gauge.captureScreenshot();
    }

    void commanCallExtensive(String optionOne, String optionTwo, String optionThree, String optionFour,
                             String optionFive, String optionSix, String optionSeven, String optionEight) {

        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(license_plate_input)));
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(optionOne);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(optionTwo);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(sliding_door_dropdown)));
        testBase.getdriver().findElement(By.xpath(sliding_door_dropdown)).click();
        String sliding_xpath = "//div[contains(text(),'" + optionThree + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(sliding_xpath)).click();
        testBase.getdriver().findElement(By.xpath(charis_input)).sendKeys(optionFour);
        testBase.scrollDownPageToElement(350,testBase.getdriver().findElement(By.xpath(color_dropdown)));
        testBase.getdriver().findElement(By.xpath(color_dropdown)).click();
        String color_xpath = "//div[contains(text(),'" + optionFive + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(color_xpath)).click();
        testBase.getdriver().findElement(By.xpath(metalic_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(man_color_name_input)).sendKeys(optionSix);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(damage_dropdown)));
        testBase.getdriver().findElement(By.xpath(damage_dropdown)).click();
        String damage_xpath = "(//div[contains(text(),'" + optionSeven + "')])[1]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(damage_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(damage_history_dropdown)).click();
        String damageHistory_xpath = "(//div[contains(text(),'" + optionEight + "')])[1 or 2 or 3]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(damageHistory_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
    }

    @Step("Adding more data for vehicle <0>, <Ja>, <Ja>, <Ja>, <2.2>, <4.4>, <3.3>, <A+>, <Euro1>, <Geel>, <Ja>, <01-01-1990>, <Yes>, <242>, <5678NL5623LPA4562>, <Ja>")
    public void addVehicleReqData(String previousOwner, String warranty, String nonSmokingVehicle, String fullServiceHistory, String fuelConsumptionCity,
                                  String fuelConsumptionOutsideCity, String fuelConsumptionCombined, String energyLabel, String emissionClass, String environmentalSticker, String dieselParticulateFilter,
                                  String MOTDate, String newMOT, String co2, String chassisNumber, String taxi) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(previousOwner_input)));
        testBase.getdriver().findElement(By.xpath(previousOwner_input)).sendKeys(previousOwner);
        testBase.getdriver().findElement(By.xpath(warranty_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(nonsmokingVehicle_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fullServiceHistory_chkbox)).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(fuelCity_input)));
        testBase.getdriver().findElement(By.xpath(fuelCity_input)).sendKeys(fuelConsumptionCity);
        testBase.getdriver().findElement(By.xpath(fuelOutSideCity_input)).sendKeys(fuelConsumptionOutsideCity);
        testBase.getdriver().findElement(By.xpath(combineFuel_input)).sendKeys(fuelConsumptionCombined);
        testBase.getdriver().findElement(By.xpath(enegry_dropdown)).click();
        String energyLabel_xpath = "//div[contains(text(),'" + energyLabel + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(energyLabel_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(emission_dropdown)).click();
        String emissionClass_xpath = "//div[contains(text(),'" + emissionClass + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(emissionClass_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(environmental_dropdown)).click();
        String environmentalSticker_xpath = "(//div[contains(text(),'" + environmentalSticker + "')])[2]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(environmentalSticker_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(diesel_filter_chkbox)).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(MOT_date)));
        testBase.getdriver().findElement(By.xpath(MOT_date)).sendKeys(MOTDate + Keys.ENTER);
        testBase.getdriver().findElement(By.xpath(newMOT_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(co2_input)).sendKeys(co2);
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisNumber);
        testBase.getdriver().findElement(By.xpath(taxi_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("Adding more data for vehicle interior <Automatische airconditioning>, <Ja>, <Ja>, <Ja>, <Volledig leer>, <Bruin> and select all features checkbox <Ja>")
    public void addingInteriorData(String ac, String androidAuto, String appleCarPlay, String cargoNet, String upholstery, String colorInterior, String checked) throws AWTException {
        Utils.pause(100, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, airConditioning_label);
        testBase.verifyElementPresence(airConditioning_label);
        testBase.getdriver().findElement(By.xpath(ac_dropdown)).click();
        String ac_xpath = "//div[contains(text(),'" + ac + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(ac_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(androidAuto_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(appleCarPlay_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(cargoNet_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(upholstery_dropdown)).click();
        String upholstery_xpath = "//div[contains(text(),'" + upholstery + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(upholstery_xpath)).click();
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(colorInterior_dropdown)).click();
        String colorInterior_xpath = "//div[contains(text(),'" + colorInterior + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(colorInterior_xpath)).click();
        if (checked.contains("Ja")) {
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(passengerSeatFullyFoldable_chkbox)));
            testBase.getdriver().findElement(By.xpath(passengerSeatFullyFoldable_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(bluetooth_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(boardComputer_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(powerSteering_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(wirelessChargingSmartphone_chkbox)));
            testBase.getdriver().findElement(By.xpath(wirelessChargingSmartphone_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(cdPlayer_chkbox)));
            testBase.getdriver().findElement(By.xpath(cdPlayer_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(cdChanger_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(centralDoorLocking_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(digitalCockpit_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(dimmingInteriorMirror_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(navigation_chkbox)));
            testBase.getdriver().findElement(By.xpath(navigation_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricallyAdjustableSeats_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricallyAdjustableRearSeats_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(ElectricSeatHeating_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(ElectricRearSeatHeating_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(soundSystem_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(handsFreeCarKit_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(headUpDisplay_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(leatherSteeringWheel_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(lumbarSupport_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(massageChair_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(centerArmrest_chkbox)).click();
            testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(radio_dropdown)));
            testBase.getdriver().findElement(By.xpath(multifunctionalWheel_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(musicStreamingIntegration_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(radio_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(DABRadio_select)).click();
            testBase.getdriver().findElement(By.xpath(tunerRadio_select)).click();
            testBase.getdriver().findElement(By.xpath(rainSensor_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(smokersPackage_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(ambientLighting_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(skiBag_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(sportsPackage_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(sportsSeats_chkbox)));
            testBase.getdriver().findElement(By.xpath(sportsSeats_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(seatVentilation_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(touchScreen_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(television_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(USB_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(shiftLevers_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricWindowControl_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(steeringWheelHeating_chkbox)));
            testBase.getdriver().findElement(By.xpath(steeringWheelHeating_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(parkingHeater_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(windscreenHeating_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(wifiHotspot_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(image_btn)).click();
            Utils.pause(1000, "wait for element load on the page");
            add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
            Utils.pause(10000, "wait for element load on the page");
            Gauge.captureScreenshot();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_btn)));
        testBase.getdriver().findElement(By.xpath(save_btn)).click();
    }

    @Step("Adding more data for vehicle Exterieur with all the option checked <Ja>, <Adaptieve bochtverlichting>, <LED-Dagrijverlichting>, <LED-koplampen>, <Afneembare trekhaak>")
    public void addingExteriorData(String checked, String light, String dayNightLight, String headLight, String towbar) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, tire_lbl);
            testBase.verifyElementPresence(tire_lbl);
            testBase.getdriver().findElement(By.xpath(tire_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(corneringLighting_dropdown)));
            testBase.getdriver().findElement(By.xpath(corneringLighting_dropdown)).click();
            String corneringLighting_xpath = "//div[contains(text(),'" + light + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(corneringLighting_xpath)).click();
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(daytimeRunningLights_dropdown)).click();
            String dayNightLight_xpath = "//div[contains(text(),'" + dayNightLight + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(dayNightLight_xpath)).click();
            Utils.pause(100, "wait for element load on the page");
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(roofRails_chkbox)));
            testBase.getdriver().findElement(By.xpath(roofRails_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricallyAdjustableExteriorMirrors_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(electricTailgate_chkbox)).click();
            //testBase.scrollPage(200);
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(headLamp_dropdown)));
            testBase.getdriver().findElement(By.xpath(headLamp_dropdown)).click();
            String headLight_xpath = "//div[contains(text(),'" + headLight + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(headLight_xpath)).click();
            testBase.getdriver().findElement(By.xpath(headlampWashers_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(alloyWheels_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(airSuspension_chkbox)).click();
            //testBase.scrollPage(500);
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(frontFogLights_chkbox)));
            testBase.getdriver().findElement(By.xpath(frontFogLights_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(panoramaRoof_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(steelRims_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(heatedExteriorMirrors_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(towbar_dropdown)).click();
            String towbar_xpath = "//div[contains(text(),'" + towbar + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(towbar_xpath)).click();
            testBase.getdriver().findElement(By.xpath(winterTires_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(sunroof_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(summerTires_chkbox)).click();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("Adding more data for vehicle Safety with all the option checked <Ja>, <Airbags voor en zijkant>, <Adaptieve cruisecontrol>, <Zelfsturend systeem | Parking Assistent>, <360° camera>, <Achter>, <Voor>, <Noodreparatiekit voor banden>")
    public void addingSafetyData(String checked, String airbags, String cruiseControl, String psOptionOne,
                                 String psOptionTwo, String psOptionThree, String psOptionFour, String tire) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, ABS_lbl);
            testBase.verifyElementPresence(ABS_lbl);
            testBase.getdriver().findElement(By.xpath(ABS_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(distanceAlert_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(airbags_dropdown)).click();
            String airbags_xpath = "//div[contains(text(),'" + airbags + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(airbags_xpath)).click();
            testBase.getdriver().findElement(By.xpath(alarm_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(tirePressureSensor_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(cruiseControl_dropdown)));
            testBase.getdriver().findElement(By.xpath(cruiseControl_dropdown)).click();
            String cruiseControl_xpath = "//div[contains(text(),'" + cruiseControl + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(cruiseControl_xpath)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(deadAngleDetection_chkbox)));
            testBase.getdriver().findElement(By.xpath(deadAngleDetection_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(ESPElectronicStabilityControl_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(highBeamAssist_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(hillStartAssist_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(isofix_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(isofixPassengerSeat_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(keylessEntry_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(laneChangeAssist_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(lightSensor_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(nightVision_chkbox)));
            testBase.getdriver().findElement(By.xpath(nightVision_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(emergencyCallSystem_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(emergencyBrakeAssistant_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(tractionControl_chkbox)).click();
            testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(parkingSensors_dropdown)));
            testBase.getdriver().findElement(By.xpath(parkingSensors_dropdown)).click();
            String psOptionOne_xpath = "//label[@title='" + psOptionOne + "']";
            testBase.getdriver().findElement(By.xpath(psOptionOne_xpath)).click();
            String psOptionTwo_xpath = "//label[@title='" + psOptionTwo + "']";
            testBase.getdriver().findElement(By.xpath(psOptionTwo_xpath)).click();
            String psOptionThree_xpath = "//label[@title='" + psOptionThree + "']";
            testBase.getdriver().findElement(By.xpath(psOptionThree_xpath)).click();
            String psOptionFour_xpath = "//label[@title='" + psOptionFour + "']";
            testBase.getdriver().findElement(By.xpath(psOptionFour_xpath)).click();
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(flatTireBreakdown_dropdown)).click();
            String tire_xpath = "//div[contains(text(),'" + tire + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(tire_xpath)).click();
            testBase.getdriver().findElement(By.xpath(plugInHybrid_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(suitableForWheelchairs_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(rangeExtender_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(fatigueDetection_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(speedLimiter_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(sportsSuspension_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(startStopSystem_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(immobilizer_chkbox)));
            testBase.getdriver().findElement(By.xpath(immobilizer_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(voiceControl_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(glareFreeHighBeam_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(trafficSignRecognition_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(fourWheelDrive_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(winterPackage_chkbox)).click();
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("Adding all required comment and select all option checked <Ja>, <Voertuig specifieke opmerkingen>, <Highlights>, <false>, <221,22>, <222,22>, <223,22>, <224,22>, <225,22>, <226,22>, <227,22>, <228,22>")
    public void addingCommentForVehicle(String checked, String comment, String highLights, String value, String value1, String value2, String value3, String value4,
                                        String value5, String value6, String value7, String value8) {
        if (checked.contains("Ja")) {
            Utils.pause(100, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, vehicleSpecificComments_lbl);
            testBase.verifyElementPresence(vehicleSpecificComments_lbl);
            testBase.getdriver().findElement(By.xpath(vehicleSpecificComments_input)).sendKeys(comment + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(standardVehicleComments_input)).sendKeys(comment + " Addition data for second comment" + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(warrantyDescription_input)).sendKeys(comment + " Addition data for third comment" + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(providerStandardComments_input)).sendKeys(comment + " Addition data for fourth comment" + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(standardCommentsPortals_input)).sendKeys(comment + " Addition data for fifth comment" + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(otherProperties_input)).sendKeys(comment + " Addition data for sixth comment" + Keys.TAB);
            testBase.getdriver().findElement(By.xpath(otherOptions_input)).sendKeys(comment + " Addition data for seventh comment" + Keys.TAB);
            testBase.scrollDownPageToElement(50, testBase.getdriver().findElement(By.xpath(otherOptionsTranslated_lbl)));
            testBase.getdriver().findElement(By.xpath(highlights1_input)).sendKeys(highLights + "1");
            testBase.getdriver().findElement(By.xpath(highlights2_input)).sendKeys(highLights + "2");
            testBase.getdriver().findElement(By.xpath(highlights3_input)).sendKeys(highLights + "3");
            if (value.contains("true")) {
                testBase.getdriver().findElement(By.xpath(forTradeExImport_chkbox)).click();
            } else {
            }
            testBase.getdriver().findElement(By.xpath(priceOnRequest_chkbox)).click();
            Gauge.captureScreenshot();
            testBase.scrollPage(100);
            String generic_check = "//following-sibling::div//following-sibling::div[contains(text(),'" + checked + "')]";
            testBase.getdriver().findElement(By.xpath(VATReclaimable_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(VATReclaimable_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(salesPriceNL_input)).sendKeys(value1);
            Gauge.captureScreenshot();
            testBase.scrollPage(200);
            testBase.getdriver().findElement(By.xpath(SalesPriceNLExVAT_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(SalesPriceNLExVAT_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(salesPriceNLExBPM_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(salesPriceNLExBPM_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exportPriceExVAT_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exportPriceExVAT_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exportPrice_input)).sendKeys(value2);
            Gauge.captureScreenshot();
            testBase.getdriver().findElement(By.xpath(exportPriceExBPM_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exportPriceExBPM_dropdown + generic_check)).click();
            testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(exVATPortalNL_dropdown)));
            Utils.pause(500,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exVATPortalNL_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATPortalNL_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalNL_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalNL_dropdown + generic_check)).click();
            testBase.scrollDownPageToElement(200,testBase.getdriver().findElement(By.xpath(exVATPortalExport_dropdown)));
            Utils.pause(500,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exVATPortalExport_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATPortalExport_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalExport_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalExport_dropdown + generic_check)).click();
            testBase.scrollDownPageToElement(150,testBase.getdriver().findElement(By.xpath(exVATNLB2B_dropdown)));
            Utils.pause(500,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exVATNLB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATNLB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exBPMNLB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exBPMNLB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(pricePortalNL_input)).sendKeys(value3);
            testBase.getdriver().findElement(By.xpath(pricePortalExport_input)).sendKeys(value4);
            testBase.getdriver().findElement(By.xpath(priceNLB2BTradingPrice_input)).sendKeys(value5);
            Gauge.captureScreenshot();
            testBase.scrollDownPageToElement(150,testBase.getdriver().findElement(By.xpath(exVATExportB2B_dropdown)));
            Utils.pause(500,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exVATExportB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATExportB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exBPMExportB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exBPMExportB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exVATPortalNLB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATPortalNLB2B_dropdown + generic_check)).click();
            Utils.pause(500,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exBPMPortalNLB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalNLB2B_dropdown + generic_check)).click();
            Utils.pause(100,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exVATPortalExportB2B_dropdown)).click();
            testBase.getdriver().findElement(By.xpath(exVATPortalExportB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(exBPMPortalExportB2B_dropdown)).click();
            Utils.pause(100,"wait to load element on the page");
            testBase.getdriver().findElement(By.xpath(exBPMPortalExportB2B_dropdown + generic_check)).click();
            testBase.getdriver().findElement(By.xpath(priceExportB2B_input)).sendKeys(value6);
            testBase.getdriver().findElement(By.xpath(pricePortalNLB2B_input)).sendKeys(value7);
            testBase.getdriver().findElement(By.xpath(pricePortalExportB2B_input)).sendKeys(value8);
        } else {
        }
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(50, testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

    @Step("verify newly added vehicle on the list <model>, <brand>, <lp>")
    public void verifyVehicleOnList(String brand, String model, String lp) {
        testBase.waitForElementVisibleXpath(waitTime,table_data);
        Utils.pause(2000, "wait to element load on the page");
        String brand_xpath = "//tbody//tr[1]//td[3]//a[contains(text(),'"+brand+"')]";
        String model_xpath = "//tbody//tr[1]//td[4]//a[contains(text(),'"+model+"')]";
        String lp_xpath = "//tbody//tr[1]//td[6]//span[contains(text(),'"+lp+"')]";
        testBase.verifyElementPresence(brand_xpath);
        testBase.verifyElementPresence(model_xpath);
        testBase.verifyElementPresence(lp_xpath);
        Gauge.captureScreenshot();
    }


    @Step("Redirect to vehicle page and Verify page")
    public void verifyProductPage() {
        testBase.getdriver().findElement(By.xpath(vehicle_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
    }


    @Step("Update product status with any one product from the list and verify status updated for vehicle")
    public void updateStatusAndVerify() {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[3]/a")));
        String product_name = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        WebElement webElement = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[1]/div/input"));
        String get_id = webElement.getAttribute("id");
        testBase.getdriver().findElement(By.xpath("//input[@id='" + get_id + "']")).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(uitvoeren_btn)));
        testBase.getdriver().findElement(By.xpath(uitvoeren_btn)).click();
        Utils.pause(5000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.getdriver().navigate().refresh();
        Utils.pause(10000, "wait for element load on the page");
        testBase.getdriver().navigate().refresh();
        Utils.pause(10000, "wait for element load on the page");
        testBase.getdriver().navigate().refresh();
        Utils.pause(10000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath("//input[@id='radio2']")).click();
        testBase.waitForElementVisibleXpath(waitTime,table_data);
        Utils.pause(1000, "wait for element load on the page");
        String checkProduct = "//a[contains(text(),'"+product_name+"')]";
        testBase.verifyElementPresence(checkProduct);
        Gauge.captureScreenshot();
    }
}