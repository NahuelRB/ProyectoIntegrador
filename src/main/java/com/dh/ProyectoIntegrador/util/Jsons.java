package com.dh.ProyectoIntegrador.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class Jsons {

    public static String asJsonString(Object object) {
        try {
            ObjectMapper objectMappeer = getObjectMapper();
            objectMappeer.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMappeer.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return objectMappeer.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T objectFromString(Class<T> aClass, String value) throws JsonProcessingException {
        return getObjectMapper().readValue(value, aClass);
    }

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new ParameterNamesModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

}
