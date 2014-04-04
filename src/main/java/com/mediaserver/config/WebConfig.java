package com.mediaserver.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({
        "com.mediaserver",
        "com.mediaserver.controller"})
public class WebConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebConfig.class, args);
    }
}