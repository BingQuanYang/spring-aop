package com.smart.spring.aop.cglib;

import com.smart.spring.aop.service.UserService;
import com.smart.spring.aop.service.impl.UserServiceImpl;

public class TestCglibProxy {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        UserServiceImpl userService = (UserServiceImpl) proxy.getProxy(UserServiceImpl.class);
        userService.login();
    }
}
