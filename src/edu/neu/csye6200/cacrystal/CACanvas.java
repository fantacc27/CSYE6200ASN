package edu.neu.csye6200.cacrystal;

import java.util.logging.Logger;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A sample canvas that draws a rainbow of squares
 *
 * @author Xiao Tan
 */
public class CACanvas extends JPanel {

    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(CACanvas.class.getName());
    private int cellSize = 16;
    private Color col = null;
    private long counter = 0L;
    private CAFlakeCell[][] c = new CAFlakeCell[67][67];

    /**
     * CellAutCanvas constructor
     */
    public CACanvas() {
        col = Color.WHITE;
        CARule car = new CARule();
        c = car.getEmptyFlake();

    }

    /**
     * The UI thread calls this method when the screen changes, or in response
     * to a user initiated call to repaint();
     */
    public void paint(Graphics g) {

        drawCellularAutomaton(g); // Our Added-on drawing
    }

    /**
     * Draw the CA graphics panel
     *
     * @param g
     */
    public void drawCellularAutomaton(Graphics g) {
        System.out.println("count: " + counter++);
        log.info("Drawing cell automation " + counter++);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, size.width, size.height);

        g2d.setColor(Color.RED);
        g2d.drawString("Time to play the GAME", 10, 15);
        //CARule car = new CARule();
        //c = car.getInitFlake();
        int maxRows = size.height / cellSize;
        int maxCols = size.width / cellSize;
        for (int j = 0; j < maxRows; j++) {
            for (int i = 0; i < maxCols; i++) {
                if (c[i][j].cellshape == "\u25A0") {
                    int redVal = validColor(i * 5);
                    int greenVal = validColor(255 - j * 5);
                    int blueVal = validColor((j * 5) - (i * 2));
                    col = new Color(redVal, greenVal, blueVal);
                    // Draw box, one pixel less to create a black outline

                    paintRect(g2d, i * cellSize - 10, j * cellSize + 20, cellSize - 1, col);
                } else {
                    paintRect(g2d, i * cellSize - 10, j * cellSize + 20, cellSize - 1, BLACK);
                }
            }
        }
    }

    public void update(CAFlakeCell[][] caf) {

        c = caf;
        //repaint();
    }

    /*
	 * A local routine to ensure that the color value is in the 0 to 255 range;
     */
    private int validColor(int colorVal) {
        if (colorVal > 255) {
            colorVal = 255;
        }
        if (colorVal < 0) {
            colorVal = 0;
        }
        return colorVal;
    }

    /*
	 * A convenience routine to set the color and paint a square
	 * @param g2d the graphics context
	 * @param x horizontal offset in pixels
	 * @param y vertical offset in pixels
	 * @param size the square size in pixels
	 * @param color the color to draw
     */
    private void paintRect(Graphics2D g2d, int x, int y, int size, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, size, size);
    }

}
