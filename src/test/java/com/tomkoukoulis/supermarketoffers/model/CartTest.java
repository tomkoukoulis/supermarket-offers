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
public class CartTest extends AbstractTestClass {
    
    public CartTest() {
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
     * Test of add method, of class Cart.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Item item = items.get(0);
        Cart cart = new Cart();
        
        boolean expResult = true;
        boolean result = cart.add(item);
        assertEquals(expResult, result);

        ArrayList<Item> expItems = cart.getItems();
        assertTrue(expItems.size() == 1);
        assertEquals(expItems.get(0), item);
    }

    /**
     * Test of addItems method, of class Cart.
     */
    @Test
    public void testAddItems() {
        System.out.println("addItems");

        Cart cart = new Cart();
        cart.addItems(items);

        ArrayList<Item> expItems = cart.getItems();
        assertEquals(expItems, items);
    }
}
