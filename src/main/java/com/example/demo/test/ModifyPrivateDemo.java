package com.example.demo.test;

import com.example.demo.entity.FilmTag;

import java.lang.reflect.Field;

/**
 * Created by houwanfei on 2017/8/6.
 */
public class ModifyPrivateDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FilmTag fm = new FilmTag();
        System.out.println(fm.getId());
        Field id = fm.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(fm,23);
        System.out.println(fm.getId());
    }
}
