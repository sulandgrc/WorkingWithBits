package bitwise;

/**
 * This class demos the bitwise and the bit shift operators available for use on the java
 * integer data types (all bit operators work on a 32 bit int by default and you can then
 * cast to a different integral type like byte, short, long)
 */
public class BitwiseOps {

    public static void main(String[] args) {

        bitwiseOR();
       // bitwiseXOR();
        bitwiseAND();
       // bitwiseInvert();
       // shiftLeft();
       // shiftRightSigned();
       // shiftRightUnSigned();

    }

    /**
     * You can use the bitwise AND to tell if numbers are even/odd
     * and also to unset a bit (set a specific bit to zero)
     */
    public static void bitwiseAND(){
        byte odd = 25;  // 0001_1001
                        // 0000_0001

        byte even = 24; // 0001_1000
        byte one = 1;   // 0000_0001

        // is the number even?
        if ((byte)(even & one) == 0) {
            System.out.println("Number is even");
        }

        if ((byte)(odd & one) != 0) {
            System.out.println("Number is odd");
        }

        // make the odd number 25 turn even to 24 by using the bitwise AND
        // 0001_1001  25
        // unset the LSB make it 0   0b binary  0x hex
        byte result = (byte)(odd & 0b1111_1110);
        System.out.println(Integer.toBinaryString(result));
    }

    /**
     * You can use the bitwise OR to set a bit (set a specific bit to one)
     */
    public static void bitwiseOR(){
        byte even = 24; // 0001_1000
        byte one = 1;   // 0000_0001

        // make the even number odd by using the bitwise OR
        byte result = (byte)(even | 0b0000_0001);
        System.out.println(Integer.toBinaryString(result));

    }

    /**
     * The bitwise XOR can tell you which bits are different in two numbers
     */
    public static void bitwiseXOR() {
        byte odd = 25; // 0001_1001
        byte even = 24; // 0001_1000
        byte xor = (byte)(odd ^ even);
        System.out.println(xor);

        // another example
    }

    /**
     * The bitwise invert operation can be helpful to turn a positive/negative binary number
     * into it's opposite by inverting the bits and adding 1
     */
    private static void bitwiseInvert() {
        byte even = 24; // 0001_1000
        byte invert = (byte)(~even);
        invert += 1;
        System.out.println(invert);

        // another example

    }

    /**
     * The shiftLeft << operator can quickly multiply a number by 2
     */
    public static void shiftLeft(){
        byte even = 4; // 0000_0100
        even <<= 1;
        System.out.println(even);

        // another example

    }

    /**
     * The shiftRight >> operator can quickly divide a number by 2 maintaining sign
     */
    private static void shiftRightSigned(){
        byte negEven = -4; // 1111_1100
        negEven = (byte)(negEven >> 1);
        System.out.println(negEven);

        byte posEven = 4; // 0000_0100
        posEven = (byte) (posEven >>1);
        System.out.println(posEven);

        //another example
    }

    /**
     * The shiftRightUnsigned >>> operator only works as expected with the 32 bit integer type
     * Positive numbers will be quickly divided by 2
     * Negative numbers will not be divided by 2 but rather become different positive numbers
     */
    public static void shiftRightUnSigned(){
        int negEven = -4; // 1111_1111_1111_1111_1111_1111_1111_1100
        negEven = negEven >>> 1;
        System.out.println(negEven);

        int posEven = 4; // 0000_0000_0000_0000_0000_0000_0000_0100
        posEven = posEven >>>1;
        System.out.println(posEven);

        //another example
    }


}
