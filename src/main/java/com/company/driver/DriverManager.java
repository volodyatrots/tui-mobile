package com.company.driver;


import com.company.util.GlobalParams;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class DriverManager {

    protected static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    protected GlobalParams globalParams = new GlobalParams();
    protected BaseOptions options = new BaseOptions();

    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    public static void close() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        appiumDriver.remove();
    }

    public abstract void createDriver();
}