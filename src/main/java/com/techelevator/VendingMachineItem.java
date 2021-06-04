package com.techelevator;

public class VendingMachineItem {

    private String name;
    private double price;
    private int number;



    public VendingMachineItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.number = number;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
