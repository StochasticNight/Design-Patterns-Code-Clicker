package com.example.bottomup;

/**
 *  A command class to be queued after purchase
 */
public class BuyBusiness extends PurchaseCommand implements UndoableCommand {

    /**
     * calls the purchase function on the Business class
     */
    @Override
    public void execute() {
        MainActivity.business.purchase();
    }

    /**
     * Performs the sell function on the Business class
     * and sets the value to be added back to the LineOfCode Singleton
     */
    @Override
    public void unexecute() {
        MainActivity.business.sell();
        type = MainActivity.business.getPrice();
        rate = MainActivity.business.getLps();
    }
}
