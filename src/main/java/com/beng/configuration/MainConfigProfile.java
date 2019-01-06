package com.beng.configuration;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.beng.model.Red;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * Profile:
 *      Spring 为我们提供的介意根据当前环境，动态激活和切换组件的功能
 *   @Profile
 *      指定组件在那个环境中生效
 *      
 *  1) 加了环境标识的bean 只有环境被激活时，才会注册到容器中，默认是 default 环境
 *  2) 写在配置类上，只有是指定环境的时候，所有的配置才能生效
 *  3) 没有环境标志的bean，在任何环境下都会生效
 */

@PropertySource("classpath:/dbconfig.properties")
@Configuration
@Profile("test")
public class MainConfigProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClass;

    // @Profile("test")
    @Bean
    public Red red() {
        return new Red();
    }

    @Profile("test")
    @Bean("testDatasource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc://mysql://localhost:3306/mydemo");
        driverClass = resolver.resolveStringValue("${db.driverClass}");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("prod")
    @Bean("proDatasource")
    public DataSource dataSourcePro() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        comboPooledDataSource.setJdbcUrl("jdbc://mysql://localhost:3306/mydemo");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }
}
