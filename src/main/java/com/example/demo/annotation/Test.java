package com.example.demo.annotation;

/**
 * @auther houwanfei
 * @create 2018-01-18 下午2:25
 */
public class Test {
    public static void main(String[] args) {
        HBeanAnnotation annotation = new HBeanAnnotation();
        try {
            annotation.hBeanAnnotation(AnnotationTest.class);
            AnnotationTest annotationTest = (AnnotationTest) annotation.getBean("annotationTest");
            annotationTest.print();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
