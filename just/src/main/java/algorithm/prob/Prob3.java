package algorithm.prob;

import java.util.Arrays;

public class Prob3 {
	public static void main(String[] args) {
		System.out.println(anagram("aaa ", "aa a"));
	}

	public static boolean anagram(String a, String b) {
		char[] tmpA = a.toLowerCase().replace(" ","").toCharArray();
		char[] tmpB = b.toLowerCase().replace(" ","").toCharArray();
		Arrays.sort(tmpA);
		Arrays.sort(tmpB);
		return String.valueOf(tmpA).equals(String.valueOf(tmpB));
	}
}
