package com.example.bottomup;

/**
 *  A command class to be queued after purchase
 */
public class BuyDepartment extends PurchaseCommand implements UndoableCommand {

    /**
     * calls the purchase function on the Department class
     */
    @Override
    public void execute() {
        MainActivity.department.purchase();
    }

    /**
     * Performs the sell function on the Department class
     * and sets the value to be added back to the LineOfCode Singleton
     */
    @Override
    public void unexecute() {
        MainActivity.department.sell();
        type = MainActivity.department.getPrice();
        rate = MainActivity.department.getLps();
    }
}
