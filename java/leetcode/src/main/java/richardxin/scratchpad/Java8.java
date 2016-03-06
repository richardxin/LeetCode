package richardxin.scratchpad;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;


public class Java8 {
	private static final String DATA_FILE_NAME = "src/main/resources/data/flatmap_test.txt";

	public static void test_map_filter(){
		/*
		 * The map() method is an intermediate operation. It returns a stream consisting of the results of 
		 * applying the given function to each element in the stream.
		 * 
		 * The filter() method is an intermediate operation. It returns a stream consisting of the elements of 
		 * this stream that match the given condition.
		*/
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("c++");
		list.add("lisp");
 
		System.out.println("---- Java8 map ----");
		//map function
		Stream<Integer> stream1 = list.stream().map(p -> p.length());
 
		Integer[] lengthArr = stream1.toArray(Integer[]:: new);
		System.out.println(Arrays.toString(lengthArr));
		//output: [4, 3, 6, 3, 4]
		
		Long count = list.stream().filter(x -> x.length() > 3).count();
		System.out.println("item -> item.length() > 3).count(): " + count);
		
		System.out.println("---- Java8 filter ----");
		Stream<String> stream2 = list.stream().filter(p -> p.length() > 3);
		String[] arr = stream2.toArray(String[]::new);
		
		System.out.println(Arrays.toString(arr));
		//output: [java, python, lisp]
	}
	
	public static void test_reduce(){
		List<Integer> nums = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
		// 1. Optional<T> reduce(BinaryOperator<T> accumulator);
		System.out.println("the sum is:" + nums.stream().reduce((sum, item) -> sum + item).get());
		
		// 2. T reduce(T identity, BinaryOperator<T> accumulator);
		// 它允许用户提供一个循环计算的初始值 0，如果Stream为空，就直接返回0
		System.out.println("the sum is:" + nums.stream().reduce(0, (sum, item) -> sum + item));		
		System.out.println("count is:" + nums.stream().count());
	}
	
	public static void test_flatmap(){
		Path path = Paths.get(DATA_FILE_NAME);
		System.out.println(path.toAbsolutePath());
		Stream<String> lines = null;
		try {
			lines = Files.lines(path, StandardCharsets.UTF_8);
			Stream<String> words = lines.flatMap(line -> Stream.of(line.split("\\W+"))); //Split by non-word characters
			//System.out.println("lines cout:"+lines.count());
			System.out.println("words distinct count:"+words.distinct().count());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (lines != null)
				lines.close();
		}
	}
	private static String contentsOf(String filename) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(filename)));
	  }
	
	public static void wordcount() throws IOException{
		Stream<String> words = Pattern.compile("\\s+").splitAsStream(contentsOf(DATA_FILE_NAME));
		
		System.out.println(words.count());
		//System.out.println(words.collect(Collectors.toMap(String::toLowerCase, s -> 1, Integer::sum)));
	}
}
