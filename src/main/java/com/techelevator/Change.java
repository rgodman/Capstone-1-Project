package com.techelevator;

public class Change {
    private int quarter;
    private int dime;
    private int nickel;

    public Change(int quarter, int dime, int nickel) {
        this.quarter = quarter;
        this.dime = dime;
        this.nickel = nickel;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getDime() {
        return dime;
    }

    public int getNickel() {
        return nickel;
    }
}
