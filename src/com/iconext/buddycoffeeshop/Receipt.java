package com.iconext.buddycoffeeshop;

import com.iconext.buddycoffeeshop.model.Item;
import com.iconext.buddycoffeeshop.model.OrderItem;
import com.iconext.buddycoffeeshop.database.DataAccess;

import java.util.List;

public class Receipt {
    private List<OrderItem> list;

    public double calculate() {
        int tmp = 0, tmp2 = 0, tmp3 = 0, sum = 0;
        for (OrderItem i : list) {
            DataAccess dao = new DataAccess();
            Item itm = dao.get(i.getItemId());

            // if expresso
            if (itm.getCategory() == "Espresso") {
                // Fixed by Apinut 20160623
                //i.setDiscount(5);
                i.setDiscount(i.getQuantity() * 5);
            } else {
                if (itm.getCategory() == "Hot Coffee") {
                    tmp2 += i.getQuantity();
                } else {
                    if (itm.getCategory() == "Ice Coffee") {

                    } else {
                        if (itm.getCategory() == "Joice") {
                            tmp3++;
                        } else {
                            if (itm.getCategory() == "Tea") {

                            } else {
                                if (itm.getCategory() == "Smoothie") {
                                    tmp += i.getQuantity();
                                }
                            }
                        }
                    }
                }
            }
            sum += i.getQuantity();

            i.setAmount(i.getQuantity() * itm.getPrice());
        }

        // Requested P' Jittakorn : 20160624
        // calculate smoothie
        if (tmp > 0 && tmp % 2 == 0) {
            for (OrderItem i : list) {
                DataAccess dao = new DataAccess();
                Item itm = dao.get(i.getItemId());
                if (itm.getCategory() == "Smoothie") {
                    i.setDiscount(i.getQuantity() * (itm.getPrice() * 20.0f / 100.0f));
                }
            }
        }

        // calculate hot coffee
        if (tmp2 >= 3) {
            int min = -1;
            float price = 999;
            for (int i = 0; i < list.size(); i++) {
                DataAccess dao = new DataAccess();
                OrderItem orderItem = list.get(i);
                Item item = dao.get(orderItem.getItemId());
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
            for (OrderItem i : list) {
                i.setDiscount(i.getDiscount() + (i.getQuantity() * 5));
            }
        }

        // ================================================================================
        // summary total
        // ================================================================================
        float amt = 0, dis = 0, sum2 = 0;
        for (OrderItem i : list) {
            amt += i.getAmount();
            dis += i.getDiscount();
            sum2 += i.getAmount() - i.getDiscount();
        }

        return sum2;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> items) {
        this.list = items;
    }
}
