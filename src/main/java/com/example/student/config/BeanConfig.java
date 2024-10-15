package com.example.student.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
