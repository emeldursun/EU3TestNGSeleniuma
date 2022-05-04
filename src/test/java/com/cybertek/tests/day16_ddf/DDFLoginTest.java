package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBaseLast {

    @DataProvider
    public Object[][] userData(){

        ExcelUtil sheet2 = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","Sheet2");

        String [][] dataArray =sheet2.getDataArrayWithoutFirstRow();

        return dataArray;

    }
    @Test(dataProvider = "userData")
    public void test1(String username,String password,String firstname,String lastname,String result){

        extentlogger=report.createTest("Test "+firstname+" "+lastname);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstname+" "+lastname;

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentlogger.pass("PASSED");
        }
}

