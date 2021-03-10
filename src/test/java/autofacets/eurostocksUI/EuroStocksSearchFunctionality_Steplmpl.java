package autofacets.eurostocksUI;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * @author niravpatel
 */

public class EuroStocksSearchFunctionality_Steplmpl extends EuroStocksTest implements WebLocators.Homepage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("Click on Search Button and Enter text to search <search text>")
    public void enterTextForSearch(String searchText) {
        Utils.pause(2000,"wait to element load on page");
        testBase.waitForElementVisibleXpath(waitTime, search_fld);
        testBase.verifyElementPresence(search_fld);
        testBase.getdriver().findElement(By.xpath(search_fld)).click();
        testBase.getdriver().findElement(By.xpath(search_fld)).sendKeys(searchText);
        testBase.getdriver().findElement(By.xpath(search_fld)).sendKeys(Keys.ENTER);
        Gauge.captureScreenshot();
    }

    @Step("Verify Search Result Completed <status>")
    public void verifySearchResultCompleted(String status) {
        testBase.waitForElementVisibleXpath(waitTime, search_result);
        testBase.verifyElementPresence(search_result);
        if (status.equalsIgnoreCase("valid")) {
            testBase.verifyElementPresence(search_result_found);
        } else {
            testBase.verifyElementPresence(search_result_notfound);
        }
        Gauge.captureScreenshot();
    }

    @Step("Verify Search Result Completed <status> for dealer website")
    public void verifySearchResultCompletedDealer(String status) {
        testBase.waitForElementVisibleXpath(waitTime, searchDealer_result);
        testBase.verifyElementPresence(searchDealer_result);
        if (status.equalsIgnoreCase("valid")) {
            testBase.verifyElementPresence(searchResultDealer_found);
        } else {
            testBase.verifyElementPresence(search_result_notfound);
        }
        Gauge.captureScreenshot();
    }

    @Step("Change category search and Verify search <table>")
    public void implementation1(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String searchOption = tableRow.getCell("CategorySearch");
            System.out.println(searchOption);
            testBase.waitForElementVisibleXpath(waitTime, dropdownMain_btn);
            testBase.verifyElementPresence(dropdownMain_btn);
            testBase.getdriver().findElement(By.xpath(dropdownMain_btn)).click();
            Utils.pause(1000,"wait to element load on page");
            String products_xpath = "//option[contains(text(),'" + searchOption + "')]";
            testBase.waitForElementVisibleXpath(waitTime, products_xpath);
            testBase.verifyElementPresence(products_xpath);
            testBase.getdriver().findElement(By.xpath(products_xpath)).click();
            testBase.getdriver().findElement(By.xpath(searchMain_btn)).click();
            String verify_xpath = "//h1[contains(text(),'Resultaten voor " + searchOption + "')]";
            testBase.waitForElementVisibleXpath(waitTime, verify_xpath);
            testBase.verifyElementPresence(verify_xpath);
            Gauge.captureScreenshot();
        }
    }

    @Step("Select option from dropdown list <Auto onderdelen>")
    public void selectOptionfromDropdown(String option) {
        testBase.waitForElementVisibleXpath(waitTime, dropdownMain_btn);
        testBase.verifyElementPresence(dropdownMain_btn);
        testBase.getdriver().findElement(By.xpath(dropdownMain_btn)).click();
        Utils.pause(1000,"wait to element load on page");
        String products_xpath = "//option[contains(text(),'" + option + "')]";
        testBase.waitForElementVisibleXpath(waitTime, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        testBase.getdriver().findElement(By.xpath(searchMain_btn)).click();
    }

    @Step("Verify auto search dropdown with option")
    public void verifySearchResultCompleted() {
        testBase.getdriver().findElement(By.xpath(search_fld)).click();
        testBase.waitForElementVisibleXpath(waitTime,autoSearch_drpdown);
        testBase.verifyElementPresence(autoSearch_drpdown);
        Utils.pause(5000,"wait to element load on page");
        testBase.verifyElementPresence(autoSearch_options);
        testBase.waitForElementVisibleXpath(waitTime,autoSearch_options);
        testBase.getdriver().findElement(By.xpath(autoSearch_options)).click();
        testBase.waitForElementVisibleXpath(waitTime,search_result);
        testBase.verifyElementPresence(search_result);
        Gauge.captureScreenshot();
    }

    @Step("Verify auto search dropdown with option for dealer website")
    public void verifySearchResultCompletedDealer() {
        testBase.getdriver().findElement(By.xpath(search_fld)).click();
        testBase.waitForElementVisibleXpath(waitTime,autoSearch_drpdown);
        testBase.verifyElementPresence(autoSearch_drpdown);
        Utils.pause(5000,"wait to element load on page");
        testBase.verifyElementPresence(autoSearch_options);
        testBase.waitForElementVisibleXpath(waitTime,autoSearch_options);
        testBase.getdriver().findElement(By.xpath(autoSearch_options)).click();
        testBase.waitForElementVisibleXpath(waitTime,searchDealer_result);
        testBase.verifyElementPresence(searchDealer_result);
        Gauge.captureScreenshot();
    }
}