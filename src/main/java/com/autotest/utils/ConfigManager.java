package com.autotest.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 读取配置文件
 */
public class ConfigManager {

    public static Map<String, String> configFileMap = new HashMap<String, String>();
    private static Properties prop = new Properties();
    private static ConfigManager instance;

    private ConfigManager(String configFile) throws IOException {
        InputStream in =ClassLoader.getSystemResourceAsStream(configFile);
        prop.load(in);

    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            String configFile = System.getProperty("user.dir")+ File.separator+"src/main/resources/config.properties";
            try {
                if (System.getenv().containsKey("CONFIG_FILE")) {
                    configFile = System.getenv().get("CONFIG_FILE");
                    System.out.println("Using config file from " + configFile);
                }
                instance = new ConfigManager(configFile);
                Enumeration<?> keys = prop.propertyNames();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    configFileMap.put(key, prop.getProperty(key));
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        return instance;
    }

    public String getProperty(String object) {
        return configFileMap.get(object);
    }
    
    public Integer getNumber(String object) {
        return Integer.parseInt(configFileMap.get(object));
    }

    public String getProperty(String key,String value) {
        return configFileMap.getOrDefault(key,value);
    }
    
    public Boolean getDebug() {
    	return Boolean.parseBoolean(configFileMap.get("debug"));
    }

    public static void main(String[] args) {
        ConfigManager.getInstance().getDebug();
        System.out.println(ConfigManager.getInstance().getProperty("code_times"));

    }
}
