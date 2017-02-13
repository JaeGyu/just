package java8.stream;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx10 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("alice",10),
				new Student("bob",20));
		
		students.stream()
//				.sorted((a, b) -> b.compareTo(a))
//				.sorted((a, b) -> b.compareTo(a))
//				.sorted(Comparator.reverseOrder())
				.forEach(d -> System.out.println(d));
		
		List<Person> persons = Arrays.asList(
				new Person("alice", 34),
				new Person("bob", 55));
		
		System.out.println("--------------------");
		persons.stream()
		       .sorted((a,b)->{
		    	   return Integer.compare(b.getAge(), a.getAge());
		       })
		       .forEach(d->System.out.println(d));
		
		System.out.println("----------------------");
		
		System.out.println(persons.stream()
		  .min((a,b)->{
			  return Integer.compare(a.getAge(), b.getAge());
		  }));
	}
}

@Data
@AllArgsConstructor
class Person{
	private String name;
	private int age;
}


