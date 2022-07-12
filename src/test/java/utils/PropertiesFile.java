package utils;

import java.util.Properties;

public class PropertiesFile {


    public static Properties readFile() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesFile.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
