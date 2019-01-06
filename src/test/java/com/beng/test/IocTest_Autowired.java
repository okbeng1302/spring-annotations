package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.configuration.MainConfigAutowired;
import com.beng.dao.BookDao;
import com.beng.model.Boss;
import com.beng.model.Car;
import com.beng.model.Color;
import com.beng.service.BookService;

public class IocTest_Autowired {

    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAutowired.class);

        BookService service = context.getBean(BookService.class);
        System.out.println(service);

        BookDao dao = context.getBean(BookDao.class);
        System.out.println(dao);

        // String[] beans = context.getBeanDefinitionNames();
        // for (String name : beans) {
        // System.out.println(name);
        // }

        Boss boss = context.getBean(Boss.class);
        System.out.println(boss);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        Color color = context.getBean(Color.class);
        System.out.println(color);

    }

}
