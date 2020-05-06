package com.sofg.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.util.StringUtils;

import java.util.Map;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    }

    /**
     * 将对象序列化为json byte数组
     * @param message
     * @return
     */
    public static byte[] encodeByte(Object message){
        try {
            return mapper.writeValueAsBytes(message);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * 将对象序列化为json 字符串
     * @param message
     * @return
     */
    public static String encodeString(Object message){
        try {
            return mapper.writeValueAsString(message);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * 反序列化一个对象
     * @param message 字符串byte数组
     * @param classOfT 对象类
     * @param charset 字符串字符集
     * @param <T>
     * @return
     */
    public static <T> T decode(byte[] message, Class<T> classOfT, String charset) {
        try{
            String jsonSrc = new String(message, charset);
            return mapper.readValue(jsonSrc, classOfT);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * 反序列化一个对象
     * @param message 字符串byte数组
     * @param classOfT 对象类。
     *                 其中classOfT是需要反序列化的对象, 该方式主要解决集合类的反序列化问题
     * @param charset
     * @param <T>
     * @return
     */
    public static <T> T decode(byte[] message, TypeReference classOfT, String charset) {
        try{

            String jsonSrc = new String(message, charset);
            return mapper.readValue(jsonSrc, classOfT);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * 默认以utf8编码进行处理
     * @param message
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T decode(byte[] message, Class<T> classOfT) {
        try{
            return mapper.readValue(message, classOfT);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public static <T> T decode(String message, Class<T> classOfT)  {
        try{
            return mapper.readValue(message, classOfT);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }



    /**
     * JSON字符串转MAP
     *
     * @param message:
     * @return MAP集合
     **/
    public static Map<String, String> decode2MapString(String message)  {
        try{
            return mapper.readValue(message, new TypeReference<Map<String, String>>(){});
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * JSON字符串转MAP
     *
     * @param message:
     * @return MAP集合
     **/
    public static Map<String, Object> decode2MapObject(String message)  {
        try{
            return mapper.readValue(message, new TypeReference<Map<String, Object>>(){});
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * @Author Administrator
     * @Description //获取json串中的KEY 值
     * @Date 2019/7/25 21:39
     * @param jsonObject:
     * @param key:
     * @return int
     **/
    public static int getIntValue(String jsonObject,String key){
        int result = -1;
        JSONObject data = JSONObject.parseObject(jsonObject);
        if(data != null){
            result = data.getIntValue(key);
        }
        return  result;
    }

    /**
     * @Author Administrator
     * @Description //获取json串中的KEY 值
     * @Date 2019/7/25 21:39
     * @param jsonObject:
     * @param key:
     * @return int
     **/
    public static String getStringValue(String jsonObject,String key){
        String result = "";
        JSONObject data = JSONObject.parseObject(jsonObject);
        if(data != null){
            result = data.getString(key);
        }
        return  result;
    }

    /**
     * @Author Administrator
     * @Description //获取json串中的KEY 值
     * @Date 2019/7/25 21:39
     * @param jsonObject:
     * @param key:
     * @return int
     **/
    public static Object getObjectValue(String jsonObject,Object key){
        Object result = null;
        JSONObject data = JSONObject.parseObject(jsonObject);
        if(data != null){
            result = data.get(key);
        }
        return  result;
    }




    /**
     * @Author Administrator
     * @Description //查验是否包含KEY
     * @Date 2019/7/26 10:26
     * @param jsonObject:
     * @param key:
     * @return boolean
     **/
    public static boolean containsKey(String jsonObject,String key){
        boolean result = false;
        JSONObject data = JSONObject.parseObject(jsonObject);
        if(data != null) {
            result = data.containsKey(key);
        }
        return result;

    }

    /**
     * @Author Administrator
     * @Description //json字符串转java对象
     * @Date 2019/7/27 11:35
     * @param json:
     * @param c:
     * @return T
     **/
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            //两个都是可行的，起码我测试的时候是没问题的。
            //JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @Author Administrator
     * @Description //java对象转json字符串
     * @Date 2019/7/27 11:34
     * @param object:
     * @return java.lang.String
     **/
    public static <T> String parseObjToJson(T object){
        String string = null;
        try {
            string = JSONObject.toJSONString(object);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    /**
     * @Author
     * @Description //是否为jsonObject类型字符串
     * @Date 2019/8/9 15:31
     * @param json:
     * @return
     **/
    public static boolean isJsonObject(String json){
        boolean flag = false;
        if(StringUtils.isEmpty(json)){
            return flag;
        }
        try {
            JSONObject obj = JSONObject.parseObject(json);
            if(obj != null) {
                flag = true;
            }
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }
    /**
     * @Author
     * @Description //是否为jsonArray类型字符串
     * @Date 2019/8/9 15:31
     * @param json:
     * @return
     **/
    public static boolean isJsonArray(String json){
        boolean flag = false;
        if(StringUtils.isEmpty(json)){
            return flag;
        }
        try {
            JSONArray array = JSONArray.parseArray(json);
            if(array != null) {
                flag = true;
            }
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }
}
