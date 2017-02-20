package com.tomkoukoulis.supermarketoffers.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tomkoukoulis
 */
public class Receipt {

    private static final AtomicInteger idProvider = new AtomicInteger(0);

    /**
     * A list of the items on the receipt
     */
    protected ArrayList<Item> listOfItems;

    /**
     * A unique id
     */
    protected final int id;

    /**
     * Constructor
     */
    public Receipt() {
        this.id = idProvider.incrementAndGet();
        listOfItems = new ArrayList<>();
    }

    /**
     *
     * @param item The item to be added
     * @return true if items was added successfully to the receipt, false otherwise
     */
    public boolean add(Item item) {
        return listOfItems.add(item);
    }

    /**
     *
     * @return The list of items on the receipt
     */
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    /**
     *
     * @return The total price of the items on the receipt
     */
    public float getTotalPrice() {
        int totalPrice = 0;
        
        for (Item item : listOfItems) {            
            totalPrice += item.getPrice();
        }
        
        return totalPrice/100f;
    }
    
    /**
     *
     * @param item 
     * @return the number of times the item appears on the receipt
     */
    public int getFrequency(Item item) {
        return Collections.frequency(listOfItems, item);
    }
    
    /**
     *
     * @param item
     * @return true if the item is on the receipt, false otherwise
     */
    public boolean contains(Item item) {
        return listOfItems.contains(item);
    }
}
