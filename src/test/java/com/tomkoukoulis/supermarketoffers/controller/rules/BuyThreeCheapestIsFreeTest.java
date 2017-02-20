package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class BuyThreeCheapestIsFreeTest extends AbstractTest {
    
    /**
     * Constructor
     */
    public BuyThreeCheapestIsFreeTest() {
    }

    /**
     * Test of add method, of class BuyThreeCheapestIsFree.
     * 
     * @throws com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException
     */
    @Test
    public void testAdd() throws NotEnoughItemsException {
        System.out.println("add");
                
        HashSet<Item> items = new HashSet<>();
        items.add(testItems.get("Pizza Margherita"));
        items.add(testItems.get("Organic Olives"));
        items.add(testItems.get("Key Lime Pies"));
        
        BuyThreeCheapestIsFree offer = new BuyThreeCheapestIsFree(items);
        
        boolean result = offer.add(testItems.get("Organic New Potatoes"));
        
        assertTrue(result);
    }

    /**
     * Test of addOffer method, of class BuyThreeCheapestIsFree.
     * 
     * @throws com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException
     */
    @Test
    public void testAddOffer() throws NotEnoughItemsException {
        System.out.println("addOffer");
        
        HashSet<Item> items = new HashSet<>();
        items.add(testItems.get("Pizza Margherita"));
        items.add(testItems.get("Organic Olives"));
        items.add(testItems.get("Key Lime Pies"));
        
        BuyThreeCheapestIsFree offer = new BuyThreeCheapestIsFree(items);
                
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Key Lime Pies"));
        
        offer.checkPrerequisites(receipt);
        
        Item result = offer.addOffer();
        Item expResult = new Item("\t Real Olive Co Organic Kalamata 210g" , -299);
        
        assertEquals(expResult.getDescription(), result.getDescription());
    }

    /**
     * Test of checkPrerequisites method, of class BuyThreeCheapestIsFree.
     * 
     * @throws com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesTrue() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites");
        
        HashSet<Item> items = new HashSet<>();
        items.add(testItems.get("Pizza Margherita"));
        items.add(testItems.get("Organic Olives"));
        items.add(testItems.get("Key Lime Pies"));
        
        BuyThreeCheapestIsFree offer = new BuyThreeCheapestIsFree(items);
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Key Lime Pies"));
        
        boolean result = offer.checkPrerequisites(receipt);
        
        assertTrue(result);
    }   

    /**
     * Test of checkPrerequisites method, of class BuyThreeCheapestIsFree.
     * 
     * @throws com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesFalse() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites");
        
        HashSet<Item> items = new HashSet<>();
        items.add(testItems.get("Pizza Margherita"));
        items.add(testItems.get("Organic Olives"));
        items.add(testItems.get("Key Lime Pies"));
        
        BuyThreeCheapestIsFree offer = new BuyThreeCheapestIsFree(items);
        
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        
        boolean result = offer.checkPrerequisites(receipt);
        
        assertFalse(result);
    }  
}
