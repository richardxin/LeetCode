package richardxin.leetcode;

import java.util.HashMap;

/* Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 */
/* Note: 1 Zero
 *       2 Space 
 */
public class IntegerToWords {
	private static HashMap<Integer, String> map = new HashMap<>();
	static{
		map.put(0, "");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
	}

	public static String numberToWords(int num) {
		if (num ==0){
			return "Zero";			
		}
		StringBuilder res = new StringBuilder();
		
		int index = 0;
		while (num > 0) {
			int residue = num % 1000;
			num /= 1000;
			String part = handle(residue, index);
			res.insert(0, part);
			index++;
		}
		return res.toString().trim(); // 去掉最后面空格
		
	}
	
	private static String handle(int remaining, int index){
		StringBuilder res = new StringBuilder();
		String word[] = { "", "Thousand", "Million", "Billion" };
		if (remaining == 0) {
			return res.toString();
		}
		
		int n = remaining / 100;
		remaining = remaining - 100 * n;
		if (n != 0){
			res.append(map.get(n) + " Hundred");
			if (remaining != 0)
				res.append(" "); //百位数和十位数之间的空格
		}
		if (remaining <= 20){
			res.append(map.get(remaining));
		}else{
			res.append(map.get(remaining - remaining % 10));
			n = remaining / 10;
			remaining = remaining - n * 10;
			if (remaining != 0)
				res.append(" " + map.get(remaining)); // "Twenty Two" The space between word
		}
		res.append(" " + word[index] + " "); // 空格加在word两边
		return res.toString();		
	}
	
	public String numberToWords1(int num) {
		if (num == 0)
			return "Zero";
		String[] big = { "", "Thousand", "Million", "Billion" };
		String[] small = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen" };
		String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		StringBuilder res = new StringBuilder();
		int count = 0;
		while (num != 0) {
			int cur = num % 1000;
			int o = cur % 10, t = (cur / 10) % 10, h = cur / 100; // 直接获得个十百位
			StringBuilder tmp = new StringBuilder();
			if (h != 0)
				tmp.append(ones[h] + " Hundred ");
			if (t == 1)
				tmp.append(small[o] + " ");
			else {
				if (t > 1)
					tmp.append(tens[t - 2] + " ");
				if (o > 0)
					tmp.append(ones[o] + " ");
			}
			if (tmp.length() != 0)
				tmp.append(big[count] + " ");
			res.insert(0, tmp);
			num /= 1000;
			count++;
		}
		return res.toString().trim();
	}
	
}
