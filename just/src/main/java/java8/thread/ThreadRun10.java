package java8.thread;

public class ThreadRun10 {
	public static void main(String[] args) throws InterruptedException {

		SumThread sumThread = new SumThread();

		sumThread.start();
		sumThread.join();

		System.out.println(sumThread.getSum());

	}
}

class SumThread extends Thread {
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
	}

}
