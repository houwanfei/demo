package com.example.demo.test;



import java.lang.reflect.InvocationTargetException;

/**
 * Created by houwanfei on 2017/8/3.
 */

class Building{
    public void a(){
        System.out.println("building a");
    }
}
class House extends Building{
    public void a(){
        System.out.println("house a");
    }

    public void b(){
        System.out.println("house b");
    }
}
public class GenericIntClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        /*Class<?> intClass = int.class;
        intClass = double.class;

        System.out.println(intClass);*/
        Building build = new House();
        build.a();

        Class<? extends Building> building = (Class<? extends Building>) Class.forName("com.example.demo.test.House");
        House houseTest = (House) building.newInstance();
        building.getMethod("a",null).invoke(houseTest,null);
    }
}
