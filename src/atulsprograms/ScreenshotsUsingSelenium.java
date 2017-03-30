package atulsprograms;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ScreenShotUsingSelenium {
   
    public static void main(String args[]) throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "//chromedriver");
   
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
       
        //typecast webdriver instance to TakeScreenShot
        TakesScreenshot srcShot = ((TakesScreenshot)driver);
       
        //call the getScreenshotAs() method of TakeScreenshot
        File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("//pathToStoreImageFile/test.png");
        FileUtils.copyFile(SrcFile, DestFile);
    }   
}