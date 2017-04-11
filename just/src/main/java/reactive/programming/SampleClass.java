package reactive.programming;

import java.util.Arrays;

public class SampleClass {
	private int num;
	private int[] array;

	public void test() {
		num = 3;
		array = new int[] { 1, 2, 3 };

		int num2 = Calc.calc(num, this.array);

		System.out.println("num2 : " + num2);
		System.out.println("Array : " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		SampleClass sample = new SampleClass();
		sample.test();
	}
}
