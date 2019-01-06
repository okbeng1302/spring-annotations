package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.beng.dao.BookDao;
import com.beng.model.Car;
import com.beng.model.Color;

/*
 * 自动装配：
 *  Spring 利用依赖注入，完成对IOC容器中各个组件的关系赋值
 *  1） @Autowired
 *      a. 默认有限按照类型从IOC容器中找对应的组件： context.getBean(BookDao.class)
 *      b. 如果找到多个相同类型的组件，再将属性的名称作为id去容器中查找
 *      c. @Qualifier("bookDao2")，指定需要装配的id，不适用属性名
 *      d. 自动装配默认一定要将属性赋值好，没有就报错
 *          @Autowired(required = false) 能装配就装配，不能就不装配
 *      e. @Primary, 让Spring进行自动装配的时候，默认首选的bean
 *          也可以继续使用Qualifier指定需要装配的名字 
 *  2） @Resource @Inject 【Java规范的注解】
 *          @Resource ：
 *              可以和@Autowired一样实现自动装配功能，默认按照组件名称进行装配
 *              @Resource(name="bookDao2") 没有支持 @Primary 和 @Autowired(require=false/true) 等功能
 *          @Inject ：
 *              需要导入 javax.inject 和 @Autowired 一样都能进行自动装配，@Autowired 内部有参数
 *  3） @Autowired : 构造器，参数，方法，属性，以上都是在属性位置标注
 *      a. 方法位置
 *      b. 构造器，如果组件只有一个有参构造器，参数构造器的 @Autowired 可以省略
 *      c. 参数位置
 *      
 *  4） 自定义组件想要使用 spring 底层的一些组件（ApplicationContext、BeanFactory、xxx）
 *          自定义组件 实现 xxxAware 接口 
 *          把Spring底层的一些组件注入到自定义的bean中
 * @author apple
 */
@Configuration
@ComponentScan({ "com.beng.service", "com.beng.dao", "com.beng.controller", "com.beng.model" })
public class MainConfigAutowired {

    @Primary
    @Bean
    public BookDao bookDao() {
        return new BookDao();
    }

    /*
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     */
    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }

}
