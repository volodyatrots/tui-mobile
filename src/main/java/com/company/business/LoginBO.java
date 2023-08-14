package com.company.business;

import com.company.pages.LoginPage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginBO {

    @Autowired
    LoginPage loginPage;


    @When("I login")
    public void login() {
        loginPage.clickSignIn();
    }


}
