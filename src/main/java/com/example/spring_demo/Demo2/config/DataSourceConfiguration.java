package com.example.spring_demo.Demo2.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//      表示当前是一个注解配置类
@Configuration
//    <context:component-scan base-package="com.example.spring_demo.Demo2"/>
//      扫描目录下的注解Bean
@ComponentScan("com.example.spring_demo.Demo2")
//      加载指定properties文件
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${driver}")
    private String driver;
    @Value("${jdbcurl}")
    private String url;
    @Value("${user}")
    private String name;
    //    spring将当前方法的返回值以指定名称存储到spring容器中
    @Bean("druid")
    public DataSource getDateSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(name);
        return druidDataSource;
    }
}
