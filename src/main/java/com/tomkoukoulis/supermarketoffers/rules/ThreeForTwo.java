package com.tomkoukoulis.supermarketoffers.rules;

import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;

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
