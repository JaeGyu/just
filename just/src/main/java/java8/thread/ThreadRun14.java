package java8.thread;

/*
 * 공유객체가 없는 경우 wait notify가 안됨 
 * */
public class ThreadRun14 {
	public static void main(String[] args) {
		new ThreadForNotify1().start();
		new ThreadForNotify2().start();
	}
}

class ThreadForNotify1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1");
			try {
				Thread.sleep(1000);
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadForNotify2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2");
			try {
				Thread.sleep(1000);
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}