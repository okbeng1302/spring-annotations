package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.beng.model.Car;

/*
 * bean 的生命周期：
 *  bean 的创建 - 初始化 - 销毁
 *  容器管理 bean 的生命周期
 *  自定义初始化和销毁方法，容器在执行bean生命周期时，调用初始化和销毁方法
 *  
 *  构建对象：
 *   单实例：容器启动时创建对象
 *   多实例：每次调用的时候创建对象
 *  初始化：
 *   对象创建完成，并赋值完成，调用初始化方法
 *  销毁：
 *   单实例，容器关闭的时候进行销毁
 *   多实例，容器不会管理这个bean，容器关闭不会调用销毁方法
 *   
 *  1） 指定初始化和销毁方法
 *      initMethod   destroyMethod
 *  
 *  2） 通过 Bean 实现 InitailizingBean（定义初始化逻辑）
 *                   DesposableBean（定义销毁逻辑）
 * 
 *  3） 使用注解 @PostConstruct Bean 创建完成，并且赋值完成
 *             @PreDestroy Bean 销毁之前调用
 */
@ComponentScan("com.beng.model")
@Configuration
public class MainConfigLifeCycle {

    // @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
