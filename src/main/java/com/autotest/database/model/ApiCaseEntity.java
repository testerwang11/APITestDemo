package com.autotest.database.model;

import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.excel.*;
import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

@Data
public class ApiCaseEntity {

    @ExcelField(title = "用例编号", order = 1)
    private String id;

    @ExcelField(title = "用例名称", order = 2)
    private String name;

    @ExcelField(title = "描述", order = 3)
    private String description;

    @ExcelField(title = "请求类型", readConverter = MethodTypeConvert.class)
    private MethodType methodType;

    @ExcelField(title = "认证类型", order = 4)
    private String authType;

    @ExcelField(title = "请求地址", order = 5)
    private String reqUrl;

    @ExcelField(title = "请求参数", order = 6, readConverter = BodyTypeConvert.class)
    private String reqBody;

    @ExcelField(title = "请求格式", readConverter = ContentTypeConvert.class)
    private String contentType;

    @ExcelField(title = "响应状态", order = 7)
    private int responseCode;

    @ExcelField(title = "响应结果", order = 8, readConverter = BodyTypeConvert.class)
    private String response;

    @ExcelField(title = "状态", order = 9, readConverter = CaseStatusConvert.class)
    private Boolean enable;

    private String suitName;

    @ExcelField(title = "断言方式")
    private String assertType;

    @ExcelField(title = "平台类型")
    private String platformType;
}
