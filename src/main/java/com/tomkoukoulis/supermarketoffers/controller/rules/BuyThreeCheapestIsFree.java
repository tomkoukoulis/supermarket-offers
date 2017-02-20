package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tomkoukoulis
 */
public class BuyThreeCheapestIsFree implements Rule {

    private static final int NO_OF_ITEMS = 3;

    /**
     * The set of items this offer applies to
     */
    protected HashSet<Item> items = new HashSet<>();
    
    /**
     * The list of items on the receipt that qualify for this offer
     */
    protected ArrayList<Item> qualifyingItems = new ArrayList<>();

    /**
     * Constructor
     * 
     * @param setOfItems the set of items this offer applies to
     * @throws com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException
     */
    public BuyThreeCheapestIsFree(Set<Item> setOfItems) throws NotEnoughItemsException {
        if (setOfItems.size() < 3) {
            throw new NotEnoughItemsException("This offer requires at least three items.");
        }
        this.items = (HashSet<Item>) setOfItems;
    }

    /**
     * Adds an item to the offer.
     * 
     * @param item the item to be added to the offer
     * @return true if added was successfully added to the offer, false otherwise
     */
    public boolean add(Item item) {
        return items.add(item);
    }

    @Override
    public Item addOffer() {
        Item cheapestItem = (Item) Collections.min((List) qualifyingItems);
        return new Item("\t " + cheapestItem.getDescription(), 0 - cheapestItem.getPrice());
    }

    @Override
    public boolean checkPrerequisites(Receipt receipt) {
        Item item;
        Iterator<Item> iterator = items.iterator();
        
        while (iterator.hasNext() && qualifyingItems.size() < NO_OF_ITEMS) {
            item = iterator.next();
            if (receipt.contains(item)) {
                qualifyingItems.add(item);
            }
        }
        
        return qualifyingItems.size() >= NO_OF_ITEMS;
    }
}
