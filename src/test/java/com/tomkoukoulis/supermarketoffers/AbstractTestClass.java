/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.model.Item;
import java.util.ArrayList;

/**
 *
 * @author tomkoukoulis
 */
public class AbstractTestClass {
    
    public ArrayList<Item> items;
    
    public AbstractTestClass() {
        items = new ArrayList<>();
        items.add(new Item("Pizza Express Margherita 245g", 4.50f));
        items.add(new Item("Real Olive Co Organic Kalamata 210g", 2.99f));
        items.add(new Item("GU KEY LIME PIES 2x85g", 3.00f));
        items.add(new Item("Free Range Chicken Drumsticks 412g", 5.79f));
        items.add(new Item("Organic New Potatoes 500g", 1.69f));
    }
}