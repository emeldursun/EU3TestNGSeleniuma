package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        //senkeys to fullname
        WebElement fullnameinput = driver.findElement(By.tagName("input"));
        fullnameinput.sendKeys("mike smith with tagname");

       // WebElement emailInput = driver.findElement(By.tagName("input"));
        //emailInput.sendKeys("mike@smith.com");

        //fullname ve emailinput un tagname(input)) ayni oldugu icin email boxuna defilde fullname boxuna yaziyor.
        //insert te iki tane input varsa tagname kullanamayiz.cunku her seferinde 1. tagname i bulup return yapacak
        //digerini aramayacakoy uzden asagidaki gibi yapiyoruz

        //sendkeys to email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@smith.com");

        //lazy way to click button
        driver.findElement(By.tagName("button")).click();


        Thread.sleep(3000);

        driver.quit();

    }
}
