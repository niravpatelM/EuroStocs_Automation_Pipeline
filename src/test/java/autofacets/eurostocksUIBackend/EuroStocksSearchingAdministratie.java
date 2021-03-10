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

public class EuroStocksSearchingAdministratie extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Verify Searching functionality for Administratie <table>")
    public void searchFuncForMobileDe(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Email templates")) {
                commanCodeForSearching("Email templates", 1);
            }else if (listOptions.equalsIgnoreCase("Klanten")) {
                commanCodeForSearching("Klanten", 4);
            }else if (listOptions.equalsIgnoreCase("Betaalmethodes")) {
                commanCodeForSearching("Betaalmethodes", 2);
            }else if (listOptions.equalsIgnoreCase("Prijsregels")) {
                commanCodeForSearching("Prijsregels", 1);
            }else if (listOptions.equalsIgnoreCase("Marktplaats tarieven")){
                commanCodeForSearching("Marktplaats tarieven", 3);
            }else if (listOptions.equalsIgnoreCase("2dehands prijsregels")){
                commanCodeForSearching("2dehands prijsregels", 3);
            }else if(listOptions.equalsIgnoreCase("Systeemgebruikers")){
                commanCodeForSearching("Systeemgebruikers", 3);
            }else if(listOptions.equalsIgnoreCase("Verzendstaffels")){
                //commanCodeForSearching("Verzendstaffels", 3);
                Gauge.writeMessage("List available but not date present for search functionality");
            }else if(listOptions.equalsIgnoreCase("CMS Groepen")){
                commanCodeForSearching("CMS Groepen", 2);
            }else if(listOptions.equalsIgnoreCase("CMS Pagina's")){
                commanCodeForSearching("CMS Pagina's", 1);
            }else if(listOptions.equalsIgnoreCase("API Partners")){
                commanCodeForSearching("API Partners", 1);
            }else if(listOptions.equalsIgnoreCase("Prijsregelss")){
                commanCodeForSearching("Prijsregelss", 1);
            }else if(listOptions.equalsIgnoreCase("Trefwoorden")){
                commanCodeForSearching("Trefwoorden", 1);
            }else if(listOptions.equalsIgnoreCase("Zoek trefwoorden")){
                commanCodeForSearching("Zoek trefwoorden", 1);
            }else if(listOptions.equalsIgnoreCase("Merken")){
                commanCodeForSearching("Merken", 1);
            }else if(listOptions.equalsIgnoreCase("Modellen")){
                commanCodeForSearching("Modellen", 1);
            }else if(listOptions.equalsIgnoreCase("Modelgroepen")){
                commanCodeForSearching("Modelgroepen", 1);
            }else if(listOptions.equalsIgnoreCase("Voertuigregels")){
                commanCodeForSearching("Voertuigregels", 4);
            }
        }
    }

    private void commanCodeForSearching(String business, int count) {
        if(business.equalsIgnoreCase("Email templates")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, emailTemplates_opt);
            testBase.getdriver().findElement(By.xpath(emailTemplates_opt)).click();
        }else if (business.equalsIgnoreCase("Klanten")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, klanten_opt);
            testBase.getdriver().findElement(By.xpath(klanten_opt)).click();
        }else if (business.equalsIgnoreCase("Betaalmethodes")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, betaalmethodes_opt);
            testBase.getdriver().findElement(By.xpath(betaalmethodes_opt)).click();
        }else if (business.equalsIgnoreCase("Prijsregels")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, prijsregels_opt);
            testBase.getdriver().findElement(By.xpath(prijsregels_opt)).click();
        }else if (business.equalsIgnoreCase("Marktplaats tarieven")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, marktplaatsTarieven_opt);
            testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_opt)).click();
        }else if (business.equalsIgnoreCase("2dehands prijsregels")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, dehandsPrijsregels_opt);
            testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_opt)).click();
        }else if (business.equalsIgnoreCase("Systeemgebruikers")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, systeemgebruikers_opt);
            testBase.getdriver().findElement(By.xpath(systeemgebruikers_opt)).click();
        }else if (business.equalsIgnoreCase("CMS Groepen")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, CMSGroepen_opt);
            testBase.getdriver().findElement(By.xpath(CMSGroepen_opt)).click();
        }else if (business.equalsIgnoreCase("CMS Pagina's")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, CMSPagina_opt);
            testBase.getdriver().findElement(By.xpath(CMSPagina_opt)).click();
        }else if (business.equalsIgnoreCase("API Partners")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, APIPartners_opt);
            testBase.getdriver().findElement(By.xpath(APIPartners_opt)).click();
        }else if (business.equalsIgnoreCase("Prijsregelss")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, prijsregelss_opt);
            testBase.getdriver().findElement(By.xpath(prijsregelss_opt)).click();
        }else if (business.equalsIgnoreCase("Trefwoorden")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, keywordsVertalingen_opt);
            testBase.getdriver().findElement(By.xpath(keywordsVertalingen_opt)).click();
        }else if (business.equalsIgnoreCase("Zoek trefwoorden")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, zoekTrefwoorden_opt);
            testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_opt)).click();
        }else if (business.equalsIgnoreCase("Merken")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, merken_opt);
            testBase.getdriver().findElement(By.xpath(merken_opt)).click();
        }else if (business.equalsIgnoreCase("Modellen")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, modellen_opt);
            testBase.getdriver().findElement(By.xpath(modellen_opt)).click();
        }else if (business.equalsIgnoreCase("Modelgroepen")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, modelgroepen_opt);
            testBase.getdriver().findElement(By.xpath(modelgroepen_opt)).click();
        }else if (business.equalsIgnoreCase("Voertuigregels")) {
            testBase.getdriver().findElement(By.xpath(administratie_opt)).click();
            testBase.waitForElementVisibleXpath(waitTime, voertuigregels_opt);
            testBase.getdriver().findElement(By.xpath(voertuigregels_opt)).click();
        }
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        Utils.pause(5000, "wait to load the data on the list");

        if (count == 1 && business.equalsIgnoreCase("Email templates")) {
            String topic_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[6]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(emailTemplates_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(emailTemplates_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(emailTemplates_search_fld)).sendKeys(topic_name);
                }
                testBase.getdriver().findElement(By.xpath(emailTemplates_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String topic_name_xpath = "//td[contains(text(),'" + topic_name + "')]";
                testBase.verifyElementPresence(topic_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 4 && business.equalsIgnoreCase("Klanten")) {
            String email_cust = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String name_person = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String country = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            String city = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(klanten_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(klanten_search_fld)).clear();
                if(i == 0) {
                    testBase.getdriver().findElement(By.xpath(klanten_search_fld)).sendKeys(email_cust);
                }else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(klanten_search_fld)).sendKeys(name_person.replaceAll("\\s.*", ""));
                }else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(klanten_search_fld)).sendKeys(country);  // Country searching is not working
                    //Gauge.writeMessage("Country searching is not working");
                }else if (i == 3) {
                    testBase.getdriver().findElement(By.xpath(klanten_search_fld)).sendKeys(city);
                }
                testBase.getdriver().findElement(By.xpath(klanten_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String email_cust_xpath = "//td//a[contains(text(),'" + email_cust + "')]";
                String name_person_xpath = "//td[contains(text(),'" + name_person.replaceAll("\\s.*", "") + "')]";
                String country_xpath = "//td[contains(text(),'" + country + "')]";
                String city_xpath = "//td[contains(text(),'" + city + "')]";
                testBase.verifyElementPresence(email_cust_xpath);
                testBase.verifyElementPresence(name_person_xpath);
                testBase.verifyElementPresence(country_xpath);
                testBase.verifyElementPresence(city_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("Betaalmethodes")) {
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String payment = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(betaalmethodes_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(betaalmethodes_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(betaalmethodes_search_fld)).sendKeys(name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(betaalmethodes_search_fld)).sendKeys(payment);
                }
                testBase.getdriver().findElement(By.xpath(betaalmethodes_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String name_xpath = "//td//a[contains(text(),'" + name + "')]";
                String payment_xpath = "//td[contains(text(),'" + payment + "')]";
                testBase.verifyElementPresence(name_xpath);
                testBase.verifyElementPresence(payment_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Prijsregels")) {
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(prijsregels_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(prijsregels_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(prijsregels_search_fld)).sendKeys(name);
                }
                testBase.getdriver().findElement(By.xpath(prijsregels_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String name_xpath = "//td//a[contains(text(),'" + name + "')]";
                testBase.verifyElementPresence(name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Marktplaats tarieven")) {
            String main_category = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String subcategory = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String pricing_rule = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).sendKeys(main_category);
                }else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).sendKeys(subcategory);
                }else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).sendKeys(pricing_rule);
                }
                testBase.getdriver().findElement(By.xpath(marktplaatsTarieven_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String main_category_xpath = "//td[contains(text(),'" + main_category + "')]";
                String subcategory_xpath = "//td//a[contains(text(),'" + subcategory + "')]";
                String pricing_rule_xpath = "//td[contains(text(),'" + pricing_rule + "')]";
                testBase.verifyElementPresence(main_category_xpath);
                testBase.verifyElementPresence(subcategory_xpath);
                testBase.verifyElementPresence(pricing_rule_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("2dehands prijsregels")) {
            String second_main_category = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[1]")).getText();
            String second_subcategory = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[2]")).getText();
            String pricing_rule = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).sendKeys(second_main_category);
                }else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).sendKeys(second_subcategory);
                }else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).sendKeys(pricing_rule);
                }
                testBase.getdriver().findElement(By.xpath(dehandsPrijsregels_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String second_main_category_xpath = "//td[contains(text(),'" + second_main_category + "')]";
                String second_subcategory_xpath = "//td//a[contains(text(),'" + second_subcategory + "')]";
                String pricing_rule_xpath = "//td[contains(text(),'" + pricing_rule + "')]";
                testBase.verifyElementPresence(second_main_category_xpath);
                testBase.verifyElementPresence(second_subcategory_xpath);
                testBase.verifyElementPresence(pricing_rule_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Systeemgebruikers")) {
            String fitst_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String last_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String email = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).sendKeys(fitst_name);
                }else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).sendKeys(last_name);
                }else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).sendKeys(email);
                }
                testBase.getdriver().findElement(By.xpath(systeemgebruikers_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String fitst_name_xpath = "//td//a[contains(text(),'" + fitst_name + "')]";
                String last_name_xpath = "//td[contains(text(),'" + last_name + "')]";
                String email_xpath = "//td[contains(text(),'" + email + "')]";
                testBase.verifyElementPresence(fitst_name_xpath);
                testBase.verifyElementPresence(last_name_xpath);
                testBase.verifyElementPresence(email_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("CMS Groepen")) {
            String group_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String displayText = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(CMSGroepen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(CMSGroepen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(CMSGroepen_search_fld)).sendKeys(group_name);
                }else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(CMSGroepen_search_fld)).sendKeys(displayText);
                }
                testBase.getdriver().findElement(By.xpath(CMSGroepen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String group_name_xpath = "//td//a[contains(text(),'" + group_name + "')]";
                String displayText_xpath = "//td[contains(text(),'" + displayText + "')]";
                testBase.verifyElementPresence(group_name_xpath);
                testBase.verifyElementPresence(displayText_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("CMS Pagina's")) {
            String page_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(CMSPagina_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(CMSPagina_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(CMSPagina_search_fld)).sendKeys(page_name);
                }
                testBase.getdriver().findElement(By.xpath(CMSPagina_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String page_name_xpath = "//td//a[contains(text(),'" + page_name + "')]";
                testBase.verifyElementPresence(page_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("API Partners")) {
            String user = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(APIPartners_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(APIPartners_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(APIPartners_search_fld)).sendKeys(user);
                }
                testBase.getdriver().findElement(By.xpath(APIPartners_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String user_xpath = "//td//a[contains(text(),'" + user + "')]";
                testBase.verifyElementPresence(user_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Prijsregelss")) {
            String package_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(prijsregelss_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(prijsregelss_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(prijsregelss_search_fld)).sendKeys(package_name);
                }
                testBase.getdriver().findElement(By.xpath(prijsregelss_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Totaal geregistreerde')]");
                String package_name_xpath = "//td//a[contains(text(),'" + package_name + "')]";
                testBase.verifyElementPresence(package_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Trefwoorden")) {
            String keyword = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(keywordsVertalingen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(keywordsVertalingen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(keywordsVertalingen_search_fld)).sendKeys(keyword);
                }
                testBase.getdriver().findElement(By.xpath(keywordsVertalingen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String keyword_xpath = "//td//a[contains(text(),'" + keyword + "')]";
                testBase.verifyElementPresence(keyword_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Zoek trefwoorden")) {
            String keyword = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_search_fld)).sendKeys(keyword);
                }
                testBase.getdriver().findElement(By.xpath(zoekTrefwoorden_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String keyword_xpath = "//td//a[contains(text(),'" + keyword + "')]";
                testBase.verifyElementPresence(keyword_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Merken")) {
            String brand_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(merken_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(merken_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(merken_search_fld)).sendKeys(brand_name);
                }
                testBase.getdriver().findElement(By.xpath(merken_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String brand_name_xpath = "//td//a[contains(text(),'" + brand_name + "')]";
                testBase.verifyElementPresence(brand_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Modellen")) {
            String model_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(modellen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(modellen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(modellen_search_fld)).sendKeys(model_name);
                }
                testBase.getdriver().findElement(By.xpath(modellen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String model_name_xpath = "//td//a[contains(text(),'" + model_name + "')]";
                testBase.verifyElementPresence(model_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 1 && business.equalsIgnoreCase("Modelgroepen")) {
            String model_groupName = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(modelgroepen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(modelgroepen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(modelgroepen_search_fld)).sendKeys(model_groupName);
                }
                testBase.getdriver().findElement(By.xpath(modelgroepen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String model_groupName_xpath = "//td//a[contains(text(),'" + model_groupName + "')]";
                testBase.verifyElementPresence(model_groupName_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 4 && business.equalsIgnoreCase("Voertuigregels")) {
            String vehicle_type = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String category = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String make = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            String model = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).sendKeys(vehicle_type);
                }else if(i == 1){
                    testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).sendKeys(category);
                }else if(i == 2){
                    testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).sendKeys(make);
                }else if(i == 3){
                    testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).sendKeys(model);
                }
                testBase.getdriver().findElement(By.xpath(voertuigregels_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String vehicle_type_xpath = "//td//a[contains(text(),'" + vehicle_type + "')]";
                String category_xpath = "//td[contains(text(),'" + category + "')]";
                String make_xpath = "//td[contains(text(),'" + make + "')]";
                String model_xpath = "//td[contains(text(),'" + model + "')]";
                testBase.verifyElementPresence(vehicle_type_xpath);
                testBase.verifyElementPresence(category_xpath);
                testBase.verifyElementPresence(make_xpath);
                testBase.verifyElementPresence(model_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        }
    }
}