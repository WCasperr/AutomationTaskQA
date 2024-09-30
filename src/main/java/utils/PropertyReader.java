package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum PropertyReader {
    LOGIN("login"),
    PASSWORD("password");

    private final String key;
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/properties.xml")) {
            properties.loadFromXML(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties from XML file");
        }
    }

    PropertyReader(String key) {
        this.key = key;
    }

    public String get() {
        return properties.getProperty(key);
    }
}