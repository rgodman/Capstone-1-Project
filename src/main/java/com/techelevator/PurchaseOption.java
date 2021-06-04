package com.techelevator;

import java.text.NumberFormat;

public class PurchaseOption extends Option{
    private double currentBalance = 0.00;
    private double amountFed = 0.00;

    public PurchaseOption(String name, int number) {
        super(name, number);
        this.currentBalance = currentBalance;


    }

    public void displayPurchaseMenu(){
        System.out.println("Please select from one of the following options:");
        System.out.println("1: Feed Money");
        System.out.println("2: Select Product");
        System.out.println("3: Finish Transaction");
    }

    public double getBalance(){
        //return currentBalance;
        return currentBalance;
    }

    public void printBalance(){
        NumberFormat dollarAmount = NumberFormat.getCurrencyInstance();
        System.out.println("Current funds provided: " + dollarAmount.format(currentBalance));
    }

    public double updateBalance(){
        //get price of item being purchased
        //subtract that from current balance
        //return current balance
        return currentBalance;
    }

    public double feedMoney(double amountEntered){
        amountFed+=amountEntered;
        currentBalance += amountEntered;
        return currentBalance;
    }

    public VendingMachineItem selectProduct(){
        return null;
    }

    //choice 2, run Select product
    //  getInventory()
//    -->getKeys, return to purchase menu if not found
//    -->if quantity is 0, return SOLD OUT message
//    -->if quantity is available, update inventory
//    -->print name, cost, money
//    -->print message according to product type
//    -->write to text file with item purchased, before balance, update balance


    //choice 3, run finishTransaction()
//    → return any remaining balance. Print out balance returned.
//    → if change is 0.85, divide by 0.25 // need helper method
//    → update balance $0
//     -->display Options()
//     -->write to text file, with change given, before balance, after balance


    //    Exit Option Class
//    stockInventory()
//    exit();


}
