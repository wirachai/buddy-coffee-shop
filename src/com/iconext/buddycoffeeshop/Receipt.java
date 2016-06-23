package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.Item;
import com.iconext.buddycoffeeshop.model.OrderItem;
import com.iconext.buddycoffeeshop.repository.ItemRepository;

import java.util.List;

public class Receipt {
    private List<OrderItem> orderItems;

    public double getTotalPrice() {
        for (OrderItem orderItem : orderItems) {
            ItemRepository itemRepository = new ItemRepository();
            Item item = itemRepository.get(orderItem.getItemId());

            orderItem.setAmount(orderItem.getQuantity() * item.getPrice());
        }

        float total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getAmount() - orderItem.getDiscount();
        }
        return total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> items) {
        this.orderItems = items;
    }
}
