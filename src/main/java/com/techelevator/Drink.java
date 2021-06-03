package com.techelevator;


public class Drink extends VendingMachineItems {
    private String sound;
    private String key;

    public Drink(String name, int price) {
        super(name, price);
            this.sound = "Glug Glug, Yum!";
            this.key = key;
        }

    public String getSound() {
        return sound;
    }

    public String getKey() {
        return key;
    }
}
