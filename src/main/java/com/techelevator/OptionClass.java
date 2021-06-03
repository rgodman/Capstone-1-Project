package com.techelevator;

public class OptionClass {

    private String name;
    private int number;

    public OptionClass(String name, int price) {
        this.name = name;
        this.number = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return number;
    }

    public void setPrice(int price) {
        this.number = price;
    }


}
