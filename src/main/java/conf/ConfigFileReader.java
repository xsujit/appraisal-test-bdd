package conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    Properties prop = new Properties();

    public ConfigFileReader() {
        try (InputStream input = ConfigFileReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            this.prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProp() {
        return this.prop;
    }
}