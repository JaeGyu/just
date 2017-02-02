package java8.thread;

public class ThreadRun7 {
	public static void main(String[] args) {
		StatePrintThread printThread = new StatePrintThread(new TargetThread());
		printThread.start();
	}
}

class StatePrintThread extends Thread {
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while (true) {
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상대 : " + state);

			if (state == Thread.State.NEW) {
				targetThread.start();
			}

			if (state == Thread.State.TERMINATED) {
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TargetThread extends Thread {
	@Override
	public void run() {
		for (long i = 0; i < 5000000000l; i++) {

		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}
		for (long i = 0; i < 5000000000l; i++) {
		}

	}
}
