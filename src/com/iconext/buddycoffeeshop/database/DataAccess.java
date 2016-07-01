package com.iconext.buddycoffeeshop.database;

import com.iconext.buddycoffeeshop.model.Item;

import java.util.ArrayList;

public class DataAccess {

    public ArrayList<Item> getAll() {
        // In read life, this method should connect database to query data.

        ArrayList<Item> records = new ArrayList();
        Item item = null;
        records.add(null);

        item = new Item();
        item.setItemId(1);
        item.setName("Espresso");
        item.setCategory("Espresso");
        item.setPrice(45);
        records.add(item);

        item = new Item();
        item.setItemId(2);
        item.setName("Espresso Macchiato");
        item.setCategory("Espresso");
        item.setPrice(50);
        records.add(item);

        item = new Item();
        item.setItemId(3);
        item.setName("Cappuchino");
        item.setCategory("Hot Coffee");
        item.setPrice(50);
        records.add(item);

        item = new Item();
        item.setItemId(4);
        item.setName("Caramel Cappuchino");
        item.setCategory("Hot Coffee");
        item.setPrice(60);
        records.add(item);

        item = new Item();
        item.setItemId(5);
        item.setName("Cafe Latte");
        item.setCategory("Hot Coffee");
        item.setPrice(50);
        records.add(item);

        item = new Item();
        item.setItemId(6);
        item.setName("Cafe Mocha");
        item.setCategory("Hot Coffee");
        item.setPrice(60);
        records.add(item);

        item = new Item();
        item.setItemId(7);
        item.setName("Iced Cappuchino");
        item.setCategory("Iced Coffee");
        item.setPrice(55);
        records.add(item);

        item = new Item();
        item.setItemId(8);
        item.setName("Iced Caramel Cappuchino");
        item.setCategory("Iced Coffee");
        item.setPrice(65);
        records.add(item);

        item = new Item();
        item.setItemId(9);
        item.setName("Iced Cafe Latte");
        item.setCategory("Iced Coffee");
        item.setPrice(55);
        records.add(item);

        item = new Item();
        item.setItemId(10);
        item.setName("Iced Tea Latte");
        item.setCategory("Tea");
        item.setPrice(35);
        records.add(item);

        item = new Item();
        item.setItemId(11);
        item.setName("Iced Green Tea Latte");
        item.setCategory("Tea");
        item.setPrice(40);
        records.add(item);

        item = new Item();
        item.setItemId(12);
        item.setName("Strawberry Smoothie");
        item.setCategory("Smoothie");
        item.setPrice(60);
        records.add(item);

        item = new Item();
        item.setItemId(13);
        item.setName("Blueberry Smoothie");
        item.setCategory("Smoothie");
        item.setPrice(60);
        records.add(item);

        return records;
    }

    public Item get(int itemId) {
        // In read life, this method should connect database to query data.
        return getAll().get(itemId);
    }
}
