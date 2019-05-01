package L23D1;

import java.util.Comparator;

public class GenericBikeDemo {

	public static void main(String[] args) {
		Bike[] bike = new Bike[5];
		bike[0] = new Bike("P", 250, 80000);
		bike[1] = new Bike("S", 140, 70000);
		bike[2] = new Bike("F", 180, 60000);
		bike[3] = new Bike("B", 260, 30000);
		bike[4] = new Bike("G", 160, 50000);

		// BubbleSort(bike);
		// BubbleSort(bike, new BikePriceComparator());
		// BubbleSort(bike, new BikeSpeedComparator());
		BubbleSort(bike, new BikeNameComparator());
		display(bike);

	}

	public static <T extends Comparable<T>> void BubbleSort(T[] arr) {
		for (int count = 0; count < arr.length - 1; count++) {
			for (int i = 0; i < arr.length - count - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	public static <T> void BubbleSort(T[] arr, Comparator<T> compare) {
		for (int count = 0; count < arr.length - 1; count++) {
			for (int i = 0; i < arr.length - count - 1; i++) {
				if (compare.compare(arr[i], arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	public static <T> void display(T[] bike) {
		for (T val : bike) {
			System.out.println(val + " ");
		}
	}

}
