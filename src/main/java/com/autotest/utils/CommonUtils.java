package com.autotest.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class CommonUtils {
    /**
     * 去重
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    /**
     * 修改本机dns
     * @param ncname 例如：本地连接
     * @param ip dns ip地址 172.16.110.240
     */
    public static void ChangeDns(String ncname,String ip){
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("netsh interface ip set dns \""+ncname+"\" static "+ip+" primary");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 判断一个文件是否是图片
     * @param resFile 文件
     * @return true or false
     */
    public static boolean isPic(File resFile){
        boolean isPic=true;
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(resFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bi == null){
            isPic=false;
        }
        return isPic;
    }

    /**
     * 获取一个BufferedImage
     * @param resFile 文件
     * @return BufferedImage
     */
    public static BufferedImage getBufferedImage(File resFile){
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(resFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
