package com.example.demo.test;

/**
 * Created by houwanfei on 2017/9/19.
 */
public class RotateString {
    public static void rotateString(char[] chars, int n, int m){
        m %= n;
        reverseString(chars, 0, m-1);
        reverseString(chars, m, n-1);
        reverseString(chars, 0, n-1);

    }
    public static void reverseString(char[] chars, int from, int to){
        while(from <to){
            char c = chars[from];
            chars[from] = chars[to];
            chars[to] = c;
            from++;
            to--;
        }
    }

    public static void main(String[] args){
        char[] chars = "abcdef".toCharArray();
        rotateString(chars,6, 8);
        System.out.println(chars);
    }
}
