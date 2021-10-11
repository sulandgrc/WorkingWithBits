package divisionalgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionAlgorithmTest {

    @Test
    public void testDecimalToBinary25(){
        // non zero-padded returned string
        final String twentyFive = "11001";

        // zero-padded returned string
        //final String twentyFive = "00000000000000000000000000011001";

        assertEquals(twentyFive,DivisionAlgorithm.decimalToBinary(25));

    }

    @Test
    public void testDecimalToBinary77(){
        // non zero-padded returned string
        final String seventySeven = "1001101";

        // zero-padded returned string
        //final String seventySeven = "00000000000000000000000001001101";

        assertEquals(seventySeven,DivisionAlgorithm.decimalToBinary(77));

    }


}