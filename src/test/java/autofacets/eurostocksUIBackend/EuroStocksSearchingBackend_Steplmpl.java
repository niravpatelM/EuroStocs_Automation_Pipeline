package autofacets.eurostocksUIBackend;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.PropertyManager;
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

public class EuroStocksSearchingBackend_Steplmpl extends EuroStocksTest implements WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    PropertyManager propertyManager = new PropertyManager();
    private String password = "" + propertyManager.getResourceBundle.getProperty("BackEndPassword") + "";
    private String plainPassword = Utils.passwordEncryptDecrypt(password);
    final static long waitTime = 60;


    @Step("Verify Login page and Enter valid username <eurostocksauto@mailinator.com> and password for user")
    public void verifyPageEnterUserNamePassword(String username) {
        testBase.waitForElementVisibleXpath(waitTime, email_fld);
        testBase.getdriver().findElement(By.xpath(email_fld)).sendKeys(username);
        testBase.getdriver().findElement(By.xpath(password_fld)).click();
        testBase.getdriver().findElement(By.xpath(password_fld)).sendKeys(plainPassword);
        testBase.getdriver().findElement(By.xpath(signin_btn)).click();
    }

    @Step("Verify User is redirect to the dashboard screen <loggedUser> for backend")
    public void verifyDashboardScreen(String user) {
        testBase.waitForElementVisibleXpath(waitTime, user_lbl);
        String username = testBase.getdriver().findElement(By.xpath(user_lbl)).getText();
        if (username.equalsIgnoreCase("Sandip")) {
            Gauge.writeMessage("User Logged in Successfully");
        }
        Gauge.captureScreenshot();
        Utils.pause(2000, "wait for element load on the page");
    }

    @Step("Verify Searching functionality for below list <table>")
    public void searchFuncForListModules(Table table) {
        for (TableRow tableRow : table.getTableRows()) {
            String listOptions = tableRow.getCell("ListOption");
            if (listOptions.equalsIgnoreCase("Bedrijven")) {
                commanCodeForSearching("Bedrijven", 2);
            }else if (listOptions.equalsIgnoreCase("Locations")) {
                commanCodeForSearching("Locations", 4);
            }else if (listOptions.equalsIgnoreCase("Websites")) {
                commanCodeForSearching("Websites", 3);
            }else if (listOptions.equalsIgnoreCase("Bestellingen")) {
                commanCodeForSearching("Bestellingen", 2);
            }else if (listOptions.equalsIgnoreCase("Aanvragen")) {
                commanCodeForSearching("Aanvragen", 4);
            }else if (listOptions.equalsIgnoreCase("Lead Management")) {
                commanCodeForSearching("Lead Management", 2);
            }else if (listOptions.equalsIgnoreCase("Producten")) {
                commanCodeForSearching("Producten", 3);
            }else if (listOptions.equalsIgnoreCase("Voertuigen")) {
                commanCodeForSearching("Voertuigen", 2);
                //Gauge.writeMessage("Searching functionality is not working for vehicle module");
            }
        }
    }

    private void commanCodeForSearching(String business, int count) {
        if(business.equalsIgnoreCase("Bedrijven")) {
            testBase.waitForElementVisibleXpath(waitTime, business_opt);
            testBase.getdriver().findElement(By.xpath(business_opt)).click();
        }else if (business.equalsIgnoreCase("Locations")) {
            testBase.waitForElementVisibleXpath(waitTime, locations_opt);
            testBase.getdriver().findElement(By.xpath(locations_opt)).click();
        }else if (business.equalsIgnoreCase("Websites")) {
            testBase.waitForElementVisibleXpath(waitTime, websites_opt);
            testBase.getdriver().findElement(By.xpath(websites_opt)).click();
        }else if (business.equalsIgnoreCase("Bestellingen")) {
            testBase.waitForElementVisibleXpath(waitTime, bestellingen_opt);
            testBase.getdriver().findElement(By.xpath(bestellingen_opt)).click();
        }else if (business.equalsIgnoreCase("Aanvragen")) {
            testBase.waitForElementVisibleXpath(waitTime, aanvragen_opt);
            testBase.getdriver().findElement(By.xpath(aanvragen_opt)).click();
        }else if (business.equalsIgnoreCase("Lead Management")) {
            testBase.waitForElementVisibleXpath(waitTime, lead_management_opt);
            testBase.getdriver().findElement(By.xpath(lead_management_opt)).click();
        }else if (business.equalsIgnoreCase("Producten")) {
            testBase.waitForElementVisibleXpath(waitTime, producten_opt);
            testBase.getdriver().findElement(By.xpath(producten_opt)).click();
        }else if (business.equalsIgnoreCase("Voertuigen")) {
            testBase.waitForElementVisibleXpath(waitTime, Voertuigen_opt);
            testBase.getdriver().findElement(By.xpath(Voertuigen_opt)).click();
        }
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        Utils.pause(3000, "wait to load the data on the list");

        if (count == 2 && business.equalsIgnoreCase("Bedrijven")) {
            String customer_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(search_fld)).click();
                testBase.getdriver().findElement(By.xpath(search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(search_fld)).sendKeys(customer_no);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(search_fld)).sendKeys(company_name);
                }
                testBase.getdriver().findElement(By.xpath(search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten: 1')]");
                String customer_no_xpath = "//td[contains(text(),'" + customer_no + "')]";
                String company_name_xpath = "//a[contains(text(),'" + company_name + "')]";
                testBase.verifyElementPresence(customer_no_xpath);
                testBase.verifyElementPresence(company_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 4 && business.equalsIgnoreCase("Locations")) {
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String location_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            String location_city = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
            String webshop_URL = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[5]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(location_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(location_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(location_search_fld)).sendKeys(company_name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(location_search_fld)).sendKeys(location_name);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(location_search_fld)).sendKeys(location_city);
                } else if (i == 3) {
                    testBase.getdriver().findElement(By.xpath(location_search_fld)).sendKeys(webshop_URL);
                }
                testBase.getdriver().findElement(By.xpath(location_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten:')]");
                String company_name_xpath = "//a[contains(text(),'" + company_name + "')]";
                String location_name_xpath = "//td[contains(text(),'" + location_name + "')]";
                String location_city_xpath = "//td[contains(text(),'" + location_city + "')]";
                String webshop_URL_xpath = "//td[contains(text(),'" + webshop_URL + "')]";
                testBase.verifyElementPresence(company_name_xpath);
                testBase.verifyElementPresence(location_name_xpath);
                testBase.verifyElementPresence(location_city_xpath);
                testBase.verifyElementPresence(webshop_URL_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Websites")) {
            String customer_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String webshop_URL = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(websites_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(websites_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(websites_search_fld)).sendKeys(customer_no);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(websites_search_fld)).sendKeys(company_name);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(websites_search_fld)).sendKeys(webshop_URL);
                }
                testBase.getdriver().findElement(By.xpath(websites_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten:')]");
                String customer_no_xpath = "//td[contains(text(),'" + customer_no + "')]";
                String company_name_xpath = "//a[contains(text(),'" + company_name + "')]";
                String webshop_URL_xpath = "//td[contains(text(),'" + webshop_URL + "')]";
                testBase.verifyElementPresence(customer_no_xpath);
                testBase.verifyElementPresence(company_name_xpath);
                testBase.verifyElementPresence(webshop_URL_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("Bestellingen")) {
            Utils.pause(5000, "wait for element load on the page");
            String order_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
            String person_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[8]/a")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(bestellingen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(bestellingen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(bestellingen_search_fld)).sendKeys(order_no);
                }else if (i == 1) {
                    String finalName = person_name.substring(5);
                    testBase.getdriver().findElement(By.xpath(bestellingen_search_fld)).sendKeys(finalName.substring(0, finalName.length() - 2));
                }
                testBase.getdriver().findElement(By.xpath(bestellingen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten:')]");
                String order_no_xpath = "//a[contains(text(),'" + order_no + "')]";
                String s = person_name;
                int k = s.indexOf(" ", s.indexOf(" ") + 1);
                String result = s.substring(0, k);
                String person_name_xpath = "//a[contains(text(),'" + result + "')]";
                testBase.verifyElementPresence(order_no_xpath);
                testBase.verifyElementPresence(person_name_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 4 && business.equalsIgnoreCase("Aanvragen")) {
            Utils.pause(1000, "wait for element load on the page");
            String subcategories = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
            String name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String email = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            String land = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[5]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).sendKeys(subcategories);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).sendKeys(name);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).sendKeys(email);
                }else if (i == 3) {
                    testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).sendKeys(land);
                }
                testBase.getdriver().findElement(By.xpath(aanvragen_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten:')]");
                String subcategories_xpath = "//td[contains(text(),'" + subcategories + "')]";
                String name_xpath = "//td[contains(text(),'" + name + "')]";
                String email_xpath = "//td//a[contains(text(),'" + email + "')]";
                String land_xpath = "//td[contains(text(),'" + land + "')]";
                testBase.verifyElementPresence(subcategories_xpath);
                testBase.verifyElementPresence(name_xpath);
                testBase.verifyElementPresence(email_xpath);
                testBase.verifyElementPresence(land_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 2 && business.equalsIgnoreCase("Lead Management")) {
            String company_name = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
            String contact = testBase.getdriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(lead_management_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(lead_management_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(lead_management_search_fld)).sendKeys(company_name);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(lead_management_search_fld)).sendKeys(contact);
                }
                testBase.getdriver().findElement(By.xpath(lead_management_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten:')]");
                String company_name_xpath = "//td[contains(text(),'" + company_name + "')]";
                String contact_xpath = "//td[contains(text(),'" + contact + "')]";
                testBase.verifyElementPresence(company_name_xpath);
                testBase.verifyElementPresence(contact_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }
        } else if (count == 3 && business.equalsIgnoreCase("Producten")) {
            for (int i = 0; i <= 3; i++) {
                if (i == 0) {
                    productListVeificationCode(count);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath("//*[@class='fa fa-times']")).click();
                    Utils.pause(3000, "wait for element load on the page");
                    testBase.getdriver().findElement(By.xpath("//label[contains(text(),'Inactief')]")).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    productListVeificationCode(count);
                } else if (i == 2) {
                    testBase.getdriver().findElement(By.xpath("//*[@class='fa fa-times']")).click();
                    Utils.pause(3000, "wait for element load on the page");
                    testBase.getdriver().findElement(By.xpath("//label[contains(text(),'Verwijderd')]")).click();
                    testBase.waitForElementVisibleXpath(waitTime, table_data);
                    productListVeificationCode(count);
                } else if (i == 3) {
                    testBase.getdriver().findElement(By.xpath("//*[@class='fa fa-times']")).click();
                    Utils.pause(3000, "wait for element load on the page");
                    testBase.getdriver().findElement(By.xpath("//label[contains(text(),'Niet gepubliceerd')]")).click();
                    productListVeificationCode(count);
                }
            }
        } else if (count == 2 && business.equalsIgnoreCase("Voertuigen")) {
            String brand = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[3]/a[1]")).getText();
            String model = testBase.getdriver().findElement(By.xpath("//tbody/tr[1]/td[4]/a[1]")).getText();
            for (int i = 0; i < count; i++) {
                testBase.getdriver().findElement(By.xpath(vehicle_search_fld)).click();
                testBase.getdriver().findElement(By.xpath(vehicle_search_fld)).clear();
                if (i == 0) {
                    testBase.getdriver().findElement(By.xpath(vehicle_search_fld)).sendKeys(brand);
                } else if (i == 1) {
                    testBase.getdriver().findElement(By.xpath(vehicle_search_fld)).sendKeys(model);
                }
                testBase.getdriver().findElement(By.xpath(vehicle_search_fld)).sendKeys(Keys.ENTER);
                Utils.pause(1000, "wait for element load on the page");
                testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten')]");
                String brand_name_xpath = "//a[contains(text(),'" + brand + "')]";
                String model_xpath = "//a[contains(text(),'" + model + "')]";
                testBase.verifyElementPresence(brand_name_xpath);
                testBase.verifyElementPresence(model_xpath);
                Gauge.captureScreenshot();
                Utils.pause(1000, "wait for element load on the page");
            }

        }
    }

    private void productListVeificationCode(int count) {
        Utils.pause(2000, "wait for element load on the page");
        String title = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[3]")).getText();
        String items_no = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[5]")).getText();
        String product_type = testBase.getdriver().findElement(By.xpath("//tbody//tr[2]//td[6]")).getText();
        Utils.pause(2000, "wait for element load on the page");
        for (int i = 0; i < count; i++) {
            testBase.getdriver().findElement(By.xpath(producten_search_fld)).click();
            testBase.getdriver().findElement(By.xpath(producten_search_fld)).clear();
            if (i == 0) {
                testBase.getdriver().findElement(By.xpath(producten_search_fld)).sendKeys(title);
            } else if (i == 1) {
                testBase.getdriver().findElement(By.xpath(producten_search_fld)).sendKeys(items_no);
            }
            testBase.getdriver().findElement(By.xpath(producten_search_fld)).sendKeys(Keys.ENTER);
            Utils.pause(2000, "wait for element load on the page");
            testBase.waitForElementVisibleXpath(waitTime, "//div[contains(text(),'Aantal resultaten :')]");
            String title_xpath = "//a[contains(text(),'" + title + "')]";
            String items_no_xpath = "//span[contains(text(),'" + items_no + "')]";
            String product_type_xpath = "//td[contains(text(),'" + product_type + "')]";
            Utils.pause(1000, "wait for element load on the page");
            testBase.verifyElementPresence(title_xpath);
            testBase.verifyElementPresence(items_no_xpath);
            testBase.verifyElementPresence(product_type_xpath);
            Gauge.captureScreenshot();
            Utils.pause(2000, "wait for element load on the page");
        }
    }
}