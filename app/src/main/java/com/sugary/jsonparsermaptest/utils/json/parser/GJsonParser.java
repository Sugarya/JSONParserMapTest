package com.sugary.jsonparsermaptest.utils.json.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by Ethan on 2017/6/21.
 */

public class GJsonParser{

    private Gson mGson;

    public GJsonParser() {
        mGson = new GsonBuilder().enableComplexMapKeySerialization().create();
    }


    public <T> String toJson(T t) {
        return mGson.toJson(t);
    }


    public <T> T fromJson(String jsonStr, Type type) {
        return mGson.fromJson(jsonStr, type);
    }
}
