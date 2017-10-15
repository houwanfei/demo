package com.example.demo.test;

/**
 * Created by houwanfei on 2017/9/18.
 */

class Subtype extends BasicHolder<Subtype>{

}
public class TestBasicHolder {
    public static void main(String[] args){
        Subtype subtype1 = new Subtype();
        Subtype subtype2 = new Subtype();
        subtype1.setElement(subtype2);
        Subtype subtype3 = subtype1.getElement();
        subtype1.f();
    }
}
