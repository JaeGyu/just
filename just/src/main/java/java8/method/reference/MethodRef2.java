package java8.method.reference;

import java.util.function.IntBinaryOperator;

public class MethodRef2 {
	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println(operator.applyAsInt(1, 2));
		
		operator = Calculator::staticMethod;
		System.out.println(operator.applyAsInt(1, 2));

	}
}

class Calculator {
	public static int staticMethod(int x, int y) {
		return x + y;
	}

	public static int instanceMethod(int x, int y) {
		return x + y;
	}
}
