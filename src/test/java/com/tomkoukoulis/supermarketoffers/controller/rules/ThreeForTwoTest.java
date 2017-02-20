package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tomkoukoulis
 */
public class ThreeForTwoTest extends AbstractTest {
    Rule rule;
            
    /**
     * Constructor
     */
    public ThreeForTwoTest() {
    }

    /**
     * Test of addOffer method, of class ThreeForTwo.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        
        Item pizza = testItems.get("Pizza Margherita");
        
        ThreeForTwo offer = new ThreeForTwo(pizza);
        
        Item expResult = new Item("\tBuy 3 for 2", 0 - pizza.getPrice());
        Item result = offer.addOffer();
        
        assertEquals(expResult.getDescription(), result.getDescription());
        assertEquals(expResult.getPrice(), result.getPrice());
    }

    /**
     * Test of checkPrerequisites method, of class ThreeForTwo.
     */
    @Test
    public void testCheckPrerequisitesTrue() {
        System.out.println("checkPrerequisites");
        
        
        ThreeForTwo offer = new ThreeForTwo(testItems.get("Pizza Margherita"));
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertTrue(result);
    }
    
    /**
     * Test of checkPrerequisites method, of class ThreeForTwo.
     */
    @Test
    public void testCheckPrerequisitesFalse() {
        System.out.println("checkPrerequisites");
        
        ThreeForTwo offer = new ThreeForTwo(testItems.get("Pizza Margherita"));
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Key Lime Pies"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertFalse(result);
    }
}
