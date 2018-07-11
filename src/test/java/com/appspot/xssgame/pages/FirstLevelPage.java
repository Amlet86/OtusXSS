package com.appspot.xssgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class FirstLevelPage extends BasePage<FirstLevelPage> {

    public static final By INPUT = By.id("query");
    public static final By BUTTON = By.id("button");
    public static final String URL = "https://xss-game.appspot.com/level1";

    public FirstLevelPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInput(){
        return driver.findElement(INPUT);
    }

    public WebElement getButton(){
        return driver.findElement(BUTTON);
    }

    public FirstLevelPage open(){
        driver.get(URL);
        return this;
    }

    public static FirstLevelPage open(WebDriver driver){
        FirstLevelPage firstLevelPage = new FirstLevelPage(driver);
        firstLevelPage.open();
        return firstLevelPage;
    }

    public FirstLevelPage submit(){
        switchToGameFrame();
        getButton().click();
        switchToParent();
        return this;
    }

    public FirstLevelPage enterQuery(String str){
        switchToGameFrame();
        getInput().sendKeys(str);
        switchToParent();
        return this;
    }

    public SecondLevelPage closeAlertAndGoToTheSecondLevel(){
        closeAlertAndGoToTheNextLevel();
        return new SecondLevelPage(driver);
    }

    public FirstLevelPage checkMySecretVariable(){
        switchToGameFrame();
        String result = (String)((JavascriptExecutor)driver).executeScript("return MySecretXssVariable;");
        assertEquals(result,"Hello World!");
        switchToParent();
        return this;
    }

}
