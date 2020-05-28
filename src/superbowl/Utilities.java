package superbowl;

import java.util.ArrayList;

/**
 * @author charmainpedrigal
 *<h1>Mathematical Methods</h1>
 *The Utilities program finds the minimums, maximums and averages of certain Superbowl data.
 *These would return integers which then can be accessed in other classes.
 */
public class Utilities {
	
	/**
	 * This method is used to find the minimum amount of people who attended the Superbowl since the first event.
	 * @param events - This is the parameter used to loop through the arraylist. Each attendance is checked against each other
	 * to determine which is the minimum.
	 * @return - This return the integer that contains the minimum number of attendance.
	 */
	public static int findMinimumAttendance(ArrayList<Superbowl> events)
	{
		int min = events.get(0).getAttendance();
		for(Superbowl item: events)
		{
			if (item.getAttendance() < min)
			{
				min = item.getAttendance();
			}
		}
		return min;
	}
	
	/**
	 * This method is used to find the maximum amount of people who attended the Superbowl since the first event.
	 * @param events - This is the parameter used to loop through the arraylist. Each attendance is checked against each other
	 * to determine which is the maximum.
	 * @return - This return the integer that contains the maximum number of attendance.
	 */
	public static int findMaximumAttendance(ArrayList<Superbowl> events)
	{
		int max = events.get(0).getAttendance();
		for(Superbowl item: events)
		{
			if (item.getAttendance() > max)
			{
				max = item.getAttendance();
			}
		}
		return max;
	}
	
	/**
	 * This method is the same as finding the maximum attendance except this is for finding the highest score across all the events.
	 * @param events - This is the parameter used to loop through the arraylist. Each score is checked against each other
	 * to determine which is the maximum.
	 * @return - This return the integer that contains the maximum number of score.
	 */
	public static int findHighestScore(ArrayList<Superbowl> events)
	{
		int max = events.get(0).getWinningPoints();
		for(Superbowl item: events)
		{
			if (item.getWinningPoints() > max)
			{
				max = item.getWinningPoints();
			}
		}
		return max;
	}
	
	/**
	 * This method is the same as finding the minimum attendance except this is for finding the lowest score across all the events.
	 * @param events - This is the parameter used to loop through the arraylist. Each score is checked against each other
	 * to determine which is the minimum.
	 * @return - This return the integer that contains the minimum number of score.
	 */
	public static int findLowestScore(ArrayList<Superbowl> events)
	{
		int min = events.get(0).getLosingPoints();
		for(Superbowl item: events)
		{
			if (item.getLosingPoints() < min)
			{
				min = item.getLosingPoints();
			}
		}
		return min;
	}
	
	/**
	 * This method is used to fin the average point difference of all the games.
	 * @param events - This is the parameter used to loop through the arraylist. Each point difference of an event is added
	 * to the point difference of the next event until 2018. This is then divided by the number of events from the very first
	 * Superbowl event until 2018 to find out the average point difference.
	 * @return - This return the integer that contains the average point difference.
	 */
	public static int findAveragePointDif(ArrayList<Superbowl> events)
	{
		int total = 0;
		int average = 0;
		for(int i = 0; i < events.size();i++)
		{
			total += events.get(i).getPointDifference();
			average = total / events.size();
		}
		return average;
	}
}
