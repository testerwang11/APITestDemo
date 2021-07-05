package com.autotest.utils.excel;

import com.autotest.enums.MethodType;
import com.github.crab2died.converter.ReadConvertible;

public class MethodTypeConvert implements ReadConvertible {


    @Override
    public MethodType execRead(String s) {
        switch (s){
            case "POST":
                return MethodType.Post;
            case "GET":
                return MethodType.Get;
            default:
                return MethodType.Post;

        }
    }
}
