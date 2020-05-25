package superbowl;
import java.util.Comparator;
public class CityCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		return o1.getCity().compareTo(o2.getCity());
	}

}
