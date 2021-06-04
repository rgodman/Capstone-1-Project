package com.techelevator;

public class Chip extends VendingMachineItem {

    private String sound;
    private String key;

    public Chip(String name, double price) {
        super(name, price);
        this.sound = "Crunch Crunch, Yum!";
        this.key = key;
    }

    public String getSound() {
        return sound;
    }

    public String getKey() {
        return key;
    }
}
