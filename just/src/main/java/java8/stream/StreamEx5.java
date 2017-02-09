package java8.stream;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx5 {
	public static void main(String[] args) {
		
		List<Member> mems = Arrays.asList(
				new Member("홍길동",Member.MALE,30),
				new Member("김길동",Member.MALE,20),
				new Member("이길동",Member.MALE,11),
				new Member("최길동",Member.MALE,56)
				);
		
		System.out.println(mems.stream()
				.filter(m->m.getSex() == Member.MALE)
				.mapToInt(Member::getAge)
				.average()
				.getAsDouble());
		
		
		
	}
}

@Data
@AllArgsConstructor
class Member {
	public static int MALE = 0;
	public static int FEMALE = 1;

	private String name;
	private int sex;
	private int age;

}
