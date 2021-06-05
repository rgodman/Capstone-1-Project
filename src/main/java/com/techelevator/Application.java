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


        while (menu.getOption() != null) {
            while (menu.getOption().equals("1")) {
                menu.getChoiceOne().displayNumberOfItems(newInventory);
                menu.displayMainMenu();
            }

            while(menu.getOption().equals("2") && menu.getPurchaseAction().equals("")){
                menu.displayPurchaseMenu();
                System.out.println("First purchase menu printed");
                menu.getChoiceTwo().printBalance();
            }


            while (menu.getOption().equals("2") && menu.getPurchaseAction().equals("1")) {
            //need to check if this is a number and not just ONE or TWO
                menu.getChoiceTwo().askForMoney();
                menu.getChoiceTwo().feedMoney();
                menu.getChoiceTwo().printBalance();
                menu.setPurchaseAction("");
                menu.displayPurchaseMenu();
            }

            while (menu.getOption().equals("2") && menu.getPurchaseAction().equals("2")) {
                menu.getChoiceOne().displayNumberOfItems(newInventory);
                menu.askForItemSelection();
                //if the code does not exist, return to purchase menu.
                if (!newInventory.containsKey(menu.getItemSelection())) {
                    System.out.println("****************************");
                    System.out.println("Your selection does not exist.");
                    System.out.println("Returning to purchase menu.");
                    System.out.println("****************************");
                    menu.setPurchaseAction("");
                    menu.displayPurchaseMenu();
                    break;
                }
                //if product is sold out, return to purchase menu.
                if (newInventory.get(menu.getItemSelection()).getNumber() == 0) {
                    System.out.println("****************************");
                    System.out.println("Your selection is sold out.");
                    System.out.println("Returning to purchase menu.");
                    System.out.println("****************************");
                    menu.setPurchaseAction("");
                    menu.displayPurchaseMenu();
                    break;
                }
                //else the item does exist in inventory.
                else {
                    VendingMachineItem itemToPurchase = newInventory.get(menu.getItemSelection());
                    if (itemToPurchase.getPrice() > menu.getChoiceTwo().getBalance()){
                        //not enough funds to complete purchase. return to purchase menu.
                        System.out.println("****************************");
                        System.out.println("Not enough funds to complete purchase.");
                        System.out.println("Returning to purchase menu.");
                        System.out.println("****************************");
                        menu.setPurchaseAction("");
                        menu.displayPurchaseMenu();
                        break;
                    }
                    menu.getChoiceTwo().selectProduct(itemToPurchase);
                    vMachine.updateInventory(itemToPurchase);
                    menu.getChoiceTwo().printBalance();
                    menu.setPurchaseAction("");
                    menu.displayPurchaseMenu();
                    break;
                }
            }

            while (menu.getOption().equals("2") && menu.getPurchaseAction().equals("3")){
                menu.getChoiceTwo().completeTransaction();
                menu.getChoiceTwo().calculateChange();
                menu.getChoiceTwo().printBalance();
                menu.setPurchaseAction("");
                menu.displayMainMenu();
                System.out.println(menu.getOption());
                System.out.println(menu.getPurchaseAction());
            }

            while (menu.getOption().equals("3")){
                menu.getChoiceThree().sayGoodbye();
            }

        }
    }
}


