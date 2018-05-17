package com.example.demo.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther houwanfei
 * @create 2018-01-16 下午4:33
 */
public class StreamSumTest {

    private static double sqrt(double c){
        if (c < 0){
            return Double.NaN;
        }

        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t){
            t = (c/t + t) / 2.0;
        }
        return t;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("13442");
        list.add("244");
        list.add("3566");
        list.add("43");

        int sum = list.stream().mapToInt(String::length).sum();
        System.out.println(sum);

        System.out.println(sqrt(16));
    }
}
