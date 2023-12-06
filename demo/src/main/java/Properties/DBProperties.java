package Properties;

import java.io.IOException;
import java.util.Properties;
public class DBProperties {
    private static final Properties properties = new Properties();

    static {
        try{

            properties.load(DBProperties.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch (IOException ioException){
            throw new RuntimeException(ioException);
        }
    }

    public static String getControlURL(){return properties.get("control.url").toString();};

    public static String getControlUsername() { return  properties.getProperty("control.username").toString();
    }

    public static String getControlPassword() { return properties.getProperty("control.password");
    }

}
