package com.example.bottomup;

/**
 *  A command class to be queued after purchase
 */
public class BuyAgileTeam extends PurchaseCommand implements UndoableCommand {

    /**
     * calls the purchase function on the AgileTeam class
     */
    @Override
    public void execute() {
        MainActivity.agileTeam.purchase();
    }

    /**
     * Performs the sell function on the AgileTeam class
     * and sets the value to be added back to the LineOfCode Singleton
     */
    @Override
    public void unexecute() {
        MainActivity.agileTeam.sell();
        type = MainActivity.agileTeam.getPrice();
        rate = MainActivity.agileTeam.getLps();
    }
}
