package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class CountingLink {
    //Total count of links on web page
    //get links text name
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.smartbear.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        //reading all the links from web page and display
        for (WebElement e: links) {
            System.out.println(e.getText());
        }
    }
}
