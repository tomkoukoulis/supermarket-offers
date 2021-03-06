package com.tomkoukoulis.supermarketoffers;

import com.tomkoukoulis.supermarketoffers.exceptions.NotEnoughItemsException;

/**
 *
 * @author tomkoukoulis
 */
public class CheckOut {

    /**
     * The cart to be checked out
     */
    protected Cart cart;

    /**
     * The receipt to be produced
     */
    protected Receipt receipt;

    /**
     * Constructor
     * 
     * @param cart
     * @throws com.tomkoukoulis.supermarketoffers.exceptions.NotEnoughItemsException if the cart is empty
     */
    public CheckOut(Cart cart) throws NotEnoughItemsException {
        if (cart.getItems().size() <= 0) {
            throw new NotEnoughItemsException("Attempting to check out an empty cart is absurd.");
        }
        this.cart = cart;
        this.receipt = new Receipt();
    }

    /**
     * The method to check out the cart contents applying any offers
     *
     * @return the receipt
     */
    public Receipt checkOut() {
        for (Item item : cart.getItems()) {
            receipt.add(item);
            if (item.isOnOffer() && item.getRule().checkPrerequisites(receipt)) {
                receipt.add(item.getRule().addOffer());
            }
        }

        return receipt;
    }
}
