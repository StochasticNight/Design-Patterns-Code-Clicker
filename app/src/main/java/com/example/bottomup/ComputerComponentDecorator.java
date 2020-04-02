package com.example.bottomup;

public class ComputerComponentDecorator extends ComputerComponent {

    protected final ComputerComponent decoratedComponent;

    public ComputerComponentDecorator(ComputerComponent decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    @Override
    public double getLOC() {
        return decoratedComponent.getLOC();
    }

    @Override
    public double getCost() {
        return decoratedComponent.getCost();
    }
}
