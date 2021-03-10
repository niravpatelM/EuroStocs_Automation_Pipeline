package autofacets.eurostocks;


import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;

/**
 * @author niravpatel
 */

public class LaunchBrowser_StepImpl extends EuroStocksTest {
    TestBase testBase = new TestBase();

    @Step("Setup and launch browser <browser>")
    public void setupBrowser(String browser) {
        quickSetupForLaunchBrowser(testBase, browser);
        Gauge.captureScreenshot();
    }


    @Step("Setup and launch browser <browser> <site>")
    public void setupBrowser(String browser, String site) {
        quickSetupForLaunchBrowser(testBase, browser, site);
        Gauge.captureScreenshot();
    }

    @Step("calling me to quit")
    public void quitBrowser() {
        testBase.shutdownBrowser();
    }

}