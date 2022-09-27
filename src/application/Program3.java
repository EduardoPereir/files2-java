package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program3 {

    public static void main(String[] args) {

        String[] lines = new String[] {"Good morning", "Good night", "Good day", "Good afternoon"};

        String path = "/home/eduardo/Documentos/out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
        // Adding the true parameter the BufferedWriter don't remake the existing file and just increase the data to the existing one
        {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
            catch (IOException e){
                e.printStackTrace();
            }

    }
}
