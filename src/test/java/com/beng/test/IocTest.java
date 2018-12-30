package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.configuration.BeanConfiguration;

public class IocTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        String[] beans = context.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
    }
}
