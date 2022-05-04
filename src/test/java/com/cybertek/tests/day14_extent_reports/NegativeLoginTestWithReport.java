package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBaseLast {

    @Test
    public void wrongPasswordTest(){
        //name of test
        extentlogger =report.createTest("wrong password test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentlogger.info("Enter Username");

        loginPage.passwordInput.sendKeys("somepassword");
        extentlogger.info("Enter Password: somepaassword");

        loginPage.loginButton.click();
        extentlogger.info("click Login button");

        extentlogger.info("verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentlogger.pass("Wrong password Test passed");
    }

    @Test
    public void wrongUsernameTest(){

        //name of the test
        extentlogger =report.createTest("wrong username test");

        LoginPage loginPage = new LoginPage();

        extentlogger.info("Enter Username:someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentlogger.info("Enter password: UserUSer123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentlogger.info("Click Login Button");
        loginPage.loginButton.click();

        extentlogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentlogger.pass("Passed");
    }
}
