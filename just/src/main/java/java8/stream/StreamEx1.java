package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("alice", "홍길동", "bob");
		list.stream().forEach(i -> System.out.println(i));
	}
}
