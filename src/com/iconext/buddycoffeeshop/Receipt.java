package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.OrderItem;

import java.util.List;

public class Receipt {
    private List<OrderItem> items;

    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getAmount() - item.getDiscount();
        }
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
