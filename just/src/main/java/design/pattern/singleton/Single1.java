package design.pattern.singleton;

public class Single1 {

	private static volatile Single1 instance;

	private Single1() {
	}

	public static Single1 getInstence() {
		if (instance == null) {
			synchronized (Single1.class) {
				if (instance == null) {
					instance = new Single1();
				}
			}
		}
		return instance;
	}

	public String sayHello() {
		return "Hello";
	}

	public static void main(String[] args) {
		System.out.println(Single1.getInstence().sayHello());
	}
}
