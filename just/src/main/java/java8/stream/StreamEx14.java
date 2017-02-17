package java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamEx14 {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().mapToInt(i -> i).average().orElse(0.0));
		System.out.println(IntStream.of(1, 2, 3, 4, 5).average().orElse(0.0));
	}
}
