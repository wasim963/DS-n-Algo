package L23D1;

public class Bike implements Comparable<Bike> {

	String name;
	int speed;
	int price;

	public Bike(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " Speed: " + this.speed + " Price: " + this.price;
	}

	
	// Comparable Class Function, so implemented above
	public int compareTo(Bike other) {
		// return this.speed - other.speed;
		// return this.price - other.price;
		return this.name.compareTo(other.name);
	}

}
