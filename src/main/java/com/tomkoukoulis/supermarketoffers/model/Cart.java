/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.model;

import java.util.ArrayList;

/**
 *
 * @author tomkoukoulis
 */
public class Cart {

    protected ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(ArrayList<Item> items) {
        this.items = items;
    }
    
    public boolean add(Item item) {
        return this.items.add(item);
    }
    
    public void addItems(ArrayList<Item> items) {
        this.items.addAll(items);
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
}
