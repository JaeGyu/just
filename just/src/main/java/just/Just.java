package just;

public class Just {
	public static void main(String[] args) {

		Just just = new Just();

		just.print(just.input("gg"));
	}

	public void print(String a) {
		System.out.println(a);
	}

	public String input(String a) {
		return a;
	}
}
