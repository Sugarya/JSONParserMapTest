package com.sugary.jsonparsermaptest.utils.json.parser.jackjson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sugary.jsonparsermaptest.entity.CategoryEntity;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Ethan on 2017/6/21.
 */

public class MapKeySerializer extends StdSerializer<CategoryEntity> {

    private final ObjectMapper mapper = new ObjectMapper();


    protected MapKeySerializer(Class<CategoryEntity> t) {
        super(t);
    }

    @Override
    public void serialize(CategoryEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (null == value) {
            throw new JsonGenerationException("Could not serialize object to json, input object to serialize is null");
        }
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, value);
        gen.writeFieldName(writer.toString());
    }
}
