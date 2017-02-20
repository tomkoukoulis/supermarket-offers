package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.CheckOut;
import com.tomkoukoulis.supermarketoffers.AbstractTest;
import com.tomkoukoulis.supermarketoffers.exceptions.NotEnoughItemsException;
import com.tomkoukoulis.supermarketoffers.Cart;
import com.tomkoukoulis.supermarketoffers.Item;
import com.tomkoukoulis.supermarketoffers.Receipt;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomkoukoulis
 */
public class CheckOutTest extends AbstractTest {
    
    /**
     * Constructor
     */
    public CheckOutTest() {
    }

    /**
     * Test of checkOut method, of class CheckOut.
     * @throws com.tomkoukoulis.supermarketoffers.exceptions.NotEnoughItemsException
     */
    @Test
    public void testCheckOut() throws NotEnoughItemsException {
        System.out.println("checkOut");
        
        ArrayList<Item> items = new ArrayList<>(testItems.values());
        Cart cart = new Cart(items);

        CheckOut checkout = new CheckOut(cart);
        Receipt receipt = checkout.checkOut();
        
        printReceipt(receipt);
        
        float result = receipt.getTotalPrice();
        float expResult = 17.97f;
       
        assertEquals(expResult, result, 0.01);
    }

    private void printReceipt(Receipt receipt) {
        for (Item item: receipt.getListOfItems()) {
            System.out.printf("%s\t£%s\n", item.getDescription(), String.format("%.2f", (float) item.getPrice()/100));
        }
        System.out.println("----------------------");
        System.out.printf("Total: £%s\n", String.format("%.2f", receipt.getTotalPrice()));
    }
}
