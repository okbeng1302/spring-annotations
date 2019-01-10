package com.beng.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 * 
 * @author apple
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.beng.aop.MathComputor.*(..))")
    public void pointCut() {

    }

    // 在目标方法前切入
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + " div is running, params :" + Arrays.asList(args));
    }

    @After(value = "com.beng.aop.LogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("div is ending");
    }

    // JoinPoint joinPoint 必须出现在参数的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("div is returning normally, results :{" + result.toString() + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logExpection(JoinPoint jointPoint, Exception exception) {
        System.out.println("div error, results :{" + exception.getMessage() + "}");
    }
}
