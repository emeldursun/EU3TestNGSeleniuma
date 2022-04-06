package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.BrowserUtils;
import org.testng.annotations.Test;

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

//       calendarEventsPage.waitUntilLoaderScreenDisappear();
  BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,30);
       // Click on create calender events
        calendarEventsPage.createCalendarEvent.click();




    }
}
