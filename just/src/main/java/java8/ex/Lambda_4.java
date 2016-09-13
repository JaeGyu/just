package java8.ex;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Lambda_4 {
	public static void main(String[] args) {

		Consumer<String> fi = (a) -> {
			System.out.println(a);
		};

		fi.accept("aa");

		Consumer<Integer> fi2 = (i) -> {
			System.out.println(i + 1);
		};

		fi2.accept(1);

		BiConsumer<String, Integer> fi3 = (str, i) -> {
			System.out.println(str + ":" + (i + 1));
		};
		fi3.accept("age", 33);
		
	}
}
