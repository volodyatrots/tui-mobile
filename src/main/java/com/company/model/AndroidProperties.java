package com.company.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "android")
public class AndroidProperties {

    private String appiumURL;
    private String defaultAndroidAutomationName;
    private String appPackage;
    private String appActivity;
    private String appLocation;

}
