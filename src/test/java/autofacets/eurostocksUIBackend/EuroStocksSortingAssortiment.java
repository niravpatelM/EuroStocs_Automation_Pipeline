package autofacets.eurostocksUIBackend;

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

public class EuroStocksSortingAssortiment extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Sorting functionality for below list for Assortiment <table>")
    public void sortFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Categorieën")) {
                commanCodeForSort("Categorieën", 3);
            }else if (listOptions.equalsIgnoreCase("Kenmerken")) {
                commanCodeForSort("Kenmerken", 4);
            }else if (listOptions.equalsIgnoreCase("Eigenschappen")) {
                commanCodeForSort("Eigenschappen", 5);
            }
        }
    }

    @Step("Verify Sorting functionality for below list for tools <table>")
    public void sortFuncForListModulesTools(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Bulk wijzigen")) {
                commanCodeForSort("Bulk wijzigen", 0);

            }
        }
    }

    private void commanCodeForSort(String business, int count) {
        if (business.equalsIgnoreCase("Categorieën") && count == 3) {
            testBase.waitForElementVisibleXpath(waitTime, assortiment_opt);
            testBase.getdriver().findElement(By.xpath(assortiment_opt)).click();
            Utils.pause(500, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(categorieën_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(3000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Naam", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Key", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("Kenmerken")) && count == 4){
            testBase.getdriver().findElement(By.xpath(kenmerken_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Naam", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Key", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Display Tekst", "//tbody//tr[1]//td[3]");
                } else if (i == 3) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[4]");
                }
            }
        } else if (business.equalsIgnoreCase(("Eigenschappen")) && count == 5){
            testBase.getdriver().findElement(By.xpath(eigenschappen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Naam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Key", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Display Text", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Validatietype", "//tbody//tr[1]//td[4]");
                }else if (i == 4) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[5]");
                }
            }
        } else if (business.equalsIgnoreCase(("Bulk wijzigen")) && count == 0){
            testBase.waitForElementVisibleXpath(waitTime,tools_opt);
            testBase.getdriver().findElement(By.xpath(tools_opt)).click();
            Utils.pause(500, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(bulkWijzigen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            Gauge.writeMessage("List available for sorting data but data is not present for: "+business);
        }
    }

    private void sortingCode(String option, String elePath) {
        testBase.waitForElementVisibleXpath(waitTime, "//th[contains(text(),'" + option + "')]");
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        String descData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("descnding: " + descData);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        String ascData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("asceding: " + ascData);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        boolean value = option.equalsIgnoreCase("Kundennr") || option.equalsIgnoreCase("Gebruikersnaam") || option.equalsIgnoreCase("Naam");
        if (value) {
            String desc_xpath = "" + elePath + "//a[contains(text(),'" + descData + "')]";
            testBase.verifyElementPresence(desc_xpath);
        }else {
            String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
            testBase.verifyElementPresence(desc_xpath);
        }
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        if (value) {
            String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        } else {
            String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        }
        Gauge.captureScreenshot();
    }
}