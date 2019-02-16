import java.io.*;
import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		printPrimes(n);
	}

	private static void printPrimes(int n) {
		boolean primes[] = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int table = 2; table * table <= n; table++) {
			if (primes[table] == false)
				continue;

			for (int mult = 2; mult * table <= n; mult++) {
				primes[mult * table] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (primes[i])
				System.out.print(i + " ");
		}
	}

}
