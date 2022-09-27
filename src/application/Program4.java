package application;

import java.io.File;
import java.util.Scanner;

public class Program4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the folder path: ");
        String str = scanner.nextLine();

        File path = new File(str);
        File[] files = path.listFiles(File::isDirectory);
        System.out.println("\n\nFolders: ");
        for (File file : files) {
            System.out.println(file);
        }

        File[] folders = path.listFiles(File::isFile);
        System.out.println("\n\nFiles: ");
        for (File f : folders) {
            System.out.println(f);
        }

        System.out.println("");

        boolean success = new File(str + "/subdir").mkdir();
        System.out.println("Directory created successfully: " + success);

        scanner.close();

    }
}
