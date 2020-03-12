package com.firestarters.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    //generate random string
    public static String getRandomString(){
        String s= RandomStringUtils.randomAlphabetic(6);
        return s;
    };
    public static String stringReplace(String s){
        //System.out.println(s);
        String s1=s.replace(" $US","").replace("$", "");
       //System.out.println(s);
        String s2=s1.replace(",",".");
        return s2;

    }
    public static double convertStringToDouble(String s){
        //System.out.println(s);
        Double doubleVal = Double.parseDouble(s);
        return doubleVal;
   }



}
