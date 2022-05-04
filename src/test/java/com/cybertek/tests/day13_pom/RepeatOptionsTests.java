package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBaseLast {

    /*
    Verify radio button
    Open chrome browser
    Login as driver
    Go to Activities-->Calender Events
    Click on create calender events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
     */
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        // Go to Activities-->Calender Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,30);
       // Click on create calender events
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat days selected");
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday is not selected");

    }
    /*verify repeat options
      open chrome browser
      Login as driver
      Go to activities->Calender Events
      Click on create calendar events button
      Click on repeat chechbox
      verify that repeat optins daily,wekkly,montly,yearly(in this order)
     */


    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        // Go to Activities-->Calender Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,30);
        // Click on create calender events
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        // Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        // verify that repeat optins daily,wekkly,montly,yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualoptions = repeatsDropdown.getOptions();
        for (WebElement option : actualoptions) {
            //get text of element and add to actual List
            actualList.add(option.getText());

        }
        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualoptions);

        //verify that repeat optins daily,wekkly,montly,yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"verify daily,weekly,montly,yearly");


    }
}
