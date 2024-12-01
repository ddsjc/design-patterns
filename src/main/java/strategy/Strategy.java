package strategy;

import java.io.*;
import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args.length == 0) {
            System.err.println("Файл не нашел - задай параметр");
            return;
        }
        String fileName = args[0];

        int[] arr = {1,2,3,4,1,1,1,4,5,5,6};
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(arr);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Activity activity1 = new FirstMethod();
        activity1.countInt(fileInputStream);
        fileInputStream.close();

        fileInputStream = new FileInputStream(fileName);
        Activity activity2 = new Secondmethod();
        activity2.countInt(fileInputStream);
    }
}
