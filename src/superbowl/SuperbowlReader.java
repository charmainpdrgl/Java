package superbowl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author charmainpedrigal
 *<h1>Reader Class</h1>
 *This class is used for reading the data from a csv file onto the arraylist that
 *was created in the App Class. This class also converts the string data into their
 *own respective data types.
 */
public class SuperbowlReader {
	/**
	 * This is the method where the loading takes place.
	 * Fields are declared to match the data into its respective categories.
	 * The scanner class is used to go through the the csv file. And it's 
	 * surrounded by try and catch so that if an error occurs, it can be caught.
	 * @param events - This parameter is used to loop through.
	 */
	public static void load(ArrayList<Superbowl> events)
	{
		String date;
		String attendance;
		String winner;
		String winningPoints;
		String loser;
		String losingPoints;
		String mvp;
		String stadium;
		String city;
		String state;
		String pointDifference;
		String line;
		// creating the File instance
		File text = new File("SuperBowlData.csv");
		// creating the Scanner instance
		Scanner scan;
		try {
			scan = new Scanner(text);

			while (scan.hasNextLine()) {
				try {
					line = scan.nextLine();
					String[] fields = line.split(",");

					date = fields[0];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					LocalDate date1 = LocalDate.parse(date, formatter);
					//LocalDate date1 = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
					attendance = fields[1];
					int eventAttendance = Integer.parseInt(attendance);
					winner = fields[2];
					winningPoints = fields[3];
					int eventWin = Integer.parseInt(winningPoints);
					loser = fields[4];
					losingPoints = fields[5];
					int eventLose = Integer.parseInt(losingPoints);
					mvp = fields[6];
					stadium = fields[7];
					city = fields[8];
					state = fields[9];
					pointDifference = fields[10];
					int eventPointDif = Integer.parseInt(pointDifference);

					events.add(new Superbowl(date1, eventAttendance, winner, eventWin, loser, eventLose, mvp, stadium,
							city, state, eventPointDif));

				} catch (NumberFormatException ne) {
					System.out.println("Not a number " + ne);
				} 

			}

			scan.close();
		}

		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
