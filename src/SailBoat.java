import java.awt.Color; // graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * A sail boat in a graphics window
 */

public class SailBoat {

	// The graphics window the boat belongs to
	private GWindow window;

	// The location of the boat
	private int x;
	private int y;

	// location of the rectangle that close part of the
	// boat's hull
	private int x1, y1;

	// counter for the boat, when it should go up and down
	private int up, down;
	// Scale of the drawing of the boat
	private double scale;

	// boat movement
	private int movement;

	// parts of the boat
	private Rectangle r1, r2, r3;
	private Triangle t1, t2, t3, t4;

	// possible boat direction
	public static final int MOVE_UP = -5;
	public static final int MOVE_DOWN = 16;

	/**
	 * Draws a sail boat in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the boat
	 * @param y
	 *            the y coordinate of the location of the boat
	 * @param scale
	 *            the scale of the sailboat displayed
	 * @param movement
	 *            the movement direction of the sailboat
	 * @param window
	 *            the graphics window the boat belongs to
	 */
	public SailBoat(int x, int y, double scale, int movement, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.movement = movement;
		this.window = window;

		// initializing counter to 0
		up = 0;
		down = 0;

		// initializing new points for rectangle that close part, 
		// of the boat when it moves down
		x1 = x;
		y1 = y;

		// Draw the boat
		this.draw();
	}

	/**
	 * the sailboat is moving up and down
	 */
	public void moveUpOrDown() {

		// erasing boat
		eraseBoat();

		// locating the boat when it moves up and down
		if (movement == MOVE_UP) {
			up += 1;
			y -= 2;
		}
		if (movement == MOVE_DOWN) {
			down += 1;
			y += 2;
		}

		// when the boat is moving up, it should go down,
		// when the boat is moving down, it should go up
		if (up == 8) {
			movement = MOVE_DOWN;
			// initialize back the up variable to 0
			up = 0;
		}
		if (down == 8) {
			movement = MOVE_UP;
			// initialize back the down variable to 0
			down = 0;
		}

		// redraw the sailboat
		this.draw();
	}

	/**
	 * erasing the boat in the window
	 */
	public void eraseBoat() {
		window.remove(r1);
		window.remove(r2);
		window.remove(r3);
		window.remove(t1);
		window.remove(t2);
		window.remove(t3);
		window.remove(t4);
	}

	/**
	 * Draws this sail boat
	 */
	public void draw() {

		// boat's base size
		int boatSize = (int) (this.scale * 5);

		// boat's base width and height
		int baseWidth = 20 * boatSize;
		int baseHeight = (baseWidth / 4);

		// boat's pole size
		int poleSize = (int) (this.scale * 1.5);

		// boat's pole width and height
		int poleWidth = 6 * poleSize;
		int poleHeight = baseWidth / 2 + baseHeight;

		// Between the Boat's base and flag gap
		int flagGap = (int) (5 * scale);

		// The distance of the edge of each side of flag from the boat's base
		int flagEdge = (int) (3 * scale);

		// draw boat's base in red
		r1 = new Rectangle(x, y, baseWidth, baseHeight, Color.RED, true);
		window.add(r1);
		t1 = new Triangle(x - baseHeight, y, x, y, x, y + baseHeight,
				Color.RED, true);
		window.add(t1);
		t2 = new Triangle(x + baseWidth + baseHeight, y, x + baseWidth, y, x
				+ baseWidth, y + baseHeight, Color.RED, true);
		window.add(t2);

		// draw boat's pole in black
		r2 = new Rectangle(x + baseWidth / 2 - poleWidth / 2, y - poleHeight,
				poleWidth, poleHeight, Color.BLACK, true);
		window.add(r2);

		// draw boat's flag in red facing left
		t3 = new Triangle(x + baseWidth / 2 - poleWidth / 2, y - poleHeight, x
				+ flagEdge, y - flagGap, x + baseWidth / 2 - poleWidth / 2, y
				- flagGap, Color.RED, true);
		window.add(t3);

		// draw another boat's flag in white facing right
		t4 = new Triangle(x + baseWidth / 2 + poleWidth / 2, y - poleHeight, x
				+ baseWidth - flagEdge, y - flagGap, x + baseWidth / 2
				+ poleWidth / 2, y - flagGap, Color.WHITE, true);
		window.add(t4);

		// rectangle that close part of the boat's hull
		r3 = new Rectangle(x1 - baseHeight, y1 + baseHeight + baseWidth / 20, baseWidth + 2
				* baseHeight, baseHeight, Color.BLUE, true);
		window.add(r3);
	}
}
