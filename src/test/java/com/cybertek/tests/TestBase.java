package com.cybertek.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
   protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //this class is used for starting and building reports
   protected ExtentReports report;
   //this class is used to create HTML REPORT FILE
   protected ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors and test steps
   protected ExtentTest extentlogger;

   @BeforeTest
   public void setUpTest(){
       //initilaize the class
       report = new ExtentReports();

       //create a report path
       String  projectPath = System.getProperty("user.dir");
       String path = projectPath + "/test-output/report.html";

       //initilaize the html reporter with the report path
       htmlReporter = new ExtentHtmlReporter(path);

       // attach the html report to report object
       report.attachReporter(htmlReporter);

       //title in report
       htmlReporter.config().setReportName("Vytrack smoke test");

       //set envirronment information
       report.setSystemInfo("Environment","QA");
       report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
       report.setSystemInfo("OS",System.getProperty("os.name"));

   }

    @BeforeMethod
    public void setup() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(2000);
        Driver.closeDriver();

    }
    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();
    }
}

