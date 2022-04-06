package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchange {
    public static void main(String[] args) {
        /* open chrome browse
        go to http://practice.cydeo.com/forgot_password
        enter any email
        click on Retrieve password
        verify that url changed http://practice.cydeo.com/email_sent
     */
        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cydeo.com/forgot_password
        driver.get("http://practice.cydeo.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys--> send keyboard action to the WebElement
        emailInputBox.sendKeys("mikesmith@gmail.com");

        //click retrieve password button
        WebElement retrievePasswordbutton = driver.findElement(By.id("form_submit"));
        retrievePasswordbutton.click();

        //TASK
        //verify that url change to "http://practice.cydeo.com/email_sent"
        //create expectedUrl
        String expectedUrl = "http://practice.cydeo.com/email_sent";

        //saving actual url from browser after we enter any e mail and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //close browser
        driver.quit();
    }
}
