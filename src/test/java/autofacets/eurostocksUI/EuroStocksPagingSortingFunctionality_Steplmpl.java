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

/**
 * @author niravpatel
 */

public class EuroStocksPagingSortingFunctionality_Steplmpl extends EuroStocksTest implements WebLocators.Homepage {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;
    private String a_z_label, z_a_label, laa_hoog_label, hoog_laag_label, oud_nieuw_label, nieuw_oud_label;

    @Step("Verify Pagination button visible on screen")
    public void verifyPaginationButton() {
        testBase.waitForElementVisibleXpath(waitTime, pagination_options);
        testBase.scrollDownPageToElement(30, testBase.getdriver().findElement(By.xpath(pagination_options)));
        testBase.verifyElementPresence(pagination_options);
        Gauge.captureScreenshot();
    }

    @Step("Verify Pagination functionality with switching other options <option>")
    public void verifyPaginationFunctionality(String option) {
        String currentURL = testBase.getdriver().getCurrentUrl();
        if (currentURL.contains("p=1")) {
            Gauge.writeMessage("user on first page ");
            Gauge.captureScreenshot();
        }
        String nextOption_xpath = "//*[@class='pagination']//a[@id='page_" + option + "']";
        testBase.getdriver().findElement(By.xpath(nextOption_xpath)).click();
        String nextURL = testBase.getdriver().getCurrentUrl();
        if (nextURL.contains("p=" + option + "")) {
            Gauge.writeMessage("user on passed " + option + " Page ");
            Gauge.captureScreenshot();
        }
    }

    @Step("Verify Sorting button visible on screen")
    public void verifySortingButton() {
        testBase.waitForElementVisibleXpath(waitTime, sorting_options);
        testBase.verifyElementPresence(sorting_options);
        Gauge.captureScreenshot();
    }

    @Step("Change with other Sorting option and get the data for first section <site> <table>")
    public void getDataforEachSortOption(String site, Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String sortOption = tableRow.getCell("SortingOption");
            commanCode(sortOption,site);
            String sortOption_data;
            if(site.equalsIgnoreCase("eurostocks")){
                sortOption_data = testBase.getdriver().findElement(By.xpath(firstSection_option)).getText();
            }else{
                sortOption_data = testBase.getdriver().findElement(By.xpath(firstSectionDealer_option)).getText();
            }
            String lines[];
            if (sortOption.equalsIgnoreCase("Titel volgorde (a-z)")) {
                lines = sortOption_data.split("\\r?\\n");
                a_z_label = lines[0];
            } else if (sortOption.equalsIgnoreCase("Titel volgorde (z-a)")) {
                lines = sortOption_data.split("\\r?\\n");
                z_a_label = lines[0];
            } else if (sortOption.equalsIgnoreCase("Prijs (laag-hoog)")) {
                lines = sortOption_data.split("\\r?\\n");
                laa_hoog_label = lines[0];
            } else if (sortOption.equalsIgnoreCase("Prijs (hoog-laag)")) {
                lines = sortOption_data.split("\\r?\\n");
                hoog_laag_label = lines[0];
            } else if (sortOption.equalsIgnoreCase("Datum (oud-nieuw)")) {
                lines = sortOption_data.split("\\r?\\n");
                oud_nieuw_label = lines[0];
            } else if (sortOption.equalsIgnoreCase("Datum (nieuw-oud)")) {
                lines = sortOption_data.split("\\r?\\n");
                nieuw_oud_label = lines[0];
            }
            Gauge.captureScreenshot();
        }
    }

    @Step("Verify all options with data of first section <site> <table>")
    public void verifingData(String site,Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String sortOption = tableRow.getCell("SortingOption");
            commanCode(sortOption,site);
            String data_xpath;
            if (sortOption.equalsIgnoreCase("Titel volgorde (a-z)")) {
                data_xpath = "//a//h5[normalize-space()='"+a_z_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            } else if (sortOption.equalsIgnoreCase("Titel volgorde (z-a)")) {
                data_xpath = "//a//h5[normalize-space()='"+z_a_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            } else if (sortOption.equalsIgnoreCase("Prijs (laag-hoog)")) {
                data_xpath = "//a//h5[normalize-space()='"+laa_hoog_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            } else if (sortOption.equalsIgnoreCase("Prijs (hoog-laag)")) {
                data_xpath = "//a//h5[normalize-space()='"+hoog_laag_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            } else if (sortOption.equalsIgnoreCase("Datum (oud-nieuw)")) {
                data_xpath = "//a//h5[normalize-space()='"+oud_nieuw_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            } else if (sortOption.equalsIgnoreCase("Datum (nieuw-oud)")) {
                data_xpath = "//a//h5[normalize-space()='"+nieuw_oud_label+"']";
                testBase.waitForElementVisibleXpath(waitTime,data_xpath);
                testBase.verifyElementPresence(data_xpath);
            }
            Gauge.captureScreenshot();
        }
    }

    private void commanCode(String option, String site){
        testBase.waitForElementVisibleXpath(waitTime, sorting_options);
        testBase.verifyElementPresence(sorting_options);
        testBase.getdriver().findElement(By.xpath(sorting_options)).click();
        Utils.pause(1000);
        String products_xpath = "//option[contains(text(),'" + option + "')]";
        testBase.waitForElementVisibleXpath(waitTime, products_xpath);
        testBase.verifyElementPresence(products_xpath);
        testBase.getdriver().findElement(By.xpath(products_xpath)).click();
        Utils.pause(2000);
        if(site.equalsIgnoreCase("eurostocks")){
            testBase.waitForElementVisibleXpath(waitTime, firstSection_option);
        }else{
            testBase.waitForElementVisibleXpath(waitTime, firstSectionDealer_option);
        }
    }
}