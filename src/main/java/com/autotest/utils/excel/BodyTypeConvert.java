package com.autotest.utils.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.github.crab2died.converter.ReadConvertible;

public class BodyTypeConvert implements ReadConvertible {


    @Override
    public String execRead(String s) {
        s = s.replaceAll("\"", "\\\\\"");
        //非json直接返回，json做一次toString
        if(DiffMethod.isJsonObject(s)){
            return JSONObject.parseObject(s).toJSONString();
        }
        if(DiffMethod.isJsonArray(s)){
            return JSONArray.parseArray(s).toJSONString();
        }
        return s;

    }
}
