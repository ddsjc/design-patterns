package adapter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Adapter adapter = new Adapter();
        String[] strings = {"Adapter", "is", "working"};
        byte[] bytes = adapter.writeStringToByte(strings);
        System.out.println(Arrays.toString(bytes));
        System.out.println(adapter.writeByteToString(bytes));
    }
}
