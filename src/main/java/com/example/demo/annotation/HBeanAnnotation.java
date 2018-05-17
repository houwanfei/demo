package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther houwanfei
 * @create 2018-01-18 下午2:16
 */
public class HBeanAnnotation {
    private static Map<String, Object> factoryBeans = new ConcurrentHashMap<>();

    public void hBeanAnnotation(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        HBean hBean = clazz.getDeclaredAnnotation(HBean.class);
        if (hBean != null){
            factoryBeans.put(hBean.value(), clazz.newInstance());
        }
    }

    public  Object getBean(String value){
        return factoryBeans.get(value);
    }
}
