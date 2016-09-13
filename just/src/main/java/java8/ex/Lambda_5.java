package java8.ex;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Lambda_5 {
	public static void main(String[] args) {

		/*
		 * 매개변수가 없고 리턴값이 있는 getXXX()를 가지고 있다.
		 */
		Supplier<String> fi = () -> {
			return "리턴값";
		};
		System.out.println(fi.get());

		System.out.println(getString(() -> {
			return "abc";
		}));

		BooleanSupplier fi2 = () -> {
			return true;
		};

		if (fi2.getAsBoolean() == true) {
			System.out.println("트루 입니다.");
		} else {
			System.out.println("펄스 입니다.");
		}

		IntSupplier fi3 = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};

		for (int i = 0; i < 10; i++) {
			System.out.println(fi3.getAsInt());
		}
	}

	public static String getString(Supplier<String> s) {
		return s.get() + "입니다.";
	}
}
