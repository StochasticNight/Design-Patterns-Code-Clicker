package com.example.bottomup;

/**
 *  A command class to be queued after purchase
 */
public class BuyProgrammer extends PurchaseCommand implements UndoableCommand {

    /**
     * calls the purchase function on the Programmer class
     */
    @Override
    public void execute() {
        MainActivity.programmer.purchase();
    }

    /**
     * Performs the sell function on the Programmer class
     * and sets the value to be added back to the LineOfCode Singleton
     */
    @Override
    public void unexecute() {
        MainActivity.programmer.sell();
        type = MainActivity.programmer.getPrice();
        rate = MainActivity.programmer.getLps();
    }

}
