package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument1: location of the file(path)
        //Argument2: shheet that we want to open(shhetName)

        ExcelUtil sheet2 = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","Sheet2");

        //how many rows in the sheet
        System.out.println("sheet2.rowCount() = " + sheet2.rowCount());

        //how many columns in the sheet
        System.out.println("sheet2.columnCount() = " + sheet2.columnCount());

        //get all column names
        System.out.println("sheet2.getColumnsNames() = " + sheet2.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = sheet2.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
            
        }

        //get Yasmine as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        //get nicolas
        System.out.println("dataList.get(1) = " + dataList.get(1).get("lastname"));

        //get all data in 2d array
        String [][] dataArray = sheet2.getDataArray();

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));

}}
