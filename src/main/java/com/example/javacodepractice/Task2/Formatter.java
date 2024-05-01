package com.example.javacodepractice.Task2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public class Formatter {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd '##' hh:mm:ss:SSS", locale = "ru")
    private LocalDateTime localDateTime;

    public Formatter(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Formatter formatter = new Formatter(LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = objectMapper.writeValueAsString(formatter);

        System.out.println(json);
    }

}
