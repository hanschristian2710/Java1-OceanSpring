import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A fish in a graphics window
 */

public class Fish {

	// The graphics window the fish belongs to
	private GWindow window;
	
	// The location of the fish
	private int x;
	private int y;
	
	// Scale of the drawing of the fish
	private double scale;
	
	// fish direction
	private int direction;
	
	// fish color
	private Color color;
	
	// parts of the fish
	private Oval body, eyes;
	private Triangle tail;
	private int bodyWidth;
	private int bodyHeight;
	
	// Possible fish direction
	public static final int LEFT_MOVING = -5;
	public static final int RIGHT_MOVING = 16;

	/**
	 * Draws a Fish in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the fish
	 * @param y
	 *            the y coordinate of the location of the fish
	 * @param scale
	 *            the scale of the drawing of the fish
	 * @param direction
	 *            the direction of the fish moving
	 * @param window
	 *            the graphics window the fish belongs to
	 */
	public Fish(int x, int y, double scale, int direction, GWindow window) {
		
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.direction = direction;
		this.window = window;

		// randomly choose the color of the fish
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		color = new Color(red, green, blue);

		// Draw the fish
		this.draw();
	}

	/**
	 * Moves the fish, as if it is swimming
	 */
	public void swim() {
		
		// erasing the fish
		eraseFish();
		
		// locating the fish when moving
		if (direction == RIGHT_MOVING) {
			x += 6;
		} else {
			x -= 6;
		}
		
		// when the fish turn around as it reached the edge of the window
		if (x + bodyWidth / 2 > window.getWindowWidth()) {
			direction = LEFT_MOVING;
		}
		if (x + bodyWidth / 2 < 0) {
			direction = RIGHT_MOVING;
		}

		// redraw the fish
		this.draw();
	}

	/**
	 * erasing the fish from the window
	 */
	public void eraseFish() {
		window.remove(body);
		window.remove(tail);
		window.remove(eyes);
	}

	/**
	 * Draws this fish
	 */
	public void draw() {

		// body of the fish
		bodyHeight = (int) (20 * scale);
		bodyWidth = (int) (58 * scale);
		body = new Oval(x, y, bodyWidth, bodyHeight, color, true);
		window.add(body);

		int x1, x2, x3, y1, y2, y3;
		int eyex, eyey;
		int eyeWidth = (int) (2 * scale);
		int eyeHeight = eyeWidth;

		if (direction == LEFT_MOVING) {
			// facing left
			x1 = x + bodyWidth;
			y1 = y + bodyHeight / 2;
			x2 = x + bodyWidth + bodyHeight;
			y2 = y;
			x3 = x + bodyWidth + bodyHeight;
			y3 = y + bodyHeight;
			eyex = x + bodyWidth / 5;
			eyey = y + (9 * bodyHeight) / 20;

		} else {
			// facing right
			x1 = x;
			y1 = y + bodyHeight / 2;
			x2 = x - bodyHeight;
			y2 = y;
			x3 = x - bodyHeight;
			y3 = y + bodyHeight;
			eyex = x + (4 * bodyWidth) / 5;
			eyey = y + (9 * bodyHeight) / 20;
		}

		tail = new Triangle(x1, y1, x2, y2, x3, y3, color, true);
		window.add(tail);
		eyes = new Oval(eyex, eyey, eyeWidth, eyeHeight);
		window.add(eyes);
	}
}
