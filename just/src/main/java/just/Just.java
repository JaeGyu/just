package just;

public class Just {
	public static void main(String[] args) {

		Just just = new Just();

		just.print(just.input("gg"));

		Object obj = just.a();
		System.out.println(obj);
	}

	public void print(String a) {
		System.out.println(a);
	}

	public String input(String a) {
		return a;
	}

	public String a() {
		return "ok";
	}
}
