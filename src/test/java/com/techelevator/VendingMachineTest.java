package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    private VendingMachine menu;


    @Before
    public void create_new_menu (){
        menu = new VendingMachine();
    }

    @Test
    public void test_correct_input_main_menu(){
        menu.setOption(2);
        int output = menu.getOption();
        boolean isMenuOption = output == 1 || output == 2 || output == 3;
        Assert.assertEquals(true, isMenuOption);

    }

    @Test
    public void test_correct_input_purchase_menu(){
        menu.setPurchaseAction(4);
        int output = menu.getOption();
        boolean isMenuOption = output == 1 || output == 2 || output == 3;
        Assert.assertEquals(false, isMenuOption);

    }

    @Test
    public void test_correct_item_selection(){
        menu.setPurchaseAction(4);
        int output = menu.getOption();
        boolean isMenuOption = output == 1 || output == 2 || output == 3;
        Assert.assertEquals(false, isMenuOption);

    }


}
