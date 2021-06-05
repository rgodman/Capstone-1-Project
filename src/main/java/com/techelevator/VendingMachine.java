package com.techelevator;

import java.util.Scanner;

public class VendingMachine {
    private String option = "";
    //user response from the Scanner
    //option object that's being operated on
    private Option optionX;

    public VendingMachine(){
    }

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
        Scanner userChoice = new Scanner(System.in);
        setOption(userChoice.nextLine());
        return option;
    }


}
