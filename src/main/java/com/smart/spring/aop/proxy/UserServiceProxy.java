package com.smart.spring.aop.proxy;

import com.smart.spring.aop.service.UserService;

/**
 * 代理
 * 代理对象必须持有被代理对象的引用
 * 静态代理一个代理类只能代理一个接口
 */
public class UserServiceProxy {
    UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }


    private void open(){
        System.out.println("打开数据库连接");
    }
    private void close(){
        System.out.println("关闭数据库连接");
    }
}
