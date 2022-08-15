package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Selenium doesn't have synchronization, selenium provide synchronization through different type of wait.
// wait is an interface and WevDriverWait is a class.
public class Synchronization {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Do we need implicitly and explicitly wait together? NO
        //We should avoid implicitly wait because it's a global wait
        //Suppose we are setting implicitly wait 20 seconds and explicitly wait for 10 seconds
        //So it's taking 30 seconds for a particular elements

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));//Dynamic waits
        //If the page are loaded in 2 secs then rest of the 18 seconds will be ignored. It's not gonna wait for 20 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        //ctrl+space
        //implicitlyWait--is always applied globally---is available for all the web elements
        //dynamic in nature and it can be changed anywhere and at any time in your code
        //If driver is interacting with 15 elements it will be applied for 15 elements
        //No such element exception

        //Explicit wait:
        //1. No explicit keyword or method
        //2. available with WebDriverWait with some ExpectedConditions
        //3. specific to element
        //4. dynamic in nature
        //We should and never use implicit wait and explicit wait together
        //Because selenium WebDriver will wait for the element first because of IMPLICIT WAIT and
        // then EXPLICIT WAIT will be applied
        //Hence, total synchronization wait will be increased for each element

        driver.get("https://www.facebook.com/");

        WebElement createNewAccount = driver.findElement(By.linkText("open-registration-form-button"));
        clickOn(driver, createNewAccount,5);

        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));

        WebElement mobileNum = driver.findElement(By.name("reg_email__"));
        WebElement password = driver.findElement(By.name("reg_passwd__"));

        sendKeys(driver, firstName, 10, "Nurul");
        sendKeys(driver, lastName, 5, "Mahmud");
        sendKeys(driver, mobileNum, 5, "9173611286");
        sendKeys(driver, password, 10, "Mahmud@2020");

        /*WebElement forgotAccount =  driver.findElement(By.linkText("Forgot password?"));
        clickOn(driver, forgotAccount, 5);*/

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //You can overwrite implicitly wait any time because it's a global wait
    }

   public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    public static void clickOn(WebDriver driver, WebElement element, int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
