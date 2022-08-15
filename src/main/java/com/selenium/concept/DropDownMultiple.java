package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownMultiple {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Approach 1: Lengthy
  /*      WebElement noOfEmpDD = driver.findElement(By.name("NoOfEmployees"));
        Select drop_down_emp = new Select(noOfEmpDD);
        drop_down_emp.selectByVisibleText("16 - 20");

        WebElement industryDD = driver.findElement(By.name("Industry"));
        Select drop_down_ind = new Select(industryDD);
        drop_down_ind.selectByVisibleText("Travel");

        WebElement countryDD = driver.findElement(By.name("Country"));
        Select drop_down_country = new Select(countryDD);
        drop_down_country.selectByVisibleText("Aruba");*/

        //Approach 2:
        WebElement noOfEmpDD = driver.findElement(By.name("NoOfEmployees"));
        selectOptionFromDropDown(noOfEmpDD,"16 - 20");

        WebElement industryDD = driver.findElement(By.name("Industry"));
        selectOptionFromDropDown(industryDD,"Healthcare");

        WebElement countryDD = driver.findElement(By.name("Country"));
        selectOptionFromDropDown(countryDD,"Ghana");
    
    }

    public static void selectOptionFromDropDown(WebElement element, String value){
        Select drop_down = new Select(element);

        List<WebElement> allOptions = drop_down.getOptions();
        for (WebElement option:allOptions) {
            if(option.getText().equals(value)){
                option.click();
                break;
            }
        }

    }

}
