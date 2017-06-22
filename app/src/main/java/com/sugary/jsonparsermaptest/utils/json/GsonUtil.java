package com.sugary.jsonparsermaptest.utils.json;

import com.sugary.jsonparsermaptest.utils.json.parser.GJsonParser;
import com.sugary.jsonparsermaptest.utils.json.parser.IParser;

import java.lang.reflect.Type;

/**
 * Created by Ethan on 2017/6/21.
 * 线程安全的JSON工具类
 */

public class GsonUtil {

    private static volatile GsonUtil INSTANCE;

    private GJsonParser mParser;

    public static GsonUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (GsonUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GsonUtil(new GJsonParser());
                }
            }
        }
        return INSTANCE;
    }

    private GsonUtil(GJsonParser parser) {
        mParser = parser;
    }


    public <T> String toJson(T t) {

        return mParser.toJson(t);
    }

    public <T> T fromJson(String jsonStr, Type type) {

        return mParser.fromJson(jsonStr, type);
    }


}
