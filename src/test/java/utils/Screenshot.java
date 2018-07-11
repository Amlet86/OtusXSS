package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Screenshot {

    public static void take(WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss");
            String filename = "screenshot_"+format.format(date)+".png";
            FileUtils.copyFile(src, new File("target\\screenshots\\"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
