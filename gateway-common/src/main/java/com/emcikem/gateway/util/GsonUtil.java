package com.emcikem.gateway.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Emcikem
 * @create 2022/7/16
 */
public class GsonUtil {

    private final static Gson GSON = (new GsonBuilder()).registerTypeAdapter(Date.class, new DateTypeAdapter()).create();

    public static String toJsonString(Object object) {
        return object == null ? "" : GSON.toJson(object);
    }

    public static <T> T parseObject(String json, Class<T> clz) {
        return StringUtils.isBlank(json) ? null : GSON.fromJson(json, clz);
    }

    public static <T> List<T> parseList(String json, final Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        } else {
            Type type = new ParameterizedType() {
                @Override
                public Type[] getActualTypeArguments() {
                    return new Type[]{clazz};
                }
                @Override
                public Type getRawType() {
                    return List.class;
                }
                @Override
                public Type getOwnerType() {
                    return null;
                }
            };
            return GSON.fromJson(json, type);
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        map = GSON.fromJson(gsonString, new TypeToken<Map<String, T>>() {}.getType());
        return map;
    }

}
