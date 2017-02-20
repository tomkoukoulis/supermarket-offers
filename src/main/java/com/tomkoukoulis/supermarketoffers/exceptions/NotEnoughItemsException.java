package com.tomkoukoulis.supermarketoffers.exceptions;

/**
 *
 * @author tomkoukoulis
 */
public class NotEnoughItemsException extends Exception {

    /**
     * Constructor
     *
     * @param message A message with details about this exception
     */
    public NotEnoughItemsException(String message) {
        super(message);
    }
}
