package application;

import entities.Product;

import java.io.*;
import java.util.*;

public class Exercise {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<Product>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String path = scanner.next();
        File fileSource = new File(path);
        String parent = fileSource.getParent();

        boolean success = new File(parent + "/out").mkdir();

        String sourceFilePath = parent+ "/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);

                String[] str = line.split(", ");
                String name = str[0];
                int quantity = Integer.parseInt(str[2]);
                double price = Double.parseDouble(str[1]);

                products.add(new Product(name, price, quantity));
                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFilePath))) {
                for (Product p : products) {
                   bw.write(p.getName() + ", " + String.format("%.2f", p.totalValue()));
                   bw.newLine();
                }
                System.out.println(sourceFilePath + " CREATED!");

            } catch (IOException e) {
                System.out.println("\nError: writing file" + e.getMessage());
            }


        } catch (IOException e) {
            System.out.println("Error: reading file" + e.getMessage());
        }



        scanner.close();
    }
}

