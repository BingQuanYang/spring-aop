package com.smart.spring.aop.dynamic;

import com.smart.spring.aop.service.ShopService;
import com.smart.spring.aop.service.UserService;
import com.smart.spring.aop.service.impl.ShopServiceImpl;
import com.smart.spring.aop.service.impl.UserServiceImpl;

public class TestDynamicProxy {
    public static void main(String[] args) {
        TransactionDynamicProxy proxy = new TransactionDynamicProxy();
        UserService userService = (UserService) proxy.newInstance(new UserServiceImpl());
        userService.login();
        System.out.println("--------------------");
        ShopService shopService = (ShopService) proxy.newInstance(new ShopServiceImpl());
        shopService.add();
    }
}
