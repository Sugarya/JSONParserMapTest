package com.sugary.jsonparsermaptest.utils.json.parser;

import java.lang.reflect.Type;

/**
 * Created by Ethan on 2017/6/21.
 */

public interface IParser {

    /**
     *
     * @param t
     * @param <T>
     * @return
     */
     <T> String toJson(T t);

    /**
     *
     * @param jsonStr
     * @param <T>
     * @return
     */
     <T> T fromJson(String jsonStr, Type type);

}
