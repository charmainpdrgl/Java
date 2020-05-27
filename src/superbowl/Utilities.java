package superbowl;

import java.util.ArrayList;

public class Utilities {
	
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
