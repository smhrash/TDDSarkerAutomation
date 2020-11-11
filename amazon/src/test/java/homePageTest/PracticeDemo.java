package homePageTest;


import commonAPI.WebAPI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PracticeDemo extends WebAPI {

    public static void main(String[] args) {

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot,new File("/Users/user/IdeaProjects/TDDSarkerAutomation/amazon/lib/Screenshots"));
            System.out.println("Screenshot Taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
