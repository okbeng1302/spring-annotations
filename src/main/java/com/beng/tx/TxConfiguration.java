package com.beng.tx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 声明式事务
 * 
 * 环境搭建: 
 *  1. 导入相关依赖
 *      数据源、数据库驱动、Spring-jdbc 模块 
 *  2. 配置数据源 JdbcTemplate
 *  3. 在方法上标注 @Transactional 表名该方法是一个事务，发生异常回滚
 *  4. @EnableTransactionManagement 开启注解事务管理机制
 *  5. 配置事务管理器管理事务
 */
@EnableTransactionManagement
@ComponentScan("com.beng.tx")
@Configuration
public class TxConfiguration {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        // Spring 对 配置类会特殊处理，调用方法不是重新调用，而是找其注册的组件
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
