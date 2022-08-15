package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClearFromText {

    //Clear the text inside the text box field
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://omayo.blogspot.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).clear();
        Thread.sleep(5000);
        driver.quit();
    }
}
