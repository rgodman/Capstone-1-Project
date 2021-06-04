package com.techelevator;

public class ExitOption extends Option{


    public ExitOption(String name, Integer number){
        super(name, number);
    }

    public void sayGoodbye(){
        System.out.println("Thanks for your business!");
        System.exit(1);
    }
}
