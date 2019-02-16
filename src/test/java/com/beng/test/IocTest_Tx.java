package com.beng.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beng.tx.TxConfiguration;
import com.beng.tx.UserService;

public class IocTest_Tx {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfiguration.class);

        UserService service = context.getBean(UserService.class);
        service.insertUser();
        context.close();
    }

}
