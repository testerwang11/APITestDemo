package com.autotest.utils;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private ClassPathResource resource = new ClassPathResource("config.properties");
    private static Properties properties = new Properties();

    public ConfigUtils() {
        try {
            properties.load(resource.getStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}
