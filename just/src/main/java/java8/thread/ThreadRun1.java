package java8.thread;

public class ThreadRun1 {
	public static void main(String[] args) {

		Thread th = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread Run~~");
		});

		th.start();
		System.out.println("main Thread~~");
	}
}
