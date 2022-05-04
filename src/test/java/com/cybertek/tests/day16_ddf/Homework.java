package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class Homework extends TestBaseLast {

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       calendarEventsPage.getPageSubTitle();
       calendarEventsPage.waitUntilLoaderScreenDisappear();
       WebElement options= driver.findElement(By.xpath("//div[contains(text(),'Options')]"));
       System.out.println(options.isDisplayed());
       Assert.assertTrue(options.isDisplayed());
    }
    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String actual = calendarEventsPage.page_number.getText();

        Assert.assertEquals( actual, "1");




        }





    }


        



    
