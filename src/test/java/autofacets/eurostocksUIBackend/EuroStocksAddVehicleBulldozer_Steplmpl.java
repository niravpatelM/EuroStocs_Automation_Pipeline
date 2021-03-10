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

public class EuroStocksAddVehicleBulldozer_Steplmpl extends EuroStocksTest implements WebLocators.AddVehiclePageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("For Bulldozer Select condition of vehicle <Nieuw>, <Auto van werknemer>, <22>, <Nederland>, <Wordt verwacht>, <646328379>")
    public void additionDataForVehicleForBulldozer(String condition, String subCategory, String consYear, String build, String available, String number) {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(condition_dropdown)));
        testBase.getdriver().findElement(By.xpath(condition_dropdown)).click();
        String cond_xpath = "//div[contains(text(),'" + condition + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(cond_xpath)).click();
        testBase.getdriver().findElement(By.xpath(subcategory_dropdown)).click();
        String subCategory_xpath = "//div[contains(text(),'" + subCategory + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(subCategory_xpath)).click();
        testBase.getdriver().findElement(By.xpath(construction_year_input)).sendKeys(consYear);
        testBase.getdriver().findElement(By.xpath(build_for_dropdown)).click();
        String build_xpath = "//div[contains(text(),'" + build + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(build_xpath)).click();
        testBase.getdriver().findElement(By.xpath(available_dropdown)).click();
        String available_xpath = "//div[contains(text(),'" + available + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(available_xpath)).click();
        testBase.getdriver().findElement(By.xpath(mobiledeAdId_input)).sendKeys(number);
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }


    @Step("For Bulldozer Add Extensive data while adding vehicle <22pvps>, <1235689>, <Geen>, <5678NL5623LPA4562>")
    public void addExtensiveVehicleDataForBulldozer(String licencePlate, String internalNumber, String sticker, String chassisnummer) {
        testBase.waitForElementVisibleXpath(waitTime, license_plate_lbl);
        testBase.getdriver().findElement(By.xpath(license_plate_input)).sendKeys(licencePlate);
        testBase.getdriver().findElement(By.xpath(internal_number_input)).sendKeys(internalNumber);
        testBase.getdriver().findElement(By.xpath(environmental_dropdown)).click();
        String environmentalSticker_xpath = "//div[contains(text(),'" + sticker + "')]";
        Utils.pause(100, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(environmentalSticker_xpath)).click();
        testBase.getdriver().findElement(By.xpath(chassisNummer_input)).sendKeys(chassisnummer);
        testBase.getdriver().findElement(By.xpath(roadLicence_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(diesel_filter_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(newMOT_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
        Gauge.captureScreenshot();
    }


    @Step("For Bulldozer Adding more data for interior, Exterieur and safety with all the option checked")
    public void addInteriorDataBulldozer() throws AWTException {
        testBase.waitForElementVisibleXpath(waitTime, centralLubricationUnit_lbl);
        testBase.verifyElementPresence(centralLubricationUnit_lbl);
        testBase.getdriver().findElement(By.xpath(centralLubricationUnit_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(image_btn)).click();
        Utils.pause(1000, "wait for element load on the page");
        add_Photos("D:\\IDEA\\AutoEuroStocks\\resources\\interior\\testimageInterior.jpg");
        Utils.pause(10000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, BSS_lbl);
        testBase.verifyElementPresence(BSS_lbl);
        testBase.getdriver().findElement(By.xpath(BSS_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(mechanicalQuickCoupling_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime, ABS_lbl);
        testBase.verifyElementPresence(ABS_lbl);
        testBase.getdriver().findElement(By.xpath(abs_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fourWheelDrive_chkbox)).click();
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
    }

}