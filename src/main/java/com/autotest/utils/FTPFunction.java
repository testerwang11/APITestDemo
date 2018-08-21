package com.autotest.utils;

import com.autotest.client.CallClient;
import org.apache.log4j.Logger;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class FTPFunction {

    static Logger log = Logger.getLogger(FTPFunction.class);

    /**
     * 连接FTP
     * @param url
     * @param port
     * @param username
     * @param password
     * @return
     */
    public static FtpClient connectFTP(String url, int port, String username, String password) {
        //创建ftp
        log.info("创建FTP连接");
        FtpClient ftp = null;
        try {
            //创建地址
            SocketAddress addr = new InetSocketAddress(url, port);
            //连接
            ftp = FtpClient.create();
            ftp.connect(addr);
            //登陆
            ftp.login(username, password.toCharArray());
            ftp.setBinaryType();
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftp;
    }

    public void excuteCommand(FtpClient ftp) throws IOException, FtpProtocolException {
    }


    /**
     * 文件上传ftp
     * @param localFile
     * @param ftpFile
     * @param ftp
     */
    public static void upload(String localFile, String ftpFile, FtpClient ftp) {
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            // 将ftp文件加入输出流中。输出到ftp上
            os = ftp.putFileStream(ftpFile);
            File file = new File(localFile);

            // 创建一个缓冲区
            fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int c;
            while((c = fis.read(bytes)) != -1){
                os.write(bytes, 0, c);
            }
            System.out.println("upload success!!");
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os!=null) {
                    os.close();
                }
                if(fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 下载文件
     * @param localFile
     * @param ftpFile
     * @param ftp
     */
    public static void download(String localFile, String ftpFile, FtpClient ftp) {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            // 获取ftp上的文件
            is = ftp.getFileStream(ftpFile);
            File file = new File(localFile);
            byte[] bytes = new byte[1024];
            int i;
            fos = new FileOutputStream(file);
            while((i = is.read(bytes)) != -1){
                fos.write(bytes, 0, i);
            }
            log.info(ftpFile+"--文件下载成功!");
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("未找到需要下载的文件:"+ftpFile);
            log.error(e.getMessage());
        } finally {
            try {
                if(fos!=null) {
                    fos.close();
                }
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FtpClient ftp = connectFTP("192.168.220.42", 212, "autotest", "123qweASD");
        download("slave1.jar", "autotest/slave1.jar", ftp);
        ftp.close();
    }
}
