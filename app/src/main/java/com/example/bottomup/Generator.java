package com.example.bottomup;

/**
 * @author Christian Baker
 */

import java.io.Serializable;

/**
 * generator class to be extended by the objects
 * in the generator store
 */
public abstract class Generator implements Serializable {
    int price = 0;
    double lps;
    int count = 0;

    /**
     * this is a template method, incrementPrice() is
     * the abstract class/hook being called and implemented
     * by the children classes
     */
    public void purchase(){
        incrementCount();
        incrementPrice();
    }

    /**
     * this is a template method, decrementPrice() is
     * the abstract class/hook being called and implemented
     * by the children classes
     */
    public void sell(){
        decrementPrice();
        decrementCount();
    }

    /**
     *
     * @return the price of the generator
     */
    public int getPrice(){
        return price;
    }

    /**
     *
     * @return the lines per second prduced by the generator
     */
    public double getLps(){
        return lps;
    }

    /**
     *
     * @return the number of those generators
     */
    public int getCount(){
        return count;
    }

    /**
     *
     * @param num set the price of the generator
     */
    public void setPrice(int num){
        price = num;
    }

    /**
     * the hook method for the template
     * purchase() method
     */
    public abstract void incrementPrice();

    /**
     * the hook method for the template
     * sell() method
     */
    public abstract void decrementPrice();

    /**
     * reduce the count of the generator by 1
     */
    public void incrementCount(){count += 1;}

    /**
     * increase the count of the generator by 1
     */
    public void decrementCount(){count -= 1;}
}
