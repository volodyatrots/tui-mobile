package com.company.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.company.business", "com.company.pages", "com.company.util", "com.company.spring", "com.company"})
public class UiSpringConfig {
}
