package com.example.bottomup;

public class CPU extends ComputerComponent {

    private double LOC = 0.25;
    private double cost = 1.5;

    @Override
    public double getLOC() {
        return LOC;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
