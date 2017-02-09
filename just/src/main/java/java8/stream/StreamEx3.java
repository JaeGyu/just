package java8.stream;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(n -> System.out.println(n));
		String[] strArr = { "홍길동", "김길동" };
		Arrays.stream(strArr).forEach(s -> System.out.println(s));

		System.out.println(Stream.of(1, 2, 3, 4, 5, 6).map(n -> n.toString()).collect(joining(",", "[", "]")));

		System.out.println(IntStream.rangeClosed(1, 100).sum());

		System.out.println(IntStream.rangeClosed(1, 100).filter(x -> (x % 2 == 0)).count());
		
	}
}
