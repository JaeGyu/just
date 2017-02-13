package java8.stream;

import java.util.stream.IntStream;

public class StreamEx12 {
	public static void main(String[] args) {
		System.out.println(IntStream.of(2,4,6)
				.allMatch(a -> a % 2 == 0));
		
		System.out.println(IntStream.of(2,4,6)
				.anyMatch(a -> a % 3 == 0));
		
		System.out.println(IntStream.of(2,4,6)
				.noneMatch(a -> a % 3 == 0));
	}
}
