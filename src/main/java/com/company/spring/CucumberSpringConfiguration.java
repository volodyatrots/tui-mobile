package com.company.spring;

import com.company.model.AndroidProperties;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = UiSpringConfig.class)
@EnableConfigurationProperties(AndroidProperties.class)
public class CucumberSpringConfiguration {
}
