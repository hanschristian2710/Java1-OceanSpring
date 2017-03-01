import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A star in a graphics window
 */

public class Star {

	// The graphics window the star belongs to
	private GWindow window;
	
	// The location of the center of the star
	private int x;
	private int y;
	
	// Scale of the drawing of the star
	private double scale;
	
	// Color of the star
	private Color color;

	/**
	 * Draws a star in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the star
	 * @param y
	 *            the y coordinate of the center of the star
	 * @param scale
	 *            the scale of the drawing of the star
	 * @param window
	 *            the graphics window the star belongs to
	 */
	public Star(int x, int y, double scale, GWindow window) {
		
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.window = window;
		this.scale = scale;
		
		// Draw the star
		this.draw();
	}

	/**
	 * Changes randomly the color of the star
	 */

	public void twinkle() {
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		color = new Color(red, green, blue);
		
		// redraw the star according to the random color assigned
		this.draw();

	}

	/**
	 * Draws this star (complete this method to make a better star)
	 */
	public void draw() {

		// Size of the star
		int starSize = (int) (scale * 10);
		
		// Draw the lines making up the star
		Line line1 = new Line(x, y - starSize / 2, x, y + starSize / 2, color);
		Line line2 = new Line(x - starSize / 2, y, x + starSize / 2, y, color);
		Line line3 = new Line(x - starSize / 4, y - starSize / 4, x + starSize
				/ 4, y + starSize / 4, color);
		Line line4 = new Line(x - starSize / 4, y + starSize / 4, x + starSize
				/ 4, y - starSize / 4, color);
		window.add(line1);
		window.add(line2);
		window.add(line3);
		window.add(line4);
	}
}