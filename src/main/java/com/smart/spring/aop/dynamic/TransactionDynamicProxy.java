package com.smart.spring.aop.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 对象中的方法
 * 事务代理类
 */
public class TransactionDynamicProxy implements InvocationHandler {
    private Object target;

    public Object newInstance(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    /**
     * Method
     * invoke()
     *
     * @param proxy  代理对象
     * @param method 核心方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        Object invoke = null;
        try {
            invoke = method.invoke(target, args);
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务！！！");
        }
        return invoke;
    }
}
