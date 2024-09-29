package com.example.other.trans.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-08-01
 */
public class ResourceSerializer extends JsonSerializer<Resource> {

    @Override
    public void serialize(Resource value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//            ;
        SerializedString serializedString = new SerializedString(String.valueOf(value.getInputStream().readAllBytes()));
        gen.writeString(serializedString);
    }
}
