package com.example.demo;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther houwanfei
 * @create 2017-12-08 下午12:21
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek((e) -> {System.out.println("filter value:" + e);})
                .map(String::toUpperCase)
                .peek(e -> System.out.println("map value:" + e))
                .collect(Collectors.toList());

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);

    }
}
