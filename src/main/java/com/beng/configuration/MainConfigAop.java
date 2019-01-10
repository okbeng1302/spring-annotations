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
