package com.sugary.jsonparsermaptest.utils.json.parser.jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sugary.jsonparsermaptest.entity.CategoryEntity;

import java.io.IOException;

/**
 * Created by Ethan on 2017/6/21.
 */

public class MapKeyDeserializer extends KeyDeserializer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        return objectMapper.readValue(key, CategoryEntity.class);
    }
}
