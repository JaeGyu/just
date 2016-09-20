package threadEx;

public class YieldExample {
	public static void main(String[] args) throws InterruptedException {
		ThreadAForYield aForYield = new ThreadAForYield();
		ThreadBForYield bForYield = new ThreadBForYield();

		aForYield.start();
		bForYield.start();

		Thread.sleep(100);
		aForYield.work = false;

		Thread.sleep(100);
		aForYield.work = true;

		Thread.sleep(100);
		aForYield.stop = true;
		bForYield.stop = true;

	}
}
