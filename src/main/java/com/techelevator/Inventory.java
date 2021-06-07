package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private  Map<String, VendingMachineItem> inventory = new HashMap<>();
    public Map<String, VendingMachineItem> getInventory() {
        return this.inventory;
    }

    //populates inventory with file data
    public Map createInventory(String filepath) {
        File vendingItems = new File(filepath);
        try (Scanner fileInput = new Scanner(vendingItems)) {
            while (fileInput.hasNextLine()) {
                String[] itemDetails = fileInput.nextLine().split("\\|");
                if (itemDetails[3].equals("Candy")) {
                    inventory.put(itemDetails[0], new Candy(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Chip")) {
                    inventory.put(itemDetails[0], new Chip(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Drink")) {
                    inventory.put(itemDetails[0], new Drink(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Gum")) {
                    inventory.put(itemDetails[0], new Gum(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
            }
        } catch (IOException e) {
        System.out.println(e.getMessage());
        }
        return inventory;
    }

        public Map restockInventory () {
            //resets each item in numberOfItem map to 5.
            this.getInventory();
            for (String key : inventory.keySet()) {
                VendingMachineItem item = inventory.get(key);
                item.setNumber(5);
            }
            return inventory;
        }

        public Map updateInventory (VendingMachineItem itemToPurchase){
            this.getInventory();
            //for the item to purchase, need to find the key being used
            for (String key : inventory.keySet()) {
                VendingMachineItem item = inventory.get(key);
                if (itemToPurchase.getName().equals(item.getName())) {
                    item.setNumber(item.getNumber() - 1);
                }
            }
            return inventory;
        }
    }












