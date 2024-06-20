package JavaLearn.Algorithmen;

import org.junit.jupiter.api.Test;

import JavaLearn.Algorithmen.decimalToBinary;


import static org.junit.jupiter.api.Assertions.assertEquals; 

public class decimalToBinaryTest {

    @Test
    public void testDecimalToBinary() { 

        decimalToBinary decimal = new decimalToBinary(); 

        assertEquals(0, decimal.decimalToBinaryRecursion(0)); 

    } 

}
