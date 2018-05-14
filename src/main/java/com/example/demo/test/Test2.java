package com.example.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther houwanfei
 * @create 2018-02-26 下午5:40
 */
public class Test2 {
    static String sendGet(String url){
        //定义一个字符串用来存储网页内容
        String result = "";
        //定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            //将String转成url对象
            URL realUrl = new URL(url);
            //初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            //开始实际的连接
            connection.connect();
            //初始化BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //用来临时存储抓取到的每一行数据
            String line;
            while ((line = in.readLine()) != null){
                //遍历抓取到的每一行并将其存储到result里面
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    static String RegexString(String targetStr, String patternStr){
        //定义一个样式模板， 此中使用正则表达式，括号中是要抓取的内容
        //相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern = Pattern.compile(patternStr);
        //定义一个matter用来作匹配
        Matcher matcher = pattern.matcher(targetStr);
        //如果找到了
        if (matcher.find()) {
            //打印出结果
            return matcher.group(0);
        }
        return "Nothing";
    }

    public static void main(String[] args){
        //定义即将访问的连接
        String url = "http://www.baidu.com";
        //访问链接并获取页面内容
        String result = sendGet(url);
        //使用正则匹配图片的src内容
        String imgSrc = RegexString(result, "src=.*png");
        System.out.print(imgSrc);
    }
}

