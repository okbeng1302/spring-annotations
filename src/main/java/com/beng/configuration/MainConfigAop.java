package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.beng.aop.LogAspect;
import com.beng.aop.MathComputor;

/*
 * Aop:
 *  程序运行时，动态的将某段代码切入到指定方法位置运行
 *  1. 导入Aop模块： Spring AOP  （spring-aspects）
 *  2. 定义一个业务逻辑类，在业务逻辑运行时进行日志打印（运行前，运行后，运行前后）
 *  3. 定义一个日志切面类（LogAspect），切面中的方法动态感知 MathComputor 类中方法的执行
 *      通知方法：
 *          前置 : @Before
 *          后置 : @After
 *          返回 : @AfterReturning
 *          异常 : @AfterException
 *          环绕 : @Around  动态代理，手动推进目标方法运行（jointPoint.proceed()）
 *  4. 给切面类的目标方法标注何时何地运行
 *  5. 将切面类和目标逻辑类（目标方法所在类）都要加到容器中
 *  6. 必须告诉 spring 那个是 aspect，给切面类加注解 @Aspect
 *  7. 启动 aop 功能 @EnableAspectJAutoProxy
 *  
 *  三步：
 *      1） 将业务逻辑组件和切面类都加到容器中，告诉Spring那个是切面类（@Aspect）
 *      2） 在切面类的每一个通知方法上标记通知注释，告诉Spring何时何地运行
 *      3） 开启基于注解的 Aop 模式 @EnableAspectJAutoProxy
 *      
 *  Aop 原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能？】
 *      @EnableAspectJAutoProxy
 *      1. @EnableAspectJAutoProxy 是什么？
 *          @Import(AspectJAutoProxyRegistrar.class)
 *          利用 AspectJAutoProxyRegistrar 自定义这容器中注册bean BeanDefinetion
 *          internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册：AnnotationAwareAspectJAutoProxyCreator
 *      
 *      2. AnnotationAwareAspectJAutoProxyCreator
 *          AnnotationAwareAspectJAutoProxyCreator
 *              -> AspectJAwareAdvisorAutoProxyCreator 
 *                  -> AbstractAdvisorAutoProxyCreator
 *                      -> AbstractAutoProxyCreator implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                      关注后置处理器（在bean的初始化前后做事情 ）、自动装配 BeanFactory
 *         AbstractAutoProxyCreator.setBeanFactory
 *         AbstractAutoProxyCreator 有后置处理器的逻辑
 *         
 *         AbstractAdvisorAutoProxyCreator.setBeanFactory -> initBeanFactory
 *         
 *         AspectJAwareAdvisorAutoProxyCreator
 *         
 *         AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *         
 *  流程:
 *      1) 传入配置类，创建 IOC 容器
 *      2) 注册配置类，调用 refresh() 说新容器
 *      3) registerBeanPostProcessors(beanFactory) 注册 bean 的后置处理器来方便 bean 的拦截
 *          a. 先获取IOC容器中已经定义了的需要创建对象的所有 BeanPostProcessor 
 *          b. 给容器中加别的 BeanPostProcessor
 *          c. 优先注册实现了 PriorityOrdered 接口的 BeanPostProcessor
 *          d. 再给容器中注册实现了 Orderd 接口的 BeanPostProcessor
 *          e. 注册和实现没有优先级的接口的 BeanPostProcessor
 *          f. 注册 BeanPostProcessor，实际上就是创建 BeanPostProcessor 对象保存在容器中 
 *              创建 internalAutoProxyCreator 的 BeanPostProcessor
 *              1. 创建bean的实例
 *              2. populateBean 给bean的各种属性赋值 
 *              3. initializeBean : 初始化 Bean
 */

// 开启基于注解的aop模式
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {

    @Bean
    public MathComputor mathComputor() {
        return new MathComputor();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
