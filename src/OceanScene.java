import uwcse.graphics.*; // access the graphics utilities in the uw library

import java.awt.Color; // access the Color class        

/**
 * An OceanScene displays fish, sail boats, stars, and a fourth element of your
 * choice in a graphics window.
 * 
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * @author Hans Christian
 */

public class OceanScene extends GWindowEventAdapter {

	/** The graphics window that displays the picture */
	private GWindow window;

	/** The elements in the picture */
	// 2 sailboats that sail back and forth
	private SailBoat sailboat1, sailboat2, sailboat3;

	// 9 stars that twinkle
	private Star star1, star2, star3, star4, star5, star6, star7, star8, star9,
			star10, star11, star12;

	// 6 fish that swim back and forth
	private Fish fish1, fish2, fish3, fish4, fish5, fish6;

	// Add here the declaration of an instance field of the type
	// that you created in hw1
	// YOU MUST NAME THIS VARIABLE: myElement.
	// Thus your statement should be (replacing
	// classname with the name of your class)
	// private classname myElement; (e.g. private Moon myElement if your fourth
	// element is a Moon).
	private Bubble myElement1, myElement2, myElement3, myElement4, myElement5,
			myElement6, myElement7, myElement8, myElement9, myElement10;

	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Create a picture
	 */
	public OceanScene() {
		// The graphics window
		this.window = new GWindow("Mountain scene");
		this.window.setExitOnClose();

		// The ocean and the sky
		Rectangle ocean = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight(), Color.blue, true);
		window.add(ocean);

		// the sky covers the upper quarter of the window
		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight() / 4, Color.black, true);
		window.add(sky);

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	// To do the animation
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();

		// star element
		this.star1.twinkle();
		this.star2.twinkle();
		this.star3.twinkle();
		this.star4.twinkle();
		this.star5.twinkle();
		this.star6.twinkle();
		this.star7.twinkle();
		this.star8.twinkle();
		this.star9.twinkle();
		this.star10.twinkle();
		this.star11.twinkle();
		this.star12.twinkle();
		// sailboat element
		this.sailboat1.moveUpOrDown();
		this.sailboat2.moveUpOrDown();
		this.sailboat3.moveUpOrDown();
		// fish element
		this.fish1.swim();
		this.fish2.swim();
		this.fish3.swim();
		this.fish4.swim();
		this.fish5.swim();
		this.fish6.swim();
		// bubble element
		this.myElement1.doAction();
		this.myElement2.doAction();
		this.myElement3.doAction();
		this.myElement4.doAction();
		this.myElement5.doAction();
		this.myElement6.doAction();
		this.myElement7.doAction();
		this.myElement8.doAction();
		this.myElement9.doAction();
		this.myElement10.doAction();

		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 800)
			this.window.stopTimerEvents();
	}

	/**
	 * Instantiate in this method the elements of the scene. This is the only
	 * method that you need to modify in this class
	 */
	private void addGraphicsElements() {
		// You can change the coordinates and scales that appear
		// in the constructors (but don't change the names of the variables)
		// star element
		this.star1 = new Star(50, 20, 0.9, this.window);
		this.star2 = new Star(100, 30, 0.9, this.window);
		this.star3 = new Star(150, 10, 0.8, this.window);
		this.star4 = new Star(10, 40, 0.8, this.window);
		this.star5 = new Star(200, 50, 0.8, this.window);
		this.star6 = new Star(300, 40, 1.5, this.window);
		this.star7 = new Star(400, 30, 1.2, this.window);
		this.star8 = new Star(350, 20, 1.2, this.window);
		this.star9 = new Star(250, 50, 1.3, this.window);
		this.star10 = new Star(180, 30, 1.3, this.window);
		this.star11 = new Star(450, 60, 1.3, this.window);
		this.star12 = new Star(460, 25, 0.9, this.window);
		// fish element
		this.fish1 = new Fish(50, 185, 0.8, Fish.LEFT_MOVING, this.window);
		this.fish2 = new Fish(200, 370, 0.8, Fish.RIGHT_MOVING, this.window);
		this.fish3 = new Fish(300, 340, 0.6, Fish.LEFT_MOVING, this.window);
		this.fish4 = new Fish(100, 156, 0.6, Fish.RIGHT_MOVING, this.window);
		this.fish5 = new Fish(200, 169, 0.5, Fish.LEFT_MOVING, this.window);
		this.fish6 = new Fish(350, 355, 0.5, Fish.RIGHT_MOVING, this.window);
		// sailboat element
		this.sailboat1 = new SailBoat(75, 110, 0.8, SailBoat.MOVE_DOWN,
				this.window);
		this.sailboat2 = new SailBoat(105, 295, 1.3, SailBoat.MOVE_DOWN,
				this.window);
		this.sailboat3 = new SailBoat(330, 120, 1, SailBoat.MOVE_DOWN,
				this.window);

		// bubble element
		this.myElement1 = new Bubble(30, 120, 1.2, Bubble.MOVE_LEFT_UP,
				this.window);
		this.myElement2 = new Bubble(45, 375, 1.2, Bubble.MOVE_RIGHT_DOWN,
				this.window);
		this.myElement3 = new Bubble(180, 165, 1.0, Bubble.MOVE_RIGHT_UP,
				this.window);
		this.myElement4 = new Bubble(350, 250, 1.0, Bubble.MOVE_LEFT_DOWN,
				this.window);
		this.myElement5 = new Bubble(460, 180, 0.9, Bubble.MOVE_RIGHT_UP,
				this.window);
		this.myElement6 = new Bubble(470, 380, 0.9, Bubble.MOVE_LEFT_UP,
				this.window);
		this.myElement7 = new Bubble(70, 220, 0.8, Bubble.MOVE_LEFT_DOWN,
				this.window);
		this.myElement8 = new Bubble(370, 380, 0.8, Bubble.MOVE_RIGHT_DOWN,
				this.window);
		this.myElement9 = new Bubble(450, 230, 0.9, Bubble.MOVE_RIGHT_UP,
				this.window);
		this.myElement10 = new Bubble(400, 180, 0.9, Bubble.MOVE_RIGHT_DOWN,
				this.window);
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new OceanScene();
	}
}