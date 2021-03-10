package autofacets.eurostocksUIBackend;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author niravpatel
 */

public class EuroStocksRemarketingPortalForProductsBackend_Steplmpl extends EuroStocksTest implements WebLocators.AddProductPageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;


    @Step("Redirect to Marktplaats.nl page and Verify page and sort the data with title")
    public void verifyMarktplaatsProductPage() {
        testBase.getdriver().findElement(By.xpath(producten_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        testBase.waitForElementVisibleXpath(waitTime,marktplaatsnl_btn);
        testBase.getdriver().findElement(By.xpath(marktplaatsnl_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime,table_data);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'Titel')]")).click();
        Utils.pause(5000, "wait for element load on the page");
    }


    @Step("Redirect to 2dehands.be page and Verify page and sort the data with title")
    public void verifyDehandsBeProductPage() {
        testBase.getdriver().findElement(By.xpath(producten_opt)).click();
        testBase.waitForElementVisibleXpath(waitTime, table_data);
        testBase.waitForElementVisibleXpath(waitTime,dehands_btn);
        testBase.getdriver().findElement(By.xpath(dehands_btn)).click();
        testBase.waitForElementVisibleXpath(waitTime,table_data);
        testBase.getdriver().findElement(By.xpath("//th[contains(text(),'Titel')]")).click();
        Utils.pause(5000, "wait for element load on the page");
    }

    @Step("Update product status with any one product from the list and verify status updated")
    public void updateStatusAndVerify() {
        String product_name = testBase.getdriver().findElement(By.xpath("//tbody/tr[4]/td[3]")).getText();
        System.out.println(product_name);
        WebElement webElementtitle = testBase.getdriver().findElement(By.xpath("//tbody/tr[4]/td[6]"));
        String title = webElementtitle.getAttribute("title");
        System.out.println(title);
        WebElement webElement = testBase.getdriver().findElement(By.xpath("//tbody/tr[4]/td[1]/div/input"));
        String get_id = webElement.getAttribute("id");
        System.out.println(get_id);
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath("//input[@id='" + get_id + "']")));
        testBase.getdriver().findElement(By.xpath("//input[@id='" + get_id + "']")).click();
        testBase.scrollDownPageToElement(100,testBase.getdriver().findElement(By.xpath(uitvoeren_btn)));
        testBase.getdriver().findElement(By.xpath(uitvoeren_btn)).click();
        Utils.pause(5000, "wait for element load on the page");
        WebElement webElementtitleupdate = testBase.getdriver().findElement(By.xpath("//tbody/tr[4]/td[6]"));
        String title_update = webElementtitleupdate.getAttribute("title");
        System.out.println(title_update);
        String verifyUpdatedXpath = "//tbody/tr[4]/td[6][@title='"+title_update+"']";
        testBase.verifyElementPresence(verifyUpdatedXpath);
        Gauge.captureScreenshot();
    }
}