package java8.thread;

/*
 * 일지정지 상태의 스레드를 interrupt()를 통해 실행대기 상태로 만든다. 
 * */
public class ThreadRun8 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new InterruptThread();

		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}
}

class InterruptThread extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("InterruptThread 실행!");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("인터럽트가 발생했습니다.");
		}
	}
}
