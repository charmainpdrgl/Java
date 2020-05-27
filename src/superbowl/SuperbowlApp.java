package superbowl;

import java.util.*;

public class SuperbowlApp {

	public static void main(String[] args) {
		ArrayList<Superbowl> events = new ArrayList<Superbowl>();
		SuperbowlReader.load(events);
		
		GUI gui = new GUI(events);
		gui.setVisible(true);
	}
}