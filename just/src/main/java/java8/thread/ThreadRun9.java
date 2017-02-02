package java8.thread;

public class ThreadRun9 {
	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();

		a.start();
		b.start();

		Thread.sleep(3000);
		a.work = false;

		Thread.sleep(3000);
		a.work = true;

		Thread.sleep(3000);
		a.stop = true;
		b.stop = true;
	}
}

class ThreadA extends Thread {
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ThreadA 작업 내용");
			} else {
				Thread.yield();
				System.out.println("state : " + ThreadA.currentThread().getState());
			}
		}

		System.out.println("ThreadA 종료");
	}
}

class ThreadB extends Thread {
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ThreadB 작업 내용");
			} else {
				Thread.yield();
			}
		}

		System.out.println("ThreadB 종료");
	}
}
