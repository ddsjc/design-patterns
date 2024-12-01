package strategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class FirstMethod implements Activity{
    @Override
    public void countInt(FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int[] arr = (int[]) objectInputStream.readObject();
        Arrays.sort(arr);
        int count = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                count++;
            } else {
                System.out.println("Value " + arr[i] + " Count " + count);
                count = 1;
            }
        }
        System.out.println("Value " + arr[arr.length - 1] + " Count " + count );
    }
}
