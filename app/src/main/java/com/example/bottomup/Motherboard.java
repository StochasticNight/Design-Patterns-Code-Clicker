package com.example.bottomup;

public class Motherboard extends ComputerComposite {
    private double LOC = 0.05;
    private double cost = 5.0;

    @Override
    public double getLOC() {
        return LOC;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    protected double getCompositeBaseCost() {
        return cost;
    }

    protected double getCompositeBaseLines() {
        return LOC;
    }
}
