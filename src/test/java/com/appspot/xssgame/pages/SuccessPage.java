package com.appspot.xssgame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import static org.testng.Assert.assertEquals;

public class SuccessPage extends BasePage<SuccessPage> {

    @FindBy(id = "level-title")
    WebElement title;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public void getCongratulations(){
        Screenshot.take(driver);
        assertEquals(title.getText(), "Congratulations!");
    }
}
