package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//What is the difference between frame and iframe?
//iframe having some content which is coming from different source.
public class HandlingIFrame {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        driver.switchTo().frame("packageListFrame");//entering to frame 1
        driver.findElement(By.linkText("org.openqa.selenium")).click();//inside the frame1
        driver.switchTo().defaultContent();// go back to the page or focus on page
        Thread.sleep(3000);

        driver.switchTo().frame("packageFrame");//entering to frame 2
        driver.findElement(By.linkText("WebDriver")).click();//inside the frame2
        driver.switchTo().defaultContent();// go back to the page or focus on page
        Thread.sleep(5000);

        driver.switchTo().frame("classFrame");//entering to frame 2
        driver.findElement(By.xpath("//body[1]/header[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]")).click();//inside the frame3
        Thread.sleep(2000);
        driver.quit();
    }
}
