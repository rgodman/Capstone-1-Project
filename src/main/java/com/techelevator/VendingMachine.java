package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    //user response from the Scanner for Main Menu
    private String option = "";
    //user response from the Scanner for Purchase Menu
    private String purchaseAction = "";
    //user response from the Scanner for Item Selection
    private String itemSelection = "";
    //options to be operated on
    private DisplayItemsOption choiceOne = new DisplayItemsOption("Display Items", 1);
    private PurchaseOption choiceTwo = new PurchaseOption("Purchase Item", 2);
    private ExitOption choiceThree = new ExitOption("Exit Machine", 3);

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String displayMainMenu(){
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Display Vending Machine Items");
        System.out.println("2: Purchase");
        System.out.println("3: Exit");
        System.out.println("****************************");
        Scanner userChoice = new Scanner(System.in);
        option = userChoice.nextLine();
        return option;
    }

    public String displayPurchaseMenu() {
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Feed Money");
        System.out.println("2: Select Product");
        System.out.println("3: Finish Transaction");
        System.out.println("****************************");
        Scanner purchaseChoice = new Scanner(System.in);
        purchaseAction = purchaseChoice.nextLine();
        return purchaseAction;
    }

    public String askForItemSelection(){
        System.out.println("Please select an item to purchase");
        System.out.println("Use the key provided");
        System.out.println("****************************");
        Scanner userChoice = new Scanner(System.in);
        itemSelection =  userChoice.nextLine();
        return itemSelection;
    }

    public String getPurchaseAction() {
        return purchaseAction;
    }

    public void setPurchaseAction(String purchaseAction) {
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
