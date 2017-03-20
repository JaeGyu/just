package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
	public static void main(String[] args) {
		Integer[] nums = { 2, 3, 1, 5, 6, 4 };
		quick(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void quick(Integer[] nums) {
		if (nums.length == 0)
			return;

		int pivot = nums[0];

		List<Integer> lP = new ArrayList<>();
		List<Integer> rP = new ArrayList<>();

		for (int i = 1; i < nums.length; i++) {
			if (pivot > nums[i]) {
				lP.add(nums[i]);
			} else {
				rP.add(nums[i]);
			}
		}

		quick(lP.toArray(new Integer[lP.size()]));
		quick(rP.toArray(new Integer[lP.size()]));
	}
}
