package com.beng.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.beng.model.RainBow;

public class MyImprtBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    // AnnotationMetadata 当前类的注解信息
    // BeanDefinitionRegistry 注册类
    // BeanDefinitionRegistry.registerBeanDefinition 手动注册
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean flag = registry.containsBeanDefinition("com.beng.model.Red");
        if (flag) {
            // 指定 bean 的定义信息
            RootBeanDefinition rd = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", rd);
        }
    }

}
