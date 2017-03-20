package algorithm.prob;

import java.util.HashSet;
import java.util.Set;

public class Prob1 {
	public static void main(String[] args) {
		char[] test = { 'a', 'b', 'c' };
		char[] test2 = { 'a', 'a' };

		System.out.println(chk(test));
		System.out.println(chk(test2));
	}

	public static boolean chk(char[] cs) {
		int num = cs.length;
		Set<Character> set = new HashSet<>();

		for (char c : cs) {
			set.add(c);
		}

		return (set.size() == num);
	}
}
