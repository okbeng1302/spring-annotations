package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.aop.MathComputor;
import com.beng.configuration.MainConfigAop;

public class IocTest_Aop {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathComputor mathComputor = context.getBean(MathComputor.class);
        mathComputor.div(1, 1);
    }

}
