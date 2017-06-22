package com.sugary.jsonparsermaptest.utils.json.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import java.lang.reflect.Type;

/**
 * Created by Ethan on 2017/6/21.
 */

public class FastjsonParser  {

    public <T> String toJson(T t) {
        return JSON.toJSONString(t);
    }

    public <T> T fromJson(String jsonStr, Type type) {
        return JSON.parseObject(jsonStr, type, new Feature[]{});
    }
}
