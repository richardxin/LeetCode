package richardxin.leetcode;

import java.util.HashMap;

public class StringUtility {
	static String getMinWindow(String s, String t){
		/*
		 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
		 *  For example,
		 *  S = "ADOBECODEBANC"
		 *  T = "ABC"
		 *  
		 *  Minimum window is "BANC".
		 *  
		 *  Note:
		 *  If there is no such window in S that covers all characters in T, return the empty string "".
		 *  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
		 */
		
		if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //put string t into a HashMap with count
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	 
	    // character counter for s
	    HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	 
	    int count = 0; // the total of mapped characters
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(counter.containsKey(c)){
	                if(counter.get(c)<target.get(c)){
	                    count++;
	                }
	                counter.put(c,counter.get(c)+1);
	            }else{
	                counter.put(c,1);
	                count++;
	            }
	        }
	 
	        if(count == t.length()){
	            char sc = s.charAt(left);
	            while (!counter.containsKey(sc) || counter.get(sc) > target.get(sc)) {
	                if (counter.containsKey(sc) && counter.get(sc) > target.get(sc))
	                    counter.put(sc, counter.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	 
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	    }
	 
	    return result;
		
	}

}
