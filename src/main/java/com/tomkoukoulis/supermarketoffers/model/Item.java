package com.tomkoukoulis.supermarketoffers.model;

import com.tomkoukoulis.supermarketoffers.controller.rules.Rule;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tomkoukoulis
 */
public class Item implements Comparable<Item> {
    private static final AtomicInteger idProvider = new AtomicInteger(0);

    protected int id;
    protected String desciption;
    protected int price;
    protected Rule rule;
    
    public Item(String description, int price) {
        this.id = idProvider.incrementAndGet();
        this.desciption = description;
        this.price = price;
    }
    
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
    
    public boolean hasRule() {
        return (rule != null);
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(item.getPrice(), this.price);
    }
}
