package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.1.52",9999);
        InputStream sin = client.getInputStream();
        OutputStream sout = client.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        Scanner scanner = new Scanner(System.in);

        String strline;

        while(true){
            System.out.println("Print command line:");
            strline = scanner.next();
            out.writeUTF(strline); // відправляємо введену строку текста серверу.
            out.flush(); // заставляємо потік закінчити передачу даних.
            strline = in.readUTF(); // чекаємо поки сервер відправить строку тексту.
            System.out.println(strline);
        }
    }
}
