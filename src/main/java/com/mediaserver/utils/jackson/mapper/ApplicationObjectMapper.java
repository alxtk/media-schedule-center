package com.mediaserver.utils.jackson.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mediaserver.utils.jackson.deserializer.LocalDateTimeDeserializer;
import com.mediaserver.utils.jackson.serializer.LocalDateSerializer;
import com.mediaserver.utils.jackson.serializer.LocalDateTimeSerializer;
import com.mediaserver.utils.jackson.serializer.LocalTimeSerializer;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ApplicationObjectMapper extends ObjectMapper {

    public ApplicationObjectMapper() {
        SimpleModule module = new SimpleModule("JSONModule");
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalTime.class, new LocalTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        this.registerModule(module);
    }
}
