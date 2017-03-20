package algorithm.prob;

public class Prob2 {
	public static void main(String[] args) {
		System.out.println(reverse("abc"));
	}

	public static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str.length());

		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}

		return sb.toString();
	}
}
