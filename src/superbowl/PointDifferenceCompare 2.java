package superbowl;
import java.util.Comparator;
public class PointDifferenceCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getPointDifference(), o2.getPointDifference());
	}

}
