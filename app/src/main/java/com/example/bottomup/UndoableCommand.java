package com.example.bottomup;

/**
 * @author Christian Baker
 */

/**
 * UndoableCommand interface to be implemented by
 * commands that are able to be undone
 */
public interface UndoableCommand extends Command {
    /**
     * unexecute function to be defined by the commands
     * implementing UndoableCommand, the logic should be opposite
     * to the execute() function
     */
    void unexecute();
}
