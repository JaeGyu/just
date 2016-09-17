package threadEx;

public class SleepThreadExample {
	public static void main(String[] args) {
		SleepThread th = new SleepThread();

		th.start();
		try {
			Thread.sleep(15000);
			System.out.println("15초 후 인터럽트를 겁니다. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th.interrupt();
		try {
			Thread.sleep(5000);
			System.out.println(th.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
