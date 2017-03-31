package algorithm;

import java.util.List;
import java.util.Vector;

import org.junit.Test;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer> list = new Vector<>();
		for (int i = 10; i > 0; i--) {
			list.add(i);
		}
		System.out.println(list);
		list = mergeSort(list);
		System.out.println(list);
	}

	public static List<Integer> mergeSort(List<Integer> list) {
		if (list.size() > 1) {
			int mid = list.size() / 2;
			List<Integer> l1 = list.subList(0, mid);
			List<Integer> l2 = list.subList(mid, list.size());
			l1 = mergeSort(l1);
			l2 = mergeSort(l2);
			list = merge(l1, l2);
		}
		return list;
	}

	private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		List<Integer> result = new Vector<>();
		
		while (!l1.isEmpty() && !l2.isEmpty()) {
			if (l1.get(0) <= l2.get(0)) {
				result.add(l1.get(0));
				l1.remove(0);
			} else {
				result.add(l2.get(0));
				l2.remove(0);
			}
		}

		if (!l1.isEmpty()) {
			result.addAll(l1);
		}
		if (!l2.isEmpty()) {
			result.addAll(l2);
		}

		return result;
	}

	@Test
	public void testL() throws Exception {
		List<Integer> l = new Vector<>();

		List<Integer> result = new Vector<>();

		for (int i = 10; i > 0; i--) {
			l.add(i);
		}
		System.out.println(l);

		while (!l.isEmpty()) {
			result.add(l.get(0));
			l.remove(0);
		}

		System.out.println("l : " + l);
		System.out.println("result : " + result);
		
		System.out.println(result.subList(0, 5));
		System.out.println(result.subList(5, result.size()));
		
	}
}
