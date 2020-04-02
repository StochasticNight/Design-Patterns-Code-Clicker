package com.example.bottomup;

public class RAM extends ComputerComponent {

    private double LOC = 0.2;
    private double cost = 5.0;

    @Override
    public double getLOC() {
        return LOC;
    }

    @Override
    public double getCost() {
        return cost;
    }

}