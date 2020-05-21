package superbowl;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SuperbowlReader {
	
	public SuperbowlReader()
	{
		
	}
	
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
		int count = 0;
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

					/*for (String item : fields) {
						count++;
						System.out.println(item);
					}*/

					//Collections.sort(events);
					//Collections.sort(events, new AttendanceCompare());

				} catch (NumberFormatException ne) {
					System.out.println("Not a number " + ne);
				} /*catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("There was a problem");
					e.printStackTrace();
				}*/

			}

			scan.close();
		}

		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
