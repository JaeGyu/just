package java8.ex;

public class MyFunctionalInterfaceWithParamExampleReview {
	public static void main(String[] args) {
		MyFunctionalInterfaceWithParamReview fi;

		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);

		fi = (x) -> System.out.println(x * 5);
		fi.method(2);

		fi = x -> System.out.println(x * 5);
		fi.method(2);
	}
}
