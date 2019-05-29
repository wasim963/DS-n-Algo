public class Car implements Comparable<Car> {

	String name;
	int speed;
	int price;

	public Car(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Name:" + this.name + "  Speed:" + this.speed + "  Price:" + this.price;
	}

	@Override
	public int compareTo(Car other) {

		return this.speed - other.speed;
		// return other.price-this.price;
		// return this.name.compareTo(other.name);
	}

}
