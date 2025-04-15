package org.example.onlinemediclestore.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    private static final Gson gson = new Gson();
    //convert objects to json string
    public  static  String toJson(Object obj){
        return gson.toJson(obj);
    }
    //convert JSON String to objects
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    //convert JSON array to List
    public static <T> List<T> fromJsonToList(String json, Class<T> classOfT) {
        Type type = TypeToken.getParameterized(List.class, classOfT).getType();
        return gson.fromJson(json, type);
    }
}
