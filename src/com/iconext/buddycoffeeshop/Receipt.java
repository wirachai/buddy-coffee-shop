package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.OrderItem;

import java.util.List;

public class Receipt {
    private List<OrderItem> items;

    public double getTotalPrice() {
        return 0;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
