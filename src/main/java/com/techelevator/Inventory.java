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

        public Map restockInventory () {
            //resets each item in numberOfItem map to 5.
            this.getInventory();
            for (String key: inventory.keySet()){
                VendingMachineItem item = inventory.get(key);
                item.setNumber(5);
            }
            return inventory;
        }

        public Map updateInventory () {
            this.getInventory();
            //get the item being purchase from the purchase object
            //subtract number of that by 1
            return inventory;
        }



    }










