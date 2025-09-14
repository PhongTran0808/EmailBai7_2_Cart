package com.example.demo17_11_9_2025.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cart implements Serializable
{
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems()
    {
        return items;
    }

    public void addItem(Product product, int quantity)
    {
        for (CartItem item : items)
        {
            if (item.getProduct().getCode().equals(product.getCode()))
            {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void updateItem(String code, int quantity)
    {
        items.removeIf(item -> item.getProduct().getCode().equals(code) && quantity <= 0);
        for (CartItem item : items)
        {
            if (item.getProduct().getCode().equals(code))
            {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public double getTotal()
    {
        double total = 0;
        for (CartItem item : items)
        {
            total += item.getTotal();
        }
        return total;
    }
}