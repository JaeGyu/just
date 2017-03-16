package java8.method.reference;

import java.util.Arrays;

public class MethodRef1 {
	public static void main(String[] args) {
		Sample s = new Sample();
		Arrays.asList(1, 2, 3, 4, 5).stream().forEach(s::show);
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).forEach(Sample::showStatic);
		System.out.println();
		Arrays.asList(1, 2, 3, 4, 5).stream().map(Sample::returnPlusOne).forEach(System.out::println);
		System.out.println();
		
	}
}

class Sample {
	public void show(int n) {
		System.out.println(n);
	}

	public static void showStatic(int n) {
		System.out.print(n + " ");
	}

	public static int returnPlusOne(int n) {
		return n + 1;
	}
}
