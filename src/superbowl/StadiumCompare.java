package superbowl;
import java.util.Comparator;
public class StadiumCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		return o1.getStadium().compareTo(o2.getStadium());
	}

}
