package com.example.bottomup;

public class GPU extends ComputerComposite {
    private double LOC = 0.05;
    private double cost = 2.0;

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public double getLOC() {
        return LOC;
    }

    @Override
    protected double getCompositeBaseCost() {
        return cost;
    }

    protected double getCompositeBaseLines() {
        return LOC;
    }
}
