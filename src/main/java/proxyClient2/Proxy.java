package proxyClient2;

import java.io.*;
import java.net.Socket;

public class Proxy {
    public static void multi(double num, double num2) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5000);
            System.out.println("Client " + clientSocket + " connected!");

            OutputStream outputStream = clientSocket.getOutputStream();
            InputStream reader = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(reader);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeDouble(num);
            dataOutputStream.writeDouble(num2);

            double result = dataInputStream.readDouble();
            System.out.println("Result of multi is " + result);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
