package org.example.app;


import org.example.model.Product;
import org.example.service.CartService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartService cartService = new CartService();

        System.out.println("Welcome to the Shopping Cart System!");

        boolean running = true;

        while (running) {
            System.out.println("1. Show all products");
            System.out.println("2. Add a product");
            System.out.println("3. Remove product by index");
            System.out.println("4. Show cart total");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> cartService.showAllProducts();
                case "2" -> {
                    System.out.println("Adding a product...");

                    System.out.print("Product name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    cartService.addProduct(new Product(name, price, quantity));

                }
                case "3" -> {
                    System.out.println("Removing a product...");

                    cartService.showAllProducts();

                    System.out.print("Enter the number of the product to remove: ");
                    int index = Integer.parseInt(sc.nextLine());

                    cartService.removeProductByIndex(index);
                }

                case "4" -> cartService.showCartTotal();
                case "5" -> running = false;
                default -> System.out.println("\nInvalid number, try again!\n");


            }

        }

        System.out.println("\nThank you for using the Shopping Cart System!");
        System.out.println("Goodbye!");
        sc.close();
    }
}
