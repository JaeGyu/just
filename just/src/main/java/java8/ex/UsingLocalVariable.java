package java8.ex;

public class UsingLocalVariable {

	void method(int arg) { // java8에서는 final을 명시안해줘도 final특성을 같는다.
		int localVar = 40; // java8에서는 final을 명시안해줘도 final특성을 같는다.

		MyFunctionInterface fi = () -> {
			
			/*
			 * 이안에서 method의 매개변수 arg나 localVar을 읽을순있어도
			 * 변경은 안된다. 
			 * final이기 때문에...
			 * */
			
			System.out.println("arg: " + arg);
			System.out.println("localVar: " + localVar);
		};

		fi.method();

	}
}
