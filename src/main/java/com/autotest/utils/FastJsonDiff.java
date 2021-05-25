package com.autotest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.listeners.ExtentTestNGITestListener;

import java.util.Iterator;

public class FastJsonDiff {

    public static StringBuilder diffResult = new StringBuilder();

    @SuppressWarnings("unchecked")
    public static boolean compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = (String) i.next();
            compareJson(json1.get(key), json2.get(key), key);
        }
        if (diffResult.length() == 0) {
            return true;
        }
        ExtentTestNGITestListener.logger(diffResult.toString());
        return false;
    }

    public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
            try {
                compareJson((JSONArray) json1, (JSONArray) json2, key);
            }catch (Exception e){
                System.out.println("转换发生异常 key:" + key);

            }
        } else if (json1 instanceof String) {
            try {
                String json1ToStr = json1.toString();
                String json2ToStr = json2.toString();
                compareJson(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
                System.out.println("转换发生异常 key:" + key);
                e.printStackTrace();
            }

        } else {
            compareJson(json1.toString(), json2.toString(), key);
        }
    }

    public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
            //sb.append("key:" + key + ",json1:" + str1 + ",json2:" + str2);
            diffResult.append("不一致key:" + key + ",current:" + str1 + ",expected:" + str2 + "\n");
            //System.err.println("不一致key:" + key + ",json1:" + str1 + ",json2:" + str2);
        } else {
            //System.out.println("一致：key:" + key + ",json1:" + str1 + ",json2:" + str2);
        }
    }

    public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
            Iterator i1 = json1.iterator();
            Iterator i2 = json2.iterator();
            while (i1.hasNext()) {
                compareJson(i1.next(), i2.next(), key);
            }
        } else {
            if (json1 == null && json2 == null) {
                System.err.println("不一致：key:" + key + "  在json1和json2中均不存在");
            } else if (json1 == null) {
                diffResult.append("不一致：key:" + key + "  在json1中不存在"+ "\n");
                //System.err.println("不一致：key:" + key + "  在json1中不存在"+ "\n");
            } else if (json2 == null) {
                diffResult.append("不一致：key:" + key + "  在json2中不存在"+ "\n");
                //System.err.println("不一致：key:" + key + "  在json2中不存在"+ "\n");
            } else {
                //System.err.println("不一致：key:" + key + "  未知原因");
                diffResult.append("不一致：key:" + key + "  未知原因"+ "\n");
            }

        }
    }

    private final static String st1 = "{\"username\":\"tom\",\"age\":18,\"address\":[{\"province\":\"上海市\"},{\"city\":\"上海市\"},{\"disrtict\":\"静安区\"}]}";
    private final static String st2 = "{username:\"tom\",age:18}";

    public static void main(String[] args) {
        System.out.println(st1);
        JSONObject jsonObject1 = JSONObject.parseObject(st1);
        JSONObject jsonObject2 = JSONObject.parseObject(st2);
        compareJson(jsonObject1, jsonObject2, null);
    }
}
