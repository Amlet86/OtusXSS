package com.appspot.xssgame.pages;

import org.openqa.selenium.WebDriver;

public class SixLevelPage extends BasePage<SixLevelPage> {

    public static final String FRAME_URL = "https://xss-game.appspot.com/level6/frame";

    public SixLevelPage(WebDriver driver) {
        super(driver);
    }

    public SuccessPage closeAlertAndGoToTheSuccessPage(){
        closeAlertAndGoToTheNextLevel();
        return new SuccessPage(driver);
    }
}
