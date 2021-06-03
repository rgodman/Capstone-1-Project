package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private static int currentBalance;


    public static void main(String[] args) {
        //creating new inventory
        Inventory vMachine = new Inventory();
        File vendingItems = new File("src/main/java/com/techelevator/view/vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingItems)) {
            while (fileInput.hasNextLine()) {
                String[] items = fileInput.nextLine().split("\\|");
                String itemsArray = Arrays.toString(items);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Scanner userChoice = new Scanner(System.in);

        System.out.println("*******************************");
        System.out.println("Welcome to the Vendo-Matic 800!");
        System.out.println("*******************************");
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Display Vending Machine Items");
        System.out.println("2: Purchase"); //get option object 2
        System.out.println("3: Exit"); //get option object 3

        //if option one, create new display option object
        //call method to print out name and price of each vending machine object



        //if option 2, display secondary purchase menu
        //create new Purchase object.

        //just print out secondary menu for Purchase
        //display current balance
        //if feedmoney is selected, call feedMoney on Purchase object
        //if select product, run selectProduct method
        //then run finish transaction
        //display option objects again

        //if Option 3 Exit is selected,
        //run stockInventory
        System.out.println("Thanks for your business!");
        //System.exit






    }

    public static int getBalance(){
        return currentBalance;
    }

    public static int updateBalance(){
        //get price of item being purchased
        //subtract that from current balance
        //return current balance
    }


}