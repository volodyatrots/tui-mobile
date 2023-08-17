package com.company.driver;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.time.Duration;


@Log4j2
public class IphoneManager extends DriverManager {

    @Override
    public void createDriver() {
        try {
            options
                    .setPlatformName(globalParams.getPlatformName())
                    .setAutomationName(globalParams.getAutomationName())
                    .amend("autoGrantPermissions", true)
                    .amend("appPackage", globalParams.getAppPackage())
                    .amend("app", globalParams.getAppLocation())
                    .amend("appActivity", globalParams.getAppActivity());
            URL url = new URL(globalParams.getAppiumURL());
            AndroidDriver driver = new AndroidDriver(url, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            appiumDriver.set(driver);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}