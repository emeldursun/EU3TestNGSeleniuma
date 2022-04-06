package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    //singleton class will have private constructor
    //it means other casses cannot create object of this class
    private  Singleton(){}

    private static String str;

    public static String getInstance(){

        //if str has no value, initiallize and return it
        if(str==null){
            System.out.println("str is null.assignig value it");
            str = "somevalue";
        }else{
            //if it has value return it
            System.out.println("it has value ,just returning it");
        }
        return str;
    }

    }

