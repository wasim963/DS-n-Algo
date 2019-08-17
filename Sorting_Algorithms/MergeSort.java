public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 5,80, 70, 50, 40, 30, 20,-1, 10 };
		display(arr);
		int[] merge = mergeSort(arr, 0, arr.length - 1);
		display(merge);

	}

	private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int rv[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				rv[k] = arr1[i];
				i++;
				k++;
			} else if (arr2[j] < arr1[i]) {
				rv[k] = arr2[j];
				j++;
				k++;
			} else {
				rv[k] = arr1[i];
				i++;
				j++;
				k++;
			}
		}
		if (i < arr1.length) {
			while (i < arr1.length) {
				rv[k] = arr1[i];
				k++;
				i++;
			}
		}

		if (j < arr2.length) {
			while (j < arr2.length) {
				rv[k] = arr2[j];
				k++;
				j++;
			}
		}

		return rv;
	}

	private static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int br[] = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		int[] arr1 = mergeSort(arr, lo, mid);
		int arr2[] = mergeSort(arr, mid + 1, hi);

		int[] merge = mergeSortedArrays(arr1, arr2);
		return merge;
	}

	private static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println("\n------------------------");
	}

}
