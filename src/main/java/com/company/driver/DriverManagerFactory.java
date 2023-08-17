package com.company.driver;


public class DriverManagerFactory {

    public static DriverManager getManager(String platformName) {

        DriverManager driverManager;

        DriverType type = DriverType.valueOf(platformName.toUpperCase());

        switch (type) {
            case ANDROID:
                driverManager = new AndroidManager();
                break;
            case IOS:
                driverManager = new IphoneManager();
                break;
            default:
                driverManager = new AndroidManager();
                break;
        }
        return driverManager;
    }
}