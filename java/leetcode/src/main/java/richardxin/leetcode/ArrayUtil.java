package richardxin.leetcode;

import java.util.Arrays;

public class ArrayUtil {
	public static int[] removeDuplicates(int[] array){
		/* 26. Remove Duplicates from Sorted Array
		 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. 
		 * Do not allocate extra space for another array, you must do this in place with constant memory.
		 */
		if (array == null || array.length < 2)
			return array;
		int i = 0;
		int j = 1;
		while (j < array.length){
			if (array[i] == array[j]){
				j++;
			}else{
				i++;
				array[i] = array[j];
				j++;
			}
		}
		
		return Arrays.copyOf(array, i+1);
	}
	
	public static int removeDuplicates1(int[] arr) {
		if (arr.length == 0) return 0;
		int i=0;
		for (int j=1;j<arr.length; j++){
			if (arr[j] != arr[i]){
				i++;
				arr[i] = arr[j];
			}			
		}
		return i+1;
	}
}
