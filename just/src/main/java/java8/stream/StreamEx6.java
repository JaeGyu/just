package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "김길동", "이길동", "홍길동");

		names.stream().distinct().forEach(n -> System.out.println(n));
		System.out.println();

		names.stream().filter(n -> n.startsWith("홍")).forEach(n -> System.out.println(n));
		System.out.println();

		names.stream().distinct().filter(n -> n.startsWith("홍")).forEach(n -> System.out.println(n));
	}
}
