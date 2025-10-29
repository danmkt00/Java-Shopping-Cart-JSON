package org.example.service;

import com.google.gson.reflect.TypeToken;
import org.example.model.Product;
import org.example.util.JsonUtil;

import java.lang.reflect.Type;

import java.util.List;

public class CartService {
    private List<Product> products;

    @SuppressWarnings("unchecked")
    public CartService()
    {
        Type listType = new TypeToken<List<Product>>() {}.getType();
        this.products = (List<Product>) JsonUtil.loadFromFile(listType);
    }

    public void showAllProducts()
    {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("\nProducts in your cart:");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.printf("%d. %s (Price: %.2f, Quantity: %d)%n",
                    i + 1, p.getName(), p.getPrice(), p.getQuantity());
        }

        System.out.println();

    }

    public void addProduct(Product product)
    {
        products.add(product);
        System.out.println(product + " added successfully");
        save();
    }

    public void removeProductByIndex(int index)
    {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        int actualIndex = index - 1;

        if (actualIndex >= 0 && actualIndex < products.size()) {
            Product removed = products.remove(actualIndex);
            System.out.println("Removed product: " + removed.getName());
        } else {
            System.out.println("Invalid selection. Please choose a valid number.");
        }
    }

    public void showCartTotal()
    {
        double total = 0.0;
        for(Product product : products)
        {
            total += product.getPrice() * product.getQuantity();
        }

        System.out.printf("\nYour cart total is : %.2f%n\n", total);

    }



    private void save()
    {
        JsonUtil.saveToFile(products);
    }


}
