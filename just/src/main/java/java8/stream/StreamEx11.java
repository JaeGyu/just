package java8.stream;

import java.util.stream.IntStream;

public class StreamEx11 {
	public static void main(String[] args) {
		System.out.println("tot : " + IntStream.of(1, 2, 3, 4, 5, 6)
				.filter(d -> (d % 2 == 0))
				.peek(d -> System.out.println(d))
				.sum());
	}
}
