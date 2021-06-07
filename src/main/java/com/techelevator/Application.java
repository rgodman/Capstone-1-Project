package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        //create new inventory. call method to restock inventory so there are 5 of each.
        Inventory itemsForSale = new Inventory();
        VendingMachine menu = new VendingMachine();
        Map<String, VendingMachineItem> newInventory = itemsForSale.getInventory();
        itemsForSale.createInventory("src/main/java/com/techelevator/view/vendingmachine.csv");
        itemsForSale.restockInventory();

        System.out.println("*******************************");
        System.out.println("Welcome to the Vendo-Matic 800!");
        System.out.println("*******************************");

        menu.displayMainMenu();


        while (true) {

            while (menu.getOption() == 1 && menu.getPurchaseAction() == 0) {
                menu.getChoiceOne().displayNumberOfItems(newInventory);
                menu.displayMainMenu();
            }

            while (menu.getOption() == 2 && menu.getPurchaseAction() == 0) {
                menu.displayPurchaseMenu();
                menu.getChoiceTwo().printBalance();
            }


            while (menu.getOption() == 2 && menu.getPurchaseAction() == 1) {
                menu.getChoiceTwo().askForMoney();
                menu.getChoiceTwo().feedMoney();
                menu.getChoiceTwo().printBalance();
                menu.setPurchaseAction(0);
                menu.displayPurchaseMenu();
            }

            while (menu.getOption() == 2 && menu.getPurchaseAction() == 2) {
                menu.getChoiceOne().displayNumberOfItems(newInventory);
                menu.askForItemSelection();
                //if the code does not exist, return to purchase menu.
                if (!newInventory.containsKey(menu.getItemSelection())) {
                    System.out.println("****************************");
                    System.out.println("Your selection does not exist.");
                    System.out.println("Returning to purchase menu.");
                    System.out.println("****************************");
                    menu.setPurchaseAction(0);
                    menu.displayPurchaseMenu();
                    break;
                }
                //if product is sold out, return to purchase menu.
                if (newInventory.get(menu.getItemSelection()).getNumber() == 0) {
                    System.out.println("****************************");
                    System.out.println("Your selection is sold out.");
                    System.out.println("Returning to purchase menu.");
                    System.out.println("****************************");
                    menu.setPurchaseAction(0);
                    menu.displayPurchaseMenu();
                    break;
                }
                //else proceed with the purchase.
                else {
                    VendingMachineItem itemToPurchase = newInventory.get(menu.getItemSelection());
                    if (itemToPurchase.getPrice() > menu.getChoiceTwo().getBalance()) {
                        //not enough funds to complete purchase. return to purchase menu.
                        System.out.println("****************************");
                        System.out.println("Not enough funds to complete purchase.");
                        System.out.println("Returning to purchase menu.");
                        System.out.println("****************************");
                        menu.setPurchaseAction(0);
                        menu.displayPurchaseMenu();
                        break;
                    }
                    menu.getChoiceTwo().selectProduct(itemToPurchase);
                    itemsForSale.updateInventory(itemToPurchase);
                    menu.getChoiceTwo().printBalance();
                    menu.setPurchaseAction(0);
                    menu.displayPurchaseMenu();
                }
            }

            while (menu.getOption() == 2 && menu.getPurchaseAction() == 3) {
                menu.getChoiceTwo().completeTransaction();
                menu.getChoiceTwo().calculateChange();
                menu.getChoiceTwo().printBalance();
                menu.displayMainMenu();
                menu.setPurchaseAction(0);

            }

            while (menu.getOption() == 3) {
                menu.getChoiceThree().sayGoodbye();
            }


        }
    }
}



