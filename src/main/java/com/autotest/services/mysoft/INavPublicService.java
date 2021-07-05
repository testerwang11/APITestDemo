package com.autotest.services.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class INavPublicService extends BaseService {
    private BaseCall call;

    public INavPublicService(String host) {
        super.setHost(host);
    }

    /**
     * 获取重构系统导航菜单(管理员)
     *
     * @param authType
     * @param body
     * @return
     */
    public JSONArray getApplicationMenu(AuthType authType, String body, String username) {
        String uri = "/pub/Mysoft.PubPlatform.Nav.PublicServices.INavPublicService/GetApplicationMenu?userGuid=" + body;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType, username);
        call.callService();
        return call.getReturnJsonArray();
    }


}
