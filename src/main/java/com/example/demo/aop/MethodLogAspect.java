package com.example.demo.aop;

import com.example.demo.annotation.MethodLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodLogAspect {

    @Pointcut("execution(* com.example.demo.controller.hello*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut() && @annotation(methodLog)")
    public void beforeMethod(JoinPoint joinPoint, MethodLog methodLog){
        System.out.println("before method   start ...");
        System.out.println("操作：" + methodLog.description());
        System.out.println("before method   end ...");
    }
}
