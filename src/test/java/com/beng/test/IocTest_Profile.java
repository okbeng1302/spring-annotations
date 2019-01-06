package com.beng.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.configuration.MainConfigProfile;

public class IocTest_Profile {

    /*
     * 1) 使用命令行动态参数 -Dspring.profiles.active=test 2) 代码方式激活环境
     */
    @Test
    public void test() {

        // AnnotationConfigApplicationContext context = new
        // AnnotationConfigApplicationContext(MainConfigProfile.class);

        // 1. 创建一个 ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 设置需要激活的环境
        context.getEnvironment().setActiveProfiles("prod");
        // 3. 注册主配置类
        context.register(MainConfigProfile.class);
        // 4. 启动刷新容器
        context.refresh();
        String[] beans = context.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }

        String[] dataSources = context.getBeanNamesForType(DataSource.class);
        for (String name : dataSources) {
            System.out.println(name);
        }
    }

}
