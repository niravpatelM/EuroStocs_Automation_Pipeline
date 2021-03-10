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

public class EuroStocksSortingAdministratie extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Sorting functionality for below list for Administratie <table>")
    public void sortFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Email templates")) {
                commanCodeForSort("Email templates", 6);
            }else if (listOptions.equalsIgnoreCase("Klanten")) {
                commanCodeForSort("Klanten", 5);
            }else if (listOptions.equalsIgnoreCase("Betaalmethodes")) {
                commanCodeForSort("Betaalmethodes", 3);
            }else if (listOptions.equalsIgnoreCase("Prijsregels")) {
                commanCodeForSort("Prijsregels", 5);
            }else if (listOptions.equalsIgnoreCase("Marktplaats tarieven")){
                commanCodeForSort("Marktplaats tarieven", 3);
            }else if (listOptions.equalsIgnoreCase("2dehands prijsregels")){
                commanCodeForSort("2dehands prijsregels", 3);
            }else if(listOptions.equalsIgnoreCase("Systeemgebruikers")){
                commanCodeForSort("Systeemgebruikers", 3);
            }else if(listOptions.equalsIgnoreCase("Verzendstaffels")){
                commanCodeForSort("Verzendstaffels", 3);
                Gauge.writeMessage("List available but not data present for search functionality");
            }else if(listOptions.equalsIgnoreCase("CMS Groepen")){
                commanCodeForSort("CMS Groepen", 3);
            }else if(listOptions.equalsIgnoreCase("CMS Pagina's")){
                commanCodeForSort("CMS Pagina's", 4);
            }else if(listOptions.equalsIgnoreCase("API Partners")){
                commanCodeForSort("API Partners", 1);
            }else if(listOptions.equalsIgnoreCase("Prijsregelss")){
                commanCodeForSort("Prijsregelss", 4);
            }else if(listOptions.equalsIgnoreCase("Trefwoorden")){
                commanCodeForSort("Trefwoorden", 1);
            }else if(listOptions.equalsIgnoreCase("Zoek trefwoorden")){
                commanCodeForSort("Zoek trefwoorden", 1);
            }else if(listOptions.equalsIgnoreCase("Merken")){
                commanCodeForSort("Merken", 2);
            }else if(listOptions.equalsIgnoreCase("Modellen")){
                commanCodeForSort("Modellen", 4);
            }else if(listOptions.equalsIgnoreCase("Modelgroepen")){
                commanCodeForSort("Modelgroepen", 3);
            }else if(listOptions.equalsIgnoreCase("Voertuigregels")){
                commanCodeForSort("Voertuigregels", 4);
            }else if(listOptions.equalsIgnoreCase("BPM FuelType")){
                commanCodeForSort("BPM FuelType", 3);
            }
        }
    }

    private void commanCodeForSort(String business, int count) {
        if (business.equalsIgnoreCase("Email templates") && count == 6) {
            testBase.waitForElementVisibleXpath(waitTime, administratie_opt);
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            Utils.pause(500, "wait for element load on the page");
            testBase.getdriver().findElement(By.xpath(emailTemplates_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Template KEY", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Omschrijving", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Afzender", "//tbody//tr[1]//td[3]");
                } else if (i == 3) {
                    sortingCode("Ontvanger", "//tbody//tr[1]//td[4]");
                } else if (i == 4) {
                    sortingCode("Antwoord naar", "//tbody//tr[1]//td[5]");
                } else if (i == 5) {
                    sortingCode("Onderwerp", "//tbody//tr[1]//td[6]");
                }
            }
        } else if (business.equalsIgnoreCase(("Klanten")) && count == 5){
            testBase.getdriver().findElement(By.xpath(klanten_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Email klant", "//tbody//tr[1]//td[1]");
                } else if (i == 1) {
                    sortingCode("Naam van persoon", "//tbody//tr[1]//td[2]");
                } else if (i == 2) {
                    sortingCode("Land", "//tbody//tr[1]//td[3]");
                } else if (i == 3) {
                    sortingCode("Stad", "//tbody//tr[1]//td[4]");
                } else if (i == 4) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[5]");
                }
            }
        } else if (business.equalsIgnoreCase(("Betaalmethodes")) && count == 3){
            testBase.getdriver().findElement(By.xpath(betaalmethodes_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Naam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Betaalprovider", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[4]");
                }
            }
        } else if (business.equalsIgnoreCase(("Prijsregels")) && count == 5){
            testBase.getdriver().findElement(By.xpath(prijsregels_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Prijsregeltype", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Naam", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Standaard", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Prijs", "//tbody//tr[1]//td[4]");
                }else if (i == 4) {
                    sortingCode("Percentage", "//tbody//tr[1]//td[5]");
                }
            }
        } else if (business.equalsIgnoreCase(("Marktplaats tarieven")) && count == 3){
            testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("MP hoofdcategorie", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("MP subcategorie", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Prijsregel", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("2dehands prijsregels")) && count == 3){
            testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("2dehands hoofdcategorie", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("2dehands subcategorie", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Prijsregels", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("Systeemgebruikers")) && count == 3){
            testBase.getdriver().findElement(By.xpath(systeemgebruikers_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Voornaam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Achternaam", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Email", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("CMS Groepen")) && count == 3){
            testBase.getdriver().findElement(By.xpath(CMSGroepen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Groepnaam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Weergave tekst", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Volgorde", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("CMS Pagina's")) && count == 4){
            testBase.getdriver().findElement(By.xpath(CMSPagina_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Paginanaam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Pagina titel", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCodeException("Groepnaam", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Laatst gewijzigd", "//tbody//tr[1]//td[4]");
                }
            }
        } else if (business.equalsIgnoreCase(("API Partners")) && count == 1){
            testBase.getdriver().findElement(By.xpath(APIPartners_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Gebruiker", "//tbody//tr[1]//td[1]");
                }
            }
        } else if (business.equalsIgnoreCase(("Prijsregelss")) && count == 4){
            testBase.getdriver().findElement(By.xpath(prijsregelss_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Pakketnaam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Van", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Naar", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Maandelijks tarief", "//tbody//tr[1]//td[4]");
                }
            }
        } else if (business.equalsIgnoreCase(("Trefwoorden")) && count == 1){
            testBase.getdriver().findElement(By.xpath(keywordsVertalingen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Trefwoord", "//tbody//tr[1]//td[1]");
                }
            }
        } else if (business.equalsIgnoreCase(("Zoek trefwoorden")) && count == 1){
            testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Trefwoord", "//tbody//tr[1]//td[1]");
                }
            }
        } else if (business.equalsIgnoreCase(("Merken")) && count == 2){
            testBase.getdriver().findElement(By.xpath(merken_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Merk naam", "//tbody//tr[1]//td[1]");
                } else if(i == 1){
                    sortingCode("Mobile.de merk naam", "//tbody//tr[1]//td[2]");
                }
            }
        } else if (business.equalsIgnoreCase(("Modellen")) && count == 4){
            testBase.getdriver().findElement(By.xpath(modellen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Model naam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Mobile.de model naam", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCodeException("Merk naam", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Model groep", "//tbody//tr[1]//td[4]");

                }
            }
        } else if (business.equalsIgnoreCase(("Modelgroepen")) && count == 3){
            testBase.getdriver().findElement(By.xpath(modelgroepen_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Model groep naam", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Mobile.de model groep naam", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCodeException("Merk naam", "//tbody//tr[1]//td[3]");
                }
            }
        } else if (business.equalsIgnoreCase(("Voertuigregels")) && count == 4){
            testBase.getdriver().findElement(By.xpath(voertuigregels_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Vehicle Type", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Category", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Make", "//tbody//tr[1]//td[3]");
                }else if (i == 3) {
                    sortingCode("Model", "//tbody//tr[1]//td[4]");
                }
            }
        } else if (business.equalsIgnoreCase(("BPM FuelType")) && count == 3){
            testBase.getdriver().findElement(By.xpath(BPMFuelType_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, table_data);
            Utils.pause(5000, "wait for element load on the page");
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sortingCode("Jaar van registratie", "//tbody//tr[1]//td[1]");
                }else if (i == 1) {
                    sortingCode("Brandstof", "//tbody//tr[1]//td[2]");
                }else if (i == 2) {
                    sortingCode("Tarief geldig voor", "//tbody//tr[1]//td[3]");
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
        boolean optionOne = option.equalsIgnoreCase("Email klant") || option.equalsIgnoreCase("Naam")
                            || option.equalsIgnoreCase("MP subcategorie") || option.equalsIgnoreCase("2dehands subcategorie")
                            || option.equalsIgnoreCase("Voornaam") || option.equalsIgnoreCase("Groepnaam")
                            || option.equalsIgnoreCase("Paginanaam") || option.equalsIgnoreCase("Gebruiker")
                            || option.equalsIgnoreCase("Pakketnaam") || option.equalsIgnoreCase("Van")
                            || option.equalsIgnoreCase("Naar") || option.equalsIgnoreCase("Maandelijks tarief")
                            || option.equalsIgnoreCase("Trefwoord") || option.equalsIgnoreCase("Merk naam")
                            || option.equalsIgnoreCase("Model naam") || option.equalsIgnoreCase("Model groep naam")
                            || option.equalsIgnoreCase("Vehicle Type");
        if (optionOne) {
            if(option.equalsIgnoreCase("Vehicle Type")){
                String desc_xpath = "" + elePath + "//a[contains(text(),'" + descData.substring(0, descData.length() - 2) + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else{
                String  desc_xpath = "" + elePath + "//a[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        }else {
            if(option.equalsIgnoreCase("Naam van persoon")){
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData.replaceAll("\\s.*", "") + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }else{
                String desc_xpath = "" + elePath + "[contains(text(),'" + descData + "')]";
                testBase.verifyElementPresence(desc_xpath);
            }
        }
        Gauge.captureScreenshot();
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'" + option + "')]")).click();
        Utils.pause(2500, "wait for element load on the page");
        if (optionOne) {
            if(option.equalsIgnoreCase("Vehicle Type")){
                String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData.substring(0, ascData.length() - 2) + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }else{
                String asc_xpath = "" + elePath + "//a[contains(text(),'" + ascData + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }
        } else {
            if(option.equalsIgnoreCase("Naam van persoon")){
                String asc_xpath = "" + elePath + "[contains(text(),'" + ascData.replaceAll("\\s.*", "") + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }else{
                String asc_xpath = "" + elePath + "[contains(text(),'" + ascData + "')]";
                testBase.verifyElementPresence(asc_xpath);
            }
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