package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx2 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("alice", "bob", "peter", "lisa");

		names.stream().forEach(StreamEx2::print);
		System.out.println();

		names.parallelStream().forEach(StreamEx2::print);
	}

	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
