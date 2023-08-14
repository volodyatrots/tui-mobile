package com.company.business;

import com.company.pages.SamplesListPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;


public class SamplesListBO {

    @Autowired
    SamplesListPage samplesListPage;

    @Then("samples list should appear")
    public void samplesListShouldBeDisplayed() {
        Assert.assertTrue(samplesListPage.isMenuDisplayed(), "List is missing");
    }

}
