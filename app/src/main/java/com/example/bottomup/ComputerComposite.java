package com.example.bottomup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ComputerComposite extends ComputerComponent {

    protected List<ComputerComponent> subComponents = new ArrayList<ComputerComponent>();


    public ComputerComposite composite() {
        return this;
    }

    public void add(ComputerComponent component) {
        if (component != null){
            subComponents.add(component);
        }
    }

    public void remove(ComputerComponent component) {
        subComponents.remove(component);
    }

    public Iterator<ComputerComponent> iterator() {
        return subComponents.iterator();
    }

    public Iterator<ComputerComponent> deepLeafIterator() {
        return this.new ComputerCompositeIterator();
    }


    public double getCostTotal() {
        double componentPrice = getCompositeBaseCost();
        Iterator<ComputerComponent> subIter = subComponents.iterator();
        while (subIter.hasNext()) {
            ComputerComponent computerComp = subIter.next();
            componentPrice += computerComp.getCost();
        }
        return componentPrice;
    }

    public double getLinesTotal() {
        double componentLines = getCompositeBaseLines();
        Iterator<ComputerComponent> subIter = subComponents.iterator();
        while (subIter.hasNext()) {
            ComputerComponent computerComp = subIter.next();
            componentLines += computerComp.getLOC();
        }
        return componentLines;
    }



    protected abstract double getCompositeBaseCost();

    protected abstract double getCompositeBaseLines();

    private class ComputerCompositeIterator implements Iterator<ComputerComponent> {

        Iterator<ComputerComponent> subComponentsIter = iterator();  // method on outer class
        Iterator<ComputerComponent> subComponentsCompositeIter = null;

        @Override
        public boolean hasNext() {
            return (subComponentsIter.hasNext() || subComponentsCompositeIter.hasNext());
        }

        @Override
        public ComputerComponent next() {
            // If there aren't components to loop through on a current composite
            // get my next element
            if ((subComponentsCompositeIter == null) || (!subComponentsCompositeIter.hasNext())) {
                ComputerComponent currentComponent = subComponentsIter.next();
                // If not a composite return it, otherwise get its subcomponents
                if (currentComponent.composite() == null) {
                    return currentComponent;
                } else {
                    subComponentsCompositeIter = currentComponent.composite().iterator();
                    // If composite doesn't have any subcomponents treat it as a leaf
                    if (subComponentsCompositeIter.hasNext()) {
                        return subComponentsCompositeIter.next();
                    } else {
                        return currentComponent;
                    }
                }
            } else {
                return subComponentsCompositeIter.next();
            }
        }


    }

}
