package com.autotest.utils.excel;

import com.github.crab2died.converter.ReadConvertible;

public class CaseStatusConvert implements ReadConvertible {


    @Override
    public Boolean execRead(String s) {
        if(s.equals("启用")){
            return true;
        }
        return false;
    }
}
