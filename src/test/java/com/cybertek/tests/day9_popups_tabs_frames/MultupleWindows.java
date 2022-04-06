package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultupleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void SwitchWindowsTest(){
        driver.get("https://practice.cybertekschool.com/windows");

        ////get title
        System.out.println("Title before new window: " + driver.getTitle());

        System.out.println("Title after new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currrentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currrentWindowHandle)){

            }
        }
        System.out.println("Title after switch new window: " + driver.getTitle());
    }
    @Test
    public void moreThan2Window(){
        driver.get("https://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("before switch: " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

              //loop througt each window
        for (String handle : driver.getWindowHandles()) {
            //one by one change it
            driver.switchTo().window(handle);

            //whenever yourtitle equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("After Switch :" + driver.getTitle());

    }


    }

