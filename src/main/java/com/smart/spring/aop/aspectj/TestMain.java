package com.smart.spring.aop.aspectj;

import com.smart.spring.aop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.register();
        //1、环绕前
        //2、前置通知
        //3.核心方法
        //4.返回通知   4.异常通知
        //5.最终通知
        //6.环绕后
    }
}
