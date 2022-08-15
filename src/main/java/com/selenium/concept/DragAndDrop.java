package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    //We need to know the source element and the target element
    //From where I Drag and where I drop it
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement source_element = driver.findElement(By.id("box1"));//Oslo-source element
        WebElement target_element = driver.findElement(By.id("box101"));//Norway-target element

        WebElement source_element1 = driver.findElement(By.id("box3"));//Oslo-source element
        WebElement target_element1 = driver.findElement(By.id("box103"));//Norway-target element

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(source_element, target_element).build().perform();
        actions.dragAndDrop(source_element1, target_element1).build().perform();
        Thread.sleep(3000);
        driver.quit();
   }
}
