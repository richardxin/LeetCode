package richardxin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	private final static Pattern NUMERIC = Pattern.compile("[-+]?\\d*\\.?\\d+");
	
	public static boolean containsDuplicate(int[] nums) {
		/*
		 * #217. Contains Duplicate
		 * Given an array of integers, find if the array contains any duplicates. 
		 * Your function should return true if any value appears at least twice in the array, 
		 * and it should return false if every element is distinct. 
		 */
        if(nums==null || nums.length==0)
        return false;
 
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: nums){
            if(!set.add(i)){
                return true;
            }
        }
 
        return false;
    }
	
	public static int[] searchRange(int[] arr, int target) {
		/*
		 * 34. Search for a Range
		 * Given a sorted array of integers, find the starting and ending position of a given target value.
		 * Your algorithm's runtime complexity must be in the order of O(log n).
		 * If the target is not found in the array, return [-1, -1].
		 * 
		 * For example,
		 * Given [5, 7, 7, 8, 8, 10] and target value 8,
		 * return [3, 4]. 
		 */
		int[] index = { -1, -1 };
		int start = 0, end = arr.length - 1;
		int mid = 0;
		boolean found = false;
		
		while (start <= end){
			mid = (start + end) >> 1; // /2
			if (arr[mid] == target){
				found = true;
				break;
			}
			if (arr[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		if (!found)
			return index;
		int right = mid;
		while (right < arr.length && arr[right] == target) 
			right ++;
		
		int left = mid;
		while (left >= 0 && arr[right] == target)
			left --;
		
		index[0] = left + 1;
		index[1] = right - 1;
		return index;		
	}
	
	public static List<String> generateParenthesis(int n) {
	/*
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	
	 */
		ArrayList<String> result = new ArrayList<String>();
	    dfs(result, "", n, n);
	    return result;
	}
	
	private static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if(left == 0 && right == 0){
	        result.add(s);
	        return;
	    }
	 
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	 
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
	
	public static boolean isNumber(String s) {
		/*
		 * Validate if a given string is numeric.
		 * Some examples:
		 * "0" => true
		 * " 0.1 " => true
		 * "abc" => false
		 * "1 a" => false
		 * "2e10" => true
		 * 
		 */
		if (s.trim().isEmpty())
			return false;
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		if (s.trim().matches(regex))
			return true;
		else
			return false;
    }
	
	public static boolean isNumeric(String s) {
	    //return s.matches("[-+]?\\d*\\.?\\d+");
		Matcher m = NUMERIC.matcher(s);
		return m.find();		
		//return Pattern.matches(regex, input)
	}
}
