package threadEx;

public class TargetThread extends Thread {

	@Override
	public void run() {
		for (long i = 0; i < 5000000000l; i++) {
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (long i = 0; i < 5000000000l; i++) {
		}

	}

}
