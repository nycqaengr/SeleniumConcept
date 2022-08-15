package com.selenium.concept;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Take_ScreeShot {

    static WebDriver driver;
    public static void main(String[] args) throws IOException {
        Date currentDate = new Date();
        System.out.println(currentDate);
        String screenshotfilename = currentDate.toString().replace(" ","-").replace(":","-");
        System.out.println(screenshotfilename);

        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Converting the driver to the screenshot object and Call getScreenshotAs method to create image file
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(".//screenshot"+screenshotfilename+".png"));
        driver.quit();
    }
}
