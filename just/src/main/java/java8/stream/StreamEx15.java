package java8.stream;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx15 {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
				new Student2(1,"alice",76),
				new Student2(1, "Bob", 65),
				new Student2(3, "Peter", 48))
		.stream().mapToInt(Student2::getScore)
		.sum());
		
		System.out.println(Arrays.asList(
				new Student2(1,"alice",76),
				new Student2(1, "Bob", 65),
				new Student2(3, "Peter", 48))
				.stream().mapToInt(Student2::getScore)
				.reduce((a, b) -> a + b));
		
		System.out.println(Arrays.asList(
				new Student2(1,"alice",76),
				new Student2(1, "Bob", 65),
				new Student2(3, "Peter", 48))
				.stream().mapToInt(Student2::getScore)
				.reduce(0, (a, b) -> a + b));
	}
}

@Data
@AllArgsConstructor
class Student2{
	private int id;
	private String name;
	private Integer score;
}