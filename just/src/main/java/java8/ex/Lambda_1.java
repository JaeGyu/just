package java8.ex;

public class Lambda_1 {

	public static void main(String[] args) {

		MyFunctionInterface fi;

		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
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
