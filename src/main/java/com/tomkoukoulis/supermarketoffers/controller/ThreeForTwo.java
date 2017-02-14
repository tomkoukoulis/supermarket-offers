/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.controller;

import com.tomkoukoulis.supermarketoffers.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tomkoukoulis
 */
public class ThreeForTwo implements Rule {

    Set<Item> setOfItems;

    public ThreeForTwo() {
    }

    @Override
    public float calculateNewPrice() {
        ArrayList<Item> list = new ArrayList<>(setOfItems);
        Item item = list.get(0);
        return item.getPrice()
                .divide(BigDecimal.valueOf(3))
                .multiply(BigDecimal.valueOf(2))
                .floatValue();
    }

    @Override
    public int getNumberOfItems() {
        int numberOfItems;
        if (setOfItems == null) {
            numberOfItems = 0;
        } else {
            numberOfItems = setOfItems.size();
        }
        return numberOfItems;
    }

    @Override
    public Set<Item> getSetOfItems() {
        return setOfItems; //What happens if set is not set?
    }

    @Override
    public void setSetOfItems(Set<Item> setOfItems) throws Exception {
        if (setOfItems.size() > 1) {
            throw new Exception("Set size not compatible with rule.");
        }
        this.setOfItems = setOfItems;
    }

    @Override
    public void setItem(Item item) {
        if (setOfItems == null) {
            setOfItems = new HashSet<>();
        }
        //Check rule compatibility
        setOfItems.add(item);
    }
}
