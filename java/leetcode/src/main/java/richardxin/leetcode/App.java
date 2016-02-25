package richardxin.leetcode;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
    	int[] arr = { 1, 2, 2, 3, 3 };
    	arr = ArrayUtil.removeDuplicates(arr);
    	System.out.println(arr.length);
    	System.out.println(Arrays.toString(arr));
    	System.out.println("====================");
    	int[] arr1 = {1,1, 1, 2, 2, 3, 3 };
    	
    	int count = ArrayUtil.removeDuplicates1(arr1);
    	System.out.println(count);
    	
    	arr1 = Arrays.copyOf(arr1, count);
    	System.out.println(Arrays.toString(arr1));
    }
}
