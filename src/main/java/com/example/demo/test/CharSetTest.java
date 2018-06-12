package com.example.demo.test;

/**
 * @auther houwanfei
 * @create 2018-05-28 上午11:05
 */
public class CharSetTest {
    public static void main(String[] args) {
        String str = "fuck，所有人";
        try {
            byte[] ios8859 = str.getBytes("ISO-8859-1");
            System.out.println("ISO-8859-1 byte length:" + ios8859.length);
            System.out.println("ISO-8859-1:" + new String(ios8859, "ISO-8859-1"));
            byte[] gb2312 = str.getBytes("GB2312");
            System.out.println("GB2312 byte length:" + gb2312.length);
            System.out.println("GB2312:" + new String(gb2312, "GB2312"));
            byte[] gbk = str.getBytes("GBK");
            System.out.println("GBK byte length:" + gbk.length);
            System.out.println("GBK:" + new String(gbk, "GBK"));
            System.out.println("GB2312 to GBK:" + new String(gb2312, "GBK"));
            System.out.println("GBK to GB2312:" + new String(gbk, "GB2312"));
            byte[] utf16 = str.getBytes("UTF_16");
            System.out.println("UTF-16 byte length:" + utf16.length);
            System.out.println("UTF-16:" + new String(utf16, "UTF-16"));
            byte[] utf8 = str.getBytes("UTF-8");
            System.out.println("UTF-8 byte length:" + utf8.length);
            System.out.println("UTF-8:" + new String(utf8, "UTF-8"));
            System.out.println("UTF-8 to UTF-16:" + new String(utf8, "UTF-16"));
            System.out.println("UTF-16 to UTF-8:" + new String(utf16, "UTF-8"));
        } catch (Exception e){
            System.out.println("fuck");
        }
    }
}
