import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A Bubble in the graphics window
 */

public class Bubble {

	// The graphics window the bubble belong to
	private GWindow window;

	// The location of the bubble
	private int x;
	private int y;

	// scale of the bubble
	private double scale;

	// Parts of the bubble
	private Oval outerBubble, insideBubble;
	private int firstWidth;
	private int firstHeight;

	// bubble moving
	private int moving;

	// possible bubble direction
	public static final int MOVE_LEFT_UP = -5;
	public static final int MOVE_LEFT_DOWN = 5;
	public static final int MOVE_RIGHT_UP = -16;
	public static final int MOVE_RIGHT_DOWN = 16;

	/**
	 * Draws bubbles in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the bubble
	 * @param y
	 *            the y coordinate of the center of the bubble
	 * @param scale
	 *            the scale of the drawing of the bubble
	 * @param moving
	 *            the moving direction of the bubble
	 * @param window
	 *            the graphics window the bubble belongs to
	 */
	public Bubble(int x, int y, double scale, int moving, GWindow window) {
		
		// initialize the instance field
		this.window = window;
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.moving = moving;

		// initialize width and height of the outer bubble,
		// so that it can be use in this class
		firstWidth = (int) (13 * scale);
		firstHeight = (int) (15 * scale);

		// draw the bubble
		this.draw();
	}

	/**
	 * Bubble will move
	 */
	public void doAction() {
		
		// erasing the bubble
		eraseBubble();

		// Locating the bubble when it is moving
		if (moving == MOVE_LEFT_UP) {
			x -= 1;
			y -= 1;
		} else if (moving == MOVE_RIGHT_UP) {
			x += 1;
			y -= 1;
		} else if (moving == MOVE_RIGHT_DOWN) {
			x += 1;
			y += 1;
		} else {
			x -= 1;
			y += 1;
		}

		// when the bubble reach the edge or above the blue ocean
		if (y <= window.getWindowHeight() / 4) {
			moving = MOVE_RIGHT_DOWN;
		}
		if (x + firstWidth >= window.getWindowWidth()) {
			moving = MOVE_LEFT_DOWN;
		}
		if (y + firstHeight >= window.getWindowHeight()) {
			moving = MOVE_LEFT_UP;
		}
		if (x <= 0) {
			moving = MOVE_RIGHT_UP;
		}
		
		// redraw the bubble
		this.draw();
	}

	public void eraseBubble() {
		window.remove(outerBubble);
		window.remove(insideBubble);
	}

	/**
	 * Draw the bubble
	 */
	public void draw() {
		
		// Bubble color
		Color bubbleColor = Color.WHITE;

		// draw the bubble
		// outer side bubble
		outerBubble = new Oval(x, y, firstWidth, firstHeight, bubbleColor,
				false);
		window.add(outerBubble);

		// inside bubble width and height
		int secondWidth = (int) (3.25 * scale);
		int secondHeight = (int) (4 * scale);

		insideBubble = new Oval(x + (2 * firstWidth) / 3, y + firstHeight / 4,
				secondWidth, secondHeight, bubbleColor, false);
		window.add(insideBubble);
	}

}
