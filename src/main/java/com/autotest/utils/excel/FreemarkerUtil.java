package com.autotest.utils.excel;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import com.autotest.database.model.ApiCaseEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FreemarkerUtil {

    public static boolean genClass(List<ApiCaseEntity> caseDatas, String hostFW, String hostCore) throws IOException, TemplateException {
        String rootDir = System.getProperty("user.dir");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("src\\main\\resources\\ftl"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template temp = cfg.getTemplate("testcase.ftl");
        Map<String, Object> root = new HashMap<String, Object>();
        String className = toUpString(RandomUtil.randomString(10));
        root.put("packageName", "com.autotest.temp");
        root.put("className", className);
        root.put("apis", caseDatas);
        root.put("hostFW", hostFW);
        root.put("hostCore", hostCore);

        //root.put("url", api.getHost().split("\\?")[0]);
        //root.put("methodPath", api.getMethodPath());
        //root.put("version", api.getVersion());
        //root.put("reqestParameters", api.getRequestParameters());

        File packagePath = new File(rootDir + "/src/test/java/com/autotest/temp/");
        if (!packagePath.exists()) {
            packagePath.mkdirs();
        }

        File caseFile = new File(packagePath, className + ".java");

        if (caseFile.exists()) {
            System.err.println(className + ".java已存在");
            return false;
        } else {
            OutputStream fos = new FileOutputStream(caseFile); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            temp.process(root, out);
            fos.flush();
            fos.close();
            System.out.println(className + ".java代码生成成功!!!");
            return true;
        }
    }

    // 首字母大写
    private static String toUpString(String className) {
        char[] cs = className.toCharArray();
        cs[0] -= 32;
        String ClassName = String.valueOf(cs);
        return ClassName;
    }

    private static int countFileNumber(File directory) {
        int n = 0;
        if (!directory.isDirectory()) {
            return 1;
        }
        File[] files = directory.listFiles();
        for (File direc : files) {
            n += countFileNumber(direc);
        }
        return n;
    }

    public static void main(String[] args) throws IOException, TemplateException {
        String host_fw = "http://10.5.6.14:8001";
        String host_core = "http://10.5.11.142:8007";
        LinkedList<ApiCaseEntity> datas = ExcelUtilsDemo.excel2Object2();
        genClass(datas, host_fw, host_core);

        //统计用例数量
        //int size = countFileNumber(new File("D:\\work\\workspace\\Avatar\\src\\test\\java\\com\\testcase\\http"));
        //System.out.println("用例数量 = [" + size + "]");
    }
}
