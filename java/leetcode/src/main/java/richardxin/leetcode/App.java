package richardxin.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

import richardxin.scratchpad.GsonTest;

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
    	System.out.println(IntegerToWords.numberToWords(18766656));
    	
    	System.out.println(Util.generateParenthesis(4));
    	demoPriorityQueue();
    	
    	System.out.println(Util.isNumeric("1234.56"));
    	
    	GsonTest.testTypeToken();

    }
    
    private static void demoPriorityQueue(){
    	PriorityQueue<String> stringQueue = new PriorityQueue<>();
    	stringQueue.add("abc");
    	stringQueue.add("ab");
    	stringQueue.add("cab");
    	stringQueue.add("a");
    	System.out.println("====== demoPriorityQueue String ======");
    	while (stringQueue.size() > 0){
    		System.out.println (stringQueue.remove());
    	}
    	
    	System.out.println("====== demoPriorityQueue QueueItem ======");
    	PriorityQueue<QueueItem> theQueue = new PriorityQueue<>();
    	theQueue.add(new QueueItem("itemA", 10));
    	theQueue.add(new QueueItem("itemX", 1));
    	theQueue.add(new QueueItem("itemY", 5));
    	theQueue.add(new QueueItem("itemB", 4));
    	
    	while (theQueue.size() > 0){
    		System.out.println (theQueue.remove().toString());
    	}    	
    }
}
