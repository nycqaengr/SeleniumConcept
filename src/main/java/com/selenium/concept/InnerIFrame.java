package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InnerIFrame {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
        WebElement outerIFrame = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(outerIFrame);// Here we are passing frame as a web element

        WebElement innerIFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerIFrame);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
        Thread.sleep(5000);
    }
}
