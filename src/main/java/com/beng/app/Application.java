package com.beng.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beng.configuration.BeanConfiguration;
import com.beng.model.Person;

public class Application {

    public static void main(String[] args) {
        // 读取 xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());

        // 利用注解读取
        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Person person1 = (Person) context1.getBean("person");
        System.out.println(person1.toString());

    }
}
