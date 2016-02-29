package richardxin.leetcode;

public class AddDigits {
	/*
	 * 258. Add Digits
	 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	 *  For example:
	 *  
	 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	 *  Follow up:
	 *  Could you do it without any loop/recursion in O(1) runtime?
	 *  
	 *  Hint:
	 *  A naive implementation of the above process is trivial. Could you come up with other methods?
	 *  What are all the possible results?
	 *  How do they occur, periodically or randomly?
	 *  You may find this Wikipedia article(https://en.wikipedia.org/wiki/Digital_root) useful.
	 */
	
	public int addDigits(int num) {
        if (num < 10)
			return num;
		else {
			int res = 0;
			while (num > 0) {
				res += num % 10;
				num /= 10;
			}
			return addDigits(res);
		}
    }

}
