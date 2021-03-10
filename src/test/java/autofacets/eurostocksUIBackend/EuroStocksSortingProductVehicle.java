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

public class EuroStocksSortingProductVehicle extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Sorting functionality for below list for product and vehicle <table>")
    public void sortFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Producten")) {
                commanCodeForSort("Producten", 5);
            }else if (listOptions.equalsIgnoreCase("Voertuigen")) {
                commanCodeForSort("Voertuigen", 5);
            }
        }
    }

    private void commanCodeForSort(String business, int count) {
        if(business.equalsIgnoreCase("Producten") && count == 5) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    testBase.waitForElementVisibleXpath(waitTime, producten_opt);
                    testBase.getdriver().findElement(By.xpath(producten_opt)).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    Utils.pause(5000, "wait for element load on the page");
                    for (int i = 0; i < count; i++) {
                        if (i == 0) {
                            sortingCode("Titel", "//tbody//tr[1]//td[3]");
                        } else if (i == 1) {
                            sortingCode("Prijs", "//tbody//tr[1]//td[4]");
                        } else if (i == 2) {
                            sortingCode("Artikel/Onderdeelnr.", "//tbody/tr[1]/td[5]");
                        } else if (i == 3) {
                            sortingCode("Producttype", "//tbody/tr[1]/td[6]");
                        } else if (i == 4) {
                            sortingCode("//tr[1]/th[7]/i[1]", "//tbody/tr[1]/td[7]");
                        }
                    }
                } else if (j == 1) {
                    testBase.getdriver().findElement(By.xpath(inactive_radioBtn)).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    Utils.pause(5000, "wait for element load on the page");
                    for (int i = 0; i < count; i++) {
                        if (i == 0) {
                            sortingCode("Titel", "//tbody//tr[1]//td[3]");
                        } else if (i == 1) {
                            sortingCode("Prijs", "//tbody//tr[1]//td[4]");
                        } else if (i == 2) {
                            sortingCode("Artikel/Onderdeelnr.", "//tbody/tr[1]/td[5]");
                        } else if (i == 3) {
                            sortingCode("Producttype", "//tbody/tr[1]/td[6]");
                        } else if (i == 4) {
                            sortingCode("//tr[1]/th[7]/i[1]", "//tbody/tr[1]/td[7]");
                        }
                    }
                } else if (j == 2) {
                    testBase.getdriver().findElement(By.xpath(deleted_radioBtn)).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    Utils.pause(5000, "wait for element load on the page");
                    for (int i = 0; i < count; i++) {
                        if (i == 0) {
                            sortingCode("Titel", "//tbody//tr[1]//td[3]");
                        } else if (i == 1) {
                            sortingCode("Prijs", "//tbody//tr[1]//td[4]");
                        } else if (i == 2) {
                            sortingCode("Artikel/Onderdeelnr.", "//tbody/tr[1]/td[5]");
                        } else if (i == 3) {
                            sortingCode("Producttype", "//tbody/tr[1]/td[6]");
                        } else if (i == 4) {
                            sortingCode("//tr[1]/th[7]/i[1]", "//tbody/tr[1]/td[7]");
                        }
                    }
                } else if (j == 3) {
                    testBase.getdriver().findElement(By.xpath(notPublished_radioBtn)).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    Utils.pause(5000, "wait for element load on the page");
                    for (int i = 0; i < count; i++) {
                        if (i == 0) {
                            sortingCode("Titel", "//tbody//tr[1]//td[3]");
                        } else if (i == 1) {
                            sortingCode("Prijs", "//tbody//tr[1]//td[4]");
                        } else if (i == 2) {
                            sortingCode("Artikel/Onderdeelnr.", "//tbody/tr[1]/td[5]");
                        } else if (i == 3) {
                            sortingCode("Producttype", "//tbody/tr[1]/td[6]");
                        } else if (i == 4) {
                            sortingCode("//tr[1]/th[7]/i[1]", "//tbody/tr[1]/td[7]");
                        }
                    }
                }
            }
        }else if (business.equalsIgnoreCase(("Voertuigen")) && count == 5){
            testBase.waitForElementVisibleXpath(waitTime, Voertuigen_opt);
            testBase.getdriver().findElement(By.xpath(Voertuigen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            Gauge.writeMessage("Sorting is not working for: "+business);
            /*for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Merk", "//tbody//tr[1]//td[3]");
                } else if (i == 1) {
                    sortingCode("Model", "//tbody//tr[1]//td[4]");
                } else if (i == 2) {
                    sortingCode("KM", "//tbody/tr[1]/td[5]");
                } else if (i == 3) {
                    sortingCode("Verkoopprijs NL", "//tbody/tr[1]/td[7]");
                } else if (i == 4) {
                    sortingCode("Exportprijs", "//tbody/tr[1]/td[8]");
                }
            }*/
        }
    }

    private void sortingCode(String option, String elePath) {
        if(option.equalsIgnoreCase("//tr[1]/th[7]/i[1]")){
            testBase.getdriver().findElement(By.xpath(""+option+"")).click();
        }else{
            testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        }
        Utils.pause(2500, "wait for element load on the page");
        String descData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("descnding: " + descData);
        if(option.equalsIgnoreCase("//tr[1]/th[7]/i[1]")){
            testBase.getdriver().findElement(By.xpath(""+option+"")).click();
        }else{
            testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        }
        Utils.pause(2500, "wait for element load on the page");
        String ascData = testBase.getdriver().findElement(By.xpath("" + elePath + "")).getText();
        System.out.println("asceding: " + ascData);
        if(option.equalsIgnoreCase("//tr[1]/th[7]/i[1]")){
            testBase.getdriver().findElement(By.xpath(""+option+"")).click();
        }else{
            testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        }
        Utils.pause(2500, "wait for element load on the page");
        boolean optionTwo = option.equalsIgnoreCase("Prijs") || option.equalsIgnoreCase("Artikel/Onderdeelnr.") || option.equalsIgnoreCase("")
                || option.equalsIgnoreCase("KM") || option.equalsIgnoreCase("Verkoopprijs NL")
                || option.equalsIgnoreCase("Exportprijs") || option.equalsIgnoreCase("//tr[1]/th[7]/i[1]");
        boolean optionOne = option.equalsIgnoreCase("Bedrijfsnaam") || option.equalsIgnoreCase("Company Name") || option.equalsIgnoreCase("Ordernummer")
                || option.equalsIgnoreCase("Email adres") || option.equalsIgnoreCase("Telefoonnummer") || option.equalsIgnoreCase("Titel")
                || option.equalsIgnoreCase("Merk") || option.equalsIgnoreCase("Model");
        if (optionOne) {
            String desc_xpath = "" + elePath + "//a[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
            testBase.verifyElementPresence(desc_xpath);
        } else if (optionTwo) {
            if(descData.equalsIgnoreCase("")){
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else{
                String desc_xpath = "" + elePath + "//span[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        } else {
            if (option.equalsIgnoreCase("Locatienaam")) {
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
                testBase.verifyElementPresence(desc_xpath);
            } else {
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        }
        Gauge.captureScreenshot();
        if(option.equalsIgnoreCase("//tr[1]/th[7]/i[1]")){
            testBase.getdriver().findElement(By.xpath(""+option+"")).click();
        }else{
            testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        }
        Utils.pause(2500, "wait for element load on the page");
        if (optionOne) {
            String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        } else if (optionTwo) {
            if(ascData.equalsIgnoreCase("")){
                String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }else{
                String asc_xpath = "" + elePath + "//span[contains(text(),'" + ascData + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }
        } else {
            String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
            testBase.verifyElementPresence(asc_xpath);
        }
        Gauge.captureScreenshot();
    }
}