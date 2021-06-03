package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private  Map<String, VendingMachineItem> inventory = new HashMap<>();


    public Inventory() {


        public Map<String, VendingMachineItem> getInventory () {
            //number of each item available in the machine currently.
            return inventory;
        }


        public Map restockInventory () {
            //resets each item in numberOfItem map to 5.
            //this is different than setNumberOfItem because this just updates the numberOfItem
            for (String Item : numberOfItem.keySet()) {
                int number = numberOfItem.get(Item);
                numberOfItem.put(Item, 5);
            }
            return inventory;
        }

        public Map updateInventory () {
            //subtracts from the item every time a purchase is made
            //if item is one, update amount to SOLD OUT
            return inventory;
        }

        public File recordPurchase () {
            //writes todays date, current time, key and value for keysOfItem and
            //menu.getBalance.
            return null;
        }

    }

    }








