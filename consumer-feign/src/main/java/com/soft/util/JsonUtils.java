package com.soft.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZWJ
 * @date 2019/8/21 16:37
 * @Version 1.0
 **/
public class JsonUtils {

    private static JsonMapper jsonMapper = JsonMapper.getDefault();

    public static String toJson(Object object) {
        if (object == null) {
            return "{}";
        }
        return jsonMapper.toJson(object);
    }

    /**
     * 不含值为null的属性
     *
     * @param object
     * @return
     */
    public static String toJsonIgnoreNullField(Object object) {
        return JsonMapper.nonNullMapper().toJson(object);
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) {
        return jsonMapper.toObject(jsonString, clazz);
    }

    public static <T> List<T> toList(String jsonString, Class<T> clazz) {
        return jsonMapper.toList(jsonString, clazz);
    }

    public static String getToken(String jsonString, String token) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode actualObj = mapper.readTree(jsonString);
            return actualObj.get(token).asText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 对传入的对象转换成json字符串，插入Key-value
     *
     * @param object
     *            需要执行put的对象
     * @param key
     *            插入的key
     * @param value
     *            插入的 value
     * @return
     */
    public static String put(Object object, String key, Object value) {
        ObjectNode objectNode = jsonMapper.getObjectNode(object);
        if (value instanceof String) {
            objectNode.put(key, (String) value);
        } else if (value instanceof Integer) {
            objectNode.put(key, (Integer) value);
        } else if (value instanceof Float) {
            objectNode.put(key, (Float) value);
        } else if (value instanceof Boolean) {
            objectNode.put(key, (Boolean) value);
        } else if (value instanceof Double) {
            objectNode.put(key, (Double) value);
        } else if (value instanceof BigDecimal) {
            objectNode.put(key, (BigDecimal) value);
        } else if (value instanceof Long) {
            objectNode.put(key, (Long) value);
        } else if (value instanceof Short) {
            objectNode.put(key, (Short) value);
        }
        return objectNode.toString();
    }

    /**
     * 传入对象和想移除的key，返回去掉该key后对象生成的json字符串
     *
     * @param object
     * @param key
     * @return
     */
    public static String remove(Object object, String key) {
        ObjectNode objectNode = jsonMapper.getObjectNode(object);
        objectNode.remove(key);
        return objectNode.toString();
    }

    /**
     * jackson 读取或载入磁盘上的 json 格式文件
     *
     * @param filePath
     * @return
     */
    public static String getJsonFile(String filePath) {
        String strResult = "";
        ObjectMapper objMapper = JsonMapper.getDefault().getMapper();

        try {
            JsonNode rootNode = objMapper.readTree(new File(filePath));
            // 获得 json 字符串
            strResult = rootNode.toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strResult;
    }

    /**
     * 把json文件存到磁盘上
     * @param filePath 存放路径
     * @param value 存放对象
     */
    public static void setJsonFile(String filePath, Object value) {
        ObjectMapper objMapper = JsonMapper.getDefault().getMapper();
        try {
            objMapper.writeValue(new File(filePath), value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}