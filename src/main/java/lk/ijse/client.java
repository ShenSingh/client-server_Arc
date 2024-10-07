package lk.ijse;
import java.util.Scanner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try {
            boolean flog = false;

            Socket socket = new Socket("localhost", 3000);
            System.out.println("Hello I'm a client");
            do {
                System.out.print("Enter your message : ");
                String message = new Scanner(System.in).nextLine();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message);

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String response = dataInputStream.readUTF();
                System.out.println("Server : " + response);

                if (response != null){
                    flog = true;
                }else {
                    flog = false;
                }
            }while (flog);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
