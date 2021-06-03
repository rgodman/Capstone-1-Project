package com.techelevator;

public class GumClass extends VendingMachineItems {

    private String sound;
    private String key;

    public GumClass(String name, int price) {
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
