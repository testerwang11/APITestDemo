package com.autotest.enums;

public enum EnvType {
    TEST("测试环境", 1), PRELINE("预上线环境", 2), ONLINE("生产环境", 3);
    // 成员变量
    private String name;
    private int index;

    private EnvType(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (EnvType c : EnvType.values()) {
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
