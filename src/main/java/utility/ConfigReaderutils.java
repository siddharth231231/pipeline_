package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderutils {
	
	private static Properties properties;

    // Static block to load properties file only once
    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    // Method to get property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Additional helper methods for specific configurations
    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }

    public static String getUsername() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }
}     


