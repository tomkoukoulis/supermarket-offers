package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.CheckOut;
import com.tomkoukoulis.supermarketoffers.rules.Rule;
import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.rules.BuyThreeCheapestIsFree;
import com.tomkoukoulis.supermarketoffers.rules.ForMItemsXGetNItemsYFree;
import com.tomkoukoulis.supermarketoffers.rules.ThreeForTwo;
import com.tomkoukoulis.supermarketoffers.rules.TwoForASpecialPrice;
import com.tomkoukoulis.supermarketoffers.Cart;
import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class CheckOutTestFunctional extends AbstractTest {
    
    public CheckOutTestFunctional() {
    }

    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithNoOffers() throws NotEnoughItemsException {
        System.out.println("run with no offers");
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Key Lime Pies"));
        cart.add(testItems.get("Key Lime Pies"));
        cart.add(testItems.get("Key Lime Pies"));
        cart.add(testItems.get("Free Range Chicken"));
        cart.add(testItems.get("Free Range Chicken"));
        cart.add(testItems.get("Free Range Chicken"));
        cart.add(testItems.get("Organic New Potatoes"));
        cart.add(testItems.get("Organic New Potatoes"));
        cart.add(testItems.get("Organic New Potatoes"));

        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        float result = receipt.getTotalPrice();
        
        float expResult = 53.90f; //1p out - fix this maybe multiply by 100
       
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithThreeForTwoRule() throws InstantiationException, IllegalAccessException, NotEnoughItemsException {
        System.out.println("run with 'Three For Two' offer");
        Rule threeForTwo = new ThreeForTwo(testItems.get("Pizza Margherita"));
        testItems.get("Pizza Margherita").setRule(threeForTwo);
        
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));


        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        float result = receipt.getTotalPrice();
        
        float expResult = 20.99f;
       //check receipt has offer items
        assertEquals(expResult, result, 0.01);
    }
      
    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithTwoForASpecialPrice() throws InstantiationException, IllegalAccessException, NotEnoughItemsException {
        System.out.println("run with 'Two For a Special Price offer");
        TwoForASpecialPrice rule = new TwoForASpecialPrice(testItems.get("Pizza Margherita"), 800);
        
        testItems.get("Pizza Margherita").setRule(rule);
        
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));


        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        
        float result = receipt.getTotalPrice();
        
        float expResult = 20.99f; //1p out - fix this maybe multiply by 100
       
        assertEquals(expResult, result, 0.01);
    }       
    
    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithBuyThreeCheapestIsFree() throws InstantiationException, IllegalAccessException, NotEnoughItemsException {
        System.out.println("run with 'Buy Three Cheapest Is Free' offer");
        HashSet<Item> items = new HashSet();
        items.add(testItems.get("Pizza Margherita"));
        items.add(testItems.get("Organic Olives"));
        items.add(testItems.get("Key Lime Pies"));
        
        Rule rule = new BuyThreeCheapestIsFree(items);
        
        //testItems.get("Pizza Margherita").setRuleC(TwoForASpecialPrice.class);
        testItems.get("Pizza Margherita").setRule(rule);
        testItems.get("Organic Olives").setRule(rule);
        testItems.get("Key Lime Pies").setRule(rule);
        
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Key Lime Pies"));

        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        
        float result = receipt.getTotalPrice();
        
        float expResult = 20.99f; //1p out - fix this maybe multiply by 100
       
        assertEquals(expResult, result, 0.01);
    }
          
    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithForMItemsXGetNItemsFree() throws InstantiationException, IllegalAccessException, NotEnoughItemsException {
        System.out.println("run with 'Buy M ItemsX Get N ItemsY For Free' offer");
        Rule rule = new ForMItemsXGetNItemsYFree(testItems.get("Pizza Margherita"), 3, testItems.get("Organic Olives"), 2);
        
        testItems.get("Pizza Margherita").setRule(rule);
        testItems.get("Organic Olives").setRule(rule);
        
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Key Lime Pies"));


        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        
        float result = receipt.getTotalPrice();
        
        float expResult = 20.99f; //1p out - fix this maybe multiply by 100
       
        assertEquals(expResult, result, 0.01);
    } 
          
    /**
     * Test of checkOut method, of class CheckOut.
     */
    @Test
    public void testRunWithForMItemsXGetNItemsFreeOdd() throws InstantiationException, IllegalAccessException, NotEnoughItemsException {
        System.out.println("run with 'Buy M ItemsX Get N ItemsY For Free' offer with less than N ItemsY");
        Rule rule = new ForMItemsXGetNItemsYFree(testItems.get("Pizza Margherita"), 3, testItems.get("Organic Olives"), 2);
        
        testItems.get("Pizza Margherita").setRule(rule);
        testItems.get("Organic Olives").setRule(rule);
        
        Cart cart = new Cart();
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Pizza Margherita"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Organic Olives"));
        cart.add(testItems.get("Key Lime Pies"));

        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t%s\n", item.getDescription(), item.getPrice());
        }
        
        float result = receipt.getTotalPrice();
        
        float expResult = 20.99f; //1p out - fix this maybe multiply by 100
       
        assertEquals(expResult, result, 0.01);
    } 
}
