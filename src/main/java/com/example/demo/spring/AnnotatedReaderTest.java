package com.example.demo.spring;

import com.example.demo.annotation.AnnotationTest;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @auther houwanfei
 * @create 2018-01-19 下午4:55
 */
public class AnnotatedReaderTest {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        AnnotationScopeMetadataResolver resolver = new AnnotationScopeMetadataResolver();
        annotatedBeanDefinitionReader.setScopeMetadataResolver(resolver);

        annotatedBeanDefinitionReader.register(AnnotationTest.class);
        context.refresh();
        AnnotationTest annotationTest = context.getBeanFactory().getBean(AnnotationTest.class);
        annotationTest.print();
    }
}
