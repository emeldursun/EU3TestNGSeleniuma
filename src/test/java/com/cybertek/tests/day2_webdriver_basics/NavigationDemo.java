package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //navigate to another website with different selenium method
        driver.navigate().to("https://www.facebook.com");

        //bir onceki sayfaya geri gitmeden ne jadar belemesini istiyorsak
        Thread.sleep(3000);
        
        //goes back to previos page
        driver.navigate().back();

        //goes back to back
        driver.navigate().forward();

        //refresh to webpage
        driver.navigate().refresh();
    }
    }

