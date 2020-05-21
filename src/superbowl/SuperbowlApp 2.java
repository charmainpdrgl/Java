package superbowl;

import java.util.*;

public class SuperbowlApp {

	public static void main(String[] args) {
		ArrayList<Superbowl> events = new ArrayList<Superbowl>();
		//ArrayList<Integer> attendeeList = new ArrayList<Integer>();
		//ArrayList<Integer> pointsList = new ArrayList<Integer>();
		//ArrayList<String> cityList = new ArrayList<String>();
		SuperbowlReader.load(events);
		
		GUI gui = new GUI(events);
		gui.setVisible(true);
	}
}