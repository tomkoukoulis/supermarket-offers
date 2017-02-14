/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.controller;

import com.tomkoukoulis.supermarketoffers.model.Item;
import java.util.Set;

/**
 *
 * @author tomkoukoulis
 */
public interface Rule {
    //setofitems
    public abstract float calculateNewPrice();
    public abstract int getNumberOfItems();
    public abstract Set<Item> getSetOfItems();
    public abstract void setSetOfItems(Set<Item> setOfItems) throws Exception;
    public abstract void setItem(Item item);
}
