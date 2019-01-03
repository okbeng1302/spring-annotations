package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.beng.model.Person;

// 使用 @Propertysource 读取配置文件
@PropertySource(value = "classpath:/person.properties")
@Configuration
public class MainConfigPropertyValue {

    @Bean
    public Person person() {
        return new Person();
    }
}
