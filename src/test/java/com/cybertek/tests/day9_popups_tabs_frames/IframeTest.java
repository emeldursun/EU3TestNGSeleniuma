package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

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
    public void test1() throws InterruptedException {
        driver.get("https://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1.Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //tekrar small html e tiklamak istedigimizde 2.yol olarak
        //2.switching with INDEX

        //clear before sendkeys
        driver.switchTo().frame(0);//INDEX NUMBER IS 0 BECAUSE WE ONLY 1 IFRAME ON THE PAGE
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //parenttan tekrar smalla gitmek icin
        //3.USING WEBELEMENT
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with WEBELEMENT");
    }
    @Test
    public void test2(){
        driver.get("https://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under(left.middle and rigt)
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //goes bak to top frame
        driver.switchTo().parentFrame();

        //switching right with INDEX
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //goes to main html to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
