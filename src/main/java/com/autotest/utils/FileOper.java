package com.autotest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autotest.enums.FileType;
import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.lang.invoke.MethodType;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Enumeration;


public class FileOper {
    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        //新建目标目录
        (new File(targetDir)).mkdirs();
        //获取源文件夹当下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                //源文件
                File sourceFile = file[i];
                //目标文件
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                //准备复制的源文件夹
                String dir1 = sourceDir + file[i].getName();
                //准备复制的目标文件夹
                String dir2 = targetDir + File.separator + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }

    }

    public static void copyFile(File sourcefile, File targetFile) throws IOException {

        //新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourcefile);
        BufferedInputStream inbuff = new BufferedInputStream(input);

        //新建文件输出流并对它进行缓冲
        FileOutputStream out = new FileOutputStream(targetFile);
        BufferedOutputStream outbuff = new BufferedOutputStream(out);

        //缓冲数组
        byte[] b = new byte[1024 * 5];
        int len = 0;
        while ((len = inbuff.read(b)) != -1) {
            outbuff.write(b, 0, len);
        }

        //刷新此缓冲的输出流
        outbuff.flush();

        //关闭流
        inbuff.close();
        outbuff.close();
        out.close();
        input.close();
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 压缩zip格式文件
     *
     * @param targetFile  输出的文件。
     * @param sourceFiles 带压缩的文件数组。
     * @return 如果所有文件压缩成功，则返回true；如果有任何文件未成功压缩，则返回false。
     * @throws IOException 如果出错后无法删除目标文件或无法覆盖目标文件。
     */
    public static boolean compressZip(File targetFile, File... sourceFiles) throws IOException {
        ZipOutputStream zipOut;
        boolean flag;
        if (targetFile.exists() && !targetFile.delete()) {
            throw new IOException();
        }
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(targetFile));
            BufferedOutputStream out = new BufferedOutputStream(zipOut);
            flag = compressZip(zipOut, out, "", sourceFiles);
            out.close();
            zipOut.close();
        } catch (IOException e) {
            targetFile.delete();
            throw new IOException(e);
        }
        return flag;
    }

    private static boolean compressZip(ZipOutputStream zipOut, BufferedOutputStream out, String filePath, File... sourceFiles)
            throws IOException {
        if (null != filePath && !"".equals(filePath)) {
            filePath += filePath.endsWith(File.separator) ? "" : File.separator;
        } else {
            filePath = "";
        }
        boolean flag = true;
        for (File file : sourceFiles) {
            if (null == file) {
                continue;
            }
            if (file.isDirectory()) {
                File[] fileList = file.listFiles();
                if (null == fileList) {
                    return false;
                } else if (1 > fileList.length) {
                    zipOut.putNextEntry(new ZipEntry(filePath + file.getName() + File.separator));
                } else {
                    flag = compressZip(zipOut, out, filePath + File.separator + file.getName(), fileList) && flag; // 只要flag有一次为false，整个递归的结果都为false。
                }
            } else {
                zipOut.putNextEntry(new ZipEntry(filePath + file.getName()));
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                int bytesRead;
                while (-1 != (bytesRead = in.read())) {
                    out.write(bytesRead);
                }
                in.close();
            }
            out.flush();
        }
        return flag;
    }

    /**
     * 解压zip格式文件
     *
     * @param originFile zip文件。
     * @param targetDir  要解压到的目标路径。
     * @return 如果目标文件不是zip文件则返回false。
     * @throws IOException 如果发生I/O错误。
     */
    public static boolean decompressZip(File originFile, String targetDir)  {
        try {
            if (FileType.ZIP != getFileType(originFile)) {
                return false;
            }
            if (!targetDir.endsWith(File.separator)) {
                targetDir += File.separator;
            }
            ZipFile zipFile = new ZipFile(originFile, "GBK");
            ZipEntry zipEntry;
            Enumeration<ZipEntry> entry = zipFile.getEntries();
            while (entry.hasMoreElements()) {
                zipEntry = entry.nextElement();
                String fileName = zipEntry.getName();
                File outputFile = new File(targetDir + fileName);
                if (zipEntry.isDirectory()) {
                    forceMkdirs(outputFile);
                    continue;
                } else if (!outputFile.getParentFile().exists()) {
                    forceMkdirs(outputFile.getParent());
                }
                OutputStream outputStream = new FileOutputStream(outputFile);
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                int len;
                byte[] buffer = new byte[8192];
                while (-1 != (len = inputStream.read(buffer))) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.close();
                inputStream.close();
            }
            zipFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 获取文件真实类型
     *
     * @param file 要获取类型的文件。
     * @return 文件类型枚举。
     */
    public static FileType getFileType(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        byte[] head = new byte[4];
        if (-1 == inputStream.read(head)) {
            return FileType.UNKNOWN;
        }
        inputStream.close();
        int headHex = 0;
        for (byte b : head) {
            headHex <<= 8;
            headHex |= b;
        }
        switch (headHex) {
            case 0x504B0304:
                return FileType.ZIP;
            default:
                return FileType.UNKNOWN;
        }
    }


    public static String convertCygwinPath(String path) {
        path = path.replaceAll("\\\\", "/");
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            path = "/cygdrive/" + path.replaceFirst(":", "");
        return path;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static File forceMkdirs(File file) {
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return file;
    }

    public static File forceMkdirs(String pathName) {
        return forceMkdirs(new File(pathName));
    }

    public static File forceMkdirs(File parent, String child) {
        return forceMkdirs(new File(parent, child));
    }

    public static File forceMkdirs(String parent, String child) {
        return forceMkdirs(new File(parent, child));
    }

    public static void saveJsonSchema(String filename, Object object)  {
        File file = new File(System.getProperty("user.dir")+File.separator+"src/test/resources/jsonschema/"+filename+".json");
        if(!file.exists()) {
            try {
                FileUtils.forceMkdirParent(file);
                file.createNewFile();
                FileUtils.writeStringToFile(file, object.toString(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONObject queryJsonSchema(String filename) {
        File file = new File(System.getProperty("user.dir")+File.separator+"src/test/resources/jsonschema/"+filename+".json");
        try {
            return JSONObject.parseObject(FileUtils.readFileToString(file, Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveResponse(String filename, Object object)  {
        File file = new File(System.getProperty("user.dir")+File.separator+"src/test/resources/response/"+filename+".rs");
        if(!file.exists()) {
            try {
                FileUtils.forceMkdirParent(file);
                file.createNewFile();
                FileUtils.writeStringToFile(file, object.toString(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String queryResponse(String filename) {
        File file = new File(System.getProperty("user.dir")+File.separator+"src/test/resources/response/"+filename+".rs");
        String content="";
        try {
            content = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
 /*       try {
            return JSONObject.parseObject(content);
        } catch (Exception e) {
            JSONObject.parseArray(content);
        }*/
        //return null;
    }

    public static void main(String[] args) throws IOException {
        //FileOper.decompressZip(new File("D:\\duizhang\\download\\20180622\\支付宝\\20180621_2088101909164661.zip"), "D:\\duizhang\\download\\20180622\\支付宝");
        System.out.println(URLEncoder.encode("上海"));
    }
}
