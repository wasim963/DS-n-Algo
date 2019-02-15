import java.util.ArrayList;

public class ArrayIntersection {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 1, 2, 4, 1 };
		int arr2[] = { 2, 1, 3, 1, 5, 2, 2 };
		System.out.println(intersection(insertionSort(arr1), insertionSort(arr2)));
	}

	private static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
		int i = 0, j = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				ans.add(arr1[i]);
				i++;
				j++;
			}
		}
		return ans;
	}

	private static int[] insertionSort(int[] arr) {
		for (int count = 1; count < arr.length; count++) {
			int min = arr[count];
			int j = count - 1;
			while (j >= 0 && arr[j] > min) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = min;
		}
		return arr;
	}

}
