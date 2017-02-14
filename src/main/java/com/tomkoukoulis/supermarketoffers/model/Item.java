/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.model;

import com.tomkoukoulis.supermarketoffers.controller.Rule;
import java.math.BigDecimal;

/**
 *
 * @author tomkoukoulis
 */
public class Item {
    protected int id;
    protected String desciption;
    protected BigDecimal price;
    protected Rule rule;
    
    public Item() {
        id++;
    }
    
    public Item(String description, float price) {
        this.desciption = description;
        this.price = BigDecimal.valueOf(price);
        id++;
    }
    
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = BigDecimal.valueOf(price);
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
}
