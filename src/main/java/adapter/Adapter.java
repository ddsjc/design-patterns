package adapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class Adapter {
    public byte[] writeStringToByte(String[] strings) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data;
        try {
            for(int i = 0; i < strings.length; i++){
                data = strings[i].getBytes();
                outputStream.write(data);
            }
            return outputStream.toByteArray();
        } catch (IOException e){
            throw new IOException("Recording not successful!");
        }
    }
    public String writeByteToString(byte[] bytes){
        return new String(bytes, Charset.defaultCharset());
}
}
