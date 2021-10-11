package divisionalgo;

public class DivisionAlgorithm {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(25));
    }

    /**
     * Creates a binary string representation for a positive decimal number
     * @param decimal a base 10 positive decimal number
     * @return binary representation of the number as a String
     */
    public static String decimalToBinary(int decimal){
        System.out.println("Binary String " +Integer.toBinaryString(decimal));
        // initialize an empty String to return
        String binary = "";
        // while the decimal is > 0 {
        while(decimal > 0) {
            // use % 2 to get the left most bit value
            int bit = decimal % 2;
            // add this bit value to the front of the String
            binary = bit + binary;
            // make the decimal smaller by dividing by 2
            decimal /= 2;
        } //end while

        // return the binary string zero-padded

        for (int i = Integer.SIZE - binary.length(); i > 0 ; i--) {
            // append a zero to the front of the binary string to return
            binary = "0" + binary;
        }

        return binary;
    }


}
