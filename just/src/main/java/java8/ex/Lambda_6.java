package java8.ex;

import java.util.function.Function;

public class Lambda_6 {
	public static void main(String[] args) {

		/*
		 * Function 함수적 인터페이스는 매개값과 리턴값이 있는 applyXXX()를 가지고 있다. 
		 * 매개변수값을 리턴값으로 매핑(타입변환) 한다.
		 */
		Function<String, Integer> fi = (t) -> {
			return Integer.parseInt(t);
		};
		System.out.println(fi.apply("3"));
		
		System.out.println(getXXX((x)->{
			return x + " 입니다.";
		}, "alice"));
	}
	
	public static String getXXX(Function<String, String> fi, String name){
		return fi.apply(name);
	}
}
