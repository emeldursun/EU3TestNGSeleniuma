package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBaseLast {

    @Test
    public void loginAsDriver() {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager() {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.usernameInput.sendKeys(username);
////        loginPage.passwordInput.sendKeys(password);
////        loginPage.loginButton.click()

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager2() {

        LoginPage loginPage = new LoginPage();

//        String username = ConfigurationReader.get("storemanager_username");
//        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.usernameInput.sendKeys(username);
////        loginPage.passwordInput.sendKeys(password);
////        loginPage.loginButton.click()

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

}