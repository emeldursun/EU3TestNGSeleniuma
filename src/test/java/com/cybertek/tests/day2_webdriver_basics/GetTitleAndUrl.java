package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        //Task open chrome and navigate to https:/practice.cydeo.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https:/cydeo.com");

        //driver.get("http:/practice.cydeo.com"); de yazabiliriz

        //getting title with selenium

        //shortcut for creating variable alt +enter+ enter
        String title = driver.getTitle();

        //soutv +enter to print variable name and value
        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        

    }
}
