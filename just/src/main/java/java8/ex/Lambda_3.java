package java8.ex;

public class Lambda_3 {
	public static void main(String[] args) {

		// 아래의 인터페이스는 타겟타입이라 한다.
		MyFunctionInterfaceWithReturnValue fun;

		// 아래와 같이 리턴만 있을경우 return 예약어를 생략 할 수 있다.
		fun = (x, y) -> x + y;
		System.out.println(fun.method(1, 2));

		fun = (x, y) -> sum(x, y);
		System.out.println(fun.method(10, 30));
	}

	public static int sum(int x, int y) {
		return x + y;
	}

}
