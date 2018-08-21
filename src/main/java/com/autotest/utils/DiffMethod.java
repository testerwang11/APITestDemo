package com.autotest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DiffMethod {

    /**
     * 返回当前数据类型
     * @param source
     * @return
     */
    public static String getTypeValue(Object source){

        if(source instanceof String){
            return "String";
        }

        if(source instanceof Integer){
            return "Integer";
        }

        if(source instanceof Float){
            return "Float";
        }

        if(source instanceof Long){
            return "Long";
        }

        if(source instanceof Double){
            return "Double";
        }

        if(source instanceof Date){
            return "Date";
        }

        if(source instanceof Boolean){
            return "Boolean";
        }

        return "null";
    }


    /**
     * 把Object变成JsonSchema
     * @param source
     * @return
     */
    public static Object generateJsonSchema(Object source){
        //Object result = new Object();
        //判断是否为JsonObject
        if(source instanceof JSONObject){
            JSONObject jsonResult = new JSONObject();
            //JSONObject jsonResult = JSONObject.parseObject(result.toString());
            JSONObject sourceJSON = JSONObject.parseObject(source.toString());
            Iterator iterator = sourceJSON.keySet().iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                Object nowValue = sourceJSON.get(key);
                if(nowValue == null || nowValue.toString().equals("null")){
                    jsonResult.put(key,"null");
                }else if(isJsonObject(nowValue)){
                    jsonResult.put(key,generateJsonSchema(nowValue));
                }else if(isJsonArray(nowValue)){
                    JSONArray tempArray = JSONArray.parseArray(nowValue.toString());
                    JSONArray newArray = new JSONArray();
                    if(tempArray != null && tempArray.size() > 0 ){
                        for(int i = 0 ;i < tempArray.size(); i++){
                            newArray.add(generateJsonSchema(tempArray.get(i)));
                        }
                        jsonResult.put(key,newArray);
                    }
                }else if(nowValue instanceof List){
                    List<Object> newList = new ArrayList<Object>();
                    for(int i = 0;i<((List) nowValue).size();i++){
                        newList.add(((List) nowValue).get(i));
                    }
                    jsonResult.put(key,newList);
                }else {
                    jsonResult.put(key,getTypeValue(nowValue));
                }
            }
            return jsonResult;
        }


        if(source instanceof JSONArray){
            JSONArray jsonResult = JSONArray.parseArray(source.toString());
            JSONArray tempArray = new JSONArray();
            if(jsonResult != null && jsonResult.size() > 0){
                for(int i = 0 ;i < jsonResult.size(); i++){
                    tempArray.add(generateJsonSchema(jsonResult.get(i)));
                }
                return tempArray;
            }
        }
        return getTypeValue(source);

    }



    /**
     * JSON格式比对
     * @param currentJSON
     * @param expectedJSON
     * @return
     */
    public static JSONObject diffJson(JSONObject currentJSON,JSONObject expectedJSON){

        JSONObject jsonDiff = new JSONObject();

        Iterator iterator = expectedJSON.keySet().iterator();

        while (iterator.hasNext()){
            String key = (String)iterator.next();
            Object expectedValue = expectedJSON.get(key);
            Object currentValue = currentJSON.get(key);
            if(!expectedValue.toString().equals(currentValue.toString())){
                JSONObject tempJSON = new JSONObject();
                tempJSON.put("value",currentValue);
                tempJSON.put("expected",expectedValue);
                jsonDiff.put(key,tempJSON);
            }
        }
        return jsonDiff;
    }


    /**
     * 判断是否为JSONObject
     * @param value
     * @return
     */
    public static boolean isJsonObject(Object value){

        try{
            if(value instanceof JSONObject) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }


    /**
     * 判断是否为JSONArray
     * @param value
     * @return
     */
    public static boolean isJsonArray(Object value){

        try{

            if(value instanceof JSONArray){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }


    /**
     * JSON格式比对，值不能为空,且key需要存在
     * @param current
     * @param expected
     * @return
     */
    public static JSONObject diffFormatJson(Object current,Object expected){

        JSONObject jsonDiff = new JSONObject();

        if(isJsonObject(expected)) {

            JSONObject expectedJSON = JSONObject.parseObject(expected.toString());
            JSONObject currentJSON = JSONObject.parseObject(current.toString());

            Iterator iterator = JSONObject.parseObject(expected.toString()).keySet().iterator();

            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Object expectedValue = expectedJSON.get(key);

                if (!currentJSON.containsKey(key)) {
                    JSONObject tempJSON = new JSONObject();
                    tempJSON.put("actualKey", "不存在此" + key);
                    tempJSON.put("expectedKey", key);
                    jsonDiff.put(key, tempJSON);

                }

                if (currentJSON.containsKey(key)) {

                    Object currentValue = currentJSON.get(key);

                    if (expectedValue != null && currentValue == null || expectedValue.toString() != "null" && currentValue.toString() == "null") {
                        JSONObject tempJSON = new JSONObject();
                        tempJSON.put("actualValue", "null");
                        tempJSON.put("expectedValue", expectedValue);
                        jsonDiff.put(key, tempJSON);
                    }

                    if (expectedValue != null && currentValue != null) {
                        if (isJsonObject(expectedValue) && !JSONObject.parseObject(expectedValue.toString()).isEmpty() || isJsonArray(expectedValue) && !JSONArray.parseObject(expectedValue.toString()).isEmpty()) {
                            JSONObject getResultJSON = new JSONObject();
                            getResultJSON = diffFormatJson(currentValue, expectedValue);
                            if (getResultJSON != null) {
                                jsonDiff.putAll(getResultJSON);
                            }
                        }
                    }
                }
            }
        }

        if(isJsonArray(expected)){
            JSONArray expectArray = JSONArray.parseArray(expected.toString());
            JSONArray currentArray = JSONArray.parseArray(current.toString());

            if(expectArray.size() != currentArray.size()){
                JSONObject tempJSON = new JSONObject();
                tempJSON.put("actualLenth",currentArray.size());
                tempJSON.put("expectLenth",expectArray.size());
                jsonDiff.put("Length",tempJSON);
            }

            if(expectArray.size() != 0){
                Object expectIndexValue = expectArray.get(0);
                Object currentIndexValue = currentArray.get(0);

                if(expectIndexValue != null && currentIndexValue != null){
                    if (isJsonObject(expectIndexValue) && !JSONObject.parseObject(expectIndexValue.toString()).isEmpty() || isJsonArray(expectIndexValue) && !JSONArray.parseArray(expectIndexValue.toString()).isEmpty()) {
                        JSONObject getResultJSON = new JSONObject();
                        getResultJSON = diffFormatJson(currentIndexValue, expectIndexValue);
                        if (getResultJSON != null) {
                            jsonDiff.putAll(getResultJSON);
                        }
                    }
                }
            }
        }
        return jsonDiff;
    }

    public static void main(String[] args) {

        DiffMethod diffMethod = new DiffMethod();


        String str1 = "{\"status\":201,\"msg\":\"今天您已经领取过，明天可以继续领取哦！\",\"res\":{\"remainCouponNum\":\"5\",\"userId\":\"123123213222\"}}";

        JSONObject jsonObject1 = JSONObject.parseObject(str1);


        String str2 = "{\"status\":201,\"msg2\":\"今天您已经领取过，明天可以继续领取哦！\",\"res\":{\"remainCouponNum\":\"5\",\"userId\":\"123123213222\"}}";

        JSONObject jsonObject2 = JSONObject.parseObject(str2);


        String str3 = "{\"status\":null,\"msg\":\"今天您已经领取过，明天可以继续领取哦！\",\"res\":{\"remainCouponNum\":\"5\",\"userId\":\"123123213222\"}}";

        JSONObject jsonObject3 = JSONObject.parseObject(str3);

        System.out.println("转换成JSONschame:" + diffMethod.generateJsonSchema(jsonObject1).toString());

        System.out.println("当前str2没有msg字段: " + diffMethod.diffFormatJson(jsonObject2,jsonObject1).toString());

        System.out.println("当前str2中的status为null值:" + diffMethod.diffFormatJson(jsonObject3,jsonObject1).toString());


    }
}
