package com.example.SpringConfig;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;


@Configurable
@PropertySource("classpath:user.properties")
@ComponentScan("com.example.Dao")
@ComponentScan("com.example.Service")
public class Configuration {
    @Value("${driver}")
    private String driverClass;
    @Value("${user}")
    private String name;
    @Value("${url}")
    private String url;
    @Bean("druid")
    public DataSource druid() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUsername(name);
        druidDataSource.setUrl(url);
        return druidDataSource;
    }
}
