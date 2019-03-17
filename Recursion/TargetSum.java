public class TargetSum {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };
		targetSum(arr, 0, 60, "");
	}

	private static void targetSum(int[] arr, int idx, int target, String ans) {
		if (idx == arr.length) {
			if (target == 0)
				System.out.println(ans);
			return;
		}
		
		targetSum(arr, idx + 1, target, ans);
		targetSum(arr, idx + 1, target - arr[idx], ans + " " + arr[idx]);
	}

}
