package com.autotest.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.enums.MethodType;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/************************************************************************************
 * 基础Call类，实现HttpClient发送请求基础功能
 * 
 * @File name : BaseCall.java
 ************************************************************************************/
public class BaseCall {

	protected CallClient client = null;

	/**
	 * 新增用于记录cookie 的变量 cookie
	 */
	protected String cookie = "";

	protected String url = null;

	protected String entityString = "";

	protected HttpEntity entity;

	protected String mode;
	
	//protected static Logger log = Logger.getLogger(BaseCall.class);

	/**
	 * 初始化接口
	 * 
	 * @param systemUrl
	 *            例如http://api.alpha.ymatou.com/ 则设置system为"appapi"来获取到baseurl
	 * @param uri
	 *            相对路径 <br>
	 *            例如 api/User/LoginAuth <br>
	 *            最终url为baseurl+opurl <br>
	 *            示例中最终的url为http://api.alpha.ymatou.com/api/User/LoginAuth
	 * @param mode
	 *            GET or POST or FILE or Delete or Put
	 */
	public BaseCall(String systemUrl, String uri, MethodType mode) {
		this.mode = mode.name();
		this.url = systemUrl + uri;
		if (client == null) {
			client = new CallClient(url, this.mode);
		}
	}

	public BaseCall(String systemUrl, MethodType mode) {
		this.mode = mode.name();
		this.url = systemUrl;
		if (client == null) {
			client = new CallClient(url, this.mode);
		}
	}

	/**
	 * 设置参数 请求String
	 * 
	 * @param s
	 *            String
	 * 
	 */
	public void setData(String s) {

		StringEntity se = new StringEntity(s, HTTP.UTF_8);
		this.entity = se;
	}

	public void setData( Map<String, String> s) {
		List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
		for (String key : s.keySet()) {
			nameValuePairList.add(new BasicNameValuePair(key, s.get(key)));
		}
		UrlEncodedFormEntity formEntity=null;
		try {
			formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.entity = formEntity;
	}

	/**
	 * 发送请求
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public void callService() {
		client.setEntity(entity);
		try {
			client.sendRequest();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//log.error(e.getMessage());
		}
    }

	/**
	 * 获取返回报文
	 * 
	 * @return 返回报文
	 */
	public String getReturnData() {
		return client.getResponseString();
	}

	/**
	 * 获取返回的jsonobject
	 * 
	 * @return
	 */
	public JSONObject getReturnJsonObject() {
		return JSONObject.parseObject(client.getResponseString());

	}

	/**
	 * 获取返回的jsonarray
	 * 
	 * @return
	 */
	public JSONArray getReturnJsonArray() {
		return JSONArray.parseArray(client.getResponseString());
	}

	/**
	 * 获取请求消耗时间
	 * 
	 * @return 时间 秒
	 */
	public double getResponseTime() {
		return client.getDuration();
	}

	/**
	 * 获取http请求状态码
	 * 
	 * @return http请求状态码
	 */
	public int getStatusCode() {
		return client.getStatusCode();
	}

	/**
	 * 用于登陆后获取headcookie
	 * 
	 * @return cookie
	 */
	public List<String> getCookies() {
		return client.getCookies();
	}

	/**
	 * 用于设置cookie
	 * 
	 * @param cookie
	 *            登陆后获取到的cookie
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * 用于使用List<String>设置cookie,该值可从getCookies获取
	 * 
	 * @param cookies
	 *            list格式的一串数据
	 * 
	 */
	public void setCookies(List<String> cookies) {
		for (String s : cookies) {
			this.cookie += s + ";";
		}
	}

	/**
	 * 默认添加header信息PC
	 */
	public void addDefHeader() {
		// client.addHeader("Accept","text/xml,text/javascript,text/html,application/json");
		// 每个系统默认头信息都不同
//		client.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;text/html");
//		client.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
//		client.addHeader("Cookie", cookie);
		client.addHeader("Accept", "application/json");
		client.addHeader("Content-Type", "application/json; charset=utf-8");
		client.addHeader("Origin", "http://hcm-ui-dev.oss-cn-shanghai.aliyuncs.com");
		client.addHeader("Referer", "http://hcm-ui-dev.oss-cn-shanghai.aliyuncs.com/index.html");
		client.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

	}

	/**
	 * addHeader 添加header
	 * 
	 * @param key
	 *            header key
	 * @param value
	 *            header value
	 */
	public void addHeader(String key, String value) {
		client.addHeader(key, value);
	}

	/**
	 * 获取请求头
	 * @return
	 */
	public List<String> getReqHeaders() {
		return client.getReqHeaders();
	}

	/**
	 * 获取发送报文
	 * 
	 * @return 发送报文内容
	 */
	public String getEntityString() {
		return entityString;
	}

	/**
	 * 获取返回格式为Json报文格式的对象中key对应的value
	 * 
	 * @param key
	 *            JsonKey
	 * @return String value
	 */
	public String getJsonValue(String key) {
		String value = null;
		try {
			JSONObject jo = JSONObject.parseObject((getReturnData()));
			value = jo.get(key).toString();
		} catch (NullPointerException e) {
		}
		return value;
	}

	/**
	 * 设置url 调用这个方法可以强制设置Call的URL
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
		client.close();
		client = new CallClient(url, mode);
	}

	/**
	 * 添加文件，用于文件上传
	 * 
	 * @param name
	 *            参数名
	 * @param fliename
	 *            文件全路径
	 */
	public void addPart(String name, String fliename) {
		client.addPart(name, fliename);
	}

	/**
	 * @see CallClient#setConnectionTimeout(int)
	 */
	public void setConnectionTimeout(int timeout) {
		client.setConnectionTimeout(timeout);
	}

	/**
	 * @see CallClient#setSoTimeout(int)
	 */
	public void setSoTimeout(int timeout) {
		client.setSoTimeout(timeout);
	}

	/**
	 * @see CallClient#removeAllHeader()
	 */
	public void removeAllHeader() {
		client.removeAllHeader();
	}

	public void close() {
		client.close();
	}
}
