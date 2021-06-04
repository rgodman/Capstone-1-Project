package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class DisplayItemsOption extends Option{
    private String name = "Display Options";
    private int number = 1;

    public DisplayItemsOption(String item, int number){
        super(item, number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void displayNumberOfItems(Map<String, VendingMachineItem> inventory){

        for (String key: inventory.keySet()){
            int number = inventory.get(key).getNumber();
            if (number == 0){
                System.out.println(key + ": SOLD OUT");
            }
            else{
                System.out.println(key+ ": " + number);
            }
        }

    }

}
