package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseOptionTest {
    private PurchaseOption purchaseObject;

    @Before
    public void create_new_object(){
        purchaseObject = new PurchaseOption("Purchase", 2);
    }

    @Test
    public void is_feedMoney_input_valid(){
        double input = purchaseObject.getAmountFed(); //arrange + act
        Assert.assertEquals(true, input >=0); //assert
    }

    @Test
    public void is_balance_positive(){
        double input = purchaseObject.getBalance(); //arrange + act
        Assert.assertEquals(true, input >=0); //assert
    }

    @Test
    public void calculate_correct_change(){
        purchaseObject.setCurrentBalance(1.15);
        int[] coins = {4, 1, 1};
        int[] outputCoins = {purchaseObject.calculateChange().getQuarter(), purchaseObject.calculateChange().getNickel(), purchaseObject.calculateChange().getDime() };
        Assert.assertArrayEquals(coins, outputCoins); //assert
    }



}
