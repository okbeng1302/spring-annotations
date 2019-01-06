package com.beng.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 默认加载IOC容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

    // @Autowired
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss 有参数构造器...");
    }

    public Car getCar() {
        return car;
    }

    // @Autowired
    // 标注在方法上，Spring 容器创建当前对象，就会调用该方法，进行赋值
    // 方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss [car=" + car + "]";
    }

}
