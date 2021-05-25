package com.autotest.services.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;
import com.autotest.utils.DiffMethod;
import com.autotest.utils.FileOper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IOrganizationPublicService extends BaseService {

    private BaseCall call;

    public IOrganizationPublicService(String host) {
        super.host = host;
    }

    /**
     * 获取组织下的用户
     *
     * @return
     */
    public JSONObject getUserByOrganization(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUserByOrganization?organizationGuid" + body;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        System.out.println(call.getReqHeaders());

        System.out.println(body);
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 获取当前登录用户有权限的所有组织
     *
     * @return
     */
    public JSONArray queryBUTreeDataList(AuthType authType) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/QueryBUTreeDataList";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     * 根据关键字查询用户组织信息
     */
    public JSONArray getAllHasRoleUsers(AuthType authType, String searchKey) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetAllHasRoleUsers?searchKey=" + searchKey;
        call = new BaseCall(host, uri, MethodType.Get);
        setAuth(call, authType);
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     * 获取组织角色
     */
    public JSONArray getOrganizationsAndRole(AuthType authType, String organizationGuid) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationsAndRole?organizationGuid=" + organizationGuid;
        call = new BaseCall(host, uri, MethodType.Get);
        setAuth(call, authType);
        call.callService();
        return call.getReturnJsonArray();

    }

    public static void main(String[] args) {
        String host = "http://10.5.6.15:8006";//mysql

        IOrganizationPublicService iOrganizationPublicService = new IOrganizationPublicService(host);
        JSONObject response = iOrganizationPublicService.getUserByOrganization(AuthType.Appkey, "{\n" +
                "  \"BuCode\": \"\",\n" +
                "  \"IsRoot\": true\n" +
                "}");
        //JSONArray response2 = iOrganizationPublicService.queryBUTreeDataList("2");
    }
}
