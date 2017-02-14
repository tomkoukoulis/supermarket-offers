/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomkoukoulis.supermarketoffers.controller;

import com.tomkoukoulis.supermarketoffers.AbstractTestClass;
import com.tomkoukoulis.supermarketoffers.model.Item;
import java.util.HashSet;
import java.util.Set;
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
public class ThreeForTwoTest extends AbstractTestClass {
    Rule threeForTwo;
            
    public ThreeForTwoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Item OrganicKalamataOlives = listOfItems.get(1);
        threeForTwo = new ThreeForTwo();
        threeForTwo.setItem(OrganicKalamataOlives);
        OrganicKalamataOlives.setRule(threeForTwo); //improve this
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateNewPrice method, of class ThreeForTwo.
     */
    @Test
    public void testCalculateNewPrice() {
        System.out.println("calculateNewPrice");

        float expResult = 1.99F;
        float result = threeForTwo.calculateNewPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getNumberOfItems method, of class ThreeForTwo.
     */
    @Test
    public void testGetNumberOfItems() {
        System.out.println("getNumberOfItems");

        int expResult = 1;
        int result = threeForTwo.getNumberOfItems();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSetOfItems method, of class ThreeForTwo.
     */
    @Test
    public void testGetSetOfItems() {
        System.out.println("getSetOfItems");

        Set<Item> setOfItems = new HashSet<>();
        setOfItems.add(listOfItems.get(1));
        
        Set<Item> expResult = setOfItems;
        Set<Item> result = threeForTwo.getSetOfItems();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSetOfItems method, of class ThreeForTwo.
     */
    @Test
    public void testSetSetOfItems() throws Exception {
        System.out.println("setSetOfItems");
        
        Set<Item> setOfItems = new HashSet<>();
        setOfItems.add(listOfItems.get(0));
        
        ThreeForTwo instance = new ThreeForTwo();
        instance.setSetOfItems(setOfItems);
        
        Set<Item> result = instance.getSetOfItems();
        Set<Item> expResult = setOfItems;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setItem method, of class ThreeForTwo.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
                
        ThreeForTwo instance = new ThreeForTwo();
        instance.setItem(listOfItems.get(0));
        
        Set<Item> result = instance.getSetOfItems();
        Set<Item> setOfItems = new HashSet<>();
        setOfItems.add(listOfItems.get(0));
        Set<Item> expResult = setOfItems;
        
        assertEquals(expResult, result);
    }
}
