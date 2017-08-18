package com.aplana.study;

import junit.framework.Assert;
import org.junit.Test;

public class SimpleArithmeticTest {

    @Test
    public void testCalc(){
        SimpleArithmetic arithmetic = new SimpleArithmetic();
        Assert.assertEquals(6, arithmetic.calc("5+8-7"));
    }
}
