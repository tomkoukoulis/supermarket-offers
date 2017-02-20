package com.tomkoukoulis.supermarketoffers.model;

import com.tomkoukoulis.supermarketoffers.AbstractTestClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class ItemTest extends AbstractTestClass {
    
    public ItemTest() {
    }

    /**
     * Test of compareTo method, of class Item.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");

        Item pizza = testItems.get("Pizza Margherita");
        Item chicken = testItems.get("Free Range Chicken");
        
        int expResult = 1;
        int result = pizza.compareTo(chicken);
        
        assertEquals(expResult, result);
    }
}
