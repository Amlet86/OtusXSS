package com.appspot.xssgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondLevelPage extends BasePage<SecondLevelPage> {

    public static final By TEXTAREA = By.id("post-content");
    public static final By BUTTON = By.cssSelector("input.share");

    public SecondLevelPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTextArea(){
        return driver.findElement(TEXTAREA);
    }

    public SecondLevelPage enterText(String str){
        switchToGameFrame();
        getTextArea().sendKeys(str);
        switchToParent();
        return this;
    }

    public WebElement getButton(){
        return driver.findElement(BUTTON);
    }

    public SecondLevelPage submit(){
        switchToGameFrame();
        getButton().click();
        switchToParent();
        return this;
    }

    public ThirdLevelPage closeAlertAndGoToTheThirdLevel(){
        closeAlertAndGoToTheNextLevel();
        return new ThirdLevelPage(driver);
    }

}
