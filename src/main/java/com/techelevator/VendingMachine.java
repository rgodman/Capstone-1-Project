package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    //user response from the Scanner for Main Menu
    private int option = 0;
    //user response from the Scanner for Purchase Menu
    private int purchaseAction = 0;
    //user response from the Scanner for Item Selection
    private String itemSelection = "";
    //options to be operated on
    private DisplayItemsOption choiceOne = new DisplayItemsOption("Display Items", 1);
    private PurchaseOption choiceTwo = new PurchaseOption("Purchase Item", 2);
    private ExitOption choiceThree = new ExitOption("Exit Machine", 3);

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int displayMainMenu(){
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Display Vending Machine Items");
        System.out.println("2: Purchase");
        System.out.println("3: Exit");
        System.out.println("****************************");
        try {
            Scanner userChoice = new Scanner(System.in);
            option = Integer.parseInt(userChoice.nextLine());
            if (option != 1 && option != 2 && option != 3){
                System.out.println("You did not enter a valid menu option. Please try again.");
                displayMainMenu();
                return option;
            }
            return option;

        } catch (NumberFormatException e){
            System.out.println("You did not enter a number. Please try again.");
            displayMainMenu();
            return option;
        }
    }

    public int displayPurchaseMenu() {
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Feed Money");
        System.out.println("2: Select Product");
        System.out.println("3: Finish Transaction");
        System.out.println("****************************");
        try {
            Scanner purchaseChoice = new Scanner(System.in);
            purchaseAction = Integer.parseInt(purchaseChoice.nextLine());
            if (purchaseAction != 1 && purchaseAction != 2 && purchaseAction != 3) {
                System.out.println("You did not enter a valid purchase option. Please try again.");
                displayPurchaseMenu();
                return purchaseAction;
            }
            return purchaseAction;
        } catch (NumberFormatException e){
            System.out.println("You did not enter a number. Please try again.");
            purchaseAction = 0;
            displayPurchaseMenu();
            return purchaseAction;
        }
    }

    public String askForItemSelection(){
        System.out.println("Please select an item to purchase");
        System.out.println("Use the key provided");
        System.out.println("****************************");
        Scanner userChoice = new Scanner(System.in);
        itemSelection =  userChoice.nextLine();
        return itemSelection;
    }


    public int getPurchaseAction() {
        return purchaseAction;
    }

    public void setPurchaseAction(int purchaseAction) {
        this.purchaseAction = purchaseAction;
    }

    public DisplayItemsOption getChoiceOne() {
        return choiceOne;
    }

    public PurchaseOption getChoiceTwo() {
        return choiceTwo;
    }

    public ExitOption getChoiceThree() {
        return choiceThree;
    }

    public String getItemSelection() {
        return itemSelection;
    }

    public void setItemSelection(String selection) {
        this.itemSelection = selection;
    }
}
