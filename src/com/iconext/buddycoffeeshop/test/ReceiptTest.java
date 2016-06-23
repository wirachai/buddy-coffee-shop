package com.iconext.buddycoffeeshop.test;

import com.iconext.buddycoffeeshop.Receipt;
import com.iconext.buddycoffeeshop.model.OrderItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReceiptTest {
    @Test
    public void getTotalPrice_shouldBeStandardPrice_whenHas1ItemAndNoDiscount() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(3);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(50.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldBeStandardPrice_whenHas2ItemsAndNoDiscount() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(6);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(120.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldGetDiscount_whenHasEspresso() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(1);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(80.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldGetDiscount20Percent_whenHasDoubleSmoothie() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(12);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(96.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldGetDiscount20Percent_whenHasDoubleDifferentSmoothie() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = null;

        orderItem = new OrderItem();
        orderItem.setItemId(12);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setItemId(13);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(96.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldGetFree1LowestPriceCup_whenHas3HotCoffee() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = null;

        orderItem = new OrderItem();
        orderItem.setItemId(3);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setItemId(4);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(110.0, totalPrice, 0.001);
    }

    @Test
    public void getTotalPrice_shouldGetAdditionDiscount5BahtPerCup_whenHas5Cups() {
        // arrange
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = null;

        orderItem = new OrderItem();
        orderItem.setItemId(1);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setItemId(3);
        orderItem.setQuantity(2);
        orderItems.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setItemId(9);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setItemId(12);
        orderItem.setQuantity(1);
        orderItems.add(orderItem);

        // 260 - 30

        Receipt receipt = new Receipt();
        receipt.setOrderItems(orderItems);

        // act
        double totalPrice = receipt.getTotalPrice();

        // assert
        Assert.assertEquals(230.0, totalPrice, 0.001);
    }
}
