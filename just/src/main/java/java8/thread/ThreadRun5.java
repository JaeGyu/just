package java8.thread;

public class ThreadRun5 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i != 10) {
				getThread("Thread " + i, Thread.MIN_PRIORITY).start();
			} else {
				getThread("Thread " + i, Thread.MAX_PRIORITY).start();
			}
		}
	}

	private static Thread getThread(String name, int priority) {

		Thread thread = new Thread(() -> {
			for (long i = 0; i < 5000000000l; i++) {
			}
			System.out.println(name);
		});
		thread.setName(name);
		thread.setPriority(priority);

		return thread;

	}
}
