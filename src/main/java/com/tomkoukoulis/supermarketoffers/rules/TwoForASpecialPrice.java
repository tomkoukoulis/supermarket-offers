package com.tomkoukoulis.supermarketoffers.rules;

import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;

/**
 *
 * @author tomkoukoulis
 */
public class TwoForASpecialPrice implements Rule {
    
    /**
     * The number of items of this offer
     */
    protected static final int NO_OF_ITEMS = 2;
    
    /**
     * The special offer price
     */
    protected int specialPrice;

    /**
     * The discount to match the offer
     */
    protected int discount;

    /**
     * The item on offer
     */
    protected Item item;

    /**
     * Constructor
     *  
     * @param item the item on offer
     * @param specialPrice the offer price
     */
    public TwoForASpecialPrice(Item item, int specialPrice) {
        this.item = item;
        this.specialPrice = specialPrice;
        this.discount = specialPrice - item.getPrice()*2;
    }    
//       
//    public Item getItem() {
//        return this.item;
//    }

    @Override
    public Item addOffer() {
        return new Item("\tBuy 2 for £" + String.format("%.2f", (float) specialPrice/100), discount);    
    }
    
    @Override
    public boolean checkPrerequisites(Receipt receipt) {
        int occurrences = receipt.getFrequency(item);
        return (occurrences % NO_OF_ITEMS) == 0;
    }
}
