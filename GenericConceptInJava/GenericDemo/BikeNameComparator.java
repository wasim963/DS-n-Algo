package L23D1;

import java.util.Comparator;

public class BikeNameComparator implements Comparator<Bike> {
	public int compare(Bike tb, Bike ob) {
		return tb.name.compareTo(ob.name);
	}
}
