package com.example.bottomup;

/**
 * @author Christian Baker
 */

/**
 * Interface for the Factory class to implement
 */
public interface AbstractUndoableCommandFactory {

    /**
     *
     * @param type which will determine the type of the PurchaseCommand being made
     * @return PurchaseCommand based on the type given
     */
    public PurchaseCommand makeUndoableCommand(char type);
}
