package singleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Singleton {
    private static Singleton single;
    private Properties properties;
    private Singleton (){
        FileInputStream data;
        properties = new Properties();
        try{
            data = new FileInputStream("src/main/resources/config.properties");
            properties.load(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static synchronized Singleton getInstance(){
        if (single == null){
          single = new Singleton();
        }
        return  single;
    }
    public String getProperty(String key){
       return properties.getProperty(key);
    }
}
