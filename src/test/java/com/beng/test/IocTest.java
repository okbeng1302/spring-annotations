package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.configuration.BeanConfiguration;
import com.beng.configuration.MainConfigure2;
import com.beng.model.Person;

public class IocTest {

    // @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        String[] beans = context.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigure2.class);

        System.out.println("Ioc 容器创建完成...");
        String[] beans = context.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
        // 默认单实例
        Person person = (Person) context.getBean("person");
        Person person1 = (Person) context.getBean("person");

        System.out.println(person == person1);
    }
}
