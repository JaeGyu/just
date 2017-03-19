package threadEx2;

public class Thd1 {
	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			createThread();
			System.out.print("#");
//			System.out.printf("%d 번째 쓰레드 끝", i);
		}

	}

	public static void createThread() {
		new Thread(() -> {
//			Thread.currentThread().setName("Hans");
			System.out.println(Thread.currentThread().getName());
			for (int i = 0; i < 10; i++) {
				System.out.print(i);
			}
		}).start();
	}
}
