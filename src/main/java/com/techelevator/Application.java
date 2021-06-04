package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        //create new inventory. call method to restock inventory so there are 5 of each.

        Inventory vMachine = new Inventory();
        VendingMachine menu = new VendingMachine();
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



        System.out.println("*******************************");
        System.out.println("Welcome to the Vendo-Matic 800!");
        System.out.println("*******************************");
        menu.displayMainMenu();


        DisplayItemsOption choiceOne = new DisplayItemsOption("Display Items", 1);
        PurchaseOption choiceTwo = new PurchaseOption("Purchase Item", 2);
        ExitOption choiceThree = new ExitOption("Exit Machine", 3);
        if (menu.getOption() != null) {
            if (menu.getOption().equals("1")) {
                choiceOne.displayNumberOfItems(newInventory);
                //display main menu options again
                menu.displayMainMenu();
            }
            //if option 2, display secondary purchase menu
            if (menu.getOption().equals("2")) {
                choiceTwo.displayPurchaseMenu();
                choiceTwo.printBalance();
                if (choiceTwo.getPurchaseAction() != null) {
                    if (choiceTwo.getPurchaseAction().equals("1")) {
                        //need to check if this is a number and not just ONE or TWO
                        choiceTwo.askForMoney();
                        choiceTwo.feedMoney();
                        choiceTwo.printBalance();
                        choiceOne.displayNumberOfItems(newInventory);
                        menu.displayMainMenu();
                        menu.getOption();
                    }
                    if (choiceTwo.getPurchaseAction().equals("2")) {
                        System.out.println("Please select an item to purchase");
                        System.out.println("Use the key provided");
                        Scanner userChoice = new Scanner(System.in);
                        String response = userChoice.nextLine();
                        //if the code does not exist, return to purchase menu.
                        if (!newInventory.containsKey(response)) {
                            System.out.println("Your selection does not exist.");
                            System.out.println("Returning to purchase menu");
                            choiceTwo.displayPurchaseMenu();

                        }
                        //if product is sold out, return to purchase menu
                        if (newInventory.get(response).getNumber() == 0) {
                            System.out.println("Your selection is sold out.");
                            System.out.println("Returning to purchase menu");
                            choiceTwo.displayPurchaseMenu();

                        }
                        VendingMachineItem itemToPurchase = newInventory.get(response);
                        choiceTwo.selectProduct(itemToPurchase);
                        vMachine.updateInventory(itemToPurchase);
                        choiceTwo.printBalance();
                        choiceTwo.displayPurchaseMenu();


                    }
                    if (choiceTwo.getPurchaseAction().equals("3")){
                        choiceTwo.completeTransaction();
                        choiceTwo.printBalance();
                        menu.displayMainMenu();
                        menu.getOption();
                    }
                }
            }
            if (menu.getOption().equals("3")){
                choiceThree.sayGoodbye();
            }

        }

    }



}


