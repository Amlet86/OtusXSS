package com.appspot.xssgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FourthLevelPage extends BasePage<FourthLevelPage>{

    public static final By TIMER_INPUT = By.id("timer");
    public static final By BUTTON = By.id("button");

    public FourthLevelPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTimerInput(){
        return driver.findElement(TIMER_INPUT);
    }

    public FourthLevelPage enterTimerValue(String str){
        switchToGameFrame();
        getTimerInput().sendKeys(str);
        switchToParent();
        return this;
    }

    public WebElement getButton(){
        return driver.findElement(BUTTON);
    }

    public FourthLevelPage submit(){
        switchToGameFrame();
        getButton().click();
        switchToParent();
        return this;
    }

    public FifthLevelPage closeAlertAndGoToTheFifthLevel(){
        closeAlertAndGoToTheNextLevel();
        return new FifthLevelPage(driver);
    }



}
