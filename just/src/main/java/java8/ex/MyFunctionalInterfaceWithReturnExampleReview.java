package java8.ex;

public class MyFunctionalInterfaceWithReturnExampleReview {
	public static void main(String[] args) {
		MyFunctionalInterfaceWithReturnReview fi;

		fi = (x, y) -> {
			return x * y;
		};
		System.out.println(fi.method(2, 3));

		fi = (x, y) -> x + y;
		System.out.println(fi.method(2, 3));

		fi = (x, y) -> sum(x, y);
		System.out.println(fi.method(3, 4));
	}

	public static int sum(int x, int y) {
		return x + y;
	}
}
