package com.company.pages;


import com.company.driver.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    @AndroidFindBy(id = "android:id/message")
    private WebElement message;

    BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    public String getMessage() {
        return message.getText();
    }

}
