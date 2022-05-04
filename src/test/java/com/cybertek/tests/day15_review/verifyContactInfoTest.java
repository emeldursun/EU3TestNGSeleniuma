package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBaseLast;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBaseLast {

    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailTest(){

        extentlogger = report.createTest("Contack info verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentlogger.info("username:"+username);
        extentlogger.info("password:"+password);
        extentlogger.info("Login as a Sales manager");
        loginPage.login(username,password);

       // DashboardPage dashboardPage = new DashboardPage();

        //if you want to use one time(one action)  sag tarafi alip .
        // tiklayip methodlari secebiliriz.ama birden fazla method kullanacak isek
        //object olusturup o sekilde yapmamiz lazim

        extentlogger.info("Navigate to --> Customer contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage = new ContactsPage();

        extentlogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedfullname = "Mariam Brackstone";
        String actualFullname = contactInfoPage.fullname.getText();

        extentlogger.info("Verify fullname is" + expectedfullname);
        Assert.assertEquals(actualFullname,expectedfullname,"verify fullname");

        extentlogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");

        extentlogger.info("verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentlogger.pass("PASSED");



    }





}
