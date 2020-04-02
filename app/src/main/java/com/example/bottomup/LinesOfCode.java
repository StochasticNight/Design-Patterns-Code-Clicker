package com.example.bottomup;

/**
 * Singleton class that holds the lines of code as a static variable
 */
class LinesOfCode {
    private static final LinesOfCode ourInstance = new LinesOfCode();

    private static double lines = 0;

    /**
     * @return instance of the singleton
     */
    static LinesOfCode getInstance() {
        return ourInstance;
    }

    private LinesOfCode() {

    }

    /**
     *
     * @return the current value of the lines of code
     */
    public double getLines(){
        return lines;
    }

    /**
     *
     * @param amount which will be added to the lines of code
     */
    public void addAmount(double amount){
        lines += amount;
    }

    /**
     * @param amount which will be deducted from the lines of code.
     */
    public void deductAmount(double amount){
        lines -= amount;
    }
}
