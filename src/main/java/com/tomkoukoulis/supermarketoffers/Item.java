package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.rules.Rule;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tomkoukoulis
 */
public class Item implements Comparable<Item> {
    private static final AtomicInteger idProvider = new AtomicInteger(0);

    /**
     * A unique id identifying the item
     */
    protected int id;

    /**
     * The description of the item
     */
    protected String description;

    /**
     * The price of the item
     */
    protected int price;

    /**
     * If item is on offer, the offer rule
     */
    protected Rule rule;
    
    /**
     * Constructor
     * 
     * Constructs an item with its description and price
     * 
     * @param description
     * @param price
     */
    public Item(String description, int price) {
        this.id = idProvider.incrementAndGet();
        this.description = description;
        this.price = price;
    }
    
    /**
     * Gets the description of the item
     * 
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the item
     * 
     * @param description The description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the item
     *
     * @return The price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the item
     *
     * @param price The price of the item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the offer rule or null if the item is not on offer
     *
     * @return the offer rule
     */
    public Rule getRule() {
        return rule;
    }

    /**
     * Sets the item on offer according to the corresponding rule
     *
     * @param rule
     */
    public void setRule(Rule rule) {
        this.rule = rule;
    }
    
    /**
     *
     * @return true if the item is on offer, false otherwise
     */
    public boolean isOnOffer() {
        return (rule != null);
    }

    @Override
    public int compareTo(Item item) {
        int cheaperThan = Integer.compare(this.price, item.getPrice());
        return cheaperThan;
    }
}
