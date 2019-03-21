import L10.DynamicStack2;

public class StockSpan {

	public static void main(String[] args) throws Exception {
		int[] price = { 6, 3, 10, 8, 7, 12, 5, 4, 11, 9 };
		int[] ans = stockspan1(price);
		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	private static int[] stockspan1(int[] price) {
		int[] span = new int[price.length];
		span[0] = 1;
		for (int i = 1; i < price.length; i++) {
			if (price[i] < price[i - 1]) {
				while (i < price.length && price[i] < price[i - 1]) {
					span[i] = 1;
					i++;
				}
			}
			if (i < price.length && price[i] > price[i - 1]) {
				int max = 1;
				for (int j = i - 1; j >= 0 && price[i] > price[j]; j--) {
					max++;
				}
				span[i] = max;
			}
		}
		return span;
	}

	private static int[] stockspan2(int[] price) throws Exception {
		int span[] = new int[price.length];
		span[0] = 1;
		DynamicStack2 ds = new DynamicStack2();
		ds.push(0);
		for (int i = 1; i < price.length; i++) {
			while (!ds.isEmpty() && price[i] > price[ds.top()]) {
				ds.pop();
			}
			if (ds.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - ds.top();
			}
			ds.push(i);

		}
		return span;
	}

}
