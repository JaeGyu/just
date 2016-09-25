package java8.ex;

public class UsingLocalVaribleReview {
	void method(int arg) {
		int localVar = 40;

		// arg = 30;  //arg가 암묵적으로 final이라 변경 할 수 없다. 
		//localVar = 10 //localVar이 암묵적으로 final이라 변경 할 수 없다.
		
		MyFunctionInterface fi = () -> {
			System.out.println("arg: " + arg);
			System.out.println("localVal : " + localVar);
		};
		fi.method();

	}
}
