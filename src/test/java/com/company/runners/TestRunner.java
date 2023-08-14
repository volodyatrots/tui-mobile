package com.company.runners;

import com.company.driver.Driver;
import com.company.util.GlobalParams;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        glue = {"com.company.business", "com.company.spring"},
        plugin = {"pretty", "json:target/cucumber-reports/pixel/Cucumber.json",
                "junit:target/cucumber-reports/pixel/Cucumber.xml",
                "html:target/cucumber-reports/pixel/report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private final GlobalParams globalParams = new GlobalParams();

    @Parameters({"platformName", "automationName", "appiumURL", "appPackage", "appActivity", "appLocation"})
    @BeforeClass(alwaysRun = true)
    public void setParams(String platformName, String automationName, String appiumURL, String appPackage, String appActivity, String appLocation) {
        globalParams.setPlatformName(platformName);
        globalParams.setAutomationName(automationName);
        globalParams.setAppLocation(appLocation);
        globalParams.setAppPackage(appPackage);
        globalParams.setAppActivity(appActivity);
        globalParams.setAppiumURL(appiumURL);
    }


    @AfterClass
    public void tearDown() {
        Driver.close();
    }

}

