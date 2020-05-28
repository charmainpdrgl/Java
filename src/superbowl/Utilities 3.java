package superbowl;

import java.util.ArrayList;

public class Utilities {
	
	public static int findMax(int[] numbers)
	{
		int max = numbers[0];
		for(int item: numbers)
		{
			if (item > max)
			{
				max = item;
			}
		}
		return max;
	}
	
	public static int findMin(ArrayList<Integer> score)
	{
		int min = score.get(0);
		for(Integer item: score)
		{
			if (item < min)
			{
				min = item;
			}
		}
		return min;
	}
}
