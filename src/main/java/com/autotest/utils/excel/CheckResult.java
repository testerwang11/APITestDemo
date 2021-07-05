package com.autotest.utils.excel;

import lombok.Data;

import java.util.List;

@Data
public class CheckResult {

    private Boolean statusCode;

    private Boolean response;

    private Boolean jsonschema;

    private List<String> faileMsgs;

}
