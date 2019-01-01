package com.beng.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.beng.configuration.BeanConfiguration;
import com.beng.configuration.MainConfigure2;
import com.beng.model.Blue;
import com.beng.model.Person;

public class IocTest {
    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            MainConfigure2.class);

    @Test
    public void testImport() {
        String[] beans = context.getBeanDefinitionNames();

        Blue blue = context.getBean(Blue.class);
        System.out.println(blue);
        for (String name : beans) {
            System.out.println(name);
        }
    }

    // @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        String[] beans = context.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
    }

    // @Test
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

    // @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigure2.class);
        System.out.println("Ioc 容器创建完成...");

        // 获取环境系统
        ConfigurableEnvironment env = context.getEnvironment();
        String pro = env.getProperty("os.name");
        System.out.println("系统环境：" + pro);
        String[] beans = context.getBeanNamesForType(Person.class);
        for (String name : beans) {
            System.out.println(name);
        }

        Map<String, Person> map = context.getBeansOfType(Person.class);
        System.out.println(map);

    }
}
