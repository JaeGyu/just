package algorithm;

public class RecursionEx {
	public static void main(String[] args) {
		int n = 4;
		func(n);
	}

	public static void func(int k) {
		if (k <= 0) {
			return;
		} else {
			System.out.println(k + " Hello world!");
			func(k - 1);
		}
		System.out.println(k + "함수 종료 직전 입니다.");
	}
}
