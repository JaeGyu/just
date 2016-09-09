package java8.ex;

public class Lambda_1 {

	public static void main(String[] args) {

		MyFunctionInterface fi;

		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		
		/*
		 * 위의 람다식이 MyFunctionInterface의 익명객체를 생성시키고
		 * 그 익명객체의 method();를 아래와 같이 실행 시킨다.
		 * 그러면 위의 람다식의 body에 기술된 코드가 실행이 된다. 
		 * */
		fi.method();

		fi = () -> {
			System.out.println("method call2");
		};
		fi.method();

		fi = () -> System.out.println("method call3");
		fi.method();
		
		fi = () -> {
			for(int i=0;i<10;i++){
				System.out.println(i);
			}
		};
		fi.method();
	}
}
