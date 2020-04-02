package com.example.bottomup;

public abstract class ComputerComponent {

    protected abstract double getLOC();

    protected abstract double getCost();

    public ComputerComposite composite() {
        return null;
    }
}
