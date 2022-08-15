package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementHandle {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nurul\\IdeaProjects\\SeleniunBasics\\" +
                "BrowserDrivers\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://omayo.blogspot.com/");

        WebElement textAreaField = driver.findElement((By.id("ta1")));
        textAreaField.sendKeys("Software Testing");

        driver.findElement(By.linkText("compendiumdev")).click();
        driver.navigate().back();

        //Again use the same driver
        textAreaField = driver.findElement(By.id("ta1"));
        textAreaField.click();// StaleElementReferenceException
    }
}
