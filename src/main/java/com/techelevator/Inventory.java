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

    //try createInventory here

        public Map restockInventory () {
            //resets each item in numberOfItem map to 5.
            this.getInventory();
            for (String key: inventory.keySet()){
                VendingMachineItem item = inventory.get(key);
                item.setNumber(5);
            }
            return inventory;
        }

        public Map updateInventory (VendingMachineItem itemToPurchase) {
            this.getInventory();
            //for the item to purchase, need to find the key being used
            for (String key : inventory.keySet()){
              VendingMachineItem item = inventory.get(key);
              if (itemToPurchase.getName().equals(item.getName())){
                  item.setNumber(item.getNumber()-1);
              }
            }
            return inventory;
        }



    }










