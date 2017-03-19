package design.pattern.singleton;

public class Single2 {

	public static void main(String[] args) {
		System.out.println(Single22.INSTANCE.sayHello());
	}
}

enum Single22 {
	INSTANCE;

	public String sayHello() {
		return "Hello";
	}
}
