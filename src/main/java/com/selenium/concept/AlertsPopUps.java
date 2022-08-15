package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopUps {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();//closes pop up by OK button.
        //driver.switchTo().alert().dismiss();
        //driver.switchTo().alert().getText();
        //driver.switchTo().alert().sendKeys("Text");
        //driver.close();
        driver.quit();
    }
}
