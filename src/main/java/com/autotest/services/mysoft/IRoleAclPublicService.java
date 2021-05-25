package com.autotest.services.mysoft;

import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IRoleAclPublicService extends BaseService {

    private BaseCall call;
    private String host;

    public IRoleAclPublicService(String host) {
        this.host = host;
        super.host = host;
    }

    /**
     * 获取指定用户、是否存在指定的功能权限点(有权限)
     * @param authType
     * @param body
     * @return
     */
    public JSONObject existsSpecifyUserActionRights(AuthType authType, String body) {
        System.out.println("地址:"+super.host);
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IRoleAclPublicService/ExistsSpecifyUserActionRights";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 获取指定用户、指定功能点的动作点集合
     */
    public JSONObject getSpecifyUserActionRights(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IRoleAclPublicService/GetSpecifyUserActionRights";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 获取用户的所有权限
     * @param authType
     * @param body
     * @return
     */
    public JSONObject getUserActionRightInfos(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IRoleAclPublicService/GetUserActionRightInfos?userId="+body;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);

        call.callService();
        return call.getReturnJsonObject();
    }
}
