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

public class EuroStocksSortingMobileDe extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("Verify Sorting functionality for below list for Mobile.de <table>")
    public void sortFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Ads overzicht")) {
                commanCodeForSort("Ads overzicht", 3);
            } else if (listOptions.equalsIgnoreCase("Mobile.de accounts")) {
                commanCodeForSort("Mobile.de accounts", 4);
            } else if (listOptions.equalsIgnoreCase("mobile.de verzoek details")) {
                commanCodeForSort("mobile.de verzoek details", 0);
            } else if (listOptions.equalsIgnoreCase("mobile.de mapping")) {
                commanCodeForSort("mobile.de mapping", 2);
            }
        }
    }

    private void commanCodeForSort(String business, int count) {
        if(business.equalsIgnoreCase("Ads overzicht") && count == 3) {
            testBase.waitForElementVisibleXpath(waitTime, mobile_opt);
            testBase.getdriver().findElement(By.xpath(mobile_opt)).click();
            Utils.pause(500, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(adsOverzicht_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Kundennr", "//tbody//tr[1]//td[3]");
                } else if (i == 1) {
                    sortingCode("Actief op mobile.de", "//tbody//tr[1]//td[5]");
                } else if (i == 2) {
                    sortingCode("Actief op Eurostocks", "//tbody//tr[1]//td[6]");
                }
            }
        }else if (business.equalsIgnoreCase(("Mobile.de accounts")) && count == 4){
            testBase.getdriver().findElement(By.xpath(mobileDeAccounts_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Gebruikersnaam", "//tbody//tr[1]//td[2]");
                } else if (i == 1) {
                    sortingCode("Bedrijfsnaam", "//tbody//tr[1]//td[3]");
                } else if (i == 2) {
                    sortingCode("Kundennr.", "//tbody//tr[1]//td[4]");
                } else if (i == 3) {
                    sortingCode("API code", "//tbody//tr[1]//td[5]");
                }
            }
        }else if (business.equalsIgnoreCase(("mobile.de verzoek details")) && count == 0){
            testBase.getdriver().findElement(By.xpath(mobileDeAccountsDetails_opt)).click();
            Utils.pause(5000, "wait for element load on the page");
            Gauge.writeMessage("No List available for sorting data for: "+business);
        }else if (business.equalsIgnoreCase(("mobile.de mapping")) && count == 2){
            testBase.getdriver().findElement(By.xpath(mobileDeAccountsMapping_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            Gauge.writeMessage("List available for sorting data but data is not present for: "+business);
        }
    }

    private void sortingCode(String option, String elePath) {
        testBase.waitForElementVisibleXpath(waitTime, "//th[contains(text(),'" + option + "')]");
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        if(option.equalsIgnoreCase("Kundennr") || option.equalsIgnoreCase("Actief op mobile.de") || option.equalsIgnoreCase("Actief op Eurostocks")){
            Utils.pause(500, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        }
        Utils.pause(2500, "wait for element load on the page");
        String descData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("descnding: " + descData);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        String ascData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("asceding: " + ascData);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        if (option.equalsIgnoreCase("Kundennr") || option.equalsIgnoreCase("Gebruikersnaam")) {
            String desc_xpath = "" + elePath + "//a[contains(text(),'" + descData + "')]";
            testBase.verifyElementPresence(desc_xpath);
        }else {
            if(option.equalsIgnoreCase("Bedrijfsnaam")){
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else{
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        }
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        if (option.equalsIgnoreCase("Kundennr") || option.equalsIgnoreCase("Gebruikersnaam")) {
            String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        } else {
            String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        }
        Gauge.captureScreenshot();
    }
}