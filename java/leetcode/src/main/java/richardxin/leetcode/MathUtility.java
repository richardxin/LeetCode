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
	
	public int addDigits(int num){
		/*258. Add Digits
		 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
		 *  For example:
		 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
		 *  Follow up:
		 *  Could you do it without any loop/recursion in O(1) runtime? 
		 */
		if (num < 10) return num;
		else{
			int res = 0;
			while (num > 0){
				res += num % 10;
				num /= 10;
			}
			return addDigits(res);
		}
		
		
		
	}

}
