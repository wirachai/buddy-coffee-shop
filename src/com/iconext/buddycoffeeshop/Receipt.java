package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.Item;
import com.iconext.buddycoffeeshop.model.OrderItem;
import com.iconext.buddycoffeeshop.repository.ItemRepository;

import java.util.List;

public class Receipt {
    private List<OrderItem> list;

    public double calculate() {
        int tmp = 0, tmp2 = 0, sum = 0;
        for (OrderItem orderItem : list) {
            ItemRepository itemRepository = new ItemRepository();
            Item item = itemRepository.get(orderItem.getItemId());

            if (item.getCategory() == "Espresso") {
                orderItem.setDiscount(orderItem.getQuantity() * 5);
            } else {
                if (item.getCategory() == "Hot Coffee") {
                    tmp2 += orderItem.getQuantity();
                } else {
                    if (item.getCategory() == "Iced Coffee") {

                    } else {
                        if (item.getCategory() == "Smoothie") {
                            tmp += orderItem.getQuantity();
                        }
                    }
                }
            }
            sum += orderItem.getQuantity();

            orderItem.setAmount(orderItem.getQuantity() * item.getPrice());
        }

        if (tmp > 0 && tmp % 2 == 0) {
            for (OrderItem orderItem : list) {
                ItemRepository itemRepository = new ItemRepository();
                Item item = itemRepository.get(orderItem.getItemId());
                if (item.getCategory() == "Smoothie") {
                    orderItem.setDiscount(orderItem.getQuantity() * (item.getPrice() * 20.0f / 100.0f));
                }
            }
        }

        if (tmp2 >= 3) {
            int min = -1;
            float price = 999;
            for (int i = 0; i < list.size(); i++) {
                ItemRepository itemRepository = new ItemRepository();
                OrderItem orderItem = list.get(i);
                Item item = itemRepository.get(orderItem.getItemId());
                if (item.getCategory() == "Hot Coffee") {
                    if (item.getPrice() < price) {
                        min = i;
                        price = item.getPrice();
                    }
                }
            }

            list.get(min).setDiscount(price);
        }

        if (sum >= 5) {
            for (OrderItem orderItem : list) {
                orderItem.setDiscount(orderItem.getDiscount() + (orderItem.getQuantity() * 5));
            }
        }

        float total = 0;
        for (OrderItem orderItem : list) {
            total += orderItem.getAmount() - orderItem.getDiscount();
        }
        return total;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> items) {
        this.list = items;
    }
}
