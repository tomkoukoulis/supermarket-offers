package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;

/**
 *
 * @author tomkoukoulis
 */
public interface Rule {

    /**
     * Adds item to an offer
     * 
     * @return the item that got on offer
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
