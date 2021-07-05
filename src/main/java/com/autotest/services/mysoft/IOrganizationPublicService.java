package com.autotest.services.mysoft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.enums.AuthType;
import com.autotest.enums.MethodType;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.suite;


public class IOrganizationPublicService extends BaseService {

    private BaseCall call;

    public IOrganizationPublicService(String host) {
        super.setHost(host);
    }

    /**
     * 获取组织下的用户
     *
     * @return
     */
    public JSONObject getUserByOrganization(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetUserByOrganization?organizationGuid=" + body;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        //call.addHeader("Content-Type", "application/json");

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

    /**
     * 批量创建用户
     */
    public JSONObject batchCreate(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/Create";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.setData(body);
        call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 获取用户部门
     */
    public JSONObject getOrganizationByUserAndBU(AuthType authType, String userGuid, String buGuid) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationByUserAndBU";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        //call.setData(body);
        call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 根据userGuid获取用户部门
     */
    public JSONArray getOrganizationByUser(AuthType authType, String userGuid) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationByUser?userGuid=" + userGuid;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        //call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     * 通过用户获取专业线
     */
    public JSONArray getProfessionByUser(AuthType authType, String userGuid) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetProfessionByUser?userGuid=" + userGuid;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        //call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     * 通过用户获取专业线
     */
    public JSONObject getAllMyStandardRolesByIds(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IStandardRolePublicService/GetAllMyStandardRolesByIds";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 根据用户id查询对应角色
     */
    public JSONArray getRolesByUserGuid(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetRolesByUserGuid?userGuid="+body;
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.callService();
        return call.getReturnJsonArray();
    }


    /**
     * 获取当前登录用户关联的组织以及用户
     */
    public JSONObject getOrganizationAndUser(AuthType authType) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationAndUser";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.callService();
        return call.getReturnJsonObject();
    }


    /**
     * 获取用户组织角色
     */
    public JSONObject getUserOrgAndRoles(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/GetUserOrgAndRoles";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 物理组织获取用户
     */
    public JSONArray getOrganizationUsers(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationUsers";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     * 权限关系获取当前及组织子组织用户信息，权限关系获取
     */
    public JSONArray getRoleUserByOrganization(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetRoleUserByOrganization";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonArray();
    }

    /**
     *
     * @param authType
     * @return
     */
    public JSONArray getOrganizationsWithRight(AuthType authType) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/GetOrganizationsWithRight";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.callService();
        return call.getReturnJsonArray();
    }


    /**
     * @param authType
     * @param body
     * @return
     */
    public JSONObject queryUserByOrganizationRolesProject(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationPublicService/QueryUserByOrganizationRolesProject";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }

    /**
     * 查询用户有权限的组织下的所有用户的总数
     * @param authType
     * @param body
     * @return
     */
    public JSONObject queryUserRightCompany2UsersCount(AuthType authType, String body) {
        String uri = "/pub/Mysoft.PubPlatform.Organization.PublicServices.IOrganizationUserPublicService/QueryUserRightCompany2UsersCount";
        call = new BaseCall(host, uri, MethodType.Post);
        setAuth(call, authType);
        call.addHeader("Content-Type", "application/json");
        call.setData(body);
        call.callService();
        return call.getReturnJsonObject();
    }



    public static void main(String[] args) {
        String uri = "/pub/Mysoft.PubPlatform.Message.Interfaces.ISendMessagePublicService/QueryTaskWakeHistoryList";
        String method = "Post";
        String body = "";

        int status_code = 200;



    }
}
