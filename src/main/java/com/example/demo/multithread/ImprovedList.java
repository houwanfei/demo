package com.example.demo.multithread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 采用组合的方式,使用委托的方式
 * @param <T>
 */
public class ImprovedList<T> {
    private final List<T> list;

    public ImprovedList(List<T> list){
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x){
        boolean contains = list.contains(x);
        if (!contains){
            list.add(x);
        }
        return contains;
    }

    public synchronized void clear(){
        list.clear();
    }

}
