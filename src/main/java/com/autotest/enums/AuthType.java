package com.autotest.enums;

public enum AuthType {
    Appkey("AppId+AppKey", 1),Cookie("账号密码登录的Cookie", 2), Token("生成的Token", 3), None("不带认证信息", 4);

    // 成员变量
    private String name;
    private int index;

    private AuthType(String name, int index) {
        this.name = name;
        this.index = index;
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
