package com.example.spring_boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
@ConfigurationProperties(prefix = "datasourece")
public class MyDataSourece {
    private String username;
    private String url;
    private String driver;
}
