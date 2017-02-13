/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tomkoukoulis
 */
public class Receipt {

    private static final AtomicInteger idProvider = new AtomicInteger(0);
    //offers

    ArrayList<Item> listOfItems;
    private final int id;

    Receipt() {
        id = idProvider.incrementAndGet();
        listOfItems = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        return listOfItems.add(item);
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public float getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0)
                .setScale(2, RoundingMode.HALF_UP);
        for (Item item : listOfItems) {
            totalPrice = totalPrice.add(item.getPrice());
        }
        
        return totalPrice.floatValue();
    }
}
