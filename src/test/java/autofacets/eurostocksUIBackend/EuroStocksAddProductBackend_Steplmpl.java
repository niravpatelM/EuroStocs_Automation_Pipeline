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
import java.awt.*;

/**
 * @author niravpatel
 */

public class EuroStocksAddProductBackend_Steplmpl extends EuroStocksTest implements WebLocators.AddProductPageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Redirect to Add Product page and click on add product")
    public void redirectToAddProduct() {
        testBase.getdriver().findElement(By.xpath(producten_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        testBase.getdriver().findElement(By.xpath(add_product_btn)).click();
    }

    @Step("Verify add product page")
    public void verifyAddProductPage() {
        testBase.waitForElementVisibleXpath(waitTime, product_information_lbl);
        testBase.waitForElementVisibleXpath(waitTime, verify_lbl);
        testBase.verifyElementPresence(verify_lbl);
        Gauge.captureScreenshot();
    }

    @Step("Add product Type <Auto onderdelen> and <text>, <text>")
    public void addProductType(String text, String textRemain, String textRemains) {
        testBase.verifyElementPresence(product_type_input);
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(product_type_input)).click();
        testBase.getdriver().findElement(By.xpath(product_type_input)).clear();
        testBase.getdriver().findElement(By.xpath(product_type_input)).sendKeys(text);
        testBase.waitForElementVisibleXpath(waitTime, suggestion_option);
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(product_type_input)).sendKeys(textRemain);
        testBase.waitForElementVisibleXpath(waitTime, suggestion_option);
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(product_type_input)).sendKeys(textRemains);
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(product_type_input)).sendKeys(Keys.ENTER);
        Gauge.captureScreenshot();
    }

    @Step("Add product Title <title> and <desc>")
    public void addProductTitle(String title, String desc) {
        testBase.waitForElementVisibleXpath(waitTime, title_lbl);
        testBase.verifyElementPresence(title_lbl);
        Utils.pause(3000, "wait for element load on the page");
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(all_field_chkbox)));
        testBase.getdriver().findElement(By.xpath(all_field_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(title_input)).click();
        testBase.getdriver().findElement(By.xpath(title_input)).clear();
        testBase.getdriver().findElement(By.xpath(title_input)).sendKeys(title);
        testBase.getdriver().findElement(By.xpath(desc_input)).click();
        testBase.getdriver().findElement(By.xpath(desc_input)).sendKeys(desc);
        Gauge.captureScreenshot();
    }

    @Step("Select Brand <text> model <> and type <> while adding product")
    public void selectBrandModelType(String brand, String model, String type) {
        testBase.scrollPage(500);
        testBase.waitForElementVisibleXpath(waitTime, brand_drpdown);
        testBase.getdriver().findElement(By.xpath(brand_drpdown)).click();
        String brand_xpath = "//option[contains(text(),'" + brand + "')]";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(brand_xpath)).click();
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(model_drpdown)).click();
        String model_xpath = "//label[contains(text(),'" + model + "') and @class='checkbox']";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(model_xpath)).click();
        Utils.pause(2000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(type_drpdown)).click();
        String type_xpath = "//label[contains(text(),'" + type + "') and @class='checkbox']";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(type_xpath)).click();
        Utils.pause(1000, "wait for element load on the page");
        //testBase.getdriver().findElement(By.xpath("//*[@class='fa fa-plus']")).click();
        Gauge.captureScreenshot();
    }

    @Step("Select Brand <text> model <> and type <> while adding product with second options")
    public void selectBrandModelTypeSecond(String brand, String model, String type) {
        testBase.pause(1000, "wait for element load on the page");
        testBase.waitForElementVisibleXpath(waitTime, brand_drpdown);
        testBase.getdriver().findElement(By.xpath("(//select[@id='merk'])[2]")).click();
        String brand_xpath = "//option[contains(text(),'" + brand + "')]";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(brand_xpath)).click();
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath("(//select[@id='model']//following-sibling::div[@class='btn-group']//*[@class='multiselect dropdown-toggle btn btn-default'])[2]")).click();
        String model_xpath = "//label[contains(text(),'" + model + "') and @class='checkbox']";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(model_xpath)).click();
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath("(//select[@id='type']//following-sibling::div[@class='btn-group']//*[@class='multiselect dropdown-toggle btn btn-default'])[2]")).click();
        String type_xpath = "//label[contains(text(),'" + type + "') and @class='checkbox']";
        testBase.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(type_xpath)).click();
        Utils.pause(1000, "wait for element load on the page");
    }

    @Step("Select condition <Nieuw> while adding product")
    public void selectCondition(String cond) {
        //testBase.scrollPage(50);
        testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(cond_drpdown)));
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(cond_drpdown)).click();
        Utils.pause(1000, "wait for element load on the page");
        String option_xpath = "//div[contains(text(),'" + cond + "')]";
        testBase.getdriver().findElement(By.xpath(option_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Select option and price on request")
    public void selectSomeOption() {
        testBase.scrollPage(20);
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(merge_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(price_on_request_chkbox)).click();
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(BTW_chkbox)).click();
        Gauge.captureScreenshot();
    }

    @Step("Adding stocks <22> and select some required option enter warehouse location <> and Internal number <>")
    public void addStocksAndSelectOption(String stocks, String location, String internalNumber) {
        testBase.scrollPage(200);
        Utils.pause(1000, "wait for element load on the page");
        testBase.scrollDownPageToElement(60, testBase.getdriver().findElement(By.xpath(stocks_input)));
        testBase.getdriver().findElement(By.xpath(stocks_input)).click();
        testBase.getdriver().findElement(By.xpath(stocks_input)).sendKeys(stocks);
        testBase.getdriver().findElement(By.xpath(product_activate_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(allow_payment_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(warehouser_location__input)).click();
        testBase.getdriver().findElement(By.xpath(warehouser_location__input)).sendKeys(location);
        testBase.getdriver().findElement(By.xpath(internal_number__input)).click();
        testBase.getdriver().findElement(By.xpath(internal_number__input)).sendKeys(internalNumber);
        Gauge.captureScreenshot();
    }

    @Step("Select Episode Option <>")
    public void selectEpisode(String episode) {
        /*testBase.scrollPage(400);
        Utils.pause(1000, "wait for element load on the page");*/
        testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(episode_drpdown)));
        testBase.getdriver().findElement(By.xpath(episode_drpdown)).click();
        Utils.pause(1000, "wait for element load on the page");
        String option_xpath = "//div[contains(text(),'" + episode + "')]";
        testBase.getdriver().findElement(By.xpath(option_xpath)).click();
        Gauge.captureScreenshot();
    }

    @Step("Enter other options like weight <> Dimensions <> <> <> , Special shipping rate <>, Part number (s) <> and EAN nummer <>")
    public void addingOtherOptions(String weight, String dimensionsL, String dimensionsB, String dimensionsH, String shippingRate, String partNumber, String EANNumber) {
        testBase.scrollPage(300);
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(weight_input)).sendKeys(weight);
        testBase.getdriver().findElement(By.xpath(dimensionL_input)).sendKeys(dimensionsL);
        testBase.getdriver().findElement(By.xpath(dimensionB_input)).sendKeys(dimensionsB);
        testBase.getdriver().findElement(By.xpath(dimensionH_input)).sendKeys(dimensionsH);
        testBase.getdriver().findElement(By.xpath(specialShippingRate_input)).sendKeys(shippingRate);
        if (partNumber.equalsIgnoreCase("null")) {
            testBase.getdriver().findElement(By.xpath(articleNo_input)).sendKeys(EANNumber);
        } else {
            testBase.getdriver().findElement(By.xpath(orderNo_input)).sendKeys(partNumber);
        }
        testBase.getdriver().findElement(By.xpath(EAN_input)).sendKeys(EANNumber);
        Gauge.captureScreenshot();
    }

    @Step("Select all other option from Characteristics select Damaged option as <Yes> and Mounting possible <Yes> add Fitting Costs <>")
    public void selectOtherOptionFromCharacteristics(String damageOption, String mountingOption, String fittingCosts) {
        testBase.scrollPage(300);
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
        Utils.pause(1000, "wait for element load on the page");
        if (damageOption.contains("Yes")) {
            testBase.getdriver().findElement(By.xpath(yes_chkbox)).click();
        } else {
        }
        if (mountingOption.contains("Ja")) {
            testBase.getdriver().findElement(By.xpath(mounting_drpdown)).click();
            Utils.pause(1000, "wait for element load on the page");
            String option_xpath = "//div[contains(text(),'" + mountingOption + "')]";
            testBase.getdriver().findElement(By.xpath(option_xpath)).click();
        } else {
        }
        testBase.scrollPage(500);
        Utils.pause(1000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fitting_costs_input)).click();
        testBase.getdriver().findElement(By.xpath(fitting_costs_input)).sendKeys(fittingCosts);
        Gauge.captureScreenshot();
    }

    @Step("Select all other option from Characteristics section for <Auto oprijplaten>, <ja>, <brand>, <modal>")
    public void selectAllOtherOptionFromCharacteristics(String product, String checked, String brand, String modelType) {
        if (product.equalsIgnoreCase("Auto oprijplaten")) {
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(damage_chkbox)).click();
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
        } else if (product.equalsIgnoreCase("Beugel")) {
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(yes_chkbox)).click();
            testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(mounting_drpdown)));
            testBase.getdriver().findElement(By.xpath(mounting_drpdown)).click();
            String option_xpath = "//div[contains(text(),'" + brand + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(option_xpath)).click();
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(modelType_input)).sendKeys(modelType);
        } else if (product.equalsIgnoreCase("Voorbumper")) {
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(damage_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(mounting_drpdown)).click();
            String option_xpath = "//div[contains(text(),'" + brand + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(option_xpath)).click();
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(colorCode_input)).sendKeys("22EX24");
            testBase.getdriver().findElement(By.xpath(assemblycosts_input)).sendKeys("254");
        } else if (product.equalsIgnoreCase("Sneeuwketting")) {
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
        } else{
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(damage_chkbox)).click();
            testBase.getdriver().findElement(By.xpath(mounting_drpdown)).click();
            String option_xpath = "//div[contains(text(),'" + brand + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(option_xpath)).click();
            testBase.getdriver().findElement(By.xpath(priceType_drpdown)).click();
            String modal_xpath = "//div[contains(text(),'" + modelType + "')]";
            Utils.pause(100, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(modal_xpath)).click();
            testBase.scrollDownPageToElement(100, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
        }
        Gauge.captureScreenshot();
    }


    @Step("click on save and next button")
    public void clickOnsSaveAndNext() {
        testBase.scrollDownPageToElement(0, testBase.getdriver().findElement(By.xpath(save_next_btn)));
        testBase.getdriver().findElement(By.xpath(save_next_btn)).click();
        Gauge.captureScreenshot();
    }

    @Step("Verifying adding Photo page and add some photos to product <label> <path>")
    public void verifyPageAndAddPhotos(String label, String photoPath) throws AWTException {
        String xpath = "//h3[contains(text(),'" + label + "')]";
        testBase.waitForElementVisibleXpath(waitTime, xpath);
        testBase.verifyElementPresence(xpath);
        Utils.pause(3000, "wait for element load on the page");
        testBase.getdriver().findElement(By.xpath(browse_btn)).click();
        Utils.pause(4000, "wait for element load on the page");
        add_PhotosVehicle("D:\\IDEA\\AutoEuroStocks\\resources\\" + photoPath + "\\");
        Utils.pause(10000, "wait for element load on the page");
        Gauge.captureScreenshot();
        testBase.scrollDownPageToElement(0,testBase.getdriver().findElement(By.xpath(publish_btn)));
        testBase.getdriver().findElement(By.xpath(publish_btn)).click();
    }





    @Step("verify newly added product on the list <AUT DATA Beugel 04C109022NN>, <04C109088NN22>, <Beugel>")
    public void verifyNewlyAddedProduct(String title, String articleNumber, String productType) {
        testBase.waitForElementVisibleXpath(waitTime,table_data);
        Utils.pause(2000, "wait to element load on the page");
        String title_xpath = "//tbody//tr[1]//td[3]//a[contains(text(),'"+title+"')]";
        String articleNumber_xpath = "//tbody//tr[1]//td[5]//span[contains(text(),'"+articleNumber+"')]";
        String productType_xpath = "//tbody//tr[1]//td[6][contains(text(),'"+productType+"')]";
        testBase.verifyElementPresence(title_xpath);
        testBase.verifyElementPresence(articleNumber_xpath);
        testBase.verifyElementPresence(productType_xpath);
        Gauge.captureScreenshot();
    }


    @Step("Redirect to product page and Verify page")
    public void verifyProductPage() {
        testBase.getdriver().findElement(By.xpath(producten_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
    }


    @Step("Update product status with any one product from the list and verify status updated for product")
    public void updateStatusAndVerify() {
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[3]")));
        String product_name = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        WebElement webElementtitle = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[12]/span"));
        String title = webElementtitle.getAttribute("title");
        WebElement webElement = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[1]/div/input"));
        String get_id = webElement.getAttribute("id");
        testBase.getdriver().findElement(By.xpath("//input[@id='" + get_id + "']")).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(uitvoeren_btn)));
        testBase.getdriver().findElement(By.xpath(uitvoeren_btn)).click();
        Utils.pause(5000, "wait for element load on the page");
        WebElement webElementtitleupdate = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[12]/span"));
        String title_update = webElementtitleupdate.getAttribute("title");
        System.out.println(title_update);
        String verifyUpdatedXpath = "//tbody/tr[1]/td[12]/span[@title='"+title_update+"']";
        testBase.verifyElementPresence(verifyUpdatedXpath);
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