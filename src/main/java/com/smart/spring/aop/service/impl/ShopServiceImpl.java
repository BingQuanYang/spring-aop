package com.smart.spring.aop.service.impl;

import com.smart.spring.aop.service.ShopService;

public class ShopServiceImpl implements ShopService {

    @Override
    public String add() {
        System.out.println("添加商品信息");
        return null;
    }
}
