package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        boolean flog = false;
        try{
            System.out.println("Hello I'm a server");
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            do {
                if (dataInputStream != null) {
                    String message = dataInputStream.readUTF();
                    System.out.println("Client : " + message);

                    System.out.print("Enter your message : ");
                    String response = new java.util.Scanner(System.in).nextLine();
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(response);

                    if (response != null){
                        flog = true;
                    }else {
                        flog = false;
                    }
                }else {
                    flog = false;
                }
            }while(flog);

            socket.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}