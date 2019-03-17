public class SplitArrayIntoEqSum {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };
		splitArray(arr, 0, 0, 0, "", "");
	}

	private static void splitArray(int[] arr, int idx, int sum1, int sum2, String ans1, String ans2) {
		if(idx==arr.length){
			if(sum1==sum2)
				System.out.println(ans1+", "+ans2);
			return;
		}
		
		splitArray(arr, idx+1, sum1+arr[idx], sum2, ans1+" "+arr[idx], ans2);
		splitArray(arr, idx+1, sum1, sum2+arr[idx], ans1, ans2+" "+arr[idx]);
	}

}
