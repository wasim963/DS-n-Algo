package L23D1;

import java.util.Comparator;

public class BikePriceComparator implements Comparator<Bike> {
	public int compare(Bike tb, Bike ob) {
		return tb.price - ob.price;
	}
}
