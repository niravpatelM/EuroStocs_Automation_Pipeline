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
import org.openqa.selenium.Keys;

/**
 * @author niravpatel
 */

public class EuroStocksSearchingMobileDe extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Searching functionality for mobile de <table>")
    public void searchFuncForMobileDe(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Ads overzicht")) {
                commanCodeForSearching("Ads overzicht", 2);
            }else if (listOptions.equalsIgnoreCase("Mobile.de accounts")) {
                commanCodeForSearching("Mobile.de accounts", 3);
            }else if (listOptions.equalsIgnoreCase("mobile.de verzoek details")) {
                //commanCodeForSearching("Mobile.de accounts", 3);
                testBase.waitForElementVisibleXpath(waitTime, mobileDeAccountsDetails_opt);
                testBase.getdriver().findElement(By.xpath(mobileDeAccountsDetails_opt)).click();
                Gauge.writeMessage("No List available for searching and sorting record");
            }else if (listOptions.equalsIgnoreCase("mobile.de mapping")) {
                //commanCodeForSearching("Mobile.de accounts", 3);
                testBase.waitForElementVisibleXpath(waitTime, mobileDeAccountsMapping_opt);
                testBase.getdriver().findElement(By.xpath(mobileDeAccountsMapping_opt)).click();
                Gauge.writeMessage("List available for searching and sorting record but no data present in the list");
            }
        }
    }


    @Step("Verify Searching functionality for Assortiment <table>")
    public void searchFuncForAssortiment(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Categorieën")) {
                commanCodeForSearching("Categorieën", 2);
            }else if (listOptions.equalsIgnoreCase("Kenmerken")) {
                commanCodeForSearching("Kenmerken", 2);
            }else if (listOptions.equalsIgnoreCase("Eigenschappen")) {
                commanCodeForSearching("Eigenschappen", 3);
            }
        }
    }

    private void commanCodeForSearching(String business, int count) {
        if(business.equalsIgnoreCase("Ads overzicht")) {
            testBase.getdriver().findElement(By.xpath(mobile_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, adsOverzicht_opt);
            testBase.getdriver().findElement(By.xpath(adsOverzicht_opt)).click();
        }else if (business.equalsIgnoreCase("Mobile.de accounts")) {
            testBase.getdriver().findElement(By.xpath(mobile_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, mobileDeAccounts_opt);
            testBase.getdriver().findElement(By.xpath(mobileDeAccounts_opt)).click();
        }else if (business.equalsIgnoreCase("Categorieën")) {
            testBase.getdriver().findElement(By.xpath(assortiment_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, categorieën_opt);
            testBase.getdriver().findElement(By.xpath(categorieën_opt)).click();
        }else if (business.equalsIgnoreCase("Kenmerken")) {
            testBase.getdriver().findElement(By.xpath(assortiment_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, kenmerken_opt);
            testBase.getdriver().findElement(By.xpath(kenmerken_opt)).click();
        }else if (business.equalsIgnoreCase("Eigenschappen")) {
            testBase.getdriver().findElement(By.xpath(assortiment_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, eigenschappen_opt);
            testBase.getdriver().findElement(By.xpath(eigenschappen_opt)).click();
        }
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        Utils.pause(5000, "wait to load the data on the list");
        if (count == 2 && business.equalsIgnoreCase("Ads overzicht")) {
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String item_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(adsMobileDe_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(adsMobileDe_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(adsMobileDe_search_fld)).sendKeys(company_name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(adsMobileDe_search_fld)).sendKeys(item_no);
                }
                testBase.getdriver().findElement(By.xpath(adsMobileDe_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String company_name_xpath = "//td[contains(text(),'" + company_name + "')]";
                String item_noe_xpath = "//a[contains(text(),'" + item_no + "')]";
                testBase.verifyElementPresence(company_name_xpath);
                testBase.verifyElementPresence(item_noe_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Mobile.de accounts")) {
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            String item_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
            String api_code = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[5]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).sendKeys(company_name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).sendKeys(item_no);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).sendKeys(api_code);
                }
                testBase.getdriver().findElement(By.xpath(accountsMobileDe_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String company_name_xpath = "//td[contains(text(),'" + company_name + "')]";
                String item_no_xpath = "//td[contains(text(),'" + item_no + "')]";
                String api_code_xpath = "//td[contains(text(),'" + api_code + "')]";
                testBase.verifyElementPresence(company_name_xpath);
                testBase.verifyElementPresence(item_no_xpath);
                testBase.verifyElementPresence(api_code_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("Categorieën")) {
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[1]")).getText();
            String key = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(categories_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(categories_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(categories_search_fld)).sendKeys(name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(categories_search_fld)).sendKeys(key);
                }
                testBase.getdriver().findElement(By.xpath(categories_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String name_xpath = "//td//a[contains(text(),'" + name + "')]";
                String api_xpath = "//td[contains(text(),'" + key + "')]";
                testBase.verifyElementPresence(name_xpath);
                testBase.verifyElementPresence(api_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("Kenmerken")) {
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[6]//td[1]")).getText();
            String key = testBase.getdriver().findElement(By.xpath("//tbody//tr[6]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(characteristics_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(characteristics_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(characteristics_search_fld)).sendKeys(name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(characteristics_search_fld)).sendKeys(key);
                }
                testBase.getdriver().findElement(By.xpath(characteristics_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String name_xpath = "//td//a[contains(text(),'" + name + "')]";
                String api_xpath = "//td[contains(text(),'" + key + "')]";
                testBase.verifyElementPresence(name_xpath);
                testBase.verifyElementPresence(api_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Eigenschappen")) {
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[4]//td[1]")).getText();
            String key = testBase.getdriver().findElement(By.xpath("//tbody//tr[4]//td[2]")).getText();
            String validatType = testBase.getdriver().findElement(By.xpath("//tbody//tr[4]//td[4]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(properties_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(properties_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(properties_search_fld)).sendKeys(name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(properties_search_fld)).sendKeys(key);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(properties_search_fld)).sendKeys(validatType);
                }
                testBase.getdriver().findElement(By.xpath(properties_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String name_xpath = "//td//a[contains(text(),'" + name + "')]";
                String api_xpath = "//td[contains(text(),'" + key + "')]";
                String validateType_xpath = "//td[contains(text(),'" + validatType + "')]";
                testBase.verifyElementPresence(name_xpath);
                testBase.verifyElementPresence(api_xpath);
                testBase.verifyElementPresence(validateType_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        }
    }
}