/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.model;

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
public class ReceiptTest {
    
    static ArrayList<Item> listOfItems;
            
    public ReceiptTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        listOfItems = new ArrayList<>();
        listOfItems.add(new Item("Pizza Express Margherita 245g", 4.50f));
        listOfItems.add(new Item("Real Olive Co Organic Kalamata 210g", 2.99f));
        listOfItems.add(new Item("GU KEY LIME PIES 2x85g", 3.00f));
        listOfItems.add(new Item("Free Range Chicken Drumsticks 412g", 5.79f));
        listOfItems.add(new Item("Organic New Potatoes 500g", 1.69f));
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
    public void testGetListOfItem() {
        System.out.println("getListOfItem");
        Receipt receipt = new Receipt();
        receipt.addItem(listOfItems.get(0));
        receipt.addItem(listOfItems.get(1));
        receipt.addItem(listOfItems.get(2));
        receipt.addItem(listOfItems.get(3));
        receipt.addItem(listOfItems.get(4));

        receipt.getListOfItems();
        
        assertEquals(listOfItems, receipt.getListOfItems());
    }
    
}
