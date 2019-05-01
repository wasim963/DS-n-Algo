package L23D1;

import java.util.Comparator;

public class BikeSpeedComparator implements Comparator<Bike> {
	public int compare(Bike tb, Bike ob) {
		return tb.speed - ob.speed;
	}
}
