package com.techelevator;

public class Candy extends VendingMachineItem {
    private String sound = "Munch Munch, Yum!";
    private String key;


    public Candy(String name, double price) {
        super(name, price);
        this.sound = sound;
        this.key = key;

    }

    public String getSound() {
        return sound;
    }

    public String getKey() {
        return key;
    }


    }

