package com.beng.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    public Dog() {
        System.out.println("Dog constructing...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog destroying...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog initing...");
    }
}
