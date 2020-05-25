package superbowl;
import java.util.Comparator;
public class LosingPointsCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getLosingPoints(), o2.getLosingPoints());
	}

}
