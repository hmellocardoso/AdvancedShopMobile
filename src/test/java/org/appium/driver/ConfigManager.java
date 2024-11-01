package org.appium.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties;

    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar o arquivo config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
