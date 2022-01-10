package com.example.spring_demo.Demo2.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//<import resource="classpath:applicationContext.xml"/>
@Configurable
@Import(DataSourceConfiguration.class)
public class Configuration {

}
