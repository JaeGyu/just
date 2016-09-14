package algorithm;

import java.util.Arrays;

public class BubbleSortEx {
	public static void main(String[] args) {

		int[] source = { 5, 4, 3, 2, 1 };

		int[] result = bubbleSort(source);
		System.out.println(Arrays.toString(result));

	}

	private static int[] bubbleSort(int[] source) {

		for (int i = source.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (source[j] > source[j + 1]) {
					int temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}

		return source;
	}

}
