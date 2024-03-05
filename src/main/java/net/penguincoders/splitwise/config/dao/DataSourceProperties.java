package net.penguincoders.splitwise.config.dao;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DataSourceProperties {
    private String username;
    private String password;
    private String driverClassName;
    private String jdbcUrl;
}
