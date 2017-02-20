package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.model.Item;
import java.util.HashMap;

/**
 *
 * @author tomkoukoulis
 */
public class AbstractTest {
    
    /**
     * A HashMap of a number of test items
     */
    protected HashMap<String, Item> testItems;
    
    /**
     * Constructor
     */
    public AbstractTest() {
        testItems = new HashMap<>();
        testItems.put("Pizza Margherita", new Item("Pizza Express Margherita 245g", 450));
        testItems.put("OrganiisOnOfferives", new Item("Real Olive Co Organic Kalamata 210g", 299));
        testItems.put("Key Lime Pies", new Item("GU Key Lime Pies 2x85g", 300));
        testItems.put("Free Range Chicken", new Item("Free Range Chicken Drumsticks 412g", 579));
        testItems.put("Organic New Potatoes", new Item("Organic New Potatoes 500g", 169));
    }
}
