package com.autotest.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.PublicKey;
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

    public static void rsaSign() {
        String publickStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDkXaJGi49qwU2Xuss6kTmDylwK\n" +
                "eR0VNVZ1nemsasXGaKSVxuy5VsL+4MVWxkn8w5SWvJUF0AsonkPlaDcZOATbLMq3\n" +
                "XoSWTIB3Ck2E5RUxCABrMG2i3HHszS5oE7DT5MlkYwsYMrMfh+4vVk28F5b43TwL\n" +
                "batLX7fEJqWupDYghQIDAQAB";

        String privateStr = "MIICXQIBAAKBgQDkXaJGi49qwU2Xuss6kTmDylwKeR0VNVZ1nemsasXGaKSVxuy5\n" +
                "VsL+4MVWxkn8w5SWvJUF0AsonkPlaDcZOATbLMq3XoSWTIB3Ck2E5RUxCABrMG2i\n" +
                "3HHszS5oE7DT5MlkYwsYMrMfh+4vVk28F5b43TwLbatLX7fEJqWupDYghQIDAQAB\n" +
                "AoGAXDbzMElqwFEOZBapuhyqfO1Z/WCqvcWsBBKgKV90PYpD67dIIA9I7mMVTNUF\n" +
                "S2wutC+yfYZk+yHtiNVsamKUkqk3rZDbX3pm+WYBrgts+IigqOgWJmBC98XVNBGp\n" +
                "8i+DWA4B0n0mNWt0WNBhxOy24TK7DBu+StpD9U5POcS9QAECQQD7b5dLeR5wA8YZ\n" +
                "vRTK6Hkt1HT1+TiFfmAwocCqGt8FaWLWEptyCyGyVIx0D8f2TnqzunmChgp9puen\n" +
                "I1x07Z0FAkEA6ILWUXzqfqFWHX838kplnKL4T4NxjVecn4T5YKDA7lW3tZTOfAGV\n" +
                "COQyeG1rKut+EbT3inbpWgdskqhRX1nNgQJBALZNIXgyWBRFWDO/OT0pMvs8qJTT\n" +
                "XtzDVUDNdqCfHQaSc3vdP+F/Gq5uyOs5qfT2z9ZSJNmzEBYslpdDdzy8L3UCQQCe\n" +
                "TG2zvxM7sYYawQGLEQHLOd1K7VfC/jIhHPxXwDp6SZuwoaZPIRihnBOMkBpVd002\n" +
                "qvmZqMnIxKMz2irEezSBAkBjV9TLfE0YkgwisfpU1PFjfKQ0tu3BF1pYFDSJ0uDd\n" +
                "Dawz8YTDq85qaFTG2iLrD+a0WmqDUu/nwbm3AouAhEb7";

        String ddd = "w55NG6+pUOMs56FigpgPC8fpJ7SXcPqV+HhdSqT4tp1lvg9oHDBbl9aK4WXjVrTsIKspEgCWObpbgFTuO8nJU1gtiXYDvtDtPcSLX0/g3SzF0ZetuBsUf2e0ArbCXBK5DYFLT2xtYXED8stFyWemMxvryJX9iFPDI4B04skYY2M=";

        RSA rsa = new RSA(privateStr, publickStr);
/*        byte[] aByte = HexUtil.decodeHex(ddd);
        byte[] decrypt = rsa.decrypt(aByte, KeyType.PrivateKey);
        System.out.println(StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));*/

        System.out.println(rsa.encrypt("1", KeyType.PublicKey));
    }

    public static void main(String[] args) {
        rsaSign();

    }
}
