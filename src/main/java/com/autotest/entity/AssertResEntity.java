package com.autotest.entity;

import com.autotest.enums.DiffType;

public class AssertResEntity {

    private int statusCode;

    private DiffType diffType;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    private String methodName;

    public AssertResEntity() {
        this.statusCode = 200;//默认200
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public DiffType getDiffType() {
        return diffType;
    }

    public void setDiffType(DiffType diffType) {
        this.diffType = diffType;
    }
}
