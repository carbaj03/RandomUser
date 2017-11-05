package com.acv.randomuser.data.network;

import com.acv.randomuser.data.JsonUtil;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonUtil implements JsonUtil {

    private static final GsonBuilder gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public GsonUtil() {

    }

    /**
     * Convierte un objeto a Json.
     *
     * @param obj
     * @param <T>
     * @return
     */
    @Override
    public <T> String toJson(T obj) {
        return gson.create().toJson(obj);
    }

    /**
     * Convierto una cadena con formato json a Objeto
     *
     * @param json
     * @param typeClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T fromJson(String json, Class<T> typeClass) {
        return gson.create().fromJson(json, typeClass);
    }

    /**
     * Convierto una cadena con formato json a Objeto
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T fromJson(String json, Type type) {
        return gson.create().fromJson(json, type);
    }
}