package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        //create new inventory. call method to restock inventory so there are 5 of each.

        Inventory vMachine = new Inventory();
        Map<String, VendingMachineItem> newInventory = vMachine.getInventory();
        File vendingItems = new File("src/main/java/com/techelevator/view/vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingItems)) {
            while (fileInput.hasNextLine()) {
                String[] itemDetails = fileInput.nextLine().split("\\|");
                if (itemDetails[3].equals("Candy")) {
                    newInventory.put(itemDetails[0], new Candy(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Chip")) {
                    newInventory.put(itemDetails[0], new Chip(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Drink")) {
                    newInventory.put(itemDetails[0], new Drink(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
                if (itemDetails[3].equals("Gum")) {
                    newInventory.put(itemDetails[0], new Gum(itemDetails[1], Double.parseDouble(itemDetails[2])));
                }
            }
            vMachine.restockInventory();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Scanner userChoice = new Scanner(System.in);

        System.out.println("*******************************");
        System.out.println("Welcome to the Vendo-Matic 800!");
        System.out.println("*******************************");
        displayMainMenu();

        //if option one, create new display option object
        //call method to print out name and price of each vending machine object
        String option = userChoice.nextLine();

        DisplayItemsOption choiceOne = new DisplayItemsOption("Display Items", 1);
        PurchaseOption choiceTwo = new PurchaseOption("Purchase Item", 2);
        if (option != null) {
            if (option.equals("1")) {
                choiceOne.displayNumberOfItems(newInventory);
                //display main menu options again
                displayMainMenu();
                option = userChoice.nextLine();
            }

            //if option 2, display secondary purchase menu
            //create new Purchase object.
            if (option.equals("2")) {
                choiceTwo.displayPurchaseMenu();
                choiceTwo.printBalance();
                String purchaseAction = userChoice.nextLine();
                if (purchaseAction != null) {
                    if (purchaseAction.equals("1")) {
                        //need to check if this is a number and not just ONE or TWO
                        System.out.println("Please enter your money, in whole dollars.");
                        Double dollarsEntered = Double.parseDouble(userChoice.nextLine());
                        choiceTwo.feedMoney(dollarsEntered);
                        choiceTwo.printBalance();
                        choiceOne.displayNumberOfItems(newInventory);
                        displayMainMenu();
                        option = userChoice.nextLine();
                    }
                    if (purchaseAction.equals("2")) {
                        System.out.println("Please select an item to purchase");
                        System.out.println("Use the key provided");
                        String response = userChoice.nextLine();
                        //if the code does not exist, return to purchase menu.
                        if (!newInventory.containsKey(response)) {
                            System.out.println("Your selection does not exist.");
                            System.out.println("Returning to purchase menu");
                            choiceTwo.displayPurchaseMenu();
                            purchaseAction = userChoice.nextLine();
                        }
                        //if product is sold out, return to purchase menu
                        if (newInventory.get(response).getNumber() == 0) {
                            System.out.println("Your selection is sold out.");
                            System.out.println("Returning to purchase menu");
                            choiceTwo.displayPurchaseMenu();
                            purchaseAction = userChoice.nextLine();
                        }
                        VendingMachineItem itemToPurchase = newInventory.get(response);
                        choiceTwo.selectProduct(itemToPurchase);
                        vMachine.updateInventory(itemToPurchase);
                        choiceTwo.printBalance();
                        choiceTwo.displayPurchaseMenu();
                        purchaseAction = userChoice.nextLine();

                    }
                    if (purchaseAction.equals("3")){

                    }
                }
            }
        }

    }





        //if feedmoney is selected, call feedMoney on Purchase object
        //if select product, run selectProduct method
        //then run finish transaction
        //display option objects again

        //if Option 3 Exit is selected,
        //run stockInventory
        //System.out.println("Thanks for your business!");
        //System.exit








    public static void displayMainMenu(){
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Display Vending Machine Items");
        System.out.println("2: Purchase");
        System.out.println("3: Exit");
    }
}


