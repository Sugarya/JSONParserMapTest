package com.sugary.jsonparsermaptest.utils.json;

import com.sugary.jsonparsermaptest.utils.json.parser.FastjsonParser;
import com.sugary.jsonparsermaptest.utils.json.parser.IParser;

import java.lang.reflect.Type;

/**
 * Created by Ethan on 2017/6/21.
 * 线程安全的JSON工具类
 */

public class FastJsonUtil {

    private static volatile FastJsonUtil INSTANCE;

    private FastjsonParser mParser;

    public static FastJsonUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (FastJsonUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FastJsonUtil(new FastjsonParser());
                }
            }
        }
        return INSTANCE;
    }

    private FastJsonUtil(FastjsonParser parser) {
        mParser = parser;
    }


    public <T> String toJson(T t) {

        return mParser.toJson(t);
    }

    public <T> T fromJson(String jsonStr, Type type) {

        return mParser.fromJson(jsonStr, type);
    }


}
