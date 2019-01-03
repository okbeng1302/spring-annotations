package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.beng.configuration.MainConfigPropertyValue;
import com.beng.model.Person;

public class IocTest_PropertyValue {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfigPropertyValue.class);
        System.out.println("容器创建完成...");
        String[] beans = context.getBeanDefinitionNames();

        ConfigurableEnvironment env = context.getEnvironment();
        String property = env.getProperty("nickname");
        System.out.println(property);

        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
        for (String name : beans) {
            System.out.println(name);
        }
        context.close();
    }
}
