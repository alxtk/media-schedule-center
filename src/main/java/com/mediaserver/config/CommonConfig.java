package com.mediaserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.mediaserver.utils.jackson.mapper.ApplicationObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new ApplicationObjectMapper();
    }

    @Bean
    public SerializationConfig serializationConfig() {
        return jacksonObjectMapper().getSerializationConfig();
    }

}
