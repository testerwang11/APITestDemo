package com.autotest.services.mysoft;

import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;

public class IStandardRolePublicService extends BaseService {

    private BaseCall call;

    private String host;

    public IStandardRolePublicService(String host) {
        this.host = host;
    }

    /**
     * 根据ID数组获取所有的标准角色
     *
     * @param authType
     * @param body
     * @return
     */
    public JSONObject getUserOrgAndRoles(AuthType authType, String body) {
        System.out.println(host);
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IStandardRolePublicService/GetAllMyStandardRolesByIds";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }
}
