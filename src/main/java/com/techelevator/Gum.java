package com.techelevator;

public class Gum extends VendingMachineItem {

    private String sound;
    private String key;

    public Gum(String name, double price) {
        super(name, price);
        this.sound = "Chew Chew, Yum!";
        this.key = key;
    }

    public String getSound() {
        return sound;
    }

    public String getKey() {
        return key;
    }
}
