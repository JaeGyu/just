package threadEx;

public class BeepPrintExample3 {
	public static void main(String[] args) {

		Thread th1 = new BeepThread();
		th1.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
