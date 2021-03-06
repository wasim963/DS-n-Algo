public class CoinChange {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 6 };
		System.out.println(coinChangeTD(arr, 0, 10, new int[arr.length][11]));
		System.out.println(coinChangeBU(arr, 10));
	}

	private static int coinChangeTD(int[] arr, int idx, int amount, int[][] strg) {
		if (idx == arr.length || amount < 0)
			return 0;
		if (amount == 0)
			return 1;

		if (strg[idx][amount] != 0) {
			return strg[idx][amount];
		}
		int exc = coinChangeTD(arr, idx + 1, amount, strg);
		int inc = coinChangeTD(arr, idx, amount - arr[idx], strg);
		strg[idx][amount] = inc + exc;
		return inc + exc;
	}

	private static int coinChangeBU(int[] arr, int amount) {
		int[] table = new int[amount + 1];
		table[0] = 1;
		for (int coin : arr) {
			for (int i = coin; i <= amount; i++) {
				table[i] += table[i - coin];
			}
		}
		return table[amount];
	}

}
