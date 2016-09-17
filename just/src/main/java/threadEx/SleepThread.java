package threadEx;

public class SleepThread extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i + " 입니다.");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("현재 이 스레드가 인터럽트에 걸렸습니다.");
				System.out.println(this.getState());
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("스레드를 wait시킵니다.  " + this.getState());
			}
		}
	}

}
