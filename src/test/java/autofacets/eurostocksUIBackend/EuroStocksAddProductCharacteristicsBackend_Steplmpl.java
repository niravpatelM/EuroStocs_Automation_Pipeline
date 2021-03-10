package autofacets.eurostocksUIBackend;

import autofacets.base.EuroStocksTest;
import autofacets.base.TestBase;
import autofacets.base.WebLocators;
import autofacets.utils.Utils;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

/**
 * @author niravpatel
 */

public class EuroStocksAddProductCharacteristicsBackend_Steplmpl extends EuroStocksTest implements WebLocators.AddProductPageBackEnd, WebLocators.LoginPageBackEnd {
    TestBase testBase = new TestBase();
    final static long waitTime = 60;

    @Step("Select all other option from Characteristics for <Set van 4>, <Personenwagen>, <18 inch>, <8J>, <4x98>, <58,1>, <9>, <15 inch>, <9J>, <4x110>, <52,1>, <8>, <Lichtmetaal>, <Advanti>, <Imitatie>,<Ja>, <22.22>")
    public void selectOtherOptionFromCharacteristics(String product, String suitable,
                                                     String inchSize, String rimWidth, String pitchSize, String hubDiameter, String etValue,
                                                     String inchSizeRims, String rimWidthBroadset, String pitchSizeBroadset, String hubDiameterBroadset,
                                                     String etValueBroadset, String rimMaterial, String rimBrand, String ethincity, String mouting, String fittingcost) {

        if(product.equalsIgnoreCase("Set van 4")){
            testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            Utils.pause(1000, "wait for element load on the page");
            sendTextMethod(""+suitable_drpdown+"", suitable);
            sendTextMethod(""+inchesSize_drpdown+"", inchSize);
            sendTextMethod(""+rimWidth_drpdown+"", rimWidth);
            sendTextMethod(""+pitchSize_drpdown+"", pitchSize);
            sendTextMethod(""+hubDiameter_drpdown+"", hubDiameter);
            sendTextMethod(""+etValue_drpdown+"", etValue);
            sendTextMethod(""+inchesSizeRims_drpdown+"", inchSizeRims);
            sendTextMethod(""+rimsWidthBrodset_drpdown+"", rimWidthBroadset);
            testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(breedSet_lbl)));
            testBase.getdriver().findElement(By.xpath(breedSet_chkbox)).click();
            Utils.pause(200, "wait for element load on the page");
            sendTextMethod(""+pitchSizeBroadset_drpdown+"", pitchSizeBroadset);
            sendTextMethod(""+hubDiameterBroadset_drpdown+"", hubDiameterBroadset);
            sendTextMethod(""+etValueBroadset_drpdown+"", etValueBroadset);
            sendTextMethod(""+rimMaterial_drpdown+"", rimMaterial);
            sendTextMethod(""+rimBrand_drpdown+"", rimBrand);
            sendTextMethod(""+ethnicity_drpdown+"", ethincity);
            checkBoxClick();
            sendTextMethod(""+mounting_drpdown+"", mouting);
            commanCallThree(fittingcost);
        }else if(product.equalsIgnoreCase("Band-velg combi")){
            testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            Utils.pause(1000, "wait for element load on the page");
            sendTextMethod(""+suitable_drpdown+"", suitable);
            sendTextMethod(""+inchesSize_drpdown+"", inchSize);
            sendTextMethod(""+rimWidth_drpdown+"", rimWidth);
            sendTextMethod(""+pitchSize_drpdown+"", pitchSize);
            sendTextMethod(""+hubDiameter_drpdown+"", hubDiameter);
            sendTextMethod(""+etValue_drpdown+"", etValue);
            commanCall("225 mm", "60", "18 inch", "60 - 70 (250 kg t/m 335 kg)", "T (tot 190 KM/H)", "6 tot 6,9 mm", "8 tot 8,9 mm", "4 tot 4,9 mm", "6 tot 6,9 mm", "All-season banden", "Apollo");
            sendTextMethod(""+rearTireBrand_drpdown+"", "Achilles");
            commanCallTwo("D", "A", "3 geluidsgolven (bovengemiddeld geluidsniveau)");
            sendTextMethod(""+rimMaterial_drpdown+"", rimMaterial);
            sendTextMethod(""+rimBrand_drpdown+"", rimBrand);
            sendTextMethod(""+ethnicity_drpdown+"", ethincity);
            checkBoxClick();
            sendTextMethod(""+mounting_drpdown+"", mouting);
            commanCallThree(fittingcost);
        }else if (product.equalsIgnoreCase("Band Set van 4")){
            testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)));
            testBase.getdriver().findElement(By.xpath(all_characteristics_chkbox)).click();
            Utils.pause(1000, "wait for element load on the page");
            sendTextMethod(""+suitable_drpdown+"", suitable);
            commanCall("225 mm", "60", "18 inch", "60 - 70 (250 kg t/m 335 kg)", "T (tot 190 KM/H)", "6 tot 6,9 mm", "8 tot 8,9 mm", "4 tot 4,9 mm", "6 tot 6,9 mm", "All-season banden", "Apollo");
            commanCallTwo("D", "A", "3 geluidsgolven (bovengemiddeld geluidsniveau)");
            sendTextMethod(""+mounting_drpdown+"", mouting);
            commanCallThree(fittingcost);
        }
    }


    void commanCall(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String apollo){
        testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(bandwidth_drpdown)));
        sendTextMethod(""+bandwidth_drpdown+"", s);
        sendTextMethod(""+tireHeight_drpdown+"", s1);
        sendTextMethod(""+inchSizeBand_drpdown+"", s2);
        sendTextMethod(""+loadIndexCapacity_drpdown+"", s3);
        sendTextMethod(""+speedRating_drpdown+"", s4);
        sendTextMethod(""+treadDepthFrontLeft_drpdown+"", s5);
        sendTextMethod(""+profileDepthRightFront_drpdown+"", s6);
        sendTextMethod(""+treadDepthRearLeft_drpdown+"", s7);
        sendTextMethod(""+treadDepthRightRear_drpdown+"", s8);
        testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(season_drpdown)));
        sendTextMethod(""+season_drpdown+"", s9);
        sendTextMethod(""+tireBrandFor_drpdown+"", apollo);
    }

    void commanCallTwo(String value1, String value2, String value3){
        sendTextMethod(""+tireLabelFuelConsumption_drpdown+"", value1);
        sendTextMethod(""+tireLabelSafety_drpdown+"", value2);
        sendTextMethod(""+tireLabelNoiseProduction_drpdown+"", value3);
        testBase.scrollDownPageToElement(200, testBase.getdriver().findElement(By.xpath(runFlat_chkbox)));
        testBase.getdriver().findElement(By.xpath(runFlat_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(extraLoad_chkbox)).click();
    }

    void commanCallThree(String cost){
        testBase.scrollDownPageToElement(0, testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)));
        testBase.getdriver().findElement(By.xpath(all_characteristicsOption_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(fitting_costs_input)).sendKeys(cost);
        Gauge.captureScreenshot();
    }

    void checkBoxClick(){
        testBase.getdriver().findElement(By.xpath(leftFrontDamage_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(rightFrontDamage_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(leftRearDamage_chkbox)).click();
        testBase.getdriver().findElement(By.xpath(rightRearDamage_chkbox)).click();
    }
}