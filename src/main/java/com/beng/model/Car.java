package com.beng.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        System.out.println("Car is 初始化...");
    }

    public void init() {
        System.out.println("Car is initing...");
    }

    public void destroy() {
        System.out.println("Car is destroyed...");
    }
}
