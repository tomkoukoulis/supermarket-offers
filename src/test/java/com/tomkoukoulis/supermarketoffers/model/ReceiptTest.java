/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.model;

import com.tomkoukoulis.supermarketoffers.AbstractTestClass;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class ReceiptTest extends AbstractTestClass {
    
    static ArrayList<Item> listOfItems;
            
    public ReceiptTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Receipt.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Receipt receipt = new Receipt();
        receipt.addItem(listOfItems.get(0));

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(listOfItems.get(0));

        assertEquals(expected, receipt.getListOfItems());
    }

    /**
     * Test of getListOfItems method, of class Receipt.
     */
    @Test
    public void testGetListOfItems() {
        System.out.println("getListOfItems");
        Receipt receipt = new Receipt();
        receipt.addItem(listOfItems.get(0));
        receipt.addItem(listOfItems.get(1));
        receipt.addItem(listOfItems.get(2));
        receipt.addItem(listOfItems.get(3));
        receipt.addItem(listOfItems.get(4));

        receipt.getListOfItems();
        
        assertEquals(listOfItems, receipt.getListOfItems());
    }

    /**
     * Test of getTotalPrice method, of class Receipt.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Receipt receipt = new Receipt();
        receipt.addItem(listOfItems.get(0));
        receipt.addItem(listOfItems.get(1));
        receipt.addItem(listOfItems.get(2));
        receipt.addItem(listOfItems.get(3));
        receipt.addItem(listOfItems.get(4));

        float result = receipt.getTotalPrice();        
        float expResult = 17.97F;
        assertEquals(expResult, result, 0.001);
    }
}
