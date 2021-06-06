package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class InventoryTest {
    private Inventory vMachine;


//    @Before
//    public void create_new_inventory() {
//        vMachine = new Inventory();
//        //VendingMachine menu = new VendingMachine();
//        Map<String, VendingMachineItem> newInventory = vMachine.getInventory();
//        File vendingItems = new File("src/main/java/com/techelevator/view/vendingmachine.csv");
//        try (Scanner fileInput = new Scanner(vendingItems)) {
//            while (fileInput.hasNextLine()) {
//                String[] itemDetails = fileInput.nextLine().split("\\|");
//                if (itemDetails[3].equals("Candy")) {
//                    newInventory.put(itemDetails[0], new Candy(itemDetails[1], Double.parseDouble(itemDetails[2])));
//                }
//                if (itemDetails[3].equals("Chip")) {
//                    newInventory.put(itemDetails[0], new Chip(itemDetails[1], Double.parseDouble(itemDetails[2])));
//                }
//                if (itemDetails[3].equals("Drink")) {
//                    newInventory.put(itemDetails[0], new Drink(itemDetails[1], Double.parseDouble(itemDetails[2])));
//                }
//                if (itemDetails[3].equals("Gum")) {
//                    newInventory.put(itemDetails[0], new Gum(itemDetails[1], Double.parseDouble(itemDetails[2])));
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//       hineItem item = vMachine.getInventory().get(key);
//                if (item.getNumber() == 5){
//                    isFive = true;
//                }
//
//            }
//            @Test
//            public void test_inventory_restock(){
//                vMachine.restockInventory(); //arrange and act
//                boolean isFive = false;
//                for (String key : vMachine.getInventory().keySet()){
//                    VendingMachineItem item = vMachine.getInventory().get(key);
//                    if (item.getNumber() == 5){
//                        isFive = true;
//                    }
//                }
//                Assert.assertEquals(true, true); //assert
//            }
//
//
//            @Test
//            public void test_update_inventory(){
//                boolean isFive = false;
//                vMachine.restockInventory();
//                for (String key : vMachine.getInventory().keySet()){
//                    VendingMac
//        }

}
