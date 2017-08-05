package com.example.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by houwanfei on 2017/8/1.
 */
public class PatternTest {

    public static void main(String[] args){
        String num = "\\d";
        String testStr = "hou1wan2fei3";

        Matcher m = Pattern.compile(num).matcher(testStr);
        System.out.println("Test");

        while(m.find()){
            for(int j=0;j<=m.groupCount();j++){
                System.out.println(m.group(j));
            }
        }
    }
}
