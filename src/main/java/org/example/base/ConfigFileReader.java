package org.example.base;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {

    private static ConfigFileReader instance;
    private final Properties properties;
    static String configPath = System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\config\\config.properties";

    private ConfigFileReader(String configFilePath) {
        this.properties = new Properties();

        try (InputStream configInputFile = Files.newInputStream(Paths.get(configFilePath))) {
            properties.load(configInputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error Read Configs : " + e.getMessage());
        }
    }

    public static ConfigFileReader getInstance() {
        if(instance == null) {
            instance = new ConfigFileReader(configPath);
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
