package com.company.business;

import com.company.model.ErrorMessages;
import com.company.model.User;
import com.company.pages.LoginPage;
import com.company.util.CsvManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LoginBO {

    @Autowired
    LoginPage loginPage;


    @When("I login")
    public void login() {
        loginPage.clickSignIn();
    }


    @When("I login with invalid credentials")
    public void iLoginWithInvalidCredentials() {
        int firstRecord = 0;
        List<User> csvDataAsList = CsvManager.getCsvDataAsList("users.csv", User.class);
        loginPage.loginWithCredentials(csvDataAsList.get(firstRecord).getUserName(), csvDataAsList.get(firstRecord).getPassword());
    }

    @Then("error message should appear")
    public void errorMessageShouldAppear() {
        Map<String, String> errors = CsvManager.getCsvDataAsList("errorMessages.csv", ErrorMessages.class).stream().collect(
                Collectors.toMap(ErrorMessages::getError, ErrorMessages::getMessage));
        Assert.assertEquals(loginPage.getMessage(), errors.get("login_error"));
    }
}
