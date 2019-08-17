import java.util.Scanner;

public class SelectionSort {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = {50, 40, 30, 20, 10}
		selectionSort(arr);
		display(arr);

	}

	private static void selectionSort(int[] arr) {
		for (int count = 0; count < arr.length - 1; count++) {
			int min = count;
			for (int j = count + 1; j < arr.length - 1; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != count) {
				int temp = arr[min];
				arr[min] = arr[count];
				arr[count] = temp;
			}
		}
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
