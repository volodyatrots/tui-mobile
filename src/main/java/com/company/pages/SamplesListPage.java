package com.company.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SamplesListPage extends BasePage {

    @AndroidFindBy(accessibility = "scrollView")
    private WebElement scrollMenu;


    public boolean isMenuDisplayed() {
        return scrollMenu.isDisplayed();
    }


}
