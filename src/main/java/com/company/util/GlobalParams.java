package com.company.util;

import com.company.model.AndroidProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalParams {

    private static final ThreadLocal<String> platformName = new ThreadLocal<>();
    private static final ThreadLocal<String> automationName = new ThreadLocal<>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static final ThreadLocal<String> appPackage = new ThreadLocal<>();
    private static final ThreadLocal<String> appActivity = new ThreadLocal<>() {
    };
    private static final ThreadLocal<String> appiumURL = new ThreadLocal<>() {
    };
    private static final ThreadLocal<String> appLocation = new ThreadLocal<>() {
    };
    @Autowired
    AndroidProperties androidProperties;

    public String getPlatformName() {
        return platformName.get();
    }

    public void setPlatformName(String platformNameNew) {
        platformName.set(platformNameNew);
    }

    public String getAutomationName() {
        return automationName.get();
    }

    public void setAutomationName(String automationNameNew) {
        automationName.set(automationNameNew == null ? androidProperties.getDefaultAndroidAutomationName() : automationNameNew);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceNameNew) {
        deviceName.set(deviceNameNew);
    }

    public String getAppPackage() {
        return appPackage.get();
    }

    public void setAppPackage(String appPackageNew) {
        appPackage.set(appPackageNew == null ? androidProperties.getAppPackage() : appPackageNew);
    }

    public String getAppActivity() {
        return appActivity.get();
    }

    public void setAppActivity(String appActivityNew) {
        appActivity.set(appActivityNew == null ? androidProperties.getAppActivity() : appActivityNew);
    }

    public String getAppiumURL() {
        return appiumURL.get();
    }

    public void setAppiumURL(String appiumURLNew) {
        appiumURL.set(appiumURLNew == null ? androidProperties.getAppiumURL() : appiumURLNew);
    }

    public String getAppLocation() {
        return appLocation.get();
    }

    public void setAppLocation(String appLocationNew) {
        appLocation.set(appLocationNew == null ? androidProperties.getAppLocation() : appLocationNew);
    }


}
