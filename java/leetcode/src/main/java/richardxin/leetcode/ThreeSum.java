package richardxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	/*
	 * 15. 3Sum
	 * 
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * Note:
	 * 
	 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
	 * The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = {-1 0 1 2 -1 -4},
	 * A solution set is:
	 * (-1, 0, 1)
	 * (-1, -1, 2)
	 */
	
	public List<List<Integer>> threeSum1(int[] nums) {
		/*
		 * Time Limit Exceeded
		 */
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums.length<3)
			return result;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				for (int k = j; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						int[] arr = new int[] { nums[i], nums[j], nums[k] };
						Arrays.sort(arr);
						for (int m = 0; m < 3; m++)
							list.add(arr[m]);
						if (!result.contains(list))  // unique only
							result.add(list);
					}
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum2(int[] nums) {
		/*
		 * Time Limit Exceeded
		 */
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length<3)
			return result;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i+1;
			int end = nums.length - 1;
			while (start < end) {
				if (nums[start] + nums[end] < -nums[i]) 
					start++;
				 else if (nums[start] + nums[end] > -nums[i])
					end--;
				else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[start]);
					list.add(nums[end]);
					if (!result.contains(list))
						result.add(list);
					
					start++;
					end--;
				}
			}
		}
		return result;
		 
	}
	public List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length<3)
			return result;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] < -nums[i])
						start++;
					else if (nums[start] + nums[end] > -nums[i])
						end--;
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[start]);
						list.add(nums[end]);
						result.add(list);
						start++;
						end--;
						while (start < end && nums[end] == nums[end + 1])
							end--;
						while (start < end && nums[start] == nums[start - 1])
							start++;
					}
				}
			}
		}
		return result;
	}
}
