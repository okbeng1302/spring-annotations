package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.beng.condition.MyImportselector;
import com.beng.condition.MyImprtBeanDefinitionRegistrar;
import com.beng.model.Color;
import com.beng.model.ColorFactoryBean;
import com.beng.model.Person;

/*
 * 给容器注册组件：
 * 1) 包扫描 + 注解标注注解( @Controller @Service @Component @Repository)
 * 2) @Bean 注入
 * 3) @Import 注入
 *    @ImportSelector : 返回需要导入的组件的全类名数组
 *    @ImprtBeanDefinitionRegistrar
 * 4) @FactoryBean 使用工厂bean
 *    默认获取工厂 bean getObject()创建的对象
 *    要获取工厂本身 需在 bean 前边加前缀 &
 *    
 */
//@Conditional({ MyCondition.class })
@Configuration
@Import({ Color.class, MyImportselector.class, MyImprtBeanDefinitionRegistrar.class }) // 快速的导入组件
                                                                                       // ,id
                                                                                       // 默认是
                                                                                       // 全名
public class MainConfigure2 {

    // scope 作用域
    // singleton 单实例（默认值） ioc启动容器调用方法创建对象，以后每次获取从 ioc 容器中拿
    // prototype 多实例 ioc 容器不会创建对象，在调用的时候再去创建对象
    // request 同一次请求创建一个实例
    // session 同一个session创建一个实例

    // 懒加载：
    // 单实例的bean，ioc容器启动的时候创建对象；
    // 懒加载，ioc容器启动时不创建对象，第一次使用（获取）bean 创建对象，并初始化
    @Bean
    // @Lazy
    // @Scope("prototype")
    public Person person() {
        System.out.println("给容器添加 Person...");
        return new Person("Jane", 20);
    }

    /*
     * @Conditional({Condition}) 按照一定的条件进行判断，满足条件注册bean
     */
    // @Bean("bill")
    // @Conditional({ MyCondition.class })
    // public Person person1() {
    // return new Person("James", 33);
    // }
    //
    // @Bean("linus")
    // public Person person2() {
    // return new Person("Linux", 48);
    // }
    //
    // @Bean("unix")
    // public Person person3() {
    // return new Person("Linux", 48);
    // }

    @Bean
    public Person person4() {
        return new Person();
    }

    @Bean
    public Person person5() {
        return new Person();
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
