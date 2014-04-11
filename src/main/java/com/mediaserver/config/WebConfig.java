package com.mediaserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@ComponentScan({
        "com.mediaserver",
        "com.mediaserver.config",
        "com.mediaserver.service",
        "com.mediaserver.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private PropertyResolver propertyResolver;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebConfig.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars*//**").addResourceLocations("classpath:/META-INF/resources/webjars/");;
    }

}