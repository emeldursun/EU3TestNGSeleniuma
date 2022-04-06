package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTItle = "Cybertek";

        Assert.assertTrue(actualTItle.startsWith(expectedTitle));
    }

    @Test
    public void test4(){
        //verify email contains @ sign
        String email = "mike@smith";

        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not grater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
