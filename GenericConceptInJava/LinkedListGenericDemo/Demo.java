package L23D2;

public class Demo {
	public static void main(String[] args) throws Exception {
		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();
		Car cars[] = new Car[5];
		cars[0] = new Car("P", 349, 76255);
		cars[1] = new Car("Q", 234, 46253);
		cars[2] = new Car("R", 362, 56250);
		cars[3] = new Car("S", 142, 96200);
		cars[4] = new Car("T", 262, 66250);
		ll.addFirst(cars[0]);
		ll.addFirst(cars[1]);
		ll.addFirst(cars[2]);
		ll.addFirst(cars[3]);
		ll.addFirst(cars[4]);
		ll.removeAt(2);
		ll.display();
		
	}
}
