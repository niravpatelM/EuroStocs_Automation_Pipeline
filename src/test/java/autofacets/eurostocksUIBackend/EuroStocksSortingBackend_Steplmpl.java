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

public class EuroStocksSortingBackend_Steplmpl extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Sorting functionality for below list <table>")
    public void sortFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Bedrijven")) {
                commanCodeForSort("Bedrijven", 5);
            } else if (listOptions.equalsIgnoreCase("Locations")) {
                commanCodeForSort("Locations", 4);
            } else if (listOptions.equalsIgnoreCase("Websites")) {
                commanCodeForSort("Websites", 3);
            } else if (listOptions.equalsIgnoreCase("Bestellingen")) {
                commanCodeForSort("Bestellingen", 7);
            }else if (listOptions.equalsIgnoreCase("Lead Management")) {
                commanCodeForSort("Lead Management", 9);
            } else if (listOptions.equalsIgnoreCase("Aanvragen")) {
                commanCodeForSort("Aanvragen", 6);
            }
        }
    }

    private void commanCodeForSort(String business, int count) {
        if (business.equalsIgnoreCase("Bedrijven") && count == 5) {
            testBase.waitForElementVisibleXpath(waitTime, business_opt);
            testBase.getdriver().findElement(By.xpath(business_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Klant #", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Bedrijfsnaam", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Maandbedrag", "//tbody//tr[1]//td[3]");
                } else if (i == 3) {
                    sortingCode("Actieve producten", "//tbody//tr[1]//td[4]");
                } else if (i == 4) {
                    sortingCode("Actieve voertuigen", "//tbody//tr[1]//td[5]");
                }
            }
        } else if (business.equalsIgnoreCase("Locations") && count == 4) {
            testBase.waitForElementVisibleXpath(waitTime, locations_opt);
            testBase.getdriver().findElement(By.xpath(locations_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Bedrijfsnaam", "//tbody//tr[1]//td[2]");
                } else if (i == 1) {
                    sortingCode("Locatienaam", "//tbody//tr[1]//td[3]");
                } else if (i == 2) {
                    sortingCode("Stad", "//tbody/tr[1]/td[4]");
                } else if (i == 3) {
                    sortingCode("URL", "//tbody/tr[1]//td[5]");
                }
            }
        } else if (business.equalsIgnoreCase("Websites") && count == 3) {
            testBase.waitForElementVisibleXpath(waitTime, websites_opt);
            testBase.getdriver().findElement(By.xpath(websites_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(2000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Klant #", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Bedrijfsnaam", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Webshop URL", "//tbody/tr[1]/td[3]");
                }
            }
        } else if (business.equalsIgnoreCase("Bestellingen") && count == 7) {
            testBase.waitForElementVisibleXpath(waitTime, bestellingen_opt);
            testBase.getdriver().findElement(By.xpath(bestellingen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(3000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Betaling gestart?", "//tbody//tr[1]//td[3]");
                } else if (i == 1) {
                    sortingCode("Ordernummer", "//tbody//tr[1]//td[4]");
                } else if (i == 2) {
                    sortingCode("Orderdatum & tijd", "//tbody/tr[1]/td[5]");
                } else if (i == 3) {
                    sortingCode("Bestelde items", "//tbody/tr[1]/td[6]");
                } else if (i == 4) {
                    sortingCode("Totaal", "//tbody/tr[1]/td[7]");
                } else if (i == 5) {
                    sortingCode("Naam van persoon", "//tbody/tr[1]/td[8]");
                } else if (i == 6) {
                    sortingCode("Email", "//tbody/tr[1]/td[9]");
                }
            }
        } else if (business.equalsIgnoreCase("Lead Management") && count == 9) {
            testBase.waitForElementVisibleXpath(waitTime, lead_management_opt);
            testBase.getdriver().findElement(By.xpath(lead_management_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(3000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Lead ID", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCodeException("Bedrijfsnaam", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Contactpersoon", "//tbody/tr[1]/td[3]");
                } else if (i == 3) {
                    sortingCode("Email adres", "//tbody/tr[1]/td[4]");
                } else if (i == 4) {
                    sortingCode("Telefoonnummer", "//tbody/tr[1]/td[5]");
                } else if (i == 5) {
                    sortingCode("Leadstatus", "//tbody/tr[1]/td[6]");
                } else if (i == 6) {
                    sortingCode("Taak", "//tbody/tr[1]/td[7]");
                } else if (i == 7) {
                    sortingCode("Taak uitvoeren op", "//tbody/tr[1]/td[8]");
                } else if (i == 8) {
                    sortingCode("Lead eigenaar", "//tbody/tr[1]/td[9]");  //(space issue)
                }
            }
        } else if (business.equalsIgnoreCase("Aanvragen") && count == 6) {
            testBase.waitForElementVisibleXpath(waitTime, aanvragen_opt);
            testBase.getdriver().findElement(By.xpath(aanvragen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Subcategorie", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Naam", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Email", "//tbody/tr[1]/td[3]");
                } else if (i == 3) {
                    sortingCode("Telefoonnummer", "//tbody/tr[1]/td[4]");
                } else if (i == 4) {
                    sortingCode("Land", "//tbody/tr[1]/td[5]");
                } else if (i == 5) {
                    sortingCode("Datum & tijd", "//tbody/tr[1]/td[6]");
                }
            }
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
        boolean optionTwo = option.equalsIgnoreCase("Prijs") || option.equalsIgnoreCase("Artikel/Onderdeelnr.") || option.equalsIgnoreCase("")
                || option.equalsIgnoreCase("KM") || option.equalsIgnoreCase("Verkoopprijs NL") || option.equalsIgnoreCase("Exportprijs");
        boolean optionOne = option.equalsIgnoreCase("Bedrijfsnaam") || option.equalsIgnoreCase("Company Name") || option.equalsIgnoreCase("Ordernummer")
                || option.equalsIgnoreCase("Email adres") || option.equalsIgnoreCase("Telefoonnummer") || option.equalsIgnoreCase("Titel")
                || option.equalsIgnoreCase("Merk") || option.equalsIgnoreCase("Model") || option.equalsIgnoreCase("Email");
        if (optionOne) {
            String desc_xpath = "" + elePath + "//a[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
            testBase.verifyElementPresence(desc_xpath);
        } else if (optionTwo) {
            String desc_xpath = "" + elePath + "//span[contains(text(),'" + descData + "')]";
            testBase.verifyElementPresence(desc_xpath);
        } else {
            if (option.equalsIgnoreCase("Locatienaam")) {
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else if(option.equalsIgnoreCase("Naam van persoon")){
                String[] finalData = descData.split(" ");
                String desc_xpath = "" + elePath + "//a[contains(text(),'" +finalData[0]+" "+finalData[1] + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else {
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        }
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        if (optionOne) {
            String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        } else if (optionTwo) {
            String asc_xpath = "" + elePath + "//span[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        }else if (option.equalsIgnoreCase("Naam van persoon")) {
            String[] finalData = ascData.split(" ");
            String asc_xpath = "" + elePath + "//a[contains(text(),'" +finalData[0]+" "+finalData[1] + "')]";
            testBase.verifyElementPresence(asc_xpath);
        } else {
            String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        }
        Gauge.captureScreenshot();
    }

    private void sortingCodeException(String option, String elePath) {
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
        String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
        testBase.verifyElementPresence(desc_xpath);
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
        testBase.verifyElementPresence(asc_xpath);
        Gauge.captureScreenshot();
    }
}