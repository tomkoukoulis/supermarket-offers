package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.Receipt;
import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.AbstractTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class ReceiptTest extends AbstractTest {
                
    /**
     * Constrictor 
     */
    public ReceiptTest() {
    }

    /**
     * Test of addItem method, of class Receipt.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(testItems.get("Pizza Margherita"));

        assertEquals(expected, receipt.getListOfItems());
    }

    /**
     * Test of getListOfItems method, of class Receipt.
     */
    @Test
    public void testGetListOfItems() {
        System.out.println("getListOfItems");
       
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Key Lime Pies"));
        receipt.add(testItems.get("Free Range Chicken"));
        receipt.add(testItems.get("Organic New Potatoes"));
        
        ArrayList<Item> expResult = new ArrayList<>(testItems.values());
        ArrayList<Item> result = receipt.getListOfItems();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalPrice method, of class Receipt.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Receipt receipt = new Receipt();
        receipt.add(testItems.get("Pizza Margherita"));
        receipt.add(testItems.get("Organic Olives"));
        receipt.add(testItems.get("Key Lime Pies"));
        receipt.add(testItems.get("Free Range Chicken"));
        receipt.add(testItems.get("Organic New Potatoes"));

        float result = receipt.getTotalPrice();        
        float expResult = 17.97F;
        assertEquals(expResult, result, 0.001);
    }
}
