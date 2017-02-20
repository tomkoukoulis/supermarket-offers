package com.tomkoukoulis.supermarketoffers;

import java.util.LinkedHashMap;

/**
 *
 * @author tomkoukoulis
 */
public class AbstractTest {
    
    /**
     * A HashMap of a number of test items
     */
    protected LinkedHashMap<String, Item> testItems;
    
    /**
     * Constructor
     */
    public AbstractTest() {
        testItems = new LinkedHashMap<>();
        testItems.put("Pizza Margherita", new Item("Pizza Express Margherita 245g", 450));
        testItems.put("Organic Olives", new Item("Real Olive Co Organic Kalamata 210g", 299));
        testItems.put("Key Lime Pies", new Item("GU Key Lime Pies 2x85g", 300));
        testItems.put("Free Range Chicken", new Item("Free Range Chicken Drumsticks 412g", 579));
        testItems.put("Organic New Potatoes", new Item("Organic New Potatoes 500g", 169));
    }
}
