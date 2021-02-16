package setup;

import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class Property {
    protected String domain;
    protected String packageName;

    public Property() throws FileNotFoundException {
        try (InputStream input = new FileInputStream("android.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            domain = prop.getProperty("DOMAIN");
            packageName = prop.getProperty("PACKAGE_NAME");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
