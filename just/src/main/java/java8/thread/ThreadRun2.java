package java8.thread;

public class ThreadRun2 {
	public static void main(String[] args) {

		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("띵~");
			}
		});

		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("똥~");
			}
		});

		th1.start();
		th2.start();

	}
}
