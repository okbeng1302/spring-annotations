package com.beng.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    /*
     * ConditionContext 判断条件能使用的 上下文环境 AnnotatedTypeMetadata 注释信息
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        ClassLoader classLoader = context.getClassLoader();
        Environment env = context.getEnvironment();
        BeanDefinitionRegistry registry = context.getRegistry();
        // 判断是否包含某个bean
        if (registry.containsBeanDefinition("person")) {
            System.out.println("Ico 容器包含 person");
        }
        // 是否苹果系统
        if (env.getProperty("os.name").equals("Mac OS X")) {
            return false;
        }
        return false;
    }

}
