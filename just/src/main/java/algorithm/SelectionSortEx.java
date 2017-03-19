package algorithm;

import java.util.Arrays;

public class SelectionSortEx {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		for (int a = 0; a < arr.length - 1; a++) {

			int min = a;
			for (int b = a; b < arr.length - 1; b++) {
				if (arr[b] > arr[b + 1]) {
					min = b + 1;
				}
			}

			int temp = arr[min];
			arr[min] = arr[a];
			arr[a] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
