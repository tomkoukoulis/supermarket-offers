package com.tomkoukoulis.supermarketoffers.rules;

import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;

/**
 *
 * @author tomkoukoulis
 */
public interface Rule {

    /**
     * Adds discount offer 
     * 
     * @return the discount to be applied to the receipt
     */
    public Item addOffer();

    /**
     * Checks prerequisites for an offer
     * 
     * @param receipt the receipt of the items so far
     * @return true if prerequisites for this offer are met, false otherwise
     */
    public boolean checkPrerequisites(Receipt receipt);
}
