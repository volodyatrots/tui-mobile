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
    @AndroidFindBy(id = "android:id/message")
    private WebElement message;


    public void clickSignIn() {
        btnSignIn.click();
    }

    public void loginWithCredentials(String name, String pass) {
        username.sendKeys(name);
        password.sendKeys(pass);
        clickSignIn();
    }

    public String getMessage() {
        return message.getText();
    }


}
