package strategy;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class Secondmethod implements Activity{
    @Override
    public void countInt(FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int[] arr = (int[]) objectInputStream.readObject();

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        System.out.println("Second method : ");
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.out.println("Value " + entry.getKey() + " Count " + entry.getValue());
        }
    }
}
