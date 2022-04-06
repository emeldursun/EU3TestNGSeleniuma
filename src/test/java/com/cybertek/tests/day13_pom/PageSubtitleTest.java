package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBaseLast {

/*
*Test case
* Open Chrome browser
* Login as a Driver
* Verify that page subtitle is Quick Launchpad
* Go to Activities ->Calender Events
* Verify that page subtitle is Calender Events
 */
    @Test
    public void test1(){

        LoginPage loginpage = new LoginPage();

        loginpage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","" + "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(5);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify subtitle Calendar Events");
    }
}
