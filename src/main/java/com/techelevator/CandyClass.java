package com.techelevator;

public class CandyClass extends VendingMachineItems{
    private String sound;
    private String key;

    public CandyClass(String name, int price) {
        super(name, price);
        this.sound = "Munch Munch, Yum!";
        this.key = key;
    }

    public String getSound() {
        return sound;
    }

    public String getKey() {
        return key;
    }
}
