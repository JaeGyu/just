package java8.stream;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx8 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("alice", 10),
				new Student("bob", 20));

		students.stream().mapToInt(data -> data.getScore()).forEach(data -> System.out.println(data));
		students.stream().map(data -> data.getName()).forEach(d -> System.out.println(d));
	}
}

@Data
@AllArgsConstructor
class Student implements Comparable<Student> {
	private String name;
	private int score;

	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}
