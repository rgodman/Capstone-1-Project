package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class InventoryTest {
    private Inventory itemsForSale = new Inventory();
    private Map<String, VendingMachineItem> newInventory = itemsForSale.getInventory();


    @Test
    public void test_map_not_empty(){
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        String output = newInventory.get("A1").getName(); //arrange, act
        Assert.assertEquals("Potato Crisps", output);//assert
    }


    @Test
    public void test_inventory_restocked(){
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        itemsForSale.restockInventory();
        int output = newInventory.get("A1").getNumber(); //arrange, act
        Assert.assertEquals(5, output);//assert
    }

    @Test
    public void test_inventory_updated(){
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        itemsForSale.restockInventory();
        VendingMachineItem itemToPurchase = newInventory.get("A1");//arrange
        itemsForSale.updateInventory(itemToPurchase); //act
        int output = newInventory.get("A1").getNumber();
        Assert.assertEquals(4, output);


    }

    @Test
    public void test_invalid_item_selection_letter(){
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        itemsForSale.restockInventory();
        VendingMachineItem itemToPurchase = newInventory.get("ZZ");//arrange, act
        Assert.assertEquals(null, null);//assert

    }

    @Test
    public void test_invalid_item_selection_number(){
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        itemsForSale.restockInventory();
        VendingMachineItem itemToPurchase = newInventory.get("12");//arrange, act
        Assert.assertEquals(null, null);//assert

    }




}
