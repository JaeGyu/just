package algorithm;

import java.util.Arrays;

/*
 * void quick([],lo,hi)
 * index patition([],lo,hi)
 * swap([], sourceIdx, targetIdx)
 * */
public class QuickSort {
	public static void main(String[] args) {
		Integer[] nums = { 2, 3, 1, 5, 6, 4 };
		quick(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void quick(Integer[] nums, int lo, int hi) {
		if (lo < hi) {
			int p = patition(nums, lo, hi);
			quick(nums, lo, p - 1);
			quick(nums, p + 1, hi);
		}
	}

	private static int patition(Integer[] nums, int lo, int hi) {
		int pivotNum = nums[hi];
		int currentIdx = lo;

		for (int i = lo; i < hi; i++) {
			if (nums[i] < pivotNum) {
				swap(nums, i, currentIdx); // 맨 왼쪽부터 피봇 보다 작은 값들을 쌓는다.
				currentIdx++;
			}
		}

		swap(nums, currentIdx, hi); // 피봇과 피봇보다 작은값의 경계 선과 교환 해준다.
		return currentIdx;
	}

	private static void swap(Integer[] nums, int sourceIdx, int targetIdx) {
		int tmp = nums[sourceIdx];
		nums[sourceIdx] = nums[targetIdx];
		nums[targetIdx] = tmp;
	}

}
