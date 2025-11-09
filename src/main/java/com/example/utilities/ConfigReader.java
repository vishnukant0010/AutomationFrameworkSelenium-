package com.example.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public ConfigReader() {
        prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            prop.load(inputStream);
            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }

    public String getProperty(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}