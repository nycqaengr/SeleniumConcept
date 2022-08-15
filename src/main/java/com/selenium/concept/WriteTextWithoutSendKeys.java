package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class WriteTextWithoutSendKeys {
    //JavaScriptExecutor can be used for this purpose
    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\nurul\\IdeaProjects\\SeleniunBasics\\" +
                "BrowserDrivers\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='James'",username);
    }
}
