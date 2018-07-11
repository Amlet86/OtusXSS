package com.appspot.xssgame.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {

    WebDriver driver;


    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void close(){
        driver.quit();
        driver = null;
    }

    public String[] readCheatSheet(String filename){
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(new File("src/test/resources/"+filename),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[lines.size()]);
    }

    public Object[][] getDataFromFile(String filename){
        String[] lines = readCheatSheet(filename);
        Object[][] cheatsheet = new Object[lines.length][1];
        int count = 0;
        for (String line: lines){
            cheatsheet[count][0]=line;
            count++;
        }
        return cheatsheet;
    }
}
