package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.Item;
import com.iconext.buddycoffeeshop.model.OrderItem;
import com.iconext.buddycoffeeshop.repository.ItemRepository;

import java.util.List;

public class Receipt {
    private List<OrderItem> orderItems;

    public double getTotalPrice() {
        int smoothieQuantity = 0;
        int hotCoffeeQuantity = 0;
        int totalQuantity = 0;
        for (OrderItem orderItem : orderItems) {
            ItemRepository itemRepository = new ItemRepository();
            Item item = itemRepository.get(orderItem.getItemId());

            if (item.getCategory() == "Espresso") {
                orderItem.setDiscount(5);
            } else if (item.getCategory() == "Hot Coffee") {
                hotCoffeeQuantity += orderItem.getQuantity();
            } else if (item.getCategory() == "Smoothie") {
                smoothieQuantity += orderItem.getQuantity();
            }
            totalQuantity += orderItem.getQuantity();

            orderItem.setAmount(orderItem.getQuantity() * item.getPrice());
        }

        if (smoothieQuantity > 0 && smoothieQuantity % 2 == 0) {
            for (OrderItem orderItem : orderItems) {
                ItemRepository itemRepository = new ItemRepository();
                Item item = itemRepository.get(orderItem.getItemId());
                if (item.getCategory() == "Smoothie") {
                    orderItem.setDiscount(orderItem.getQuantity() * (item.getPrice() * 20.0f / 100.0f));
                }
            }
        }

        if (hotCoffeeQuantity >= 3) {
            int lowestHotCoffeeIndex = -1;
            float lowestHotCoffeePrice = 999;
            for (int i = 0; i < orderItems.size(); i++) {
                ItemRepository itemRepository = new ItemRepository();
                OrderItem orderItem = orderItems.get(i);
                Item item = itemRepository.get(orderItem.getItemId());
                if (item.getCategory() == "Hot Coffee") {
                    if (item.getPrice() < lowestHotCoffeePrice) {
                        lowestHotCoffeeIndex = i;
                        lowestHotCoffeePrice = item.getPrice();
                    }
                }
            }

            orderItems.get(lowestHotCoffeeIndex).setDiscount(lowestHotCoffeePrice);
        }

        if (totalQuantity >= 5) {
            for (OrderItem orderItem : orderItems) {
                orderItem.setDiscount(orderItem.getDiscount() + (orderItem.getQuantity() * 5));
            }
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
