package com.ekibiina.ekibiina.api.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Configure the ObjectMapper as needed
        // For example, you can enable pretty printing or configure date formats
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Failed to convert object to JSON", e);
        }
    }

    public static <T> T toObject(String content, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Failed to convert JSON to object", e);
        }
    }

    public static <T> T toClassObject(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Failed to convert JSON to object", e);
        }
    }

    public static Boolean checkIfKeyInJsonString(String jsonString, String keyToCheck) {
        try {
            Map<String, Object> respMap =
                    objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});

            if (respMap.containsKey(keyToCheck)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to parse JSON: ", e);
        }
    }
}
