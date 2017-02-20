package com.tomkoukoulis.supermarketoffers.rules;

import com.tomkoukoulis.supermarketoffers.rules.TwoForASpecialPrice;
import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class TwoForASpecialPriceTest extends AbstractTest {
    
    /**
     * Constructor
     */
    public TwoForASpecialPriceTest() {
    }

    /**
     * Test of addOffer method, of class TwoForASpecialPrice.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        
        Item pizza = testItems.get("Pizza Margherita");
        
        int specialPrice = 600;
        int discount = specialPrice - pizza.getPrice()*2;
        
        TwoForASpecialPrice offer = new TwoForASpecialPrice(pizza, specialPrice);
        
        Item expResult = new Item("\tBuy 2 for £" + String.format("%.2f", (float) specialPrice/100), discount);
        Item result = offer.addOffer();
        
        System.out.println("Offer: " + result.getDescription());
        
        assertEquals(expResult.getDescription(), result.getDescription());
        assertEquals(expResult.getPrice(), result.getPrice());
    }

    /**
     * Test of checkPrerequisites method, of class TwoForASpecialPrice.
     */
    @Test
    public void testCheckPrerequisitesTrue() {
        System.out.println("checkPrerequisites True");
       
        int specialPrice = 600;
        
        TwoForASpecialPrice offer = new TwoForASpecialPrice(testItems.get("Pizza Margherita"), specialPrice);
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertTrue(result);
    }

    /**
     * Test of checkPrerequisites method, of class TwoForASpecialPrice.
     */
    @Test
    public void testCheckPrerequisitesFalse() {
        System.out.println("checkPrerequisites False");
       
        int specialPrice = 600;
        
        TwoForASpecialPrice offer = new TwoForASpecialPrice(testItems.get("Pizza Margherita"), specialPrice);
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Pizza Margherita"));
        
        boolean result = offer.checkPrerequisites(receipt);
        
        assertFalse(result);
    }    
}
