package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamEx13 {
	public static void main(String[] args) {
		okCase4();
		// errorCase();
	}

	public static void errorCase() {
		List<Integer> list = new ArrayList<>();

		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println("평균 :: " + avg);

	}

	public static void okCase() {
		List<Integer> list = new ArrayList<>();
		OptionalDouble optional = list.stream().mapToInt(Integer::intValue).average();
		if (optional.isPresent()) {
			System.out.println(optional.getAsDouble());
		} else {
			System.out.println("0.0");
		}
	}

	public static void okCase2() {
		List<Integer> list = new ArrayList<>();
		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);

		System.out.println(avg);
	}

	public static void okCase3() {
		Arrays.asList(1, 2, 3, 4, 5).stream().mapToInt(Integer::intValue).average()
				.ifPresent(i -> System.out.println(i));
	}

	public static void okCase4() {
		List<Integer> list = new ArrayList<>();
		list.stream().mapToInt(Integer::intValue).average().ifPresent(i -> System.out.println(i));
	}
}
