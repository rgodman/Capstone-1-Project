package com.techelevator;

import com.techelevator.Change;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeTest {
    private Change changeObject;

    @Before
    public void create_new_object() {
        changeObject = new Change(2, 1, 1);
    }


    @Test
    public void returning_correct_number_of_quarters() {
        int quarter = changeObject.getQuarter();
        Assert.assertEquals(2, quarter);
    }

    @Test
    public void returning_correct_number_of_dimes() {
        int dime = changeObject.getDime();
        Assert.assertEquals(1, dime);
    }

    @Test
    public void returning_correct_number_of_nickels() {
        int nickel = changeObject.getNickel();
        Assert.assertEquals(1, nickel);
    }

    @Test
    public void return_positive_quarters() {
        int quarter = changeObject.getQuarter();
        boolean isPositive = quarter > 0;
        Assert.assertEquals(true, isPositive);
    }

    @Test
    public void return_positive_dimes() {
        int dime = changeObject.getDime();
        boolean isPositive = dime > 0;
        Assert.assertEquals(true, isPositive);
    }

    @Test
    public void return_positive_nickels() {
        int nickel = changeObject.getNickel();
        boolean isPositive = nickel > 0;
        Assert.assertEquals(true, isPositive);
    }


}
