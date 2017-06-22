package com.sugary.jsonparsermaptest.utils.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sugary.jsonparsermaptest.utils.json.parser.jackjson.JacksonParser;

/**
 * Created by Ethan on 2017/6/21.
 * 线程安全的JSON工具类
 */

public class JacksonUtil {

    private static volatile JacksonUtil INSTANCE;

    private JacksonParser mIParser;

    public static JacksonUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (JacksonUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new JacksonUtil(new JacksonParser());
                }
            }
        }
        return INSTANCE;
    }

    private JacksonUtil(JacksonParser parser) {
        mIParser = parser;
    }


    public <T> String toJson(T t) {

        return mIParser.toJson(t);
    }

    public <T> T fromJson(String jsonStr, TypeReference<T> reference) {
        return mIParser.fromJson(jsonStr, reference);
    }


}
