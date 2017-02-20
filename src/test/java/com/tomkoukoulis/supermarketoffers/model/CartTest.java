package com.tomkoukoulis.supermarketoffers.model;

import com.tomkoukoulis.supermarketoffers.AbstractTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class CartTest extends AbstractTest {
    
    /**
     * Constructor
     */
    public CartTest() {
    }

    /**
     * Test of add method, of class Cart.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
        Item pizza = testItems.get("Pizza Margherita");
        Cart cart = new Cart();
        
        boolean result = cart.add(pizza);
        boolean expResult = true;
        
        assertEquals(expResult, result);
        
        ArrayList<Item> expItems = cart.getItems();
        
        assertTrue(expItems.size() == 1);
        assertEquals(expItems.get(0), pizza);
    }

    /**
     * Test of addItems method, of class Cart.
     */
    @Test
    public void testAddItems() {
        System.out.println("addItems");
        
        ArrayList<Item> items = new ArrayList(testItems.values());

        Cart cart = new Cart();
        
        boolean result = cart.addItems(items);
        boolean expResult = true;

        assertEquals(expResult, result);
        
        ArrayList<Item> expItems = cart.getItems();
        
        assertTrue(expItems.size() == 5);
        assertEquals(expItems, items);
    }
}
