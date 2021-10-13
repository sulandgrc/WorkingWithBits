package goldfish;

/**
 * This class uses static methods to draw a colored bitmap image from an
 * array of bits.  The pic array contains the color information to draw 48
 * squares. Each 2 bit sequence defines the color of the individual square.(48 total)
 * This class uses the DrawingPanel.java class
 * from the Building Java Programs textbook by Reges and  Stuart
 *
 * @author Susan Uland
 *
 *  Try-It #1 - Change the pic array to initialize the short values using Hex (0x)
 *  Try-It #2 - Change the code using bitwise operators so the fish is "swimming" left
 *  rather than "swimming" right
 *
 *
 */

import java.awt.Color;

public class BitMapImage {
    private static DrawingPanel canvas;
    private static final int SIZE = 50;
    private static final int WIN_HEIGHT = 300;
    private static final int WIN_WIDTH = 400;

    // The pic array represents 6 rows of 8 colored squares
    private static short[] pic = {
            (short) 0xAAAA,
            (short) 0b1010010110010110,
            (short) 0b1001110001011010,
            (short) 0b1001000001011010,
            (short) 0b1010010110010110,
            (short) 0b1010101010101010,
    };

    /**
     * Sets up the canvas window for drawing each row in the pic array
     * @param args - not used
     */
    public static void main(String[] args) {
        // create a canvas object to draw on
        canvas = new DrawingPanel(WIN_WIDTH, WIN_HEIGHT);

        // initialize the y coordinate of the upper left hand corner of the square
        int y = 0;
        // for each row of the bitmap image
        for (int i = 0; i < pic.length; i++) {
            // draw the row of colored squares
            drawRow(pic[i], y);
            // update y coordinate so next row is positioned correctly
            y += SIZE;
        }
    }

    /**
     * Draws a complete row of colored squares for the bitmap image
     * @param colors - colors to be used for the 8 drawn squares
     * @param y - the y coordinate of the upper left corner of the drawn square
     */
    public static void drawRow(short colors, int y) {
        final int NUM_SQUARES=8;

        // initialize the x coordinate of the upper left hand corner of the square
        int x = 0;


        for (int i = 1; i <= NUM_SQUARES; i++) {
            // zero out all bits but the rightmost 2 bits which will now indicate
            // an Orange, Blue, Black, or White color
            short col = (short) (colors & 0b0000_0000_0000_0011);

            // draw a filled rectangle with color=col at upper left hand corner (x,y)
            drawSquare(col, x, y);

            // change x to position for next square to draw, (y stays the same)
            x += SIZE;

            // shift all bits right 2 spaces to process next 2 bit color(Orange,Blue,Black,White) to be drawn
            colors = (short) (colors >>> 2);
        }


    }

    /**
     * Draws a colored square for a bitmap image in the canvas
     * @param col - 16 bits represent 8 colored squares
     * @param x - the x coordinate of the upper left corner of the drawn square
     * @param y - the y coordinate of the upper left corner of the drawn square
     */
    public static void drawSquare(short col, int x, int y) {
        final short WHITE = 0b00, ORANGE = 0b01, BLUE = 0b10, BLACK = 0b11;
        switch (col) {
            case WHITE:
                canvas.getGraphics().setColor(Color.WHITE);
                break;
            case ORANGE:
                canvas.getGraphics().setColor(Color.ORANGE);
                break;
            case BLUE:
                canvas.getGraphics().setColor(Color.BLUE);
                break;
            case BLACK:
                canvas.getGraphics().setColor(Color.BLACK);
                break;
        }
        // Draw a filled rectangle with the upper left hand corner at x,y  and width and height set to SIZE
        canvas.getGraphics().fillRect(x, y, SIZE, SIZE);

    }

}
