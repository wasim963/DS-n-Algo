import java.util.Scanner;

public class BubbleSort {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		bubbleSort(arr);
		display(arr);

	}

	private static void bubbleSort(int[] arr) {
		for (int count = 0; count < arr.length - 1; count++) {
			for (int i = 0; i < arr.length - 1 - count; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}

	private static int[] takeInput() {
		System.out.println("Enter array size : ");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		return arr;
	}

}
