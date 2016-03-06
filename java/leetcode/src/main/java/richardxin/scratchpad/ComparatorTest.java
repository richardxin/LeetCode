package richardxin.scratchpad;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	public static void testSort(){
		List<String> names = Arrays.asList("richard","peter", "tony", "anna", "mike", "tom");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a); // descending 
		    }
		});
		System.out.println(names);
		/*
		 * Java 8 lambda表达式
		 * Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型
		 */
		List<String> names1 = Arrays.asList("richard","peter", "tony", "anna", "mike", "tom");
		Collections.sort(names1, (a, b) -> b.compareTo(a)); // descending
		System.out.println(names1);
	}
}
