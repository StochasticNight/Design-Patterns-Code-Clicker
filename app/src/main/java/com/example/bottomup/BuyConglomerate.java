package com.example.bottomup;

/**
 *  A command class to be queued after purchase
 */
public class BuyConglomerate extends PurchaseCommand implements UndoableCommand {

    /**
     * calls the purchase function on the Conglomerate class
     */
    @Override
    public void execute() {
        MainActivity.conglomerate.purchase();
    }

    /**
     * Performs the sell function on the Conglomerate class
     * and sets the value to be added back to the LineOfCode Singleton
     */
    @Override
    public void unexecute() {
        MainActivity.conglomerate.sell();
        type = MainActivity.conglomerate.getPrice();
        rate = MainActivity.conglomerate.getLps();
    }
}
