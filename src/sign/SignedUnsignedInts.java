package sign;

/**
 * This class demos how primitive chars are stored as unsigned 16bit integers.
 * The integral types (byte, short, int,long)
 * are stored as signed 8bit, 16bit, 32bit, and 64bit integers
 */
public class SignedUnsignedInts {

    public static void main(String[] args) {
       assignSignedInts();
       // assignUnsignedInts();
    }

    /**
     * The primitive char uses an unsigned 16-bit integer to store the character so the MSB is not
     * reserved for the sign bit
     */
    public static void assignUnsignedInts(){
        char english = 97;
        System.out.println("English Letter: " + english);
        System.out.println(Integer.toBinaryString(english));

        char spanish = 241;
        System.out.println("Spanish Letter: " + spanish);
        System.out.println(Integer.toBinaryString(spanish));

        System.out.println("Character # of bits: " + Character.SIZE);
        System.out.println((int)Character.MIN_VALUE);
        System.out.println((int)Character.MAX_VALUE);
    }

    /**
     * In Java, signed integers are stored as two's complement numbers where
     * the leftmost bit (MSB) is the sign bit. A sign bit with the value of one
     * indicates a negative number and a sign bit with the value of zero indicates a
     * positive number. Since one of the bits in the integral type is reserved for the sign
     * the actual values the integer type can store are reduced.
     */
    public static void assignSignedInts(){
        // positive int
        byte maxByte = 0b0111_1111;
        System.out.println("Decimal Value: " + maxByte);

        // negative int - java automatically assumes the value being assigned is a 32 bit integer
        // For negative numbers that are less than 32 bits, you have to add the cast otherwise java reports
        // a potential loss of information since a 32 bit int would result in a positive value; not a negative value
        /// 0000_0000_
        byte minByte = (byte) 0b1000_0000;
        System.out.println("Decimal Value: " + minByte);
        // note the sign extension if we look at the 32 bit binary string
        System.out.println("Binary Value: " + Integer.toBinaryString(minByte));
        // 0000_0000_
        int int128 = 0b1000_0000;
        System.out.println("Decimal Value: " + int128);
        System.out.println("Binary Value: " + Integer.toBinaryString(int128));

        short minShort = (short) 0b1000_0000_0000_0000;
        System.out.println("Decimal Value: " + minShort);
        System.out.println("Binary Value: " + Integer.toBinaryString(minShort));
    }
}
