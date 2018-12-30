package com.beng.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.beng.filter.MyFilter;
import com.beng.model.Person;

@Configuration
// @ComponentScan(value = "com.beng", excludeFilters = {
// @Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) })
@ComponentScan(value = "com.beng", excludeFilters = {
        @Filter(type = FilterType.CUSTOM, classes = { MyFilter.class }) }, useDefaultFilters = false)
// @ComponentScan(value = "com.beng") // 指定要扫描的包
public class BeanConfiguration {

    @Bean
    public Person person() {
        return new Person("xiaobai", 18);
    }
}
