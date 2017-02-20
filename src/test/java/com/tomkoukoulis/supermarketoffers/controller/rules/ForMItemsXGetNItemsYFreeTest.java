package com.tomkoukoulis.supermarketoffers.controller.rules;

import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.controller.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.model.Item;
import com.tomkoukoulis.supermarketoffers.model.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class ForMItemsXGetNItemsYFreeTest extends AbstractTest {
    
    /**
     * Constructor
     */
    public ForMItemsXGetNItemsYFreeTest() {
    }

    /**
     * Test of addOffer method, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test
    public void testAddOffer() throws NotEnoughItemsException {
        System.out.println("addOffer");

        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 3, 
            testItems.get("Organic Olives"), 2);
        
        Item expResult = new Item("\tGet 2 Free", -299);
        Item result = offer.addOffer();
        
        assertEquals(expResult.getDescription(), result.getDescription());
        assertEquals(expResult.getPrice(), result.getPrice());
    }

    /**
     * Test of checkPrerequisites method, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesTrue() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites true");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 3, 
            testItems.get("Organic Olives"), 2);

        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Organic Olives"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertTrue(result);
    }
    
    /**
     * Test of checkPrerequisites method, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesTrueOddFreeItems() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites true odd free items");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(testItems.get("Pizza Margherita"), 3, testItems.get("Organic Olives"), 2);

        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives")); //Free
        
        boolean result = offer.checkPrerequisites(receipt);
        assertTrue(result);
        
        receipt.add(testItems.get("Organic Olives")); //Free
        result = offer.checkPrerequisites(receipt);
        assertTrue(result);

        receipt.add(testItems.get("Organic Olives")); //Not free
        result = offer.checkPrerequisites(receipt);
        assertFalse(result);
        
        receipt.add(testItems.get("Pizza Margherita"));
        result = offer.checkPrerequisites(receipt);
        assertFalse(result);

        receipt.add(testItems.get("Pizza Margherita"));
        result = offer.checkPrerequisites(receipt);
        assertFalse(result);
 
        receipt.add(testItems.get("Organic Olives")); //Not free either
        result = offer.checkPrerequisites(receipt);
        assertFalse(result);
        
        receipt.add(testItems.get("Pizza Margherita"));
        result = offer.checkPrerequisites(receipt);
        assertTrue(result); //Those olives are now free
    }
    
    /**
     * Test of checkPrerequisites method, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesFalseNoFreeItems() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 3, 
            testItems.get("Organic Olives"), 2);

        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertFalse(result);
    }
    
    /**
     * Test of checkPrerequisites method, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test
    public void testCheckPrerequisitesFalseNotEnoughQualifyingItems() throws NotEnoughItemsException {
        System.out.println("checkPrerequisites");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 3, 
            testItems.get("Organic Olives"), 2);

        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Organic Olives"));
        
        boolean result = offer.checkPrerequisites(receipt);
        assertFalse(result);
    }
    
    /**
     * Test of constructor, of class ForMItemsXGetNItemsYFree.
     * 
     * @throws NotEnoughItemsException
     */
    @Test(expected = NotEnoughItemsException.class)
    public void testConstructorThrowsException() throws NotEnoughItemsException {
        System.out.println("constructor throws NotEnoughItemsException");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 0, 
            testItems.get("Organic Olives"), 2);
    }
         
    /**
     * Test of constructor, of class ForMItemsXGetNItemsYFree.
     *
     * @throws NotEnoughItemsException
     */
    @Test(expected = NotEnoughItemsException.class)
    public void testConstructorThrowsExceptionNotEnoughFreeItems() throws NotEnoughItemsException {
        System.out.println("constructor throws NotEnoughItemsException");
        
        ForMItemsXGetNItemsYFree offer = new ForMItemsXGetNItemsYFree(
            testItems.get("Pizza Margherita"), 3, 
            testItems.get("Organic Olives"), 0);
    }
}
