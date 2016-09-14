package java7.ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComparableEx {

	static class Student implements Comparable<Integer>{
		String name;
		int score;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", score=" + score + "]";
		}

		@Override
		public int compareTo(Integer arg0) {
			return (this.score < arg0) ? -1 : (this.score == arg0) ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		List<Student> list = new LinkedList<>();

		list.add(new Student("a", 100));
		list.add(new Student("b", 34));

//		Collections.sort(list);
		
		System.out.println(list);
	}

}
