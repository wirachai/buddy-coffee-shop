package com.iconext.buddycoffeeshop.test;

import com.iconext.buddycoffeeshop.Receipt;
import com.iconext.buddycoffeeshop.model.OrderItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReceiptTest {
    @Test
    public void getTotalPrice_shouldBeNormalPrice_whenHas1ItemAndNoDiscount() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(1);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(45.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldBeNormalPrice_whenHas2ItemsAndNoDiscount() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(13);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(120.0, totalPrice, 0.001);
    }
}
