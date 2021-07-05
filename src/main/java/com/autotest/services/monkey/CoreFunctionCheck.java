package com.autotest.services.monkey;

import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.services.mysoft.BaseService;

public class CoreFunctionCheck extends BaseService {
    private BaseCall call;
    private String host;

    public CoreFunctionCheck(String host) {
        this.host = host;
        super.host = host;
    }

    public JSONObject getStandardRole(AuthType authType, String body) {
        String uri="/ajax/Mysoft.Map6.Modeling.Controls.AppTreeGridAjaxHandler/LoadData?pageId=9cef50f1-5729-e711-8b75-4437e6d4bcfd";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }
}
