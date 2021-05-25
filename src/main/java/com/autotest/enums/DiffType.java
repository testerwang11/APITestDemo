package com.autotest.enums;

public enum DiffType {

    Strict("严格模式", 1), General("宽松模式,忽略响应结果顺序", 2), JsonSchema("jsonschema比较字段，不比较值", 3);

    // 成员变量
    private String name;
    private int index;


    private DiffType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (DiffType c : DiffType.values()) {
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
