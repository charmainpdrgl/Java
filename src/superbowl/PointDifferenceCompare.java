package superbowl;
import java.util.Comparator;

/**
 * @author charmainpedrigal
 * <h1>Sets Point Difference Sort Order</h1>
 *The compare method compares two arguments to sort out its order.
 *It can either return a negative integer, zero or a positive integer.
 */
public class PointDifferenceCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getPointDifference(), o2.getPointDifference());
	}

}
