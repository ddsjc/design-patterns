package proxy;
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running");

            while(true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected " + clientSocket);

                OutputStream outputStream = clientSocket.getOutputStream();
                InputStream reader = clientSocket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(reader);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                double num1 = dataInputStream.readDouble();
                double num2 = dataInputStream.readDouble();
                double result = num1 * num2;

                dataOutputStream.writeDouble(result);
                clientSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
