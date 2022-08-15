package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementHandle2 {
    //Stale means old, delayed, no longer fresh
    //Stale element means an old element or no longer available element
    //Assume there is an element that is found on a web page referenced as a WebElement in WebDriver.
    //If the DOM changes then the WebElement goes stale. If we try to interact which is staled then the
    //STaleElementReferenceException thrown
    //When this happens you will need to refresh your reference, or find the element again.
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurul\\IdeaProjects\\SeleniunBasics\\" +
                "BrowserDrivers\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.pavantestingtool.com/");
        Thread.sleep(3000);

        WebElement link = driver.findElement(By.xpath(""));
        link.click();
        driver.navigate().back();
        Thread.sleep(4000);
        try{
            link.click();
        } catch (StaleElementReferenceException e){
            link = driver.findElement(By.xpath(""));
            link.click();
        }}}
