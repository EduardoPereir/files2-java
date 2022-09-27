package application;

import java.io.File;
import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        System.out.println("getName: " + file.getName());
        System.out.println("getParent: " + file.getParent());
        System.out.println("getPath: " + file.getPath());

        scanner.close();
    }
}
