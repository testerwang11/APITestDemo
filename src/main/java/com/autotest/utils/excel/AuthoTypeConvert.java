package com.autotest.utils.excel;

import com.autotest.enums.AuthType;
import com.github.crab2died.converter.ReadConvertible;

public class AuthoTypeConvert implements ReadConvertible {


    @Override
    public AuthType execRead(String s) {
        switch (s.trim()){
            case "AppKey+AppId":
                return AuthType.AppKey;
            case "Cookie":
                return AuthType.Cookie;
            case "Token":
                return AuthType.Token;
            default:
                return AuthType.None;
        }
    }
}
