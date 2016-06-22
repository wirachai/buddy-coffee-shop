package com.iconext.buddycoffeeshop.repository;

import com.iconext.buddycoffeeshop.model.Item;

public class ItemRepository {
    public Item Get(int itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        switch (itemId) {
            case 1:
                item.setName("Espresso");
                item.setCategory("Espresso");
                item.setPrice(45);
                break;
            case 2:
                item.setName("Espresso Macchiato");
                item.setCategory("Espresso");
                item.setPrice(50);
                break;
        }

        return item;
    }
}
