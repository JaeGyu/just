package java8.stream;

import java.util.Arrays;

public class StreamEx9 {
	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5 };

		Arrays.stream(intArr).asDoubleStream().forEach(d -> System.out.println(d));
		
		System.out.println();
		
		Arrays.stream(intArr).boxed().forEach(obj -> System.out.println(obj.intValue()));
	}
}
