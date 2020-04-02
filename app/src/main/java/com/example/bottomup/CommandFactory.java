package com.example.bottomup;

/**
 * @author Christian Baker
 */

/**
 * Factory pattern class responsible for creating the
 * specific purchase commands for the command pattern
 */
public class CommandFactory implements AbstractUndoableCommandFactory {

    /**
     *
     * @param type which will determine the type of the PurchaseCommand being made
     * @return PurchaseCommand based on the type given
     */
    @Override
    public PurchaseCommand makeUndoableCommand(char type) {

        PurchaseCommand returnCommand;

        if (type == 'p')
            returnCommand = new BuyProgrammer();
        else if (type == 'a')
            returnCommand = new BuyAgileTeam();
        else if (type == 'd')
            returnCommand = new BuyDepartment();
        else if (type == 'b')
            returnCommand = new BuyBusiness();
        else
            returnCommand = new BuyConglomerate();

        return returnCommand;
    }
}
