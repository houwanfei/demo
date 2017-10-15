package com.example.demo.test;

import org.eclipse.jetty.deploy.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houwanfei on 2017/8/24.
 */

class Fruit{}

class Apple extends Fruit{}

class Jonathan extends Apple{}

class Orange extends Fruit{}

public class GenericityTest {
    public static void main(String[] args){
        //List<Fruit> fList = new ArrayList<Apple>();
        List<Apple> aList = new ArrayList<>();
        aList.add(new Jonathan());
        aList.add(new Apple());
    }
}
