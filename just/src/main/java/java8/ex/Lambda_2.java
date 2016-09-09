package java8.ex;

public class Lambda_2 {

	public static void main(String[] args) {
		
		MyFunctionInterfaceWithParam fun;
		
		fun = (x) -> System.out.println(x);
		fun.method(4);
		
		fun = (x) -> {
			System.out.println(x);
		};
		fun.method(10);
		
		fun = (int x) -> {
			System.out.println(x);
		};
		fun.method(11);
	}
}
