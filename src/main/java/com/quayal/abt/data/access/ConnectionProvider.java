package com.quayal.abt.data.access;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class ConnectionProvider {

    @Value("${spring.datasource.username}")
    private static String user;

    @Value("${spring.datasource.password}")
    private static String password;

    @Value("${spring.datasource.url}")
    private static String url;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
