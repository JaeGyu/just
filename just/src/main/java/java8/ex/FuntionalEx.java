package java8.ex;

public class FuntionalEx {
	public static void main(String[] args) {
		FuncTest<Member> f = new FuncTest((t) -> {
			return t;
		});

		Member m = new Member("alice", 35);

		f.run(m);
	}
}

class Member {
	private String name;
	private Integer age;

	public Member(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

}

class FuncTest<T> {
	private Func<T> func;

	public FuncTest(Func<T> func) {
		this.func = func;
	}

	public void run(T t) {
		System.out.println(func.get(t));
	}
}

interface Func<T> {
	T get(T t);
}
