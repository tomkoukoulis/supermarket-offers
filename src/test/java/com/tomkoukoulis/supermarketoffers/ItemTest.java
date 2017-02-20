package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.AbstractTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class ItemTest extends AbstractTest {
    
    /**
     * Constructor
     */
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
        
        int expResult = -1;
        int result = pizza.compareTo(chicken);
        
        assertEquals(expResult, result);
    }
}
