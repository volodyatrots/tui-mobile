package com.company.driver;


import com.company.util.GlobalParams;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;


@Log4j2
public class Driver {
    private static final GlobalParams params = new GlobalParams();
    private static AppiumDriver appiumDriver;

    private Driver() {
    }


    private static void createDriver() {
        try {
            BaseOptions options = new BaseOptions()
                    .setPlatformName(params.getPlatformName())
                    .setAutomationName(params.getAutomationName())
                    .amend("autoGrantPermissions", true)
                    .amend("appPackage", params.getAppPackage())
                    .amend("app", params.getAppLocation())
                    .amend("appActivity", params.getAppActivity());
            URL url = new URL(params.getAppiumURL());
            appiumDriver = new AppiumDriver(url, options);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static void close() {
        try {
            if (getAppiumDriver() != null) {
                getAppiumDriver().quit();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static WebDriver getAppiumDriver() {
        if (appiumDriver == null) {
            createDriver();
        }
        return appiumDriver;
    }


}
