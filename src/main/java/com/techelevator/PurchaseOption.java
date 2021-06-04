package com.techelevator;

import java.text.NumberFormat;

public class PurchaseOption extends Option {
    private double currentBalance = 0.00;
    private double amountFed = 0.00;

    public PurchaseOption(String name, int number) {
        super(name, number);
        this.currentBalance = currentBalance;


    }

    public void displayPurchaseMenu() {
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Feed Money");
        System.out.println("2: Select Product");
        System.out.println("3: Finish Transaction");

    }

    public double getBalance() {
        //return currentBalance;
        return currentBalance;
    }

    public void printBalance() {
        NumberFormat dollarAmount = NumberFormat.getCurrencyInstance();
        System.out.println("Current funds provided: " + dollarAmount.format(currentBalance));
    }


    public double feedMoney(double amountEntered) {
        //write to text file with amount fed
        amountFed += amountEntered;
        currentBalance += amountEntered;
        return currentBalance;
    }

    public double selectProduct(VendingMachineItem itemToPurchase) {
        if (itemToPurchase.getPrice() > currentBalance) {
            System.out.println("You do not have enough funds available for this purchase.");
            System.out.println("Enter more funds to proceed.");
            return currentBalance;
            //need to display purchase menu after this.
            //
        }
        //write to text file with item purchased
        System.out.println(itemToPurchase.getSound());
        System.out.println("Item purchased: " + itemToPurchase.getName());
        NumberFormat dollarAmount = NumberFormat.getCurrencyInstance();
        System.out.println("Purchase price: " + dollarAmount.format(itemToPurchase.getPrice()));
        currentBalance -= itemToPurchase.getPrice();
        return currentBalance;
    }

    //choice 3, run finishTransaction()
//    → return any remaining balance. Print out balance returned.
//    → if change is 0.85, divide by 0.25 // need helper method
//    → update balance $0
//     -->display Options()
//     -->write to text file, with change given, before balance, after balance

    public double completeTransaction(){
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        quarters = (int) Math.floor(currentBalance / 0.25);
        currentBalance -= quarters * 0.25;
    }

    //    Exit Option Class
//    stockInventory()
//    exit();


}
