package com.company.runners;


import com.company.driver.DriverManager;
import com.company.driver.DriverManagerFactory;
import com.company.util.GlobalParams;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        glue = {"com.company.business", "com.company.configuration"},
        plugin = {"pretty", "json:target/cucumber-reports/pixel/Cucumber.json",
                "junit:target/cucumber-reports/pixel/Cucumber.xml",
                "html:target/cucumber-reports/pixel/report.html"},
        monochrome = true
)
public class AndroidTestRunner extends AbstractTestNGCucumberTests {

    private final GlobalParams globalParams = new GlobalParams();

    @Parameters({"platformName", "automationName", "appiumURL", "appPackage", "appActivity", "appLocation"})
    @BeforeTest(alwaysRun = true)
    public void init(@Optional("Android") String platformName, @Optional String automationName, @Optional String appiumURL, @Optional String appPackage, @Optional String appActivity, @Optional String appLocation) {
        globalParams.setPlatformName(platformName);
        globalParams.setAutomationName(automationName);
        globalParams.setAppLocation(appLocation);
        globalParams.setAppPackage(appPackage);
        globalParams.setAppActivity(appActivity);
        globalParams.setAppiumURL(appiumURL);
        DriverManagerFactory.getManager(platformName).createDriver();
    }


    @AfterClass
    public void tearDown() {
        DriverManager.close();
    }

}

