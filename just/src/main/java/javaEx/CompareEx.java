package javaEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareEx {
	public static void main(String[] args) {

		List<Mem> ms = new ArrayList<>();
		ms.add(new Mem("a", 20));
		ms.add(new Mem("b", 3));

		System.out.println(ms);

		Collections.sort(ms, new Comparator<Mem>() {
			@Override
			public int compare(Mem o1, Mem o2) {
				return o1.age - o2.age;
			}
		});

		System.out.println(ms);

		Collections.sort(ms);
		System.out.println(ms);

	}
}

class Mem implements Comparable<Mem> {
	String name;
	int age;

	public Mem(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Mem [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Mem o) {
		return this.name.compareTo(o.name);
	}

}
