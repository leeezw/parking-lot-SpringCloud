package com.parking.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * 自定义的 JSON 处理类，封装 Gson 的常见操作
 */
public class JsonUtils {

    // Gson 实例
    private static final Gson gson = new Gson();

    /**
     * 将对象转换为 JSON 字符串
     *
     * @param object 待转换的对象
     * @return 转换后的 JSON 字符串
     */
    public static String toJson(Object object) {
        if (object == null) {
            return "{}"; // 返回空对象的 JSON 格式
        }
        return gson.toJson(object);
    }

    /**
     * 将 JSON 字符串转换为指定的对象
     *
     * @param json   待转换的 JSON 字符串
     * @param clazz  目标对象的 class 类型
     * @param <T>    泛型类型
     * @return 转换后的对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将 JSON 字符串转换为指定类型的对象
     *
     * @param json   待转换的 JSON 字符串
     * @param typeOfT 目标对象的类型
     * @param <T>    泛型类型
     * @return 转换后的对象
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return gson.fromJson(json, typeOfT);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转换为 JsonElement，用于进一步操作（如获取 JSON 中的某个字段）
     *
     * @param object 待转换的对象
     * @return 转换后的 JsonElement
     */
    public static JsonElement toJsonElement(Object object) {
        return gson.toJsonTree(object);
    }

    /**
     * 从 JSON 字符串中获取指定字段的值
     *
     * @param json   待解析的 JSON 字符串
     * @param field  要获取的字段名
     * @return 字段对应的 JSON 元素
     */
    public static JsonElement getJsonField(String json, String field) {
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        return jsonElement.getAsJsonObject().get(field);
    }
}
