package com.techelevator;

import java.text.NumberFormat;
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
        NumberFormat dollarAmount = NumberFormat.getCurrencyInstance();
        for (String key: inventory.keySet()){
            int number = inventory.get(key).getNumber();
            String name = inventory.get(key).getName();
            Double price = inventory.get(key).getPrice();
            if (number == 0){
                System.out.println(key + ": " + name + "  SOLD OUT");
            }
            else{
                System.out.println(key+ ": " + name + " "  + dollarAmount.format(price) + ", " + number);
            }
        }

    }

}
