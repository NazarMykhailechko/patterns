package javaio;

import javassist.bytecode.ByteArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("D:/seccer1_1/different/data.txt");

        byte[] buff = new byte[1024];
        int r;

        do{
            r=inputStream.read(buff,0,buff.length);

            if(r>0){
                System.out.println(new String(buff,0,r));
            }

        } while(r>0);

        inputStream.close();
    }

}
