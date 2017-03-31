package algorithm;

import java.util.Arrays;

public class MergeSort2 {
	public static void main(String[] args) {
		int[] list = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		System.out.println(Arrays.toString(list));

		list = mergeSort(list);
		System.out.println(Arrays.toString(list));
	}

	private static int[] mergeSort(int[] list) {
		if (list.length > 1) {
			int mid = list.length / 2;
			int[] l1 = Arrays.copyOfRange(list, 0, mid);
			int[] l2 = Arrays.copyOfRange(list, mid, list.length);

			l1 = mergeSort(l1);
			l2 = mergeSort(l2);
			list = merge(l1, l2);
		}
		return list;
	}

	private static int[] merge(int[] l1, int[] l2) {
		int[] result = new int[l1.length + l2.length];
		int idxForResult = 0;
		int idxForL1 = 0;
		int idxForL2 = 0;

		while (idxForL1 < l1.length && idxForL2 < l2.length) {
			if (l1[idxForL1] <= l2[idxForL2]) {
				result[idxForResult] = l1[idxForL1];
				idxForResult++;
				idxForL1++;
			} else {
				result[idxForResult] = l2[idxForL2];
				idxForResult++;
				idxForL2++;
			}
		}

		while (idxForL1 < l1.length) {
			result[idxForResult] = l1[idxForL1];
			idxForResult++;
			idxForL1++;
		}
		while (idxForL2 < l2.length) {
			result[idxForResult] = l2[idxForL2];
			idxForResult++;
			idxForL2++;
		}

		return result;
	}
}
