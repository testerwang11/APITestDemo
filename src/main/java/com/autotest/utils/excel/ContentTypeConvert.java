package com.autotest.utils.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.StringUtils;
import com.github.crab2died.converter.ReadConvertible;

public class ContentTypeConvert implements ReadConvertible {


    @Override
    public String execRead(String s) {
        if(StringUtils.isEmpty(s)){
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }else if(s.equalsIgnoreCase("json")){
            return "application/json; charset=UTF-8";
        }else {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }
    }
}
