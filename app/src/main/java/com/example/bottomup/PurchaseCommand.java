package com.example.bottomup;

/**
 * @author Christian Baker
 */

/**
 * specific command class to be implemented by classes which
 * contain the logic for purchasing a generator object
 */
public abstract class PurchaseCommand implements UndoableCommand {
    /**
     * type and rate variables hold the information that
     * is used when the PurchaseCommand in unexecuted
     */

    public int type = 0;
    public double rate = 0;

}
