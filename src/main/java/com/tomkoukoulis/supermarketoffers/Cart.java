package com.tomkoukoulis.supermarketoffers;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author tomkoukoulis
 */
public class Cart {

    /**
     * The list of items in the cart
     */
    protected ArrayList<Item> items;

    /**
     * Constructor
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * Constructor with list of items
     * 
     * @param items
     */
    public Cart(ArrayList<Item> items) {
        this.items = items;
    }
    
    /**
     * Adds item to cart
     * 
     * @param item The item to be added
     * @return true if item was successfully added to the cart, false otherwise
     */
    public boolean add(Item item) {
        return this.items.add(item);
    }
    
    /**
     * Adds a collection of items to cart
     * 
     * @param items The collection of items to be added to cart
     * @return true cart contents have changed as a result of this method, false otherwise
     */
    public boolean addItems(Collection<Item> items) {
        return this.items.addAll(items);
    }
    
    /**
     *
     * @return the list of items in the cart
     */
    public ArrayList<Item> getItems() {
        return items;
    }
}
