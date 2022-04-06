package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskCheckboxVerification {
    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkBoxOption1 = driver.findElement(By.id("checkBoxOption1"));// driver ina checkbox 1 i tanimliyorsun
        WebElement checkBoxOption2 = driver.findElement(By.id("checkBoxOption2"));
        System.out.println("checkBoxOption1.isSelected() = " + checkBoxOption1.isSelected());    //is.Selected demek soru sormak.. yani checkbox one slected mi. Iki cevap olabilir evet/hayir yani true false
        System.out.println("checkBoxOption2.isSelected() = " + checkBoxOption2.isSelected());


        checkBoxOption1.click();// option 1 i click yap
        Assert.assertFalse(checkBoxOption1.isSelected(),"option1 is selected");//option 1 secilmis ise testi pass yap ve consola birsey yazma, eger option1 secilmemisse testi fail yap ve
        Assert.assertFalse(checkBoxOption2.isSelected(),"option2 is not selected");

        WebElement radiobutton1 = driver.findElement(By.xpath("//input[@value='radio1']"));
        WebElement radiobutton2 = driver.findElement(By.xpath("//input[@value='radio2']"));

        radiobutton1.click();
        Assert.assertTrue(radiobutton1.isSelected(),"button 1 is selected");
        Assert.assertFalse(radiobutton2.isSelected(),"button 2 is not selected");

        driver.quit();








    }
}
