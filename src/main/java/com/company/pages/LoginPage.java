package com.company.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "login")
    private WebElement btnSignIn;
    @AndroidFindBy(accessibility = "username")
    private WebElement username;
    @AndroidFindBy(accessibility = "password")
    private WebElement password;


    public void clickSignIn() {
        btnSignIn.click();
    }

    public void loginWithCredentials(String name, String pass) {
        username.sendKeys(name);
        password.sendKeys(pass);
        clickSignIn();
    }


}
