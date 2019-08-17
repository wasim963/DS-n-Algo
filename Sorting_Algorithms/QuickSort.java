<<<<<<< HEAD
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 50, 40, 30, 20, 10, 80, 90, 45 };
		display(arr);
		quickSort(arr, 0, arr.length - 1);
		display(arr);

	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int pivotloc = partition(arr, lo, hi);
		quickSort(arr, lo, pivotloc - 1); // process left sublist
		quickSort(arr, pivotloc + 1, hi); // process right sublist
	}

	private static int partition(int[] arr, int lo, int hi) {
		int i = lo + 1;
		int j = hi;
		int pivot = arr[lo];
		while (i <= j) {
			while (arr[i] < pivot && (i < hi)) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			} else {
				i++;
			}
		}
		arr[lo] = arr[j];
		arr[j] = pivot;
		return j;
	}

	private static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println("\n------------------------");
	}

}
=======
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 50, 40, 30, 20, 10, 80, 90, 45 };
		display(arr);
		quickSort(arr, 0, arr.length - 1);
		display(arr);

	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int pivotloc = partition(arr, lo, hi);
		quickSort(arr, lo, pivotloc - 1); // process left sublist
		quickSort(arr, pivotloc + 1, hi); // process right sublist
	}

	private static int partition(int[] arr, int lo, int hi) {
		int i = lo + 1;
		int j = hi;
		int pivot = arr[lo];
		while (i <= j) {
			while (arr[i] < pivot && (i < hi)) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			} else {
				i++;
			}
		}
		arr[lo] = arr[j];
		arr[j] = pivot;
		return j;
	}

	private static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println("\n------------------------");
	}

}
>>>>>>> 53d747d14c8cc9d572b1738270949a04da2b34e9
