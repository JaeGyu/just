package just;

public class ConflictStaticMember {

	public static String name = "gg";

	public static void main(String[] args) {

		System.out.println(name);

		ConflictVO c = new ConflictVO();
		System.out.println(c.getName());
	}
}
