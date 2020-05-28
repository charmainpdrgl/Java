package superbowl;

import java.util.*;

/**
 * @author charmainpedrigal
 *<h1>The Working Class</h1>
 *The SuperbowlApp calls the methods to make the program start working.
 */
public class SuperbowlApp {

	/**
	 * This method creates and initializes the arraylist. Then it calls the reader class to load the data
	 * from the CSV file to the arraylist. Then it creates the GUI.
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Superbowl> events = new ArrayList<Superbowl>();
		SuperbowlReader.load(events);
		
		GUI gui = new GUI(events);
		gui.setVisible(true);
	}
}