package java8.thread;

public class ThreadRun4 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = getThread1();
		Thread t2 = getThread2();

		System.out.println(t1.getName());
		t1.start();
		System.out.println(t2.getName());
		t2.start();

	}

	private static Thread getThread1() {
		return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("띵~");
			}
		});
	}

	private static Thread getThread2() {
		return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("똥!");
			}
		});
	}
}
