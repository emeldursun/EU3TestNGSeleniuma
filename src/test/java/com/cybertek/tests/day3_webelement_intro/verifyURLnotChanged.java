package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyURLnotChanged {

    public static void main(String[] args) {
        /*Verify URL not changed
             -open chrome browser
             -go to http://practice.cydeo.com/forgot_password Link
             -click on Retrieve password
             -verify that url did not change

         */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to link
        driver.get("http://practice.cydeo.com/forgot_password");

        //save expected url before clicking the button
        String expectrdUrl = driver.getCurrentUrl();

        //click on Retrieve password
        //WebElement-->interface that represent element on the webpage
        //findElemment--> method used for find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save actual url after clikicking button
        String actualUrl = driver.getCurrentUrl();

        //verifythat url didnt change
        if(expectrdUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close your browser
        driver.quit();

    }
}
