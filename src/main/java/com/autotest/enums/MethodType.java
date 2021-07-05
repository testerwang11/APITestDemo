package com.autotest.enums;

public enum MethodType {

    Get("Get", 1), Post("post", 2), Put("put", 3), Delete("Delete", 4);

    // 成员变量
    private String name;
    private int index;

    private MethodType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (MethodType c : MethodType.values()) {
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
