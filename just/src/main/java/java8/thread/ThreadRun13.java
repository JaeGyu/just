package java8.thread;

public class ThreadRun13 {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();

		ThreadAA aa = new ThreadAA(workObject);
		ThreadBB bb = new ThreadBB(workObject);

		aa.start();
		bb.start();
	}
}

class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadAA의 methodA() 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		System.out.println("ThreadBB의 methodB() 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadAA extends Thread {
	private WorkObject workObject;

	public ThreadAA(WorkObject workObject) {
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}
}

class ThreadBB extends Thread {
	private WorkObject workObject;

	public ThreadBB(WorkObject workObject) {
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
