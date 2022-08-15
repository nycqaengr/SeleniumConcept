package com.selenium.concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {

    //Drop_Down contains two things:
    //Select itself is a web element. Select is a tag
    //Under Select there is options. Every option is a web element
    //Select the option from the drop_down and we can do it in three different way
    //In side the Select class there three different method such as
    //selectByVisibleText, selectByValue, selectByIndex
    //Drop_down we can't directly handle. First we need to identify the drop_down element
    //and the element we have to pass into Select class object


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C://Drivers//Automation//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement dd_country_element = driver.findElement(By.id("input-country"));
        Select drop_down = new Select(dd_country_element);

        drop_down.selectByVisibleText("Bangladesh"); //By default, one country is selected
        Thread.sleep(2000);
        drop_down.selectByValue("3");
        Thread.sleep(2000);
        drop_down.selectByIndex(11);//index is normally start from zero
        Thread.sleep(3000);

        //Selecting option from dropdown without using method
        List<WebElement> allOptions = drop_down.getOptions();
        for (WebElement option:allOptions) {
            if(option.getText().equals("Cuba")){
                option.click();
                break;
            }
        }
        Thread.sleep(2000);

        //suppose in one page, there are 3 or 4 drop drown. So, every time you will generate these line of code?
        //No, we will create our own drop down method

        String all_value = driver.findElement(By.id("input-country")).getText();
        System.out.println("The values of drop_down are :"+all_value);
        Thread.sleep(3000);

        driver.quit();

    }
}
