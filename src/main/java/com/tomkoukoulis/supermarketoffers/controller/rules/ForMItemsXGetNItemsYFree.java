package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;
import java.util.ArrayList;

/**
 *
 * @author tomkoukoulis
 */
public class ForMItemsXGetNItemsYFree implements Rule {
    
    ArrayList<Item> freebies;
    
    private Item itemX;
    private Item itemY;
    private int m;
    private int n;
    
    /**
     * Constructor
     * 
     * @param itemX the items on offer
     * @param m the number of items X to buy to get this offer
     * @param itemY the free items
     * @param n the number of free items Y, when buying m Items X
     */
    public ForMItemsXGetNItemsYFree(Item itemX, int m, Item itemY, int n) throws NotEnoughItemsException {
        if (m <= 0 || n <= 0) {
            throw new NotEnoughItemsException("This offer requires at least one of each items");
        }
        this.itemX = itemX;
        this.itemY = itemY;
        this.m = m;
        this.n = n;
    }

    @Override
    public Item addOffer() {
        return new Item("\tGet " + n +" Free", 0 - itemY.getPrice());
    }
    
    @Override
    public boolean checkPrerequisites(Receipt receipt) {
        int occurrencesX = receipt.getFrequency(itemX);
        int occurrencesY = receipt.getFrequency(itemY);
        
        boolean areMultiplesOfThree = ((occurrencesX % m) == 0);
        boolean areThereEnoughItemsX = ((float) occurrencesY/n <= occurrencesX/m);
        boolean haveFreeItemsBeenAddedToReceipt = (occurrencesY != 0);
        
        return 
            areMultiplesOfThree && 
            areThereEnoughItemsX && 
            haveFreeItemsBeenAddedToReceipt;
    } 
}
