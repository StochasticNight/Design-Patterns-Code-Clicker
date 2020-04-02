package com.example.bottomup;

/**
 * One of the generators used in the Generator store
 */
public class Business extends Generator {

    /**
     * constructor
     * @param price determines the price of the class
     * @param lps determines the lines per second that
     *            is increased with each purchase
     */
    public Business(int price, double lps)
    {
        this.price = price;
        this.lps = lps;
    }

    /**
     * increases the price of the class after each purchase
     */
    public void incrementPrice(){
        setPrice((int) Math.ceil(12000 * Math.pow(1.15, count)));
    }

    /**
     * decreases the price of the class after each undo purchase action
     */
    public void decrementPrice(){
        setPrice((int) Math.ceil((12000 * Math.pow(1.15, count - 1))));
    }

}
