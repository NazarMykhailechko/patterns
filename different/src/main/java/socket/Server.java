package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Start server:");

        Socket client = serverSocket.accept();

        InputStream sin = client.getInputStream();
        OutputStream sout = client.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        String strline;

        while(true){

            strline = in.readUTF(); // чекаємо поки клієнт надішле строку тексту.

            Process command;
            try {
                command = Runtime.getRuntime().exec(strline);

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(command.getInputStream(), "Cp866"));

                StringBuilder sb = new StringBuilder();

                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                out.writeUTF(sb.toString());
                out.flush(); // заставляємо потік закінчити предачу даних.

            } catch (IOException e) {

                out.writeUTF("Error! No such a command!\n");
                out.flush(); // заставляємо потік закінчити передачу даних.
            }

        }
    }

}
