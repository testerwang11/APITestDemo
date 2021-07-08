package com.autotest.enums;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

public enum AuthType {
    AppKey("AppId+AppKey", 1),Cookie("Cookie", 2), Token("Token", 3), None("None", 4);

    // 成员变量
    private String name;
    private int index;

    private AuthType(String name, int index) {
        this.name = name;
        this.index = index;
    }


    private static final HashMap<String, AuthType> MAP = new HashMap<String, AuthType>();

    static {

        for (AuthType authType : values()) {
            MAP.put(authType.name, authType);
        }
    }

    public static AuthType valueOfName(String name) {

        return MAP.get(name);
    }

    // 普通方法
    public static String getName(int index) {
        for (AuthType c : AuthType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
