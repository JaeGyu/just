package reactive.programming;

import java.util.Arrays;

public class Calc {
	public static int calc(int n, int[] array) {
		System.out.println("Array in Calc : " + Arrays.toString(array));
//		array = new int[] {11,12,13};
		array[0] = 11;
		return 2 * n;
	}
}
