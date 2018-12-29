package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beng.model.Person;

@Configuration
public class BeanConfiguration {

    @Bean
    public Person person() {
        return new Person("xiaobai", 18);
    }
}
