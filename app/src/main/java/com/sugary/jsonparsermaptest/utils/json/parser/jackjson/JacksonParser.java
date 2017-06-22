package com.sugary.jsonparsermaptest.utils.json.parser.jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sugary.jsonparsermaptest.entity.CategoryEntity;

import java.io.IOException;

/**
 * Created by Ethan on 2017/6/21.
 */

public class JacksonParser {

    private final ObjectMapper mObjectMapper;

    public JacksonParser() {
        mObjectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeyDeserializer(CategoryEntity.class, new MapKeyDeserializer());
        simpleModule.addKeySerializer(CategoryEntity.class, new MapKeySerializer(CategoryEntity.class));
        mObjectMapper.registerModule(simpleModule);
    }


    public <T> String toJson(T t) {
        try {
            return mObjectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public <T> T fromJson(String jsonStr, TypeReference<T> reference) {
        try {
            return mObjectMapper.readValue(jsonStr, reference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
