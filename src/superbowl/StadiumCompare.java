package superbowl;
import java.util.Comparator;

/**
 * @author charmainpedrigal
 * <h1>Sets Stadium Sort Order</h1>
 *The compare method compares two arguments to sort out its order.
 *It can either return a negative integer, zero or a positive integer.
 */
public class StadiumCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		return o1.getStadium().compareTo(o2.getStadium());
	}

}
