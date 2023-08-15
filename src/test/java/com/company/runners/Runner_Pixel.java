package com.company.runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login.feature"
)
public class Runner_Pixel extends AndroidTestRunner {
}
