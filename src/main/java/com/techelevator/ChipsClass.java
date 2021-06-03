package com.techelevator;

public class ChipsClass extends VendingMachineItems{

    private String sound;
    private String key;

    public ChipsClass(String name, int price) {
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
