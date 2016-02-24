package richardxin.leetcode;

import java.util.HashSet;

public class Util {
	public boolean containsDuplicate(int[] nums) {
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
}
