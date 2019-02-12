public class BubbleSortRecursive {

	public static void main(String[] args) {
		int[] arr = { 60, 50, 40, 30, 20, 10 };
		bubbleSort(arr, 0, arr.length - 1);
		for (int val : arr)
			System.out.print(val + " ");

	}

	private static void bubbleSort(int[] arr, int si, int ei) {
		if (ei == 0)
			return;

		if (si == arr.length-1) {
			bubbleSort(arr, 0, ei - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si+1];
			arr[si+1] = temp;
		}

		bubbleSort(arr, si + 1, ei);
	}

}
