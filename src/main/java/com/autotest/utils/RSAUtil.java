package com.autotest.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    private static String privateKey = "MIICXQIBAAKBgQDkXaJGi49qwU2Xuss6kTmDylwKeR0VNVZ1nemsasXGaKSVxuy5VsL+4MVWxkn8w5SWvJUF0AsonkPlaDcZOATbLMq3XoSWTIB3Ck2E5RUxCABrMG2i3HHszS5oE7DT5MlkYwsYMrMfh+4vVk28F5b43TwLbatLX7fEJqWupDYghQIDAQABAoGAXDbzMElqwFEOZBapuhyqfO1Z/WCqvcWsBBKgKV90PYpD67dIIA9I7mMVTNUFS2wutC+yfYZk+yHtiNVsamKUkqk3rZDbX3pm+WYBrgts+IigqOgWJmBC98XVNBGp8i+DWA4B0n0mNWt0WNBhxOy24TK7DBu+StpD9U5POcS9QAECQQD7b5dLeR5wA8YZvRTK6Hkt1HT1+TiFfmAwocCqGt8FaWLWEptyCyGyVIx0D8f2TnqzunmChgp9puenI1x07Z0FAkEA6ILWUXzqfqFWHX838kplnKL4T4NxjVecn4T5YKDA7lW3tZTOfAGVCOQyeG1rKut+EbT3inbpWgdskqhRX1nNgQJBALZNIXgyWBRFWDO/OT0pMvs8qJTTXtzDVUDNdqCfHQaSc3vdP+F/Gq5uyOs5qfT2z9ZSJNmzEBYslpdDdzy8L3UCQQCeTG2zvxM7sYYawQGLEQHLOd1K7VfC/jIhHPxXwDp6SZuwoaZPIRihnBOMkBpVd002qvmZqMnIxKMz2irEezSBAkBjV9TLfE0YkgwisfpU1PFjfKQ0tu3BF1pYFDSJ0uDdDawz8YTDq85qaFTG2iLrD+a0WmqDUu/nwbm3AouAhEb7";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDkXaJGi49qwU2Xuss6kTmDylwKeR0VNVZ1nemsasXGaKSVxuy5VsL+4MVWxkn8w5SWvJUF0AsonkPlaDcZOATbLMq3XoSWTIB3Ck2E5RUxCABrMG2i3HHszS5oE7DT5MlkYwsYMrMfh+4vVk28F5b43TwLbatLX7fEJqWupDYghQIDAQAB";
    private static String A = "RSA";
    String B = "";

    /**
     * Base64编码
     * @param source
     * @return
     * @throws Exception
     */
    static String encodeBase64(byte[] source) throws Exception{
        return new String(Base64.encodeBase64(source), "UTF-8");
    }

    /**
     * Base64解码
     *
     * @param target
     * @return
     * @throws Exception
     */
    static byte[] decodeBase64(String target) throws UnsupportedEncodingException {
        return Base64.decodeBase64(target.getBytes("UTF-8"));
    }

    /**
     * 获取私钥
     * @return
     * @throws Exception
     */
    static PrivateKey getPrivateKey() throws Exception {
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(decodeBase64(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance(A);
        return keyFactory.generatePrivate(privateKeySpec);
    }

    /**
     * 获取公钥
     * @return
     * @throws Exception
     */
    static PublicKey getPublicKey() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decodeBase64(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance(A);
        return keyFactory.generatePublic(publicKeySpec);
    }

    /**
     * 私钥解密
     *
     * @param target
     * @throws Exception
     */
    public static String decryptionByPrivateKey(String target) throws Exception {
        Cipher cipher = Cipher.getInstance(getPrivateKey().getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey());
        cipher.update(decodeBase64(target));
        String source = new String(cipher.doFinal(), "UTF-8");
        return source;
    }

    /**
     * 公钥加密
     * @param source
     * @return
     * @throws Exception
     */
    public static String encryptionByPublicKey(String source){
        try{
            PublicKey publicKey = getPublicKey();
            Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipher.update(source.getBytes("UTF-8"));
            String target = encodeBase64(cipher.doFinal());
            return target;
        }catch (Exception e){
            System.out.println("加密失败");
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
/*        //加密
        encryptionByPublicKey("1");
        //解密
        String target = "bJPjNGt+2KzEIohj7ZJB2KpSDhID9UFc5NL7j68KVZKhGNSVkQPnznkK2ixrgohAH0sMYJHDGaYPRBsDTa94dUYHIFJ5R25w6yuKlpHev/MJ0KxMgmylegEj8vmdN8guD4Y6UvE/59U1VL06fSsXzopu9yWWBfwV0vPVPuzDMwU=";
        String password = decryptionByPrivateKey(target);*/
        System.out.println(encryptionByPublicKey("1"));
    }
}
