package com.appspot.xssgame.pages;

import org.openqa.selenium.WebDriver;

public class ThirdLevelPage extends BasePage<ThirdLevelPage> {

    public static final String FRAME_URL = "https://xss-game.appspot.com/level3/frame";

    public ThirdLevelPage(WebDriver driver) {
        super(driver);
    }

    public FourthLevelPage closeAlertAndGoToTheFourthLevel(){
        closeAlertAndGoToTheNextLevel();
        return new FourthLevelPage(driver);
    }

}
