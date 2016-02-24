package richardxin.leetcode;

import java.util.ArrayList;

public class MathUtility {

	static int countPrimes1(int input) {
		/*
		 * Count the number of prime numbers less than a non-negative number, n
		 * 
		 * Sieve of Eratosthenes
		 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		 * 
		 */
		if (input <= 2)
			return 0;
		boolean[] primes = new boolean[input];
		for (int i = 2; i < input; i++)
			primes[i] = true;

		for (int i = 2; i <= Math.sqrt(input - 1); i++) {
			if (primes[i]) {
				for (int j = i + 1; j < input; j += i)
					primes[j] = false;
			}
		}

		// get count
		int count = 0;
		for (int i = 2; i < input; i++) {
			if (primes[i])
				count++;
		}
		return count;
	}

	static int countPrimes2(int input) {
		input = input - 1;

		ArrayList<Integer> primes = new ArrayList<Integer>();

		if (input <= 1)
			return 0;
		if (input == 2)
			return 1;
		if (input == 3)
			return 2;

		primes.add(2);
		primes.add(3);

		for (int i = 4; i <= input; i++) {
			boolean isPrime = true;
			for (int p : primes) {
				int m = i % p;
				if (m == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}

		return primes.size();
	}

}
