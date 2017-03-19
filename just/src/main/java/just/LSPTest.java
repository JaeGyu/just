package just;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSPTest {
	public static void main(String[] args) {
		String[] arr = { "a", "B" };
		List list = Arrays.asList(arr);
		System.out.println(list);
		// list.add("c");
		// System.out.println(list);

		Integer[] i = { 1, 2, 3 };

		List l2 = Arrays.asList(i);
		System.out.println(l2);

		// l2.add(4);

		List<Integer> l3 = new ArrayList<>(Arrays.asList(i));
		l3.add(4);
		System.out.println(l3);
	}
}
