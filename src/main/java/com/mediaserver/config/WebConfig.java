package com.mediaserver.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@ComponentScan({
        "com.mediaserver",
        "com.mediaserver.config",
        "com.mediaserver.controller"})
public class WebConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebConfig.class, args);
    }
}