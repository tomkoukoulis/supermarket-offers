package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;

/**
 *
 * @author tomkoukoulis
 */
public class ThreeForTwo implements Rule {
    
    /**
     * The no of items needed to qualify for the offer
     */
    protected static final int NO_OF_ITEMS = 3;  
        
    /**
     * The offer item
     */
    protected Item item;

    /**
     * Constructor
     * 
     * @param item
     */
    public ThreeForTwo(Item item) {
        this.item = item;
    }
    
    /**
     * Gets the offer item.
     * 
     * @return the offer item
     */
//    public Item getItem() {
//        return this.item;
//    }
    
    @Override
    public Item addOffer() {
        return new Item("\tBuy 3 for 2", 0 - item.getPrice());
    }

    @Override
    public boolean checkPrerequisites(Receipt receipt) {
        int occurrences = receipt.getFrequency(item);
        return ((occurrences % NO_OF_ITEMS) == 0);
    }
}
