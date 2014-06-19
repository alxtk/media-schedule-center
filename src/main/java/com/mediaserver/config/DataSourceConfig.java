package com.mediaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    DataSource dataSource(PropertyResolver resolver) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(resolver.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(resolver.getProperty("jdbc.url"));
        dataSource.setUsername(resolver.getProperty("jdbc.username"));
        dataSource.setPassword(resolver.getProperty("jdbc.password"));
        return dataSource;
    }

}
