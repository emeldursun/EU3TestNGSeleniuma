package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public  class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

       //locating radio button
        WebElement radioBlueBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement radioRedBtn = driver.findElement(By.id("red"));


         //how to check radio button is selected
        System.out.println("radioBlueBtn.isSelected() = " + radioBlueBtn.isSelected());
        System.out.println("radioRedBtn.isSelected() = " + radioRedBtn.isSelected());

        //verify blue is selected red is not selected
        //blue-->true
        Assert.assertTrue(radioBlueBtn.isSelected(),"verify blue button is selected");
        //red-->false
        Assert.assertFalse(radioRedBtn.isSelected(),"verify red button os NOT selected");

        //how to click red button
        radioRedBtn.click();

        //blue-->false
        Assert.assertFalse(radioBlueBtn.isSelected(),"verify blue button is NOt selected");
        //red-->true
        Assert.assertTrue(radioRedBtn.isSelected(),"verify red button os  selected");



        Thread.sleep(3000);
        driver.quit();

    }
}
