package strategy;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public interface Activity {
    void countInt(FileInputStream fileInputStream) throws IOException, ClassNotFoundException;
}
