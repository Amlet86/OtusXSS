package com.appspot.xssgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FifthLevelPage extends BasePage<FifthLevelPage> {

    public static final By EMAIL_INPUT = By.id("reader-email");
    public static final By NEXT_LINK = By.cssSelector("#level5 > a");
    public static final String FRAME_URL = "https://xss-game.appspot.com/level5/frame";

    public FifthLevelPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailInput(){
        return driver.findElement(EMAIL_INPUT);
    }

    public FifthLevelPage enterEmail(String str){
        switchToGameFrame();
        getEmailInput().sendKeys(str);
        switchToParent();
        return this;
    }

    public WebElement getNextLink(){
        return driver.findElement(NEXT_LINK);
    }

    public FifthLevelPage clickNextLink(){
        switchToGameFrame();
        getNextLink().click();
        switchToParent();
        return this;
    }

    public SixLevelPage closeAlertAndGoToTheSixLevel(){
        closeAlertAndGoToTheNextLevel();
        return new SixLevelPage(driver);
    }

}
