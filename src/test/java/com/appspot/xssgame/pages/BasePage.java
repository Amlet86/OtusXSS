package com.appspot.xssgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Screenshot;

public class BasePage<T> {

    @FindBy(css = "iframe.game-frame")
    WebElement frame;

    public static final By NEXTBUTTON = By.cssSelector(".next-button");
    public static final int TIMEOUT = 2;
    public static final By URL_BAR = By.cssSelector(".urlbar");
    public static final By URL_BUTTON = By.cssSelector(".urlbutton");

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToGameFrame(){
        driver.switchTo().frame(frame);
    }

    public void switchToParent(){
        driver.switchTo().defaultContent();
    }

    public WebElement getNextButton(){
        return driver.findElement(NEXTBUTTON);
    }

    public T clickNextButton(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(getNextButton()));
        getNextButton().click();
        return (T)this;
    }

    public void waitAlert(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public T closeAlert(){
        waitAlert();
        driver.switchTo().alert().accept();
        switchToParent();
        return (T)this;
    }

    public WebElement getUrlBar(){
        return driver.findElement(URL_BAR);
    }

    public T enterUrl(String str){
        getUrlBar().clear();
        getUrlBar().sendKeys(str);
        return (T)this;
    }

    public WebElement getUrlButton(){
        return driver.findElement(URL_BUTTON);
    }

    public T clickGo(){
        getUrlButton().click();
        return (T) this;
    }

    public T pressEnterOnUrlBar(){
        getUrlBar().sendKeys(Keys.ENTER);
        return (T)this;
    }

    public T closeAlertAndGoToTheNextLevel(){
        closeAlert();
        Screenshot.take(driver);
        clickNextButton();
        return (T)this;
    }

}
