package algorithm;

import java.util.Arrays;

public class ArraysSortTest {
	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 1 };
		Arrays.sort(a, 0, 5);
		System.out.println(Arrays.toString(a));
	}
}
