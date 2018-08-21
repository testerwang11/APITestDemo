package com.autotest.services;

import com.alibaba.fastjson.JSONObject;
import com.autotest.client.BaseCall;
import com.autotest.client.CallClient;
import com.autotest.enums.MethodType;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IdentifiyCodeService {
    static Logger log = Logger.getLogger(IdentifiyCodeService.class);

    public static void main(String[] args) throws IOException {
        //localCodeIdentifiy("D:/duizhang/code/1530756783321.png");
        aliCodeIdentifiy("D:\\duizhang\\code\\1530756783321.png");
        //youDaoIdentifiy("D:/duizhang/code/1530756783321.png");
    }

    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        //return encoder.encode(data);

        return "data:image/png;base64,"+encoder.encode(data);
    }


    /**
     * 阿里云验证码识别
     * @param imgPath
     * @return
     */
    public static String aliCodeIdentifiy(String imgPath) {
        String host = "http://txyzmsb.market.alicloudapi.com";
        String path = "/yzm";
        String appcode = "1789d42d9956481ab481782e67150712";
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        //根据API的要求，定义相对应的Content-Type
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("v_pic", getImageStr(imgPath));
        bodys.put("v_type", "ne4");

        BaseCall call = new BaseCall(host, path, MethodType.Post);
        call.addHeader("Authorization", "APPCODE " + appcode);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.setData(bodys);
        call.callService();
        JSONObject response = call.getReturnJsonObject();

        call.close();
        if(response.getInteger("errCode")!=0){
            log.error("第三方验证码识别异常:"+response.getInteger("errCode"));
        }else{
            String result = response.getString("v_code");
            log.info("图片名：" + imgPath +" 识别结果："+result);
            return result;
        }
        return "";
    }

    public static String youDaoIdentifiy(String imgPath) {
        String host = "http://aidemo.youdao.com";
        String path = "/ocrapi1";

        BaseCall call = new BaseCall(host, path, MethodType.Post);
        call.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        call.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("imgBase", getImageStr(imgPath));
        bodys.put("lang", "en");
        bodys.put("company", "");

        call.setData(bodys);
        call.callService();
        JSONObject data = call.getReturnJsonObject();

        call.close();

        if(data.getInteger("errorCode")!=0){
            log.error("第三方验证码识别异常:"+data.getInteger("errCode"));
        }else{
            String result = data.getJSONArray("lines").getJSONObject(0).getString("words").replace(" ","");
            log.info("图片名：" + imgPath +" 识别结果："+result);
            return result;
        }
        return "";
    }
}
