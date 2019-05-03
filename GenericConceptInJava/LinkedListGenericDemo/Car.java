package L23D2;

public class Car {

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
		return "Name: " + this.name + " Speed: " + this.speed + " Price: " + this.price;
	}

}
